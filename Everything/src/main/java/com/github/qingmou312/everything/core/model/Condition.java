package com.github.qingmou312.everything.core.model;

import lombok.Data;

/**
 * 检索的参数(条件)condition
 * Author:lidan
 * Created:2019/3/16
 */
@Data
public class Condition {

    private String name;

    private String fileType;

    private Integer limit;

    private Boolean orderByAsc;//检索结果的文件信息depth排序规则  默认是true ->asc  false->desc
}
