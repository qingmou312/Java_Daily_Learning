package com.github.qingmou312.everything.core.interceptor;

import java.io.File;

/**
 * 文件拦截器，处理指定文件
 * Author:lidan
 * Created:2019/3/19
 */

@FunctionalInterface
public interface FileInterceptor {
    void apply(File file);
}
