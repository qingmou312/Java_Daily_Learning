package crawler.common;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:lidan
 * Created:2019/3/17
 */
@Data
public class Page {

    //网页的根地址
    private String base;

    //具体的网页路径
    private String path;

    //
    private DataSet dataSet;

    //网页的DOM对象
    private HtmlPage htmlPage;

    //标识网页是否是详情页
    private boolean detail;

    //子页面对象集合
    private Set<Page> subPage = new HashSet<>();

    public Page(String base, String path, boolean detail) {
        this.base = base;
        this.path = path;
        this.detail = detail;
    }

    //数据对象
    public String getUrl() {
        return this.base + this.path;
    }


}
