package com.github.qingmou312.everything.core;

import com.github.qingmou312.everything.config.EverythingConfig;
import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.DAO.FileDAO;
import com.github.qingmou312.everything.core.DAO.impl.FileDAOImpl;
import com.github.qingmou312.everything.core.index.FileScan;
import com.github.qingmou312.everything.core.index.impl.FileScanImpl;
import com.github.qingmou312.everything.core.interceptor.impl.FileIndexInterceptor;
import com.github.qingmou312.everything.core.interceptor.impl.ThingClearInterceptor;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;
import com.github.qingmou312.everything.core.search.FileSearch;
import com.github.qingmou312.everything.core.search.impl.FileSearchImpl;

import javax.sql.DataSource;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Author:lidan
 * Created:2019/3/19
 */
public final class EverythingManager {

    private static volatile EverythingManager manager;

    private FileSearch fileSearch;

    private FileScan fileScan;

    private ExecutorService executorService;

    /**
     * 清理删除的文件
     */
    private ThingClearInterceptor thingClearInterceptor;
    private Thread ClearThread;
    private AtomicBoolean ClearThreadStatus = new AtomicBoolean(false);


    private EverythingManager() {
        this.initComponent();
    }

    private void initComponent() {
        //数据源对象
        DataSource dataSource = DataSourceFactory.dataSource();

        initOrResetDatabase();

        //业务层的对象
        FileDAO fileIndexDao = new FileDAOImpl(dataSource);

        this.fileSearch = new FileSearchImpl(fileIndexDao);

        this.fileScan = new FileScanImpl();
        //发布代码的时候是不需要的
//        this.fileScan.interceptor(new FilePrintInterceptor());
        this.fileScan.interceptor(new FileIndexInterceptor(fileIndexDao));

        this.thingClearInterceptor = new ThingClearInterceptor(fileIndexDao);
        this.ClearThread = new Thread(this.thingClearInterceptor);
        this.ClearThread.setName("Thread-Thing-Clear");
        this.ClearThread.setDaemon(true);
    }

    public void initOrResetDatabase() {
        DataSourceFactory.initDatabase();
    }

    public static EverythingManager getInstance() {
        if (manager == null) {
            synchronized (EverythingManager.class) {
                if (manager == null) {
                    manager = new EverythingManager();
                }
            }
        }
        return manager;
    }


    /**
     * 检索
     */
    public List<Thing> search(Condition condition) {
        //Stream 流式处理 JDK8
        return this.fileSearch.search(condition)
                .stream()
                .filter(thing -> {
                    String path = thing.getPath();
                    File f = new File(path);
                    boolean flag = f.exists();
                    if (!flag) {
                        //做删除
                        thingClearInterceptor.apply(thing);
                    }
                    return flag;

                }).collect(Collectors.toList());
    }

    /**
     * 索引
     */
    public void buildIndex() {
        initOrResetDatabase();
        Set<String> directories = EverythingConfig.getInstance().getIncludePath();
        if (this.executorService == null) {
            this.executorService = Executors.newFixedThreadPool(directories.size(), new ThreadFactory() {
                private final AtomicInteger threadId = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread-Scan-" + threadId.getAndIncrement());
                    return thread;
                }
            });
        }
        final CountDownLatch countDownLatch = new CountDownLatch(directories.size());
        System.out.println("Build index start ....");
        for (String path : directories) {
            this.executorService.submit(() -> {
                EverythingManager.this.fileScan.index(path);
                //当前任务完成，值-1
                countDownLatch.countDown();
            });
        }
        //阻塞，直到任务完成，值0
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Build index complete ...");
    }


    /**
     * 启动清理线程
     */
    public void startClearThread() {
        if (this.ClearThreadStatus.compareAndSet(false, true)) {
            this.ClearThread.start();
        } else {
            System.out.println("Cant repeat start ClearThread");
        }
    }

}
