package repository.impl;

import model.contract.AttachService;
import model.contract.Contract;
import model.contract.DetailsContract;
import model.person.Customer;
import model.person.Employee;
import model.service.Service;
import repository.BaseStudentRepository;
import repository.IDetailsContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailsContractRepository implements IDetailsContractRepository {
    private BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_DETAILS_CONTRACT = " select details_contract.*,attach_service.attach_service_name from details_contract left join contract on details_contract.contract_id=contract.contract_id left join attach_service on details_contract.attach_service_id = attach_service.attach_service_id where details_contract.status=0;";
    private static final String INSERT_INTO = " insert into details_contract(details_contract_id,number_contract,details_contract.contract_id,details_contract.attach_service_id) value (?,?,?,?);";
    private static final String SELECT_CONTRACT = " select contract.*,employee.employee_name,customer.customer_name,service.service_name from contract left join employee on contract.employee_id=employee.employee_id left join customer on contract.customer_id=customer.customer_id left join service on contract.service_id= service.service_id where contract.status = 0;";
    private static final String SELECT_ATTACH_SERVICE = " select * from attach_service where status = 0;";
    private static final String UPDATE_DETAILS_CONTRACT = " update details_contract set number_contract=?,details_contract.contract_id=?,details_contract.attach_service_id=? where details_contract_id=?;";
    private static final String FIND_BY_ID = " select details_contract.*,attach_service.attach_service_name from details_contract left join contract on details_contract.contract_id=contract.contract_id left join attach_service on details_contract.attach_service_id = attach_service.attach_service_id where details_contract_id=?;";
    private static  final String DELETE = " update details_contract set status = 1 where details_contract_id = ?;";
    private static  final String SEARCH_BY_ID = " select details_contract.*,attach_service.attach_service_name from details_contract " +
            " left join attach_service on details_contract.attach_service_id = attach_service.attach_service_id where details_contract_id = ?;";

    @Override
    public List<DetailsContract> getAllDetailsContract(){
        Connection connection = baseStudentRepository.getConnection();
        List<DetailsContract> detailsContractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAILS_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("details_contract_id");
                int numberContract = resultSet.getInt("number_contract");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                detailsContractList.add(new DetailsContract(id,numberContract,new Contract(contractId),new AttachService(attachServiceId, attachServiceName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailsContractList;
    }

    @Override
    public void getCreateDetailsContract(DetailsContract detailsContract) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,detailsContract.getId());
            preparedStatement.setInt(2,detailsContract.getNumberContract());
            preparedStatement.setInt(3,detailsContract.getContract().getId());
            preparedStatement.setInt(4,detailsContract.getAttachService().getId());
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
    public List<AttachService> getAllAttachService() {
        Connection connection = baseStudentRepository.getConnection();
        List<AttachService> attachServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                double attachServiceCost = resultSet.getDouble("attach_service_cost");
                String attachServiceUnit = resultSet.getString("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                attachServiceList.add(new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;
    }

    @Override
    public void getUpdateDetailsContract(DetailsContract detailsContract) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DETAILS_CONTRACT);
            preparedStatement.setInt(1,detailsContract.getNumberContract());
            preparedStatement.setInt(2,detailsContract.getContract().getId());
            preparedStatement.setInt(3,detailsContract.getAttachService().getId());
            preparedStatement.setInt(4,detailsContract.getId());
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
    public DetailsContract findById(int id) {
        Connection connection = baseStudentRepository.getConnection();
        DetailsContract detailsContract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int ids = resultSet.getInt("details_contract_id");
                int numberContract = resultSet.getInt("number_contract");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                detailsContract = new DetailsContract(ids,numberContract,new Contract(contractId),new AttachService(attachServiceId, attachServiceName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailsContract;
    }

    @Override
    public void delete(int id) {
        Connection connection = baseStudentRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DetailsContract> searchById(String id) {
        Connection connection = baseStudentRepository.getConnection();
        List<DetailsContract> detailsContractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int ids = resultSet.getInt("details_contract_id");
                int numberContract = resultSet.getInt("number_contract");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                detailsContractList.add(new DetailsContract(ids,numberContract,new Contract(contractId),new AttachService(attachServiceId, attachServiceName) ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailsContractList;
    }
}
