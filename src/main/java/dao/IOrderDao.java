package dao;

import model.Order;
import model.OrderDetail;
import model.Product;

import java.util.List;

public interface IOrderDao extends IGeneralDao<Order> {

    List<OrderDetail> getDetails();


}
