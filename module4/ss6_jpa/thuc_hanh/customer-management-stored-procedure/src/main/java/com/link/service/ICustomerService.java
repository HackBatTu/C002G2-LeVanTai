package com.link.service;

import com.link.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
