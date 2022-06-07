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
    private static final String SELECT_CONTRACT = " select contract.*,employee.employee_name,customer.customer_name,service.service_name from contract left join employee on contract.employee_id=employee.employee_id left join customer on contract.customer_id=customer.customer_id left join service on contract.service_id= service.service_id;";

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
}
