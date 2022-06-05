package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAll();

    void add(Employee employeeList);

    void update(Employee employeeList);

    void delete(int id);

    List<Employee> searchByName(String name);
}
