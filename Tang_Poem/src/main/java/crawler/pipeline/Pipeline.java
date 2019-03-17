package crawler.pipeline;

import com.gargoylesoftware.htmlunit.Page;

/**
 * Author:lidan
 * Created:2019/3/17
 */
public interface Pipeline {
    void pipeline(Page page);
}
