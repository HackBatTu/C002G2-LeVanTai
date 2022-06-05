package service.impl;

import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
}
