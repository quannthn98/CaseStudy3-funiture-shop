package service;

import dao.IOrderDao;
import dao.OrderDao;
import model.Order;
import model.OrderDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
    public boolean insertOrderDetail(OrderDetail orderDetail) {
        return orderDao.insertOrderDetail(orderDetail);
    }

    @Override
    public int getLatestOrder() {
        return orderDao.getLatestOrder();
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
    public List<Order> findOrderByPayment(double targetValue, String direction) {
        HashMap<Integer, Double> orderByPayment = orderDao.findOrderByPayment(targetValue, direction);
        List<Order> targetOrderList = new ArrayList<>();
        List<Order> allOrderList = orderDao.getAll();
        Set<Integer> keySet = orderByPayment.keySet();
        for (Integer key: keySet){
            for (Order order: allOrderList){
                if (key == order.getId()){
                    targetOrderList.add(order);
                    continue;
                }
            }
        }
        return targetOrderList;
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
