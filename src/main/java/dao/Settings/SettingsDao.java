package dao.Settings;

import config.DBConnection;
import model.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SettingsDao implements ISettingsDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Settings> getAll() {
        List<Settings> settings = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Settings");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String logo = resultSet.getString("logo");
                String hotline = resultSet.getString("hotline");
                String address = resultSet.getString("address");
                String linkMap = resultSet.getString("linkMap");
                String email = resultSet.getString("email");
                String pageFacebook = resultSet.getString("pageFacebook");
                String logo_payment = resultSet.getString("logo_payment");
                String note = resultSet.getString("note");
                Settings settings1 = new Settings(id,title,logo,hotline,address,linkMap,email,pageFacebook,logo_payment,note);
                settings.add(settings1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return settings;
    }

    @Override
    public Settings findById(int id) {
        Settings settings = new Settings();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Settings where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                String logo = resultSet.getString("logo");
                String hotline = resultSet.getString("hotline");
                String address = resultSet.getString("address");
                String linkMap = resultSet.getString("linkMap");
                String email = resultSet.getString("email");
                String pageFacebook = resultSet.getString("pageFacebook");
                String logo_payment = resultSet.getString("logo_payment");
                String note = resultSet.getString("note");
                settings = new Settings(id,title,logo,hotline,address,linkMap,email,pageFacebook,logo_payment,note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return settings;
    }

    @Override
    public boolean save(Settings settings) {
        return false;
    }

    @Override
    public boolean add(Settings settings) {
        Boolean isCreate = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call insertSettingsById(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,settings.getTitle());
            callableStatement.setString(2,settings.getLogo());
            callableStatement.setString(3,settings.getHotline());
            callableStatement.setString(4,settings.getAddress());
            callableStatement.setString(5,settings.getLinkMap());
            callableStatement.setString(6,settings.getEmail());
            callableStatement.setString(7,settings.getPageFacebook());
            callableStatement.setString(8,settings.getLogo_payment());
            callableStatement.setString(9,settings.getNote());
            isCreate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreate;
    }

    @Override
    public boolean update(int id, Settings settings) {
        Boolean isUpdate = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call updateSettingsById(?,?,?,?,?,?,?,?,?,?)");

            callableStatement.setInt(1,settings.getId());
            callableStatement.setString(2,settings.getTitle());
            callableStatement.setString(3,settings.getLogo());
            callableStatement.setString(4,settings.getHotline());
            callableStatement.setString(5,settings.getAddress());
            callableStatement.setString(6,settings.getLinkMap());
            callableStatement.setString(7,settings.getEmail());
            callableStatement.setString(8,settings.getPageFacebook());
            callableStatement.setString(9,settings.getLogo_payment());
            callableStatement.setString(10,settings.getNote());
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
            CallableStatement callableStatement = connection.prepareCall("call deleteSettingsById(?)");
            callableStatement.setInt(1,id);
            isDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }
}
