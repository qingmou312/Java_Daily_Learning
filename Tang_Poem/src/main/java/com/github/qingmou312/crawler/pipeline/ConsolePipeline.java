package com.github.qingmou312.crawler.pipeline;

import com.github.qingmou312.crawler.common.Page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Author:lidan
 * Created:2019/3/17
 */
public class ConsolePipeline implements Pipeline {

    int flag = 0;//爬取诗详情的数量统计

    @Override
    public void pipeline(Page page) {
//        flag++;
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//        System.out.println(df.format(new Date()));
        Map<String, Object> data = page.getDataSet().getData();
        System.out.println(data);
//        System.out.println(df.format(new Date()));
//        System.out.println(flag);
    }

}
