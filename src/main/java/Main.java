import dao.CartDao;
import dao.OrderDao;
import model.Cart;
import model.Order;
import service.OrderService;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        CartDao cartDao = new CartDao();
        List<Cart> cartList = cartDao.findByCustomerId(10);
        for (Cart cart: cartList){
            System.out.println(cart.getId() + " " + cart.getCustomerId() + " " + cart.getProductId() +" "+ cart.getQuantity());

        }

    }
}
