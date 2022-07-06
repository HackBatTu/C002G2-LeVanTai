package com.link.service.impl;

import com.link.model.Contract;
import com.link.model.Customer;
import com.link.model.Employee;
import com.link.model.Facility;
import com.link.repository.IContractRepository;
import com.link.repository.ICustomerRepository;
import com.link.repository.IEmployeeRepository;
import com.link.repository.IFacilityRepository;
import com.link.service.IContractService;
import com.link.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Contract> getAllContract(String searchName, Pageable pageable) {
        return iContractRepository.findAllContract("%"+searchName+"%", pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return iEmployeeRepository.getAllEmployee();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return iCustomerRepository.getAllCustomer();
    }

    @Override
    public List<Facility> findAllFacility() {
        return iFacilityRepository.getAllFacility();
    }
}
