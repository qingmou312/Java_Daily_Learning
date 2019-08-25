package com.github.qingmou312.client.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author: lidan
 * @date: 2019/8/25 8:56
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String brief;
    private Set<String> userNames;
}
