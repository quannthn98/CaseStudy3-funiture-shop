package dao;

import model.Order;
import model.OrderDetail;
import model.Product;

import java.util.HashMap;
import java.util.List;

public interface IOrderDao extends IGeneralDao<Order> {

    List<OrderDetail> getDetails();

    HashMap<Integer, Double> getPaymentByOrder();
}
