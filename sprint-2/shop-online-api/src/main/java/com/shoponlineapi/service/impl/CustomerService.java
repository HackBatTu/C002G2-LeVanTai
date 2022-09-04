package com.shoponlineapi.service.impl;

import com.shoponlineapi.repository.ICustomerRepository;
import com.shoponlineapi.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

}
