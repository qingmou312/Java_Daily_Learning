package com.github.qingmou312.crawler.parse;


import com.gargoylesoftware.htmlunit.html.*;
import com.github.qingmou312.crawler.common.Page;

/**
 * 详情页面解析
 * Author:lidan
 * Created:2019/3/17
 */

public class DataPageParse implements Parse {

    @Override
    public void parse(Page page) {
        if (!page.isDetail()) {
            return;
        }

        HtmlPage htmlPage = page.getHtmlPage();

        HtmlElement body = htmlPage.getBody();

        //标题
        ///html/body/div[3]/div[1]/div[1]/div[1]/h1
        //body > div.main3 > div.left > div:nth-child(1) > div.cont > h1

        String titlePath = "//div[@class='cont']/h1/text()";
        DomText titleDom = (DomText) body.getByXPath(titlePath).get(0);
        String title = titleDom.asText();

        //朝代
        String dynastyPath = "//div[@class='cont']/p/a[1]";
        HtmlAnchor dynastyDom = (HtmlAnchor) body.getByXPath(dynastyPath).get(0);
        String dynasty = dynastyDom.asText();

        //作者
        String authorPath = "//div[@class='cont']/p/a[2]";
        HtmlAnchor authorDom = (HtmlAnchor) body.getByXPath(authorPath).get(0);
        String author = authorDom.asText();

        //正文
        String contentPath = "//div[@class='cont']/div[@class='contson']";
        HtmlDivision contentDom = (HtmlDivision) body.getByXPath(contentPath).get(0);
        String content = contentDom.asText();


        page.getDataSet().putData("title", title);
        page.getDataSet().putData("dynasty", dynasty);
        page.getDataSet().putData("author", author);
        page.getDataSet().putData("content", content);
        page.getDataSet().putData("url", page.getUrl());

    }
}
