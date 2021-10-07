package dao;

import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findByCategory(int categoryId);

    List<Product> findByBrand(int brandId);
}