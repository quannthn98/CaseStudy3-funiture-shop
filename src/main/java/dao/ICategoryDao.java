package dao;

import model.Category;

import java.util.List;

public interface ICategoryDao extends IGeneralDao<Category> {
    List<Category> getUniqueLocation();
}
