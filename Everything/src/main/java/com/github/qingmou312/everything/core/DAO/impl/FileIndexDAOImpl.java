package com.github.qingmou312.everything.core.DAO.impl;

import com.github.qingmou312.everything.core.DAO.DataSourceFactory;
import com.github.qingmou312.everything.core.DAO.FileIndexDAO;
import com.github.qingmou312.everything.core.model.Condition;
import com.github.qingmou312.everything.core.model.FileType;
import com.github.qingmou312.everything.core.model.Thing;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:lidan
 * Created:2019/3/16
 */
public class FileIndexDAOImpl implements FileIndexDAO {

    private final DataSource dataSource;

    //不想让DataSource和DataSourceFactory这两个类耦合
    public FileIndexDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Thing thing) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取数据库的连接
            connection = dataSource.getConnection();

            //准备sql语句
            String sql = "insert into Everything_index (name,path,depth,file_type)values(?,?,?,?)";

            //准备命令
            statement = connection.prepareStatement(sql);

            //设置参数1 2 3 4
            statement.setString(1, thing.getName());
            statement.setString(2, thing.getPath());
            statement.setInt(3, thing.getDepth());
            statement.setString(4, thing.getFileType().name());


            //执行命令
            statement.executeUpdate();


        } catch (SQLException e) {

        } finally {
            releaseResource(null,statement,connection);
        }

    }

    @Override
    public List<Thing> search(Condition condition) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Thing> things = new ArrayList<>();
        try {
            //获取数据库的连接
            connection = dataSource.getConnection();

            //准备sql语句
            //name :like
            //fileType : =
            //limit : limit offset
            //orderByAsc : order by

            /**
             * 为什么没用StringBufffer?
             * 在方法的作用域,不会被多线程共享
             *
             * */
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append("select name,path,depth,file_type from  Everything_index ");

            //name 匹配:前模糊,后模糊,前后模糊
            sqlBuilder.append(" where ").append(" name like '%").append(condition.getName()).append("%' ");

            if (condition.getFileType() != null) {
                sqlBuilder.append(" and file_type = '").append(condition.getFileType().toUpperCase()).append("' ");
            }

            //limit order by
            sqlBuilder.append(" order by depth ").append(condition.getOrderByAsc() ? "asc" : "desc");

            sqlBuilder.append(" limit ").append(condition.getLimit()).append(" offset 0");

            System.out.println(sqlBuilder.toString());

            //准备命令
            statement = connection.prepareStatement(sqlBuilder.toString());

            //执行命令
            resultSet = statement.executeQuery();

            //处理结果
            while (resultSet.next()) {
                //数据库中的行记录要变成Thing对象
                Thing thing = new Thing();
                thing.setName(resultSet.getString("name"));
                thing.setPath(resultSet.getString("path"));
                thing.setDepth(resultSet.getInt("depth"));
                String filetype = resultSet.getString("file_type");
                thing.setFileType(FileType.lookupByName(filetype));
                things.add(thing);
            }

        } catch (SQLException e) {

        } finally {
            releaseResource(resultSet,statement,connection);
        }
        return things;
    }

    //解决内部代码大量重复问题,重构
    private  void releaseResource(ResultSet resultSet,PreparedStatement Statement,Connection connection){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (Statement != null) {
            try {
                Statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
