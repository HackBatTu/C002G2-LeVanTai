package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  create Employee success
     */
    Employee saveEmployee(Employee employee);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    Employee findById(Integer id);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  update Employee success
     */
    Employee editEmployee(Employee employee);


    List<Employee> getAllEmployee();
}
