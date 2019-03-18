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
        htmlPage.getBody().getElementsByAttribute("div", "class", "typecont").forEach(div -> {
                    //a标签节点的集合
                    DomNodeList<HtmlElement> aNodeList = div.getElementsByTagName("a");
                    aNodeList.forEach(aNode -> {
                                String path = aNode.getAttribute("href");
                                Page subPage = new Page(page.getBase(), path, true);
                                page.getSubPage().add(subPage);
                            }
                    );
                }
        );
    }

}
