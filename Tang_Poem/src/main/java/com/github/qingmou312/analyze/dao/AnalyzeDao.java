package com.github.qingmou312.analyze.dao;

import com.github.qingmou312.analyze.entity.PoertyInfo;
import com.github.qingmou312.analyze.model.AuthorCount;

import java.util.List;

/**
 * Author:lidan
 * Created:2019/3/23
 */
public interface AnalyzeDao {

    /**
     * 分析唐诗中作者的创作数量
     *
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();

    /**
     * 查询所有的诗文,提供给业务层进行分析
     *
     * @return
     */
    List<PoertyInfo> queryAllPoetryINfo();
}

