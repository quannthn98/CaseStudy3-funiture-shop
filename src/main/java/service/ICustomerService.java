package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService extends IGeneralService<Customer>{
    List<Customer> findByEmail(String email) throws SQLException;
}
