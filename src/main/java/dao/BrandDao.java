package dao;

import config.DBConnection;
import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDao implements IBrandDao {
    public static final String SELECT_BRAND_SQL = "select * from  brand where id = ?";
    public static final String ADD_BRAND_SQL = "insert into brand(name,status) values (?,?);";
    public static final String DELETE_BRAND_SQL = "delete from brand where id = ?";
    public static final String UPDATE_BRAND_SQL = "update brand set name = ? , status = ? where  id = ?";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Brand> getAll() {
        List<Brand> brandList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from brand");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int status = rs.getInt("status");
                brandList.add(new Brand(id,name,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    @Override
    public Brand findById(int id) {
        Brand brand = new Brand();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BRAND_SQL);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int status = rs.getInt("status");
                brand = new Brand(id1,name,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public boolean save(Brand brand) {
        boolean rowSaved = false;
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_BRAND_SQL);
            statement.setString(1, brand.getName());
            statement.setInt(2,brand.getStatus());
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
            PreparedStatement statement = connection.prepareStatement(DELETE_BRAND_SQL);
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(int id, Brand brand) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BRAND_SQL);
            statement.setString(1, brand.getName());
            statement.setInt(2,brand.getStatus());
            statement.setInt(3,id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
