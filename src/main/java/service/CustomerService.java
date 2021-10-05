package service;

import dao.CustomerDAO;
import model.Customer;

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
    public boolean update(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerDAO.delete(id);
    }
}