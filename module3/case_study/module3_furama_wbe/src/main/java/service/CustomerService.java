package service;

import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
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
}
