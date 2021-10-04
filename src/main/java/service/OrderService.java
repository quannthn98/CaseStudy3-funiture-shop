package service;

import dao.IOrderDao;
import dao.OrderDao;
import model.Order;
import model.OrderDetail;

import java.util.List;

public class OrderService implements IOrderService {
    IOrderDao orderDao = new OrderDao();
    @Override
    public List<Order> selectAll() {
        List<Order> orderList = orderDao.getAll();
        return orderList;
    }

    @Override
    public List<OrderDetail> getDetails() {
        List<OrderDetail> orderDetailList = orderDao.getDetails();
        return orderDetailList;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public boolean update(int id, Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
