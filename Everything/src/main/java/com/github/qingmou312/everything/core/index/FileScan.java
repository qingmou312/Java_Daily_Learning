package com.github.qingmou312.everything.core.index;

import com.github.qingmou312.everything.core.interceptor.FileInterceptor;

/**
 * 建立索引
 * Author:lidan
 * Created:2019/3/19
 */
public interface FileScan {

    //遍历path
    void index(String path);

    //遍历拦截器
    void interceptor(FileInterceptor fileIndexInterceptor);
}
