package com.github.qingmou312.everything.core.search.impl;

import com.github.qingmou312.everything.core.DAO.FileIndexDAO;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;
import com.github.qingmou312.everything.core.search.FileSearch;

import java.util.List;

/**
 * 业务层
 * Author:lidan
 * Created:2019/3/19
 */
public class FileSearchImpl implements FileSearch {

    private final FileIndexDAO fileIndexDAO;

    public FileSearchImpl(FileIndexDAO fileIndexDAO) {
        this.fileIndexDAO = fileIndexDAO;
    }

    @Override
    public List<Thing> search(Condition condition) {
        return this.fileIndexDAO.search(condition);
    }
}
