package com.github.qingmou312.client.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.github.qingmou312.util.CommUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author:lidan
 * Created:2019/8/12
 * 封装基础Dao操作，获取数据源，连接，关闭资源等
 */
public class BaseDao {
    private static DruidDataSource dataSource;

    static {
        Properties properties = CommUtils.loadProperties("datasource.properties");
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("数据源加载失败。");
            e.printStackTrace();
        }
    }

    protected DruidPooledConnection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
        } catch (Exception e) {
            System.err.println("数据库连接获取失败");
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    protected void closeResources(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        closeResources(connection,statement);
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
