package crawler;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import crawler.common.Page;
import crawler.parse.Parse;
import crawler.pipeline.Pipeline;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:lidan
 * Created:2019/3/17
 */

public class Crawler {

    //放置page(超链接),文档详情页面(数据)
    private Queue<Page> docQueue = new LinkedBlockingQueue<>();

    //放置详情页面
    private final Queue<Page> detailQueue = new LinkedBlockingQueue<>();

    //页面采集客户端
    private final WebClient webClient;

    //所有的解析器
    private final List<Parse> parseList = new LinkedList<>();

    //所有的清洗器（管道）
    private final List<Pipeline> pipelineList = new LinkedList<>();

    //线程调度器
    private final ExecutorService executorService;


    public Crawler() {
        this.webClient = new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(false);
        this.executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            private final AtomicInteger id = new AtomicInteger(0);

            //线程工厂
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Crawler-Thread-" + id.getAndIncrement());
                return thread;
            }
        });

    }

    public void start() {
        //爬取
        //解析
        //清洗

        this.executorService.submit(this::parse);

        this.executorService.submit(this::pipeline);

    }

    //解析
    private void parse() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Page page = this.docQueue.poll();
            if (page == null) {
                continue;
            }
            try {
                //采集
                HtmlPage htmlPage = this.webClient.getPage(page.getUrl());

                page.setHtmlPage(htmlPage);

                for (Parse parse : this.parseList) {
                    parse.pase(page);
                }
                if (!page.isDetail()) {
                    this.detailQueue.add(page);

                } else {
                    Iterator<Page> iterator = page.getSubPage().iterator();
                    while (iterator.hasNext()) {
                        Page subPage = iterator.next();
                        this.docQueue.add(subPage);
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //清洗
    private void pipeline() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Page page = this.detailQueue.poll();
            if (page == null) {
                continue;
            }
            for (Pipeline pipeline : this.pipelineList) {
                pipeline.pipeline(page);
            }
        }
    }

    /*
     * 停止爬虫
     * */
    public void stop() {
        //线程调度器里没有线程并且没有线程在执行就停止爬虫
        if (this.executorService != null && this.executorService.isShutdown()) {
            this.executorService.shutdown();
        }
    }

    public static void main(String[] args) {

    }
}
