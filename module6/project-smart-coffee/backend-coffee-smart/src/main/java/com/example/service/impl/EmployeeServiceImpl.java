package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  create Employee success
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        return iEmployeeRepository.saveEmployee(employee);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  update Employee success
     */
    @Override
    public Employee editEmployee(Employee employee) {
        return iEmployeeRepository.editEmployee(employee.getName(), employee.getImage(),employee.getBirthday(),employee.getEmail(),
                employee.getGender(),employee.getPhoneNumber(),employee.getAddress(),employee.getSalary(),employee.getPosition());
    }

    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepository.findAll();
    }


}
