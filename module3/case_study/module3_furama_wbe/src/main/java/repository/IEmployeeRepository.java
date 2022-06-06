package repository;

import model.*;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAll();

    void add(Employee employeeList);

    void update(Employee employeeList);

    void delete(int id);

    List<Employee> searchByName(String name);

    List<EmployeePosition> getAllEmployeePosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    List<User> getAllUser();
}
