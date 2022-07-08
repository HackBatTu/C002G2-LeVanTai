package com.link.service;

import com.link.model.Contract;
import com.link.model.Customer;
import com.link.model.Employee;
import com.link.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> getAllContract( Pageable pageable);

    void save(Contract contract);

    List<Employee> findAllEmployee();

    List<Customer> findAllCustomer();

    List<Facility> findAllFacility();

}
