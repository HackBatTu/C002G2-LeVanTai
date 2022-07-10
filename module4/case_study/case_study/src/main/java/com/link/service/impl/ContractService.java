package com.link.service.impl;

import com.link.model.contract.Contract;
import com.link.model.customer.Customer;
import com.link.model.contract.DetailsContract;
import com.link.model.contract.FacilityAttach;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;
import com.link.repository.*;
import com.link.service.IContractService;
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
    @Autowired
    private IFacilityAttachRepository iFacilityAttachRepository;
    @Autowired
    private IDetailsContractRepository iDetailsContractRepository;

    @Override
    public Page<Contract> getAllContract( Pageable pageable) {
        return iContractRepository.findAllContract( pageable);
    }
    //    @Override
//    public Page<Contract> getAllContract(Pageable pageable) {
//        return iContractRepository.getAllContract(pageable,dateIn,dateOut);
//    }

    @Override
    public Contract save(Contract contract) {
       return iContractRepository.save(contract);
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

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContract(Integer id) {
        iContractRepository.deleteContract(id);
    }

    @Override
    public List<FacilityAttach> getAllFacilityAttach() {
        return iFacilityAttachRepository.findAll();
    }

    @Override
    public List<DetailsContract> getAllDetailsContract() {
        return iDetailsContractRepository.findAll();
    }

    @Override
    public void saveDetailsContract(DetailsContract detailsContract) {
        iDetailsContractRepository.save(detailsContract);
    }


}
