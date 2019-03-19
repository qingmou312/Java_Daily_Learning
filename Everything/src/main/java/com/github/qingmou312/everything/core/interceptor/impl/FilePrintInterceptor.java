package com.github.qingmou312.everything.core.interceptor.impl;

import com.github.qingmou312.everything.core.interceptor.FileInterceptor;

import java.io.File;

/**
 * Author:lidan
 * Created:2019/3/19
 */
public class FilePrintInterceptor implements FileInterceptor {
    @Override
    public void apply(File file) {
        System.out.println(file.getAbsolutePath());
    }
}
