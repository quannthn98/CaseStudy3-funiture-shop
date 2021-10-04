package dao;

import model.Product;

import java.util.List;

public class ProductDAO implements IProductDAO{


    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }
}
