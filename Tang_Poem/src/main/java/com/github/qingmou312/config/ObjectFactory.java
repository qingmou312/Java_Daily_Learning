package com.github.qingmou312.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.qingmou312.analyze.dao.AnalyzeDao;
import com.github.qingmou312.analyze.dao.impl.AnalyzeDaoImpl;
import com.github.qingmou312.analyze.service.AnalyzeService;
import com.github.qingmou312.analyze.service.impl.AnalyzeServiceImpl;
import com.github.qingmou312.crawler.Crawler;
import com.github.qingmou312.crawler.common.Page;
import com.github.qingmou312.crawler.parse.DataPageParse;
import com.github.qingmou312.crawler.parse.DocumentParse;
import com.github.qingmou312.crawler.pipeline.ConsolePipeline;
import com.github.qingmou312.crawler.pipeline.DatabasePipeline;
import com.github.qingmou312.web.WebController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象工厂
 * Author:lidan
 * Created:2019/3/23
 */
public final class ObjectFactory {

    private static final ObjectFactory instance = new ObjectFactory();

    /**
     * 存放所有的对象
     */
    private final Map<Class, Object> objectHashMap = new HashMap<>();

    private ObjectFactory() {
        //1.初始化配置对象
        initConfigProperties();

        //2.创建数据源对象
        initDataSource();

        //3.爬虫对象
        initCrawler();

        //4.Web对象
        initWebController();

        //5.对象清单打印输出
        printObjectList();
    }

    private void initWebController() {
        DataSource dataSource = getObject(DataSource.class);
        AnalyzeDao analyzeDao = new AnalyzeDaoImpl(dataSource);
        AnalyzeService analyzeService = new AnalyzeServiceImpl(analyzeDao);

        WebController webController = new WebController(analyzeService);

        objectHashMap.put(WebController.class, webController);
    }

    private void initCrawler() {
        ConfigProperties configProperties = getObject(ConfigProperties.class);

        DataSource dataSource = getObject(DataSource.class);
        final Page page = new Page(configProperties.getCrawlerBase(),
                configProperties.getCrawlerPath(),
                configProperties.isCrawlerDetail());

        Crawler crawler = new Crawler();

        crawler.addParse(new DocumentParse());

        crawler.addParse(new DataPageParse());

        if (configProperties.isEnableConsole()) {

            crawler.addPipeline(new ConsolePipeline());

        }

        crawler.addPipeline(new DatabasePipeline(dataSource));

        crawler.addPage(page);

        objectHashMap.put(Crawler.class, crawler);
    }

    private void initDataSource() {
        ConfigProperties configProperties = getObject(ConfigProperties.class);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(configProperties.getDbUserName());
        dataSource.setPassword(configProperties.getDbPassword());
        dataSource.setDriverClassName(configProperties.getDbDriverClass());
        dataSource.setUrl(configProperties.getDburl());

        objectHashMap.put(DataSource.class, dataSource);
    }

    private void initConfigProperties() {
        ConfigProperties configProperties = new ConfigProperties();
        objectHashMap.put(ConfigProperties.class, configProperties);
    }

    public <T> T getObject(Class classz) {
        if (!objectHashMap.containsKey(classz)) {
            throw new IllegalArgumentException("Class " + classz.getName() + " not found Object");
        }
        return (T) objectHashMap.get(classz);
    }

    public static ObjectFactory getInstance() {
        return instance;
    }

    private void printObjectList() {
        System.out.println("==============ObjectFactory  List================");
        for (Map.Entry<Class, Object> entry : objectHashMap.entrySet()) {
            System.out.println(String.format("\t[%s]==>[%s]", entry.getKey().getCanonicalName(), entry.getValue().getClass().getCanonicalName()));
        }
        System.out.println("=================================================");
    }

}
