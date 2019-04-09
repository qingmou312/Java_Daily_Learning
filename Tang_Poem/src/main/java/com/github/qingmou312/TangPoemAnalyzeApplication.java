package com.github.qingmou312;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.qingmou312.crawler.Crawler;
import com.github.qingmou312.crawler.common.Page;
import com.github.qingmou312.crawler.parse.DataPageParse;
import com.github.qingmou312.crawler.parse.DocumentParse;

/**
 * Author:lidan
 * Created:2019/3/30
 */
public class TangPoemAnalyzeApplication {
    public static void main(String[] args) {
        final Page page = new Page("https://so.gushiwen.org", "/gushi/tangshi.aspx", false);


        Crawler crawler = new Crawler();

        crawler.addParse(new DocumentParse());

        crawler.addParse(new DataPageParse());

//        com.github.qingmou312.crawler.addPipeline(new ConsolePipeline());

//        com.github.qingmou312.crawler.addPipeline(new DatabasePipeline());

        crawler.addPage(page);

        crawler.start();

        crawler.stop();
    }
}


