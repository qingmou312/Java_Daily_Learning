package com.github.qingmou312;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.qingmou312.config.ConfigProperties;
import com.github.qingmou312.config.ObjectFactory;
import com.github.qingmou312.crawler.Crawler;
import com.github.qingmou312.crawler.common.Page;
import com.github.qingmou312.crawler.parse.DataPageParse;
import com.github.qingmou312.crawler.parse.DocumentParse;
import com.github.qingmou312.crawler.pipeline.ConsolePipeline;
import com.github.qingmou312.crawler.pipeline.DatabasePipeline;
import com.github.qingmou312.web.WebController;
import spark.Spark;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:lidan
 * Created:2019/3/30
 */
public class TangPoemAnalyzeApplication {
    public static void main(String[] args) {
        WebController webController = ObjectFactory.getInstance().getObject(WebController.class);
        webController.launch();

        //启动爬虫
        if (args.length == 1 && args[0].equals("run-crawler")) {
            Crawler crawler = ObjectFactory.getInstance().getObject(Crawler.class);
            crawler.start();
        }




//        ConfigProperties configProperties = new ConfigProperties();
//        final Page page = new Page(configProperties.getCrawlerBase(),
//                configProperties.getCrawlerPath(),
//                configProperties.isCrawlerDetail());
//
//
//        Crawler crawler = new Crawler();
//
//        // 输出字符串
//        crawler.addParse(new DocumentParse());
//
//
//        crawler.addParse(new DataPageParse());
//
//        crawler.addPipeline(new ConsolePipeline());
//
//
//
////        DruidDataSource dataSource = new DruidDataSource();
////        dataSource.setUsername(configProperties.getDbUserName());
////        dataSource.setPassword(configProperties.getDbPassword());
////        dataSource.setDriverClassName(configProperties.getDbDriverClass());
////        dataSource.setUrl(configProperties.getDburl());
//
////        crawler.addPipeline(new DatabasePipeline(dataSource));
//
//        crawler.addPage(page);
//
//        crawler.start();
//
//        crawler.stop();
    }
}


