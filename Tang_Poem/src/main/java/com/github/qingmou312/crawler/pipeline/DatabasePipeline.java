package com.github.qingmou312.crawler.pipeline;

import com.github.qingmou312.crawler.common.Page;
import com.github.qingmou312.crawler.common.PoertyInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 数据库管道
 * Author:lidan
 * Created:2019/3/17
 */
public class DatabasePipeline implements Pipeline {

    private final DataSource dataSource;

    public DatabasePipeline(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void pipeline(Page page) {
        PoertyInfo poetryInfo = (PoertyInfo) page.getDataSet().getData("poetry");

        String sql = "insert into tang_poem_info (Title , Dynasty , Author , Content ) values (?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, poetryInfo.getTitle());
            statement.setString(2, poetryInfo.getDynasty());
            statement.setString(3, poetryInfo.getAuthor());
            statement.setString(4, poetryInfo.getContent());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
