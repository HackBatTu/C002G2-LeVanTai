package service;

import model.CustomerServiceDTO;
import model.person.Customer;
import model.person.CustomerType;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    List<Customer> selectAll();

    Map<String, String> add(Customer customerList);

    Map<String, String> update(Customer customerList);

    void delete(int id);

    List<Customer> searchByName(String name,String customerType);

    List<Customer> sortByName();

    List<CustomerType> getAllCustomerType();

    List<CustomerServiceDTO> getAllCustomerServiceDTO();
}
