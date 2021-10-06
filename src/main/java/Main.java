import dao.CustomerDAO;
import dao.OrderDao;
import model.Customer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        OrderDao orderDao = new OrderDao();
        CustomerDAO customer = new CustomerDAO();
        List<Customer> customers = customer.findByEmail("L");
        for (Customer customer1: customers){
            System.out.println(customer1.getId());
        }

    }
}
