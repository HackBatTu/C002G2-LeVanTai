package com.phuong.service;

import com.phuong.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerByUsername(String username);

    void save(Customer customer);

    List<Customer> findAll();
}
