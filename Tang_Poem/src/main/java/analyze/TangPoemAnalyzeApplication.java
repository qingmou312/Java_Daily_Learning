package analyze;

import com.alibaba.druid.pool.DruidDataSource;
import crawler.Crawler;
import crawler.common.Page;
import crawler.parse.DataPageParse;
import crawler.parse.DocumentParse;
import crawler.pipeline.DatabasePipeline;

/**
 * Author:lidan
 * Created:2019/3/30
 */
public class TangPoemAnalyzeApplication {
//    public static void main(String[] args) {
//        final Page page = new Page("https://so.gushiwen.org",
//                "/gushi/tangshi.aspx",
//                false);
//
//        Crawler crawler = new Crawler();
//
//        crawler.addParse(new DocumentParse());
//
//        crawler.addParse(new DataPageParse());
//
//
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/tang_poem");
//
//        crawler.addPipeline(new DatabasePipeline(dataSource));
//
//        crawler.addPage(page);
//
//        crawler.start();
//    }
}

