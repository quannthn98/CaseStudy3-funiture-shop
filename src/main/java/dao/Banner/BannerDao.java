package dao.Banner;


import config.DBConnection;
import model.Banner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BannerDao implements IBannerDao {
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Banner> getAll() {
        List<Banner> banners = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from banner");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                int location = resultSet.getInt("location");
                boolean status = resultSet.getBoolean("status");
                Banner banner = new Banner(id,name,image,location,status);
                banners.add(banner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banners;
    }

    @Override
    public Banner findById(int id) {
        return null;
    }

    @Override
    public boolean save(Banner banner) {
        return false;
    }

    @Override
    public boolean add(Banner banner) {
        Boolean isCreate = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call insertBannerById(?,?,?,?)");
            callableStatement.setString(1,banner.getName());
            callableStatement.setString(2,banner.getImage());
            callableStatement.setInt(3,banner.getLocation());
            callableStatement.setBoolean(4,banner.isStatus());
            isCreate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreate;
    }

    @Override
    public boolean update(int id, Banner banner) {
        Boolean isUpdate =  false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call updateBannerById(?,?,?,?,?);");
            callableStatement.setInt(1,id);
            callableStatement.setString(2,banner.getName());
            callableStatement.setString(3,banner.getImage());
            callableStatement.setInt(4,banner.getLocation());
            callableStatement.setBoolean(5,banner.isStatus());
            isUpdate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(int id) {
        Boolean isDelete = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteBannerById(?)");
            callableStatement.setInt(1,id);
           isDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public Banner finById(int id) {
        Banner banner = new Banner();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from banner where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                int location = resultSet.getInt("location");
                boolean status = resultSet.getBoolean("status");
                banner = new Banner(id,name,image,location,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banner;
    }

    @Override
    public List<Banner> findByName(String name) {
        List<Banner> banners = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Banner where name like ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String image = resultSet.getString("image");
                int location = resultSet.getInt("location");
                boolean status = resultSet.getBoolean("status");
                Banner banner = new Banner(id,name1,image,location,status);
                banners.add(banner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banners;

    }
}
