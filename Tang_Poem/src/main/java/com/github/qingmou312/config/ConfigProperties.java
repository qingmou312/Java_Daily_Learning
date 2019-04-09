package com.github.qingmou312.config;

import lombok.Data;

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


}
