package com.shoponlineapi.service.impl;

import com.shoponlineapi.model.Bill;
import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.repository.ICustomerRepository;
import com.shoponlineapi.service.IAppUserService;
import com.shoponlineapi.service.ICustomerService;
import com.shoponlineapi.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Customer getCustomerByUserName(String userName) {
        return iCustomerRepository.getCustomerByUserName(userName);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }


}
