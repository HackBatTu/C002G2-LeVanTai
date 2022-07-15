package com.link.service.impl;

import com.link.model.contract.Contract;
import com.link.model.contract.ContractCheckTotal;
import com.link.model.customer.Customer;
import com.link.model.contract.DetailsContract;
import com.link.model.contract.FacilityAttach;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;
import com.link.repository.*;
import com.link.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    @Override
//    public Page<Contract> getAllContract( Pageable pageable) {
//        return iContractRepository.findAllContract( pageable);
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

    @Override
    public Page<ContractCheckTotal> getAllContract(Pageable pageable, String dateIn, String dateOut) {
        Page<Contract> contractPage = iContractRepository.findAllContract(pageable,dateIn,dateOut);
        List<ContractCheckTotal> contractCheckTotalList = new ArrayList<>();
        Page<ContractCheckTotal> contractCheckTotalPage ;
        for (int i = 0; i < contractPage.getContent().size(); i++) {
            double total = 0;
            for (DetailsContract detailsContract: contractPage.getContent().get(i).getDetailsContractList()) {
                total +=  detailsContract.getContract().getFacility().getCost()+ detailsContract.getQuantity()*detailsContract.getFacilityAttach().getCost() ;
            }
            ContractCheckTotal contractCheckTotal = new ContractCheckTotal(contractPage.getContent().get(i).getId(),
                    contractPage.getContent().get(i).getDateCheckIn(),
                    contractPage.getContent().get(i).getDateCheckOut(),
                    contractPage.getContent().get(i).getDeposit(),
                    contractPage.getContent().get(i).getCustomer(),
                    contractPage.getContent().get(i).getEmployee(),
                    contractPage.getContent().get(i).getFacility(),
                    contractPage.getContent().get(i).getDetailsContractList(),
                    total
            );
            contractCheckTotalList.add(contractCheckTotal);
        }
        contractCheckTotalPage = new PageImpl<>(contractCheckTotalList,contractPage.getPageable(),contractPage.getTotalElements());
        return contractCheckTotalPage;
    }

    @Override
    public Page<Contract> findAllCustomerUsingService(Pageable pageable, String searchName) {
        return iContractRepository.findAllCustomerUsingService(pageable , "%" + searchName + "%");
    }


}
