package Multi;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:lidan
 * Created:2019/2/28
 */
public class JDBC {
    public static void main(String[] args) {
        sql();
    }
    public static void sql() {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //2.连接数据库
        try {
            Connection connection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/chat_room?useSSL=false", "root", "123456");


            //3.创建命令
            Statement statement = connection.createStatement();

            //4.准备sql,并且执行
            ResultSet resultSet = statement.executeQuery("select num,userName from chat_room_info");

            //5.返回结果集，处理结果
            while (resultSet.next()) {
                //如果返回true，表示有下一行记录，否则无记录
                int num = resultSet.getInt("num");
                String userName = resultSet.getString("userName");
                System.out.println(
                        String.format("id：%d,用户名：%s",num,userName.toString())
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

