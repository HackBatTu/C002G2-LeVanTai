package com.link.service;

import com.link.model.contract.Contract;
import com.link.model.Customer;
import com.link.model.contract.DetailsContract;
import com.link.model.contract.FacilityAttach;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> getAllContract(String searchDate, Pageable pageable);

    Contract save(Contract contract);

    List<Employee> findAllEmployee();

    List<Customer> findAllCustomer();

    List<Facility> findAllFacility();

    Contract findById(Integer id);

    void deleteContract(Integer id);

    List<FacilityAttach> getAllFacilityAttach();

    List<DetailsContract> getAllDetailsContract();

    void saveDetailsContract(DetailsContract detailsContract);
}
