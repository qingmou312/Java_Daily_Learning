package com.github.qingmou312.everything.core.index;

import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.DAO.impl.FileIndexDAOImpl;
import com.github.qingmou312.everything.core.index.impl.FileScanImpl;
import com.github.qingmou312.everything.core.interceptor.FileInterceptor;
import com.github.qingmou312.everything.core.interceptor.impl.FileIndexInterceptor;
import com.github.qingmou312.everything.core.interceptor.impl.FilePrintInterceptor;

/**
 * 建立索引
 * Author:lidan
 * Created:2019/3/19
 */
public interface FileScan {

    //遍历path
    void index(String path);

    void interceptor(FileInterceptor fileIndexInterceptor);

    public static void main(String[] args) {
        FileScanImpl scan = new FileScanImpl();
        FileInterceptor printInterceptor = new FilePrintInterceptor();

        scan.interceptor( printInterceptor);

        FileInterceptor fileIndexInterceptor = new FileIndexInterceptor(new FileIndexDAOImpl(DataSourceFactory.dataSource()));

        scan.interceptor( fileIndexInterceptor);

        scan.index("D:\\test");
    }
}
