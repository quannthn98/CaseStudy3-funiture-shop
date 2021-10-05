package dao;

import config.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDao {
    public static final String SELECT_ALL_PRODUCT_SQL = "select * from productDetail";
    public static final String FIND_BY_ID_SQL = "select * from product where id = ?";
    public static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ? ;";
    public static final String UPDATE_PRODUCT_BY_ID_SQL = "update product set name = ? , image = ? , sub_image = ? , price = ? , price_sell = ? , sub_description = ? , description = ? , created_date = ? , status = ?  where id = ?;";
    public static final String ADD_PRODUCT_BY_ID_SQL = "insert into product(name, image, sub_image, price, price_sell, sub_description, description, created_date, status) values (?,?,?,?,?,?,?,?,?);";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT_SQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String subImage = rs.getString("subimage");
                float price = rs.getFloat("price");
                int priceSell = rs.getInt("price_sell");
                String subDescription = rs.getString("subdescription");
                String description = rs.getString("description");
                String createdDate = rs.getString("createdDate");
                int status = rs.getInt("status");
                String brandName = rs.getString("brand");
                String categoryName = rs.getString("category");
                productList.add(new Product(id, name, image, subImage, price, priceSell, subDescription, description, createdDate, status,categoryName,brandName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String subImage = rs.getString("subimage");
                float price = rs.getFloat("price");
                int priceSell = rs.getInt("price_sell");
                String subDescription = rs.getString("subdescription");
                String description = rs.getString("description");
                String createdDate = rs.getString("createdDate");
                int status = rs.getInt("status");
                product = new Product(id1, name, image, subImage, price, priceSell, subDescription, description, createdDate, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        boolean rowSaved = false;
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_BY_ID_SQL);
            getProductDAOStatement(product, statement);
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
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID_SQL);
            getProductDAOStatement(product, statement);
            statement.setInt(10, id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    private void getProductDAOStatement(Product product, PreparedStatement statement) throws SQLException {
        statement.setString(1, product.getName());
        statement.setString(2, product.getImage());
        statement.setString(3, product.getSubImage());
        statement.setFloat(4, product.getPrice());
        statement.setInt(5, product.getPriceSell());
        statement.setString(6, product.getSubDescription());
        statement.setString(7, product.getDescription());
        statement.setString(8, product.getCreatedDate());
        statement.setInt(9, product.getStatus());
    }
}