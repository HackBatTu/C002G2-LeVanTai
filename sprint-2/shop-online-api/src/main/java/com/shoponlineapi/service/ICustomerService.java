package com.shoponlineapi.service;


import com.shoponlineapi.model.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerByUserName(String userName);

    void save(Customer customer);


    Page<Customer> getListCustomer(Pageable pageable);


}
