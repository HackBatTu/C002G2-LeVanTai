package repository;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;

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

}
