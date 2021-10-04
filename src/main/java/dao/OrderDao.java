package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import config.DBConnection;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderDao implements IOrderDao {
    private final String SELECT_ALL_ORDER = "select * from fullorderwithdetails order by orderId";

    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                HashMap<Product, Integer> productList = new HashMap<>();
                int orderId = resultSet.getInt(1);
                int customerId = resultSet.getInt(2);
                int productId = resultSet.getInt(3);
                String productName = resultSet.getString(4);
                float price = resultSet.getFloat(5);
                int saleOff = resultSet.getInt(6);
                String createdDate = resultSet.getString(7);
                int quantity = resultSet.getInt(8);
                double totalPayment = resultSet.getDouble(9);
                boolean status = resultSet.getBoolean(10);
                String address = resultSet.getString(11);
                String phone = resultSet.getString(12);
                String note = resultSet.getString(13);
                int previousOrderId = orderId;
                Product product = new Product(productId, productName, price, saleOff);
                productList.put(product, quantity);
                if (orderId != previousOrderId){
                    Order order = new Order(productList, orderId, customerId, productName, price, saleOff, totalPayment, status, createdDate, address, phone, note );
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public boolean delete(int id, Order order) {
        return false;
    }

    @Override
    public boolean update(int id) {
        return false;
    }
}
