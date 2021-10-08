package dao;

import model.Cart;

import java.util.List;

public interface ICartDao extends IGeneralDao<Cart>{
    List<Cart> findByCustomerId(int id);

    boolean deleteByCustomer(int customerId);

}
