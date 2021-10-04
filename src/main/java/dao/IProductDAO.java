package dao;

import java.util.List;

public interface IProductDAO<T> {
    List<T> getAll();

    T findById(int id);

    boolean save(T t);

    boolean delete(int id);

    boolean update(int id);

}
