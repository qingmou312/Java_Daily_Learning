package com.github.qingmou312.analyze.dao.impl;

import com.github.qingmou312.analyze.dao.AnalyzeDao;
import com.github.qingmou312.analyze.entity.PoertyInfo;
import com.github.qingmou312.analyze.model.AuthorCount;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:lidan
 * Created:2019/3/23
 */
public class AnalyzeDaoImpl implements AnalyzeDao {

    public final DataSource dataSource;

    public AnalyzeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        String sql = "select count(*) as count,author from tang_poem_info group by author";

        List<AuthorCount> authorCounts = new ArrayList<>();
        /**
         * 自动关闭
         *
         */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        ) {
            while (rs.next()) {
                AuthorCount authorCount = new AuthorCount();
                authorCount.setAuthor(rs.getString("author"));
                authorCount.setCount(rs.getInt("count"));
                authorCounts.add(authorCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorCounts;
    }

    @Override
    public List<PoertyInfo> queryAllPoetryINfo() {

        List<PoertyInfo> poertyInfos = new ArrayList<>();
        String sql = "select title,dynasty,author,content from tang_poem_info;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                PoertyInfo poertyInfo = new PoertyInfo();
                poertyInfo.setTitle(rs.getString("title"));
                poertyInfo.setDynasty(rs.getString("dynasty"));
                poertyInfo.setAuthor(rs.getString("author"));
                poertyInfo.setContent(rs.getString("content"));

                poertyInfos.add(poertyInfo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poertyInfos;
    }
}
