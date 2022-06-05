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
    private static final String SELECT_ALL = "select customer_id,customer.customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer.status from customer join customer_type on customer_type.customer_type_id= customer.customer_type_id where customer.status=0;";
    private static final String INSERT_INTO= "insert into customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) value (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE ="update customer set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=? and status=0;";
    private static final String DELETE_CUSTOMER = " update customer set status = 1 where customer_id = ?; ";
    private static final String SEARCH_BY_NAME = "select * from customer where customer_name like ? and status=0 ;";
    private static final String SORT_BY_NAME = "select * from customer where status=0 order by customer_name;";

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
                String name = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_geder");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType),name,birthDay,gender, idCard, phone,email,address ));
            }
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
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int idCustomerType = resultSet.getInt("customer_type_id");
                String names = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType),names,birthDay,gender, idCard, phone,email,address ));
            }
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
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, new CustomerType(idCustomerType),names,birthDay,gender, idCard, phone,email,address ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;    }
}
