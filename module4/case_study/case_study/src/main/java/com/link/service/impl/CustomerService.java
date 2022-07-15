package com.link.service.impl;

import com.link.model.customer.Customer;
import com.link.model.customer.CustomerType;
import com.link.repository.ICustomerRepository;
import com.link.repository.ICustomerTypeRepository;
import com.link.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;


    @Override
    public Page<Customer> findAllCustomer(String searchName, Pageable pageable) {
        return iCustomerRepository.findAllCustomer("%" + searchName +"%",pageable);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteCustomer(id);
    }






}
