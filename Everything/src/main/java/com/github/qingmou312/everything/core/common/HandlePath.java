package com.github.qingmou312.everything.core.common;

import lombok.Data;

import java.util.Set;

/**
 * Author:lidan
 * Created:2019/3/23
 */
@Data
public class HandlePath {

    private Set<String> includePath;

    private Set<String> excludePath;
}
