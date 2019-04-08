package crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import crawler.common.Page;
import crawler.parse.DataPageParse;
import crawler.parse.DocumentParse;
import crawler.parse.Parse;
import crawler.pipeline.ConsolePipeline;
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

    /*
     *放置page(超链接)
     * 文档详情页面(数据)
     * 未被采集和解析的页面
     */
    private Queue<Page> docQueue = new LinkedBlockingQueue<>();

    /*
     * 放置详情页面
     * 数据处理完成,数据在DataSet
     * */
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
        this.executorService = Executors.newFixedThreadPool(20, new ThreadFactory() {

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

    //采集和解析
    private void parse() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            this.executorService.submit(new Runnable() {
//                final Page page = docQueue.poll();
//                    if (page == null) {
//                    continue;
//                }
//                @Override
//                public void run() {
//                    //从文档连接队列取出一个链接base  path detail
//
//                    try {
//                        //如果Page里面的连接是存在的，对数据进行采集
//                        HtmlPage htmlPage = webClient.getPage(page.getUrl());
//
//                        page.setHtmlPage(htmlPage);
//
//                        for (Parse parse : parseList) {
//                            parse.parse(page);
//                        }
//                        /**
//                         * 如果文件是没有超链接的就把文档放入到详情页，对数据进行清洗
//                         * 没有的话放到采集队列继续对超链接采集
//                         */
//                        if (page.isDetail()) { detailQueue.add(page);
//                        } else {
//                            Iterator<Page> iterator = page.getSubPage().iterator();
//                            while (iterator.hasNext()) {
//                                Page subPage = iterator.next();
//                                docQueue.add(subPage);
//                                iterator.remove();
//                            }
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });





            //从文档连接队列取出一个链接base  path detail
            final Page page = this.docQueue.poll();
            if (page == null) {
                continue;
            }
            try {
                //如果Page里面的连接是存在的，对数据进行采集
                HtmlPage htmlPage = this.webClient.getPage(page.getUrl());

                page.setHtmlPage(htmlPage);

                for (Parse parse : this.parseList) {
                    parse.parse(page);
                }
                /**
                 * 如果文件是没有超链接的就把文档放入到详情页，对数据进行清洗
                 * 没有的话放到采集队列继续对超链接采集
                 */
                if (page.isDetail()) {
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
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (Pipeline pipeline : Crawler.this.pipelineList) {
                        pipeline.pipeline(page);
                    }
                }
            });

        }
    }

    public void addPage(Page page) {
        this.docQueue.add(page);
    }

    public void addParse(Parse parse) {
        this.parseList.add(parse);
    }

    public void addPipeline(Pipeline pipeline) {
        this.pipelineList.add(pipeline);
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


    public static void main(String[] args) throws IOException {
        final Page page = new Page("https://so.gushiwen.org", "/gushi/tangshi.aspx", false);


        Crawler crawler = new Crawler();

        crawler.addParse(new DocumentParse());

        crawler.addParse(new DataPageParse());

        crawler.addPipeline(new ConsolePipeline());

        crawler.addPage(page);

        crawler.start();
        crawler.stop();
    }
}
