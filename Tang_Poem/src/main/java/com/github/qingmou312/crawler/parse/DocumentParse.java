package com.github.qingmou312.crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.github.qingmou312.crawler.common.Page;

/**
 * 链接解析
 * Author:lidan
 * Created:2019/3/17
 */
public class DocumentParse implements Parse {
    @Override
    public void parse(Page page) {

        if (page.isDetail()) {
            return;
        }

        HtmlPage htmlPage = page.getHtmlPage();

        //获取网页的连接
        htmlPage.getBody()
                .getElementsByAttribute("div", "class", "typecont")
                .forEach(div -> {
                            //a标签节点的集合
                            DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                            aNodeList.forEach(aNode -> {
                                        //将取出的超链接放入到子页面对象集合中
                                        String path = aNode.getAttribute("href");//获取a标签下的属性为href的连接

                                        Page subPage = new Page(page.getBase(), path, true);

                                        page.getSubPage().add(subPage);
                                    }
                            );
                        }
                );

//        htmlPage.getBody()
////                .getElementsByAttribute("div",
////                        "class",
////                        "typecont")
////                .forEach(new Consumer<HtmlElement>() {
////                    @Override
////                    public void accept(HtmlElement htmlElement) {
////                        DomNodeList<HtmlElement> nodeList = htmlElement.getElementsByTagName("a");
////                        nodeList.forEach(
////                                aNode -> {
////                                    String path = aNode.getAttribute("href");
////                                    System.out.println(path);
////                                }
////                        );
////                    }
////                });
    }
}
