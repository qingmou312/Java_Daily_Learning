package crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import crawler.common.Page;

/**
 * 连接解析
 * Author:lidan
 * Created:2019/3/17
 */
public class DocumentParse implements Parse {
    @Override
    public void pase(Page page) {
        if (page.isDetail()) {
            return;
        }
        HtmlPage htmlPage = page.getHtmlPage();
        //获取网页的连接
        htmlPage.getBody().getElementsByAttribute("div", "class", "typecont").forEach(div -> {
                    //a标签节点的集合
                    DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                    aNodeList.forEach(aNode -> {
                        //将取出的超链接放入到子页面对象集合中
                                String path = aNode.getAttribute("href");//获取a标签下的属性为href的连接诶
                                Page subPage = new Page(page.getBase(), path, true);
                                page.getSubPage().add(subPage);
                            }
                    );
                }
        );
    }
}