package service.impl;

import model.Customer;
import model.CustomerType;
import repository.impl.CustomerRepository;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();


    @Override
    public List<Customer> selectAll() {
        return iCustomerRepository.selectAll();
    }

    @Override
    public void add(Customer customerList) {
        iCustomerRepository.add(customerList);
    }

    @Override
    public void update(Customer customerList) {
        iCustomerRepository.update(customerList);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.delete(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerRepository.searchByName(name);
    }

    @Override
    public List<Customer> sortByName() {
        return iCustomerRepository.sortByName();
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerRepository.getAllCustomerType();

    }
}
