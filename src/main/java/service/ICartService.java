package service;

import model.Cart;

import java.util.List;

public interface ICartService extends IGeneralService<Cart> {
    List<Cart> findByCustomerId(int id);

    boolean deleteByCustomer(int customerId);
}
