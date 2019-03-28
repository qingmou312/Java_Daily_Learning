package crawler.pipeline;


import crawler.common.Page;

/**
 * Author:lidan
 * Created:2019/3/17
 */
public interface Pipeline {
    void pipeline(Page page);
}
