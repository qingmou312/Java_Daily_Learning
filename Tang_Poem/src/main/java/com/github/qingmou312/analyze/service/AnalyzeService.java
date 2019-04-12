package com.github.qingmou312.analyze.service;

import com.github.qingmou312.analyze.model.AuthorCount;
import com.github.qingmou312.analyze.model.WordCount;

import java.util.List;

/**
 * Author:lidan
 * Created:2019/4/11
 */
public interface AnalyzeService {
    /**
     * 分析唐诗中作者的创作数量
     *
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();

    /**
     * 词云分析
     *
     * @return
     */
    List<WordCount> analyzeWordCloud();
}
