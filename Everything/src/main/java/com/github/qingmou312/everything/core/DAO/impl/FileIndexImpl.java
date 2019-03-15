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
public class FileIndexImpl implements FileIndexDAO {

    private final DataSource dataSource;

    //不想让DataSource和DataSourceFactory这两个类耦合
    public FileIndexImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Thing thing) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取数据库的连接
            connection = dataSource.getConnection();

            //准备sql语句
            String sql = "insert into Everything (name,path,depth,file_type)values(?,?,?,?)";

            //准备命令
            preparedStatement = connection.prepareStatement(sql);

            //设置参数1 2 3 4
            preparedStatement.setString(1, thing.getName());
            preparedStatement.setString(2, thing.getPath());
            preparedStatement.setInt(3, thing.getDepth());
            preparedStatement.setString(4, thing.getFileType().name());

            //执行命令
            preparedStatement.execute();
        } catch (SQLException e) {

        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

    @Override
    public List<Thing> search(Condition condition) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Thing> things = new ArrayList<>();
        try {
            //获取数据库的连接
            connection = dataSource.getConnection();

            //准备sql语句
            String sql = "select name,path,depth,file_type from  Everything ";

            //准备命令
            preparedStatement = connection.prepareStatement(sql);

            //执行命令
            resultSet = preparedStatement.executeQuery();

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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
        return things;
    }

    public static void main(String[] args) {
        FileIndexDAO fileIndexDAO = new FileIndexImpl(DataSourceFactory.dataSource());

        Thing thing = new Thing();

        thing.setName("简历.ppt");

        thing.setPath("D:\\a\\test\\简历.ppt");

        thing.setDepth(3);

        thing.setFileType(FileType.DOC);

        fileIndexDAO.insert(thing);

        List<Thing> things = fileIndexDAO.search(new Condition());

        for(Thing t:things){
            System.out.println(t);
        }

    }
}
