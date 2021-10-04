package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import config.DBConnection;
import model.Order;
import model.OrderDetail;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderDao implements IOrderDao {
    private final String SELECT_ALL_ORDER = "select * from orderProduct order by orderId";
    private final String SELECT_ALL_ORDER_DETAILS = "select * from orderDetailProduct order by id_Order";

    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int orderId = resultSet.getInt("id");
                int customerId = resultSet.getInt("id_Customer");
                String date = resultSet.getString("createdDate");
                Boolean status = resultSet.getBoolean("status");
                String consignee = resultSet.getString("consignee");
                String addressOrder = resultSet.getString("addressOrder");
                String phone = resultSet.getString("numberPhone");
                String note = resultSet.getString("note");
                Order order = new Order(orderId, customerId, date, status, consignee, addressOrder, phone, note );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<OrderDetail> getDetails() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_DETAILS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int orderId = resultSet.getInt("id_Order");
                int productId = resultSet.getInt("id_Product");
                String productName = resultSet.getString("nameProduct");
                float price = resultSet.getFloat("price");
                int saleOff = resultSet.getInt("price_sell");
                int quantity = resultSet.getInt("quantity");
                double total = quantity*(price*(1-saleOff/100));
                OrderDetail orderDetail = new OrderDetail(orderId, productId, productName, price, saleOff, quantity, total);
                orderDetailList.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailList;
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
