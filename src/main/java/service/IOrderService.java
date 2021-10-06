package service;

import model.Order;
import model.OrderDetail;

import java.util.HashMap;
import java.util.List;

public interface IOrderService extends IGeneralService<Order> {

    List<Order> getOrderByOffset(int offset);

    List<OrderDetail> getDetails();

    HashMap<Integer, Double> getPaymentByOrder();

    List<Order> findOrderByPayment(double targetValue, String direction);

    boolean updateSaleOff(int saleOff, int orderId);

    int getSaleOffByOrder(int id);

    int countRecord();
}
