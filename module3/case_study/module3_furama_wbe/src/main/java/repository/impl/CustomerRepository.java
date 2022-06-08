package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.BaseStudentRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_ALL = " select customer_id,customer.customer_type_id,customer_type.customer_type_name,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer.status from customer join customer_type on customer_type.customer_type_id= customer.customer_type_id where customer.status=0;";
    private static final String INSERT_INTO= " insert into customer(customer_id,customer.customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) value (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE =" update customer set customer.customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=? and customer.status=0;";
    private static final String DELETE_CUSTOMER = " update customer set status = 1 where customer_id = ?; ";
    private static final String SEARCH_BY_NAME = "select customer.*,customer_type.customer_type_name from customer left join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name like ? and customer.customer_type_id like ?;";
    private static final String SORT_BY_NAME = "select * from customer where status=0 order by customer_name;";
    private static final String SELECT_CUSTOMER_TYPE = " select * from customer_type where `status` = 0; ";


    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList =new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL);
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
    public void add(Customer customerList) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,customerList.getId());
            preparedStatement.setInt(2,customerList.getCustomerType().getId());
            preparedStatement.setString(3,customerList.getName());
            preparedStatement.setString(4,customerList.getBirthDay());
            preparedStatement.setInt(5,customerList.getGender());
            preparedStatement.setString(6,customerList.getIdCard());
            preparedStatement.setString(7,customerList.getPhone());
            preparedStatement.setString(8,customerList.getEmail());
            preparedStatement.setString(9,customerList.getAddress());
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
    public void update(Customer customerList) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1,customerList.getCustomerType().getId());
            preparedStatement.setString(2,customerList.getName());
            preparedStatement.setString(3,customerList.getBirthDay());
            preparedStatement.setInt(4,customerList.getGender());
            preparedStatement.setString(5,customerList.getIdCard());
            preparedStatement.setString(6,customerList.getPhone());
            preparedStatement.setString(7,customerList.getEmail());
            preparedStatement.setString(8,customerList.getAddress());
            preparedStatement.setInt(9,customerList.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
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
    public List<Customer> searchByName(String name,String customerType) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2,"%" + customerType + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int idCustomerType = resultSet.getInt("customer_type_id");
                String nameCustomerType = resultSet.getString("customer_type_name");
                String names = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType,nameCustomerType),names,birthDay,gender, idCard, phone,email,address));
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
    public List<Customer> sortByName() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int idCustomerType = resultSet.getInt("customer_type_id");
                String names = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType),names,birthDay,gender, idCard, phone,email,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        Connection connection = baseStudentRepository.getConnection();
        List<CustomerType> customerTypes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                int status = resultSet.getInt("status");
                CustomerType customerType = new CustomerType(id, name, status);
                customerTypes.add(customerType);
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
        return customerTypes;
    }
}
