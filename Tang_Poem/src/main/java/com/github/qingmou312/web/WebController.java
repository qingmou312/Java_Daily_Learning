package com.github.qingmou312.web;


import com.github.qingmou312.analyze.model.AuthorCount;
import com.github.qingmou312.analyze.model.WordCount;
import com.github.qingmou312.analyze.service.AnalyzeService;
import com.google.gson.Gson;
import spark.ResponseTransformer;
import spark.Spark;

import java.util.List;

/**
 * Author:lidan
 * Created:2019/3/23
 *
 * SparkJava框架完成web API 开发
 */
public class WebController {

    private final AnalyzeService analyzeService;

    public  WebController(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }


    //->http://127.0.0.1:4567/
    //->/analyze/author_count
    public List<AuthorCount> analyzeAuthorCount() {
        return analyzeService.analyzeAuthorCount();
    }

    //->http://127.0.0.1:4567/
    //->/analyze/word_cloud
    private List<WordCount> analyzeWorldCloud() {
        return analyzeService.analyzeWordCloud();
    }

    public void launch() {
        ResponseTransformer responseTransformer = new JSONResponseTransformer();

        //src/main/resources/static
        Spark.staticFileLocation("/static");

        Spark.get("/analyze/author_count", ((request, response) -> analyzeAuthorCount()), responseTransformer);
        Spark.get("/analyze/word_cloud", ((request, response) -> analyzeWorldCloud()), responseTransformer);
    }

    public static class JSONResponseTransformer implements ResponseTransformer {
        private Gson gson = new Gson();

        @Override
        public String render(Object o) throws Exception {
            return gson.toJson(o);
        }
    }

}
