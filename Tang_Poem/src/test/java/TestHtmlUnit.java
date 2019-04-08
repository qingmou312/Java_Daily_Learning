import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Author:lidan
 * Created:2019/4/6
 */
public class TestHtmlUnit {
    public static void main(String[] args) {
        try (WebClient webClien = new WebClient(BrowserVersion.CHROME)) {
            try {
                webClien.getOptions().setJavaScriptEnabled(false);

                HtmlPage htmlPage = webClien.getPage("https://www.gushiwen.org/shiwenv_45c396367f59.aspx");

//                HtmlElement htmlElement = htmlPage.getBody();
//
//                String text = htmlElement.asXml();
//
//                System.out.println(text);

                HtmlDivision domElement = (HtmlDivision) htmlPage.getElementById("contson45c396367f59");

                String divContent = domElement.asText();

                System.out.println(divContent);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
