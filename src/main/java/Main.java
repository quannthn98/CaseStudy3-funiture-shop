import dao.OrderDao;
import model.Order;
import service.OrderService;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.findOrderByPayment(30000000, "bigger");
        for (Order order: orderList){
            System.out.println(order.getId());
        }

    }
}
