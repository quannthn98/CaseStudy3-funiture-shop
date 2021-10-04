package service;

import model.Order;
import model.OrderDetail;

import java.util.List;

public interface IOrderService extends IGeneralService<Order> {
    List<OrderDetail> getDetails();

}
