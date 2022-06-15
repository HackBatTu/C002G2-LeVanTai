package repository.impl;

import model.person.Division;
import model.person.EducationDegree;
import model.person.Employee;
import model.person.EmployeePosition;
import model.user.User;
import repository.BaseStudentRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_ALL ="select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,employee.employee_position_id,employee_position.employee_position_name,employee.education_degree_id,education_degree.education_degree_name,employee.division_id,division.division_name,employee.username,user.password,employee.status from employee join employee_position on employee_position.employee_position_id= employee.employee_position_id join division on division.division_id=employee.division_id join education_degree on education_degree.education_degree_id=employee.education_degree_id join user on user.username= employee.username where employee.status=0;";
    private static final String INSERT_INTO= "insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,employee.employee_position_id,employee.education_degree_id,employee.division_id,employee.username) value (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "update employee set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,employee.employee_position_id=?,employee.education_degree_id=?,employee.division_id=?,employee.username=? where employee_id=? and employee.status=0;";
    private static final String DELETE_EMPLOYEE = " update employee set status = 1 where employee_id = ?; ";
    private static final String SEARCH_BY_NAME = "select employee.*,employee_position.employee_position_name,education_degree.education_degree_name,division.division_name from employee left join employee_position on employee_position.employee_position_id= employee.employee_position_id left join division on division.division_id=employee.division_id left join education_degree on education_degree.education_degree_id=employee.education_degree_id left join user on user.username= employee.username where employee.employee_name like ? and employee.employee_email like ?;";
    private final String SELECT_ALL_POSITION = " select * from employee_position where status = 0; ";
    private final String SELECT_ALL_EDUCATION = " select * from education_degree where status = 0;  ";
    private final String SELECT_ALL_DIVISION = " select * from division where status = 0;  ";
    private final String SELECT_ALL_USER = " select * from user; ";
    private static final String SELECT_EMPLOYEE = " select * from employee where employee_id = ? ;";

    @Override
    public List<Employee> selectAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthDay = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                int salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int employee_position_id = resultSet.getInt("employee_position_id");
                String employee_position_name = resultSet.getString("employee_position_name");
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                employeeList.add(new Employee(id,name,birthDay,idCard,salary,phone,email,address,new EmployeePosition(employee_position_id,employee_position_name),new EducationDegree(education_degree_id,education_degree_name),new Division(division_id,division_name),new User(username,password)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void add(Employee employeeList) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,employeeList.getId());
            preparedStatement.setString(2,employeeList.getName());
            preparedStatement.setString(3,employeeList.getBirthDay());
            preparedStatement.setString(4,employeeList.getIdCard());
            preparedStatement.setDouble(5,employeeList.getSalary());
            preparedStatement.setString(6,employeeList.getPhone());
            preparedStatement.setString(7,employeeList.getEmail());
            preparedStatement.setString(8,employeeList.getAddress());
            preparedStatement.setInt(9,employeeList.getEmployeePosition().getId());
            preparedStatement.setInt(10,employeeList.getEducationDegree().getId());
            preparedStatement.setInt(11,employeeList.getDivision().getId());
            preparedStatement.setString(12,employeeList.getUserName().getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employeeList) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,employeeList.getName());
            preparedStatement.setString(2,employeeList.getBirthDay());
            preparedStatement.setString(3,employeeList.getIdCard());
            preparedStatement.setDouble(4,employeeList.getSalary());
            preparedStatement.setString(5,employeeList.getPhone());
            preparedStatement.setString(6,employeeList.getEmail());
            preparedStatement.setString(7,employeeList.getAddress());
            preparedStatement.setInt(8,employeeList.getEmployeePosition().getId());
            preparedStatement.setInt(9,employeeList.getEducationDegree().getId());
            preparedStatement.setInt(10,employeeList.getDivision().getId());
            preparedStatement.setString(11,employeeList.getUserName().getUsername());
            preparedStatement.setInt(12,employeeList.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> searchByName(String name,String email) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + email + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String names = resultSet.getString("employee_name");
                String birthDay = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                int salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String emails = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int employeePosition = resultSet.getInt("employee_position_id");
                String nameEmployeePosition = resultSet.getString("employee_position_name");
                int educationDegree = resultSet.getInt("education_degree_id");
                String nameEducationDegree = resultSet.getString("education_degree_name");
                int division = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                employeeList.add(new Employee(id,names,birthDay,idCard,salary,phone,emails,address,new EmployeePosition(employeePosition,nameEmployeePosition),new EducationDegree(educationDegree,nameEducationDegree),new Division(division,divisionName),new User(username)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<EmployeePosition> getAllEmployeePosition() {
        List<EmployeePosition> positions = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("employee_position_id");
                String positionName = resultSet.getString("employee_position_name");
                int status = resultSet.getInt("status");
                positions.add(new EmployeePosition(positionId, positionName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return positions;
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int edId = resultSet.getInt("education_degree_id");
                String edName = resultSet.getString("education_degree_name");
                int status = resultSet.getInt("status");
                educationDegrees.add(new EducationDegree(edId, edName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return educationDegrees;
    }

    @Override
    public List<Division> getAllDivision() {
        List<Division> divisions = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                int status = resultSet.getInt("status");
                divisions.add(new Division(divisionId, divisionName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return divisions;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int status = resultSet.getInt("status");
                users.add(new User(username,password,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public Employee findById(int idEdit) {
        Connection connection = baseStudentRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_EMPLOYEE);
            preparedStatement.setInt(1,idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ids = resultSet.getInt("employee_id");
                String names = resultSet.getString("employee_name");
                String birthDay = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                int salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int employeePosition = resultSet.getInt("employee_position_id");
                int educationDegree = resultSet.getInt("education_degree_id");
                int division = resultSet.getInt("division_id");
                String username = resultSet.getString("username");

               employee = new Employee(ids,names,birthDay,idCard,salary,phone,email,address,new EmployeePosition(employeePosition),new EducationDegree(educationDegree),new Division(division),new User(username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


}
