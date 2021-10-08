package service;

import model.Cart;
import dao.CartDao;

import java.util.List;

public class CartService implements ICartService{
    private CartDao cartDao = new CartDao();
    @Override
    public List<Cart> selectAll() {
        return cartDao.getAll();
    }

    @Override
    public Cart findById(int id) {
        return cartDao.findById(id);
    }

    @Override
    public boolean save(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public boolean update(int id, Cart cart) {
        return cartDao.update(id, cart);
    }

    @Override
    public boolean deleteByCustomer(int customerId) {
        return cartDao.deleteByCustomer(customerId);
    }

    @Override
    public List<Cart> findByCustomerId(int id) {
        return cartDao.findByCustomerId(id);
    }

    @Override
    public boolean delete(int id) {
        return cartDao.delete(id);
    }
}
