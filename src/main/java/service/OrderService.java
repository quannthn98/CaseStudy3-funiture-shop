package service;

import dao.IOrderDao;
import dao.OrderDao;
import model.Order;
import model.OrderDetail;

import java.util.HashMap;
import java.util.List;

public class OrderService implements IOrderService {
    IOrderDao orderDao = new OrderDao();
    @Override
    public List<Order> selectAll() {
        List<Order> orderList = orderDao.getAll();
        return orderList;
    }

    @Override
    public List<Order> getOrderByOffset(int offset) {
        return orderDao.getOrderByOffset(offset);
    }

    @Override
    public List<OrderDetail> getDetails() {
        List<OrderDetail> orderDetailList = orderDao.getDetails();
        return orderDetailList;
    }

    @Override
    public HashMap<Integer, Double> getPaymentByOrder() {
        return orderDao.getPaymentByOrder();
    }

    @Override
    public boolean update(int id, Order order) {

        return orderDao.update(id, order);
    }

    @Override
    public boolean updateSaleOff(int saleOff, int orderId) {
        return orderDao.updateSaleOff(saleOff, orderId);
    }

    @Override
    public int getSaleOffByOrder(int id) {

        return orderDao.getSaleOffByOrder(id);
    }

    @Override
    public int countRecord() {
        return orderDao.countRecord();
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }

    @Override
    public boolean save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
