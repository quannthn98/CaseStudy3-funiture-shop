package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao extends IGeneralDao<Customer>{
    List<Customer> findByEmail(String email) throws SQLException;
}
