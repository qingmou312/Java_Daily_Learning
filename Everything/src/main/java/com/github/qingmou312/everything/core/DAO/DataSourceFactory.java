package com.github.qingmou312.everything.core.DAO;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.qingmou312.everything.config.EverythingConfig;

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
    private static volatile DruidDataSource instance;

    private DataSourceFactory() {

    }

    public static DataSource dataSource() {
        if (instance == null) {
            //多线程模式下,保证不会有线程的竞争
            synchronized (DataSourceFactory.class) {
                if (instance == null) {
                    instance = new DruidDataSource();
                    instance.setDriverClassName("org.h2.Driver");
                    //采用的时H2的嵌入式数据库,数据库以本地文件的方式存储,只需要提供url接口
                    //获取当前工程路径
                    instance.setUrl("jdbc:h2:" + EverythingConfig.getInstance().getH2IndexPath());//创建数据源的时候已经创建了数据库
                    //第一种处理错误的方法
                    instance.setValidationQuery("select now()");
                    //第二种
                    //dataSource.setTestWhileIdle(false);

//                    instance.setUrl("jdbc:mysql://127.0.0.1:3306/Everything_index");
//                    instance.setUsername("root");
//                    instance.setPassword("123456");
//                    instance.setDriverClassName("com.mysql.jdbc.Driver");

                }
            }
        }
        return instance;
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
                    if (!line.startsWith("--")) {
                        sqlBuilder.append(line);
                    }
                }
            }
            String sql = sqlBuilder.toString();

            //获取数据库的连接
            Connection connection = dataSource.getConnection();

            //创建命令
            PreparedStatement statement = connection.prepareStatement(sql);

            //执行sql语句
            statement.execute();

            connection.close();

            statement.close();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
