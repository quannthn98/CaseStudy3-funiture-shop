package dao;

import config.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select*from customer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String status = resultSet.getString("status");
                customers.add(new Customer(id, name, birthday, address, phone, email, password, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select *from customer where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String status = resultSet.getString("status");
                customer = new Customer(name, birthday, address, phone, email, password, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) {
        boolean isSave = false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into customer(name,birthday,address,phone,email,password,status) values (?,?,?,?,?,?,?)");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getBirthday());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPassword());
            statement.setString(7, customer.getStatus());
            isSave = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    @Override
    public boolean delete(int id) {
        boolean isRow = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from customer where id = ?");
            statement.setInt(1, id);
            isRow = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRow;
    }

    @Override
    public boolean update(int id, Customer customer) {
        boolean isRowUpdate = false;
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update customer set name = ?,birthday = ?,address = ?,phone = ?,email = ?,password = ?  where id = ?");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getBirthday());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPassword());
            statement.setInt(7,customer.getId());
            isRowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRowUpdate;
    }

    @Override
    public List<Customer> findByEmail(String email) throws SQLException, NullPointerException {
        List<Customer> customers =new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from customer where email like ?");
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String email1 = resultSet.getString("email");
            String password = resultSet.getString("password");
            String status = resultSet.getString("status");
            Customer customer = new Customer(name, birthday, address, phone, email1, password, status);
            customers.add(customer);
        }
        return customers;
    }
}
