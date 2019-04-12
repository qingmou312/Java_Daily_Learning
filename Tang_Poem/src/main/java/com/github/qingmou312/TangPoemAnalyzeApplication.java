package com.github.qingmou312;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.qingmou312.analyze.dao.AnalyzeDao;
import com.github.qingmou312.analyze.dao.impl.AnalyzeDaoImpl;
import com.github.qingmou312.analyze.service.AnalyzeService;
import com.github.qingmou312.analyze.service.impl.AnalyzeServiceImpl;
import com.github.qingmou312.config.ConfigProperties;
import com.github.qingmou312.crawler.Crawler;
import com.github.qingmou312.crawler.common.Page;
import com.github.qingmou312.crawler.parse.DataPageParse;
import com.github.qingmou312.crawler.parse.DocumentParse;
import com.github.qingmou312.crawler.pipeline.ConsolePipeline;
import com.github.qingmou312.crawler.pipeline.DatabasePipeline;

/**
 * Author:lidan
 * Created:2019/3/30
 */
public class TangPoemAnalyzeApplication {
    public static void main(String[] args) {
        ConfigProperties configProperties = new ConfigProperties();
//        final Page page = new Page(configProperties.getCrawlerBase(),
//                configProperties.getCrawlerPath(),
//                configProperties.isCrawlerDetail());
//
//
//        Crawler crawler = new Crawler();
//
//        crawler.addParse(new DocumentParse());
//
//        crawler.addParse(new DataPageParse());
//
//        crawler.addPipeline(new ConsolePipeline());

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(configProperties.getDbUserName());
        dataSource.setPassword(configProperties.getDbPassword());
        dataSource.setDriverClassName(configProperties.getDbDriverClass());
        dataSource.setUrl(configProperties.getDburl());

//               crawler.addPipeline(new DatabasePipeline(dataSource));
//
//        crawler.addPage(page);
//
//        crawler.start();
//
//        crawler.stop();

        AnalyzeDao analyzeDao = new AnalyzeDaoImpl(dataSource);
//        System.out.println("测试一");
//        analyzeDao.analyzeAuthorCount().forEach(System.out::println);
//        System.out.println("测试二");
//        analyzeDao.queryAllPoetryINfo().forEach(System.out::println);

        AnalyzeService analyzeService = new AnalyzeServiceImpl(analyzeDao);

        analyzeService.analyzeWordCloud().forEach(System.out::println);
    }
}


