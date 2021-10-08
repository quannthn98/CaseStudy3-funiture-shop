package dao.New;

import config.DBConnection;
import model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewDao implements INewDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<News> getAll() {
        List<News> newss = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM News");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String subtitle = resultSet.getString("subtitle");
                Date createDate = resultSet.getDate("createdDate");
                String description = resultSet.getString("description");
                boolean status = resultSet.getBoolean("status");
                int id_Customer = resultSet.getInt("id_Customer");
                News news = new News(id,title,subtitle,createDate,description,status,id_Customer);
                newss.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newss;
    }

    @Override
    public News findById(int id) {
        News news = new News();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from News where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                String subtitle = resultSet.getString("subtitle");
                Date createDate = resultSet.getDate("createdDate");
                String description = resultSet.getString("description");
                boolean status = resultSet.getBoolean("status");
                int id_Customer = resultSet.getInt("id_Customer");
                news = new News(id,title,subtitle, createDate,description,status,id_Customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public boolean save(News news) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        Boolean isDelete = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteNewsById(?)");
            callableStatement.setInt(1,id);
            isDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public boolean update(int id, News news) {
        Boolean isUpdate =  false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call updateNewsById(?,?,?,?,?,?)");
            callableStatement.setInt(1,id);
            callableStatement.setString(2,news.getTitle());
            callableStatement.setString(3,news.getSubtitle());
            callableStatement.setString(4,news.getDescription());
            callableStatement.setBoolean(5,news.isStatus());
            callableStatement.setInt(6,news.getId_Customer());
            isUpdate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean add(News news) {
        Boolean isCreate = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call insertNewsById(?,?,?,?,?)");
            callableStatement.setString(1,news.getTitle());
            callableStatement.setString(2,news.getSubtitle());
            callableStatement.setString(3,news.getDescription());
            callableStatement.setBoolean(4,news.isStatus());
            callableStatement.setInt(5,news.getId_Customer());
            isCreate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreate;
    }

    @Override
    public List<News> findByName(String title) {
        List<News> newss = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from NEW where title like ?");
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title1 = resultSet.getString("title");
                String subtitle = resultSet.getString("subtitle");
                Date createDate = resultSet.getDate("createdDate");
                String description = resultSet.getString("description");
                boolean status = resultSet.getBoolean("status");
                int id_Customer = resultSet.getInt("id_Customer");
                News news = new News(id,title1,subtitle, createDate,description,status,id_Customer);
                newss.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newss;
    }
}
