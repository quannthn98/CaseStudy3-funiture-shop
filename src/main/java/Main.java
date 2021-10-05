import dao.OrderDao;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        HashMap<Integer, Double> total = orderDao.getPaymentByOrder();
        System.out.println(total.get(1));
        System.out.println((float) 20/100);
    }
}
