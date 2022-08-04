package com.link.service.impl;

import com.link.model.Employee;

public interface IEmployeeService {
    Employee save(Employee employee);

    Employee findById(Integer id);
}
