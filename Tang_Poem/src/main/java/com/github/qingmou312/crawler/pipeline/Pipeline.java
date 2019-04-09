package com.github.qingmou312.crawler.pipeline;


import com.github.qingmou312.crawler.common.Page;

/**
 * Author:lidan
 * Created:2019/3/17
 */
public interface Pipeline {
    //清洗
    void pipeline(Page page);
}
