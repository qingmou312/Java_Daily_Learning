package com.github.qingmou312.crawler.common;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储清洗的数据
 * Author:lidan
 * Created:2019/3/17
 */
@ToString
public class DataSet {
    /*
     * data把DOM解析,清洗之后存储的数据
     * 比如:
     * 标题:XXXXX
     * 作者:XXXX
     * 正文:XXXXX
     *
     * */

    private Map<String, Object> data = new HashMap<>();


    public void putData(String key, Object value) {
        this.data.put(key, value);
    }


    //获取数据的集合
    public Object getData(String key) {
        return this.data.get(key);
    }

    public Map<String, Object> getData() {
        return new HashMap<>(this.data);
    }
}
