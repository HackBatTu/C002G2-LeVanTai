package repository;

import model.contract.Contract;
import model.person.Customer;
import model.person.Employee;
import model.service.Service;

import java.util.List;

public interface IContractRepository {
    List<Contract> getAllContract();

    void getCreateContract(Contract contract);

    List<Employee> getAllEmployee();

    List<Customer> getAllCustomer();

    List<Service> getAllService();

    void getUpdateContract(Contract contract);

    Contract findById(int idEdit);

    void delete(int id);

    List<Contract> searchById(String id);
}
