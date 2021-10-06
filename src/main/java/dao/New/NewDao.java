package dao.New;

import config.DBConnection;
import model.Company;
import model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewDao implements INewDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<News> getAll() {
        List<News> newss = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from News");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String subtitle = resultSet.getString("subtitle");
                Date createDate = resultSet.getDate("createDate");
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
        return null;
    }

    @Override
    public boolean save(News news) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, News news) {
        return false;
    }

    @Override
    public boolean add(News news) {
        return false;
    }

    @Override
    public List<News> findByName(String name) {
        return null;
    }
}
