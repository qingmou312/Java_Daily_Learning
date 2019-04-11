package com.github.qingmou312.config;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author:lidan
 * Created:2019/3/17
 */
@Data
public class ConfigProperties {
    private String crawlerBase;
    private String crawlerPath;
    private boolean crawlerDetail;

    private String dbUserName;
    private String dbPassword;
    private String dburl;
    private String dbDriverClass;

    public ConfigProperties() {
        //从外部文件加载
        InputStream inputStream = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");

        Properties p = new Properties();
        try {
            p.load(inputStream);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.crawlerBase = String.valueOf(p.get("crawlerBase"));
        this.crawlerPath = String.valueOf(p.get("crawlerPath"));
        this.crawlerDetail = Boolean.parseBoolean(String.valueOf(p.get("crawlerDetail")));

        this.dbUserName = String.valueOf(p.get("dbUserName"));
        this.dbDriverClass = String.valueOf(p.get("dbDriverClass"));
        this.dbPassword = String.valueOf(p.get("dbPassword"));
        this.dburl = String.valueOf(p.get("dburl"));
    }
}
