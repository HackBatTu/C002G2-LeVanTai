package repository.impl;

import model.*;
import repository.BaseStudentRepository;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_CONTRACT = " select contract.*,employee.employee_name,customer.customer_name,service.service_name from contract left join employee on contract.employee_id=employee.employee_id left join customer on contract.customer_id=customer.customer_id left join service on contract.service_id= service.service_id where contract.status = 0;";
    private static final String INSERT_INTO = " insert into contract(contract_id,date_check_in,date_check_out,contract_deposit,contract_total_money,contract.employee_id,contract.customer_id,contract.service_id) value (?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_EMPLOYEE ="select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,employee.employee_position_id,employee_position.employee_position_name,employee.education_degree_id,education_degree.education_degree_name,employee.division_id,division.division_name,employee.username,user.password,employee.status from employee join employee_position on employee_position.employee_position_id= employee.employee_position_id join division on division.division_id=employee.division_id join education_degree on education_degree.education_degree_id=employee.education_degree_id join user on user.username= employee.username where employee.status=0;";
    private static final String SELECT_ALL_CUSTOMER = "select customer_id,customer.customer_type_id,customer_type.customer_type_name,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer.status from customer join customer_type on customer_type.customer_type_id= customer.customer_type_id where customer.status=0;";
    private static final String SELECT_ALL_SERVICE = " select service.*,rent_type.rent_type_name,service_type.service_type_name from service " +
            " left join rent_type on service.rent_type_id=rent_type.rent_type_id left join service_type on service.service_type_id=service_type.service_type_id where service.status = 0; ";
    private static final String UPDATE_CONTRACT = " update contract set date_check_in=?,date_check_out=?,contract_deposit=?,contract_total_money=?,contract.employee_id=?,contract.customer_id=?,contract.service_id=? where contract_id=?;";
    private static final String FIND_BY_ID = " select contract.*,employee.employee_name,customer.customer_name,service.service_name from contract left join employee on contract.employee_id=employee.employee_id left join customer on contract.customer_id=customer.customer_id left join service on contract.service_id= service.service_id where contract_id = ?;";
    private static final String DELETE = " update contract set status = 1 where contract_id =?;";
    private final String SEARCH_CONTRACT_BY_ID = " select contract.*,employee.employee_name,customer.customer_name,service.service_name from contract " +
            " left join employee on contract.employee_id=employee.employee_id left join customer on contract.customer_id=customer.customer_id left join service on contract.service_id= service.service_id where contract_id = ?; ";



    @Override
    public List<Contract> getAllContract() {
        Connection connection = baseStudentRepository.getConnection();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String dateCheckIn = resultSet.getString("date_check_in");
                String dateCheckOut = resultSet.getString("date_check_out");
                double contractDeposit = resultSet.getDouble("contract_deposit");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                contractList.add(new Contract(id, dateCheckIn, dateCheckOut, contractDeposit, contractTotalMoney, new Employee(employeeId, employeeName), new Customer(customerId, customerName),new Service(serviceId,serviceName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void getCreateContract(Contract contract) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,contract.getId());
            preparedStatement.setString(2,contract.getDateCheckIn());
            preparedStatement.setString(3,contract.getDateCheckOut());
            preparedStatement.setDouble(4,contract.getDeposit());
            preparedStatement.setDouble(5,contract.getTotalMoney());
            preparedStatement.setInt(6,contract.getEmployee().getId());
            preparedStatement.setInt(7,contract.getCustomer().getId());
            preparedStatement.setInt(8,contract.getService().getId());
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
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
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
    public List<Customer> getAllCustomer() {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                int idCustomerType = resultSet.getInt("customer_type_id");
                String nameCustomerType = resultSet.getString("customer_type_name");
                String name = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType,nameCustomerType),name,birthDay,gender, idCard, phone,email,address ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Service> getAllService() {
        Connection connection = baseStudentRepository.getConnection();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxPerson = resultSet.getInt("service_max_person");
                String roomStandard = resultSet.getString("room_standard");
                String anotherConvenient = resultSet.getString("another_convenient");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                int serviceType = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceList.add(new Service(id, name, area, cost, maxPerson, roomStandard, anotherConvenient, poolArea, numberOfFloors, new RentType(rentType, rentTypeName), new ServiceType(serviceType, serviceTypeName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void getUpdateContract(Contract contract) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT);
            preparedStatement.setString(1,contract.getDateCheckIn());
            preparedStatement.setString(2,contract.getDateCheckOut());
            preparedStatement.setDouble(3,contract.getDeposit());
            preparedStatement.setDouble(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getEmployee().getId());
            preparedStatement.setInt(6,contract.getCustomer().getId());
            preparedStatement.setInt(7,contract.getService().getId());
            preparedStatement.setInt(8,contract.getId());
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
    public Contract findById(int idEdit) {
        Connection connection = baseStudentRepository.getConnection();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String dateCheckIn = resultSet.getString("date_check_in");
                String dateCheckOut = resultSet.getString("date_check_out");
                double contractDeposit = resultSet.getDouble("contract_deposit");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                contract = new Contract(id, dateCheckIn, dateCheckOut, contractDeposit, contractTotalMoney, new Employee(employeeId, employeeName), new Customer(customerId, customerName),new Service(serviceId,serviceName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public void delete(int id) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
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
    public List<Contract> searchById(String id) {
        Connection connection = baseStudentRepository.getConnection();
        List<Contract> contractList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CONTRACT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ids = resultSet.getInt("contract_id");
                String dateCheckIn = resultSet.getString("date_check_in");
                String dateCheckOut = resultSet.getString("date_check_out");
                double contractDeposit = resultSet.getDouble("contract_deposit");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                Contract contract = new Contract(ids, dateCheckIn, dateCheckOut, contractDeposit, contractTotalMoney, new Employee(employeeId, employeeName), new Customer(customerId, customerName),new Service(serviceId,serviceName));
                contractList.add(contract);
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
        return contractList;
    }

}
