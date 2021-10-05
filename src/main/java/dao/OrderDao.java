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
    private final String SELECT_ALL_ORDER = "select * from orderProduct order by id";
    private final String SELECT_ALL_ORDER_DETAILS = "select * from orderDetailProduct order by id_Order";
    private final String SELECT_PAYMENT_BY_ORDER = "select * from totalpaymentbyorder";
    private final String UPDATE_ORDER = "update orderProduct set consignee = ?, numberPhone = ?, addressOrder = ?, note = ? where id = ?";
    private final String UPDATE_SALE_OFF = "update orderDetailProduct set price_sell = ? where id_Order = ?";
    private final String FIND_ORDER_BY_ID = "select * from orderProduct where id = ?";
    private final String FIND_SALE_OFF_BY_ID = "select price_Sell from orderDetailProduct where id_Order = ? order by price_sell DESC";
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
                double total = (double) quantity*(price - (double) price*saleOff/100);
                OrderDetail orderDetail = new OrderDetail(orderId, productId, productName, price, saleOff, quantity, total);
                orderDetailList.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailList;
    }

    @Override
    public HashMap<Integer, Double> getPaymentByOrder() {
        HashMap<Integer, Double> totalPaymentByOrderId = new HashMap<>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderId = resultSet.getInt(1);
                double payment = resultSet.getDouble(2);
                totalPaymentByOrderId.put(orderId, payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPaymentByOrderId;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderId = resultSet.getInt(1);
                String date = resultSet.getString(2);
                boolean status = resultSet.getBoolean(3);
                String customerName =resultSet.getString(4);
                String address = resultSet.getString(5);
                String phone = resultSet.getString(6);
                String note = resultSet.getString(7);
                int customerId = resultSet.getInt(8);
                order = new Order(orderId, customerId, date, status, customerName, address, phone, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        boolean isUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1, order.getConsignee());
            preparedStatement.setString(2, order.getPhone());
            preparedStatement.setString(3, order.getAddressOrder());
            preparedStatement.setString(4, order.getNote());
            preparedStatement.setInt(5, order.getId());
            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean updateSaleOff(int saleOff, int orderId) {
        boolean isUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SALE_OFF);
            preparedStatement.setInt(1, saleOff);
            preparedStatement.setInt(2, orderId);
            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }



    @Override
    public int getSaleOffByOrder(int id) {
        int saleOff = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SALE_OFF_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            saleOff = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleOff;
    }
}
