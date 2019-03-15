package com.github.qingmou312.everything.core.DAO;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据源工厂
 * 单例模式
 * Author:lidan
 * Created:2019/3/16
 */
public class DataSourceFactory {
    //数据源(单例)
    private static volatile DruidDataSource dataSource;


    private DataSourceFactory() {

    }

    public static DataSource dataSource() {
        if (dataSource == null) {
            //多线程模式下,保证不会有线程的竞争
            synchronized (DataSourceFactory.class) {
                if (dataSource == null) {
                    //实例化
                    dataSource = new DruidDataSource();
                    dataSource.setDriverClassName("org.h2.Driver");
                    //url,username,password
                    //采用的时H2的嵌入式数据库,数据库以本地文件的方式存储,只需要提供url接口
                    String workDir = System.getProperty("user.dir");
                    dataSource.setUrl("jdbc:h2:" + workDir + File.separator + "Everything");//创建数据源的时候已经创建了数据库
                }
            }
        }
        return dataSource;
    }

    public static void initDatabase() {
        //获取数据源
        DataSource dataSource = DataSourceFactory.dataSource();
        //获取sql语句
        try (InputStream in = DataSourceFactory.class.getClassLoader().getResourceAsStream("everything.sql");) {
            if (in == null) {
                throw new RuntimeException("Not read init database script ,please check it");
            }
            StringBuilder sqlBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (!line.startsWith("-- ")) {
                        sqlBuilder.append(line);
                    }
                }
            }
            String sql = sqlBuilder.toString();
            //JDBC
            //获取数据库的连接
            Connection connection = dataSource.getConnection();
            //创建命令
            PreparedStatement statement = connection.prepareStatement(sql);
            //执行sql语句
            statement.execute();

            connection.close();
            statement.close();

        } catch (IOException e) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
