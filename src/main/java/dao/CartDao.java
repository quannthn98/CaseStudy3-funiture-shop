package dao;

import config.DBConnection;
import dao.ICartDao;
import model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements ICartDao {
    Connection connection = DBConnection.getConnection();
    private final String SELECT_ALL = "select * from cartDetail";
    private final String FIND_BY_CUSTOMER_ID ="select * from cartDetail where customerId = ?";
    private final String FIND_BY_CART_ID = "select * from cartDetail where cartId = ?";
    private final String INSERT = "insert into cart(id_Customer, id_Product, quantity) VALUES (?, ? ,?)";
    private final String UPDATE_QUANTITY = "update cart set quantity = ? where id = ?";
    private final String DELETE_BY_ID = "delete from cart where id = ?";
    private final String DELETE_ALL_BY_CUSTOMER = "delete from cart where id_Customer = ?";
    @Override
    public List<Cart> getAll() {
        List<Cart> cartList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int customerId = resultSet.getInt(2);
                int productId = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                String image = resultSet.getString(5);
                String productName = resultSet.getString(6);
                double price = resultSet.getDouble(7);
                double saleOff = resultSet.getDouble(8);
                Cart cart = new Cart(id, customerId, productId, quantity, image, productName, price, saleOff);
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public List<Cart> findByCustomerId(int id) {
        List<Cart> cartList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CUSTOMER_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int cartId = resultSet.getInt(1);
                int customerId = resultSet.getInt(2);
                int productId = resultSet.getInt(3);
                int quantity = resultSet.getInt(4);
                String image = resultSet.getString(5);
                String productName = resultSet.getString(6);
                double price = resultSet.getDouble(7);
                double saleOff = resultSet.getDouble(8);
                Cart cart = new Cart(cartId, customerId, productId, quantity, image, productName, price, saleOff);
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public Cart findById(int id) {
        Cart cart = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CART_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int cartId = resultSet.getInt(1);
            int customerId = resultSet.getInt(2);
            int productId = resultSet.getInt(3);
            int quantity = resultSet.getInt(4);
            String image = resultSet.getString(5);
            String productName = resultSet.getString(6);
            double price = resultSet.getDouble(7);
            double saleOff = resultSet.getDouble(8);
            cart = new Cart(cartId, customerId, productId, quantity, image, productName, price, saleOff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public boolean save(Cart cart) {
        boolean isSaved = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, cart.getCustomerId());
            preparedStatement.setInt(2, cart.getProductId());
            preparedStatement.setInt(3, cart.getQuantity());
            isSaved = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement  preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean update(int id, Cart cart) {
        boolean isUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY);
            preparedStatement.setInt(1, cart.getQuantity());
            preparedStatement.setInt(2, id);
            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean deleteByCustomer(int customerId) {
        boolean isDeleted = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_BY_CUSTOMER);
            preparedStatement.setInt(1, customerId);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
