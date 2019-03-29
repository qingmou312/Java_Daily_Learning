package com.github.qingmou312.everything.core.DAO;

import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.Thing;

import java.util.List;

/**
 * 业务层访问数据库
 * Author:lidan
 * Created:2019/3/16
 */
public interface FileDAO {
    //插入数据thing
    void insert(Thing thing);

    //删除数据Thing
    void delete(Thing thing);

    //根据condition条件进行数据库的检索
    List<Thing> search(Condition condition);

}
