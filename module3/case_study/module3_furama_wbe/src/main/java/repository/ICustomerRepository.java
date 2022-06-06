package repository;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface ICustomerRepository {

     List<Customer> selectAll();

     void add(Customer customerList);

     void update(Customer customerList);

     void delete(int id);

     List<Customer> searchByName(String name);

     List<Customer> sortByName();

    List<CustomerType> getAllCustomerType();
}
