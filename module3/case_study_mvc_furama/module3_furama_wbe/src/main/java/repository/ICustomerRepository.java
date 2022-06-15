package repository;

import model.CustomerServiceDTO;
import model.person.Customer;
import model.person.CustomerType;

import java.util.List;

public interface ICustomerRepository {

     List<Customer> selectAll();

     void add(Customer customerList);

     void update(Customer customerList);

     void delete(int id);

     List<Customer> searchByName(String name,String customerType);

     List<Customer> sortByName();

    List<CustomerType> getAllCustomerType();

    List<CustomerServiceDTO> getAllCustomerServiceDTO();
}
