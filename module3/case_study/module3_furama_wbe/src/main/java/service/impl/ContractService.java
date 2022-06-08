package service.impl;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository iContractRepository = new ContractRepository();

    @Override
    public List<Contract> getAllContract() {
        return iContractRepository.getAllContract();
    }

    @Override
    public void getCreateContract(Contract contract) {
        iContractRepository.getCreateContract(contract);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return iContractRepository.getAllEmployee();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return iContractRepository.getAllCustomer();
    }

    @Override
    public List<Service> getAllService() {
        return iContractRepository.getAllService();
    }

    @Override
    public void getUpdateContract(Contract contract) {
        iContractRepository.getUpdateContract(contract);
    }

    @Override
    public Contract findById(int idEdit) {
        return  iContractRepository.findById(idEdit);
    }

    @Override
    public void delete(int id) {
        iContractRepository.delete(id);
    }

    @Override
    public List<Contract> searchById(String id) {
        return iContractRepository.searchById(id);
    }


}
