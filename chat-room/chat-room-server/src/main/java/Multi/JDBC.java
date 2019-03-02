package Multi;

import java.sql.*;
import java.util.ArrayList;

/**
 * Author:lidan
 * Created:2019/2/28
 */
public class JDBC {

    private Connection connection;//创建数据库连接对象

    //连接数据库的方法
    public void sql() {

        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //2.连接数据库
        try {
            String url = "jdbc:MySQL://localhost:3306/chat_room?useSSL=false";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //增加信息的方法
    public void addPersonInfo(ChatPersonInfo chatPersonInfo) {

        //创建命令
        try {
            Statement statement = connection.createStatement();

            // 创建SQL语句执行对象
            StringBuffer strSQL = new StringBuffer();

            // 组织SQL语句
            strSQL.append("insert into chat_room_info values('");
            strSQL.append(chatPersonInfo.getUserName());
            strSQL.append("','");
            strSQL.append(chatPersonInfo.getPassWord());
            strSQL.append("')");

            // 执行SQL语句
            statement.execute(strSQL.toString());

            //关闭命令
            statement.close();

            //关闭数据库连接
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //查找聊天室信息的方法
    public String selectPersonInfo(String name) {
        String result = null;
        try {
            //创建命令
            Statement statement = connection.createStatement();

            //4.准备sql,并且执行
            ResultSet resultSet = statement.executeQuery("select userName,passWord from chat_room_info where userName = '" + name + "'");

            //5.返回结果集，处理结果
            while (resultSet.next()) {
                String username = resultSet.getString("userName");
                String password = resultSet.getString("passWord");
                result = String.format("%s,%s", username, password);
            }

            //关闭结果集
            resultSet.close();

            //关闭命令
            statement.close();

            //关闭连接
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

