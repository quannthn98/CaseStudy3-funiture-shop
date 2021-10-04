package service;

import model.Order;
import model.OrderDetail;

import java.util.HashMap;
import java.util.List;

public interface IOrderService extends IGeneralService<Order> {
    List<OrderDetail> getDetails();

    HashMap<Integer, Double> getPaymentByOrder();


}
