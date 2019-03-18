package crawler.parse;


import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlAcronym;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import crawler.common.Page;

/**
 * 解析
 * Author:lidan
 * Created:2019/3/17
 */

public class DataPageParse implements Parse {

    @Override
    public void pase(Page page) {
        if (!page.isDetail()) {
            return;
        }

        HtmlPage htmlPage = page.getHtmlPage();
        HtmlElement body = htmlPage.getBody();

        //标题
        String titlePath = "//div[@class='cont']/h1/text()";
        DomText titleDom = (DomText) body.getByXPath(titlePath).get(0);
        String title = titleDom.asText();

        //朝代
        String dynastyPath = "//div[@class='cont']/p/a[1]";
        DomText dynastyDom = (DomText) body.getByXPath(dynastyPath).get(0);
        String dynasty = dynastyDom.asText();
    }
}
