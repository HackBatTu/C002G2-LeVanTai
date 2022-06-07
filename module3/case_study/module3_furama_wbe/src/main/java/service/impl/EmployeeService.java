package service.impl;

import model.*;
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

    @Override
    public List<EmployeePosition> getAllEmployeePosition() {
        return iEmployeeRepository.getAllEmployeePosition();
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return iEmployeeRepository.getAllEducationDegree();
    }

    @Override
    public List<Division> getAllDivision() {
        return iEmployeeRepository.getAllDivision();
    }

    @Override
    public List<User> getAllUser() {
        return iEmployeeRepository.getAllUser();
    }

    @Override
    public List<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }
}
