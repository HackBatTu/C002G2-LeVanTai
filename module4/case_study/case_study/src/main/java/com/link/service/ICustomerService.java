package com.link.service;

import com.link.model.customer.Customer;
import com.link.model.customer.CustomerType;
import com.link.model.customer.CustomerUsingServiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllCustomer(String searchName, Pageable pageable);

    List<CustomerType> findAllCustomerType();

    void save(Customer customer);

    Customer findById(Integer id);

    void deleteCustomer(Integer id);

    Page<CustomerUsingServiceDTO> findAllCustomerUsingServiceDTO(Pageable pageable);
}
