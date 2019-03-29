package com.github.qingmou312.everything.core.search.impl;

import com.github.qingmou312.everything.core.DAO.FileDAO;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;
import com.github.qingmou312.everything.core.search.FileSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 * Author:lidan
 * Created:2019/3/19
 */
public class FileSearchImpl implements FileSearch {

    private final FileDAO fileIndexDAO;

    public FileSearchImpl(FileDAO fileIndexDAO) {
        this.fileIndexDAO = fileIndexDAO;
    }

    @Override
    public List<Thing> search(Condition condition) {
        if (condition == null) {
            return new ArrayList<>();
        }
        return this.fileIndexDAO.search(condition);
    }
}
