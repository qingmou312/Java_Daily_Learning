package com.github.qingmou312.crawler.pipeline;

import com.github.qingmou312.crawler.common.Page;

import java.util.Map;


/**
 * Author:lidan
 * Created:2019/3/17
 */
public class ConsolePipeline implements Pipeline {

    @Override
    public void pipeline(Page page) {
        Map<String, Object> data = page.getDataSet().getData();
        System.out.println(data);
    }
}
