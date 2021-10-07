package dao.Company;

import config.DBConnection;
import model.Banner;
import model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao implements ICompanyDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public boolean add(Company company) {
        Boolean isCreate = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call insertCompanyById(?,?,?,?,?)");
            callableStatement.setString(1,company.getName());
            callableStatement.setString(2,company.getAddress());
            callableStatement.setString(3,company.getHotline());
            callableStatement.setString(4,company.getNote());
            callableStatement.setBoolean(5,company.getStatus());
            isCreate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreate;
    }

    @Override
    public List<Company> findByName(String name) {
        List<Company> companies = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Company where name like ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                String hotline = resultSet.getString("hotline");
                String note = resultSet.getString("note");
                boolean status = resultSet.getBoolean("status");
                Company company = new Company(id,name1,address,hotline,note,status);
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Company");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                String hotline = resultSet.getString("hotline");
                String note = resultSet.getString("note");
                boolean status = resultSet.getBoolean("status");
                Company company = new Company(id,name1,address,hotline,note,status);
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Company findById(int id) {
        Company company = new Company();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Company where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                String hotline = resultSet.getString("hotline");
                String note = resultSet.getString("note");
                boolean status = resultSet.getBoolean("status");
                company = new Company(id,name1,address,hotline,note,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public boolean save(Company company) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        Boolean isDelete = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteCompanyById(?)");
            callableStatement.setInt(1,id);
            isDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public boolean update(int id, Company company) {
        Boolean isUpdate =  false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call updateCompanyById(?,?,?,?,?,?)");
            callableStatement.setInt(1,company.getId());
            callableStatement.setString(2,company.getName());
            callableStatement.setString(3,company.getAddress());
            callableStatement.setString(4,company.getHotline());
            callableStatement.setString(5,company.getNote());
            callableStatement.setBoolean(6,company.getStatus());
            isUpdate = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
}
