package com.shoponlineapi.service.impl;

import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.account.AppRole;
import com.shoponlineapi.model.account.AppUser;
import com.shoponlineapi.model.account.UserRole;
import com.shoponlineapi.repository.ICustomerRepository;
import com.shoponlineapi.service.IAppUserService;
import com.shoponlineapi.service.ICustomerService;
import com.shoponlineapi.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IAppUserService iAppUserService;
    @Autowired
    private IUserRoleService iUserRoleService;

    @Override
    public Customer getCustomerByUserName(String userName) {
        return iCustomerRepository.getCustomerByUserName(userName);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }
}
