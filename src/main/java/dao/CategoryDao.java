package dao;

import config.DBConnection;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    public static final String UPDATE_CATEGORY_SQL = "update category set name = ? , location = ? , status = ? where id = ?";
    public static final String DELETE_CATEGORY_SQL = "delete from category where id = ?";
    public static final String ADD_CATEGORY_SQL = "insert into category(name,location,status) values (?,?,?)";
    public static final String SELECT_CATEGORY_BY_ID_SQL = "select  * from category where id = ?";
    public static final String SELECT_ALL_SQL = "select * from category";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int location = rs.getInt("location");
                int status = rs.getInt("status");
                categoryList.add(new Category(id, name, location, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID_SQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int location = rs.getInt("location");
                int status = rs.getInt("status");
                category = new Category(id1, name, location, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean save(Category category) {
        boolean rowSaved = false;
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_CATEGORY_SQL);
            statement.setString(1, category.getName());
            statement.setInt(2, category.getLocation());
            statement.setInt(3, category.getStatus());
            rowSaved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSaved;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(int id, Category category) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);
            statement.setString(1, category.getName());
            statement.setInt(2, category.getLocation());
            statement.setInt(3, category.getStatus());
            statement.setInt(4, id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Category> getUniqueLocation() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("call showTopcategory()");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int location = rs.getInt("location");
                int status = rs.getInt("status");
                categoryList.add(new Category(id, name, location, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
