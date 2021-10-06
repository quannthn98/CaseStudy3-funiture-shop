package service;

import dao.CustomerDAO;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService{
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    public List<Customer> selectAll() {
        return customerDAO.getAll();
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public boolean update(int id, Customer customer) {
        return customerDAO.update(id, customer);
    }

    @Override
    public boolean delete(int id) {
        return customerDAO.delete(id);
    }

    @Override
    public List<Customer> findByEmail(String email) throws SQLException {
        email = "%"+email+"%";
        return customerDAO.findByEmail(email);
    }
}
