package com.github.qingmou312.everything.core.search;

import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.DAO.FileIndexDAO;
import com.github.qingmou312.everything.core.DAO.impl.FileIndexDAOImpl;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;
import com.github.qingmou312.everything.core.search.impl.FileSearchImpl;

import java.util.List;

/**
 * 根据Condition条件进行数据库的检索
 * Author:lidan
 * Created:2019/3/19
 */
public interface FileSearch {
    List<Thing> search(Condition condition);

}
