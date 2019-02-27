package jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:lidan
 * Created:2019/2/27
 */
public class TestJDBC {
    public static void main(String[] args) {
        //为什么这里搜索不到mysql驱动？因为mysql-connector-java不在classpath
        //1.加载驱动程序     备注：5.1版本之后可以不明确加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //2.连接数据库
        //关于数据库连接的URL格式JDBC规范里面也有定义
        //jdbc:database://host:port/databaseName?p1=v1&p2=v2
        try {
            Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/memo?useSSL=false", "root", "123456");


            //3.创建命令
            Statement statement = connection.createStatement();

            //4.准备sql,并且执行
            ResultSet resultSet = statement.executeQuery("select id,name,created_time,modify_time from memo_group");

            //5.返回结果集，处理结果
            while (resultSet.next()) {
                //如果返回true，表示有下一行记录，否则无记录
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createTime = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifyTime=resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(
                        String.format("编号：%d,名称：%s,创建时间：%s,修改时间：%s",id,name,createTime.toString(),modifyTime.toString())
                );
            }


            //6.关闭结果集
            resultSet.close();

            //7.关闭命令
            statement.close();

            //8.关闭连接
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
