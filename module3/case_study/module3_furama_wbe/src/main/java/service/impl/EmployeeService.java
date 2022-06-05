package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAll() {
        return iEmployeeRepository.selectAll();
    }

    @Override
    public void add(Employee employeeList) {
        iEmployeeRepository.add(employeeList);
    }

    @Override
    public void update(Employee employeeList) {
        iEmployeeRepository.update(employeeList);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepository.delete(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return iEmployeeRepository.searchByName(name);
    }
}
