package service;

import model.person.Division;
import model.person.EducationDegree;
import model.person.Employee;
import model.person.EmployeePosition;
import model.user.User;

import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAll();

    void add(Employee employeeList);

    void update(Employee employeeList);

    void delete(int id);

    List<Employee> searchByName(String name,String email);

    List<EmployeePosition> getAllEmployeePosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    List<User> getAllUser();

    Employee findById(int id);
}
