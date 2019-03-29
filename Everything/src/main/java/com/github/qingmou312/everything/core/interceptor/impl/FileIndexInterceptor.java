package com.github.qingmou312.everything.core.interceptor.impl;

import com.github.qingmou312.everything.core.DAO.FileDAO;
import com.github.qingmou312.everything.core.common.FileConvertThing;
import com.github.qingmou312.everything.core.interceptor.FileInterceptor;
import com.github.qingmou312.everything.core.model.Thing;

import java.io.File;

/**
 * Author:lidan
 * Created:2019/3/19
 */
public class FileIndexInterceptor implements FileInterceptor {

    private final FileDAO fileIndexDAO;

    public FileIndexInterceptor(FileDAO fileIndexDAO) {
        this.fileIndexDAO = fileIndexDAO;
    }


    @Override
    public void apply(File file) {

        Thing thing = FileConvertThing.convert(file);

        fileIndexDAO.insert(thing);
    }
}
