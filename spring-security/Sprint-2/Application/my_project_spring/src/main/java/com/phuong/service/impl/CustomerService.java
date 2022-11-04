package com.phuong.service.impl;

import com.phuong.model.Customer;
import com.phuong.repository.IAppUserRepository;
import com.phuong.repository.ICustomerRepository;
import com.phuong.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public Customer getCustomerByUsername(String username) {
        return this.customerRepository.getCustomerByUsername(username);
    }

    @Override
    public void save(Customer customer) {
        customer.setIsDeleted(false);
        Customer c = this.customerRepository.save(customer);
        c.getAppUser().setStatus(true);
        this.appUserRepository.updateStatus(c.getAppUser().getId());
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
