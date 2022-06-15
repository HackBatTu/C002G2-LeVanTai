package repository.customer;

import model.Customer;
import model.CustomerType;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String INSERT_SQL = "INSERT INTO customer" + "  (name, id_card," +
            " phone, id_customer_type) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_ALL = "SELECT * FROM customer join customer_type on customer_type.id_customer_type= customer.id_customer_type;";

    private static final String SELECT_BY_ID = "SELECT customer.id, customer.name, customer.id_card, " +
            " customer.phone, customer_type.customer_type_name, customer_type.id_customer_type " +
            " FROM customer join customer_type " +
            " on customer_type.id_customer_type = customer.id_customer_type " +
            " where customer.id = ? ";

    private static final String DELETE_SQL = "delete from customer where id = ?;";

    private static final String UPDATE_SQL = "update customer set name = ?, id_card = ?, " +
            " phone = ?, id_customer_type = ? where id = ?;";

    public Customer findById(int id) {
        Customer customer = null;
        Connection connectionSQL = new ConnectionSQL().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionSQL.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                int idCustomerType = resultSet.getInt("id_customer_type");
                String nameCusType = resultSet.getString("customer_type_name");
                customer = new Customer(id, name, idCard, phone, new CustomerType(idCustomerType, nameCusType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return customer;
    }
// "delete from customer where id = ?;";
    public void delete(int id){
        try {
            Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
    }

    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getIdCard());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, customer.getCustomerType().getId());
            preparedStatement.setInt(5, customer.getId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowUpdate;
    }

    public void insert(Customer customer) throws SQLException {
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getIdCard());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, customer.getCustomerType().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);
        } finally {
            ConnectionSQL.close();
        }
    }

    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connectionSQL = new ConnectionSQL().getConnection();
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connectionSQL.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 String idCard = resultSet.getString("id_card");
                 String phone = resultSet.getString("phone");
                 int idCustomerType = resultSet.getInt("id_customer_type");
                 String nameCusType = resultSet.getString("customer_type_name");
                 customerList.add(new Customer(id, name, idCard, phone, new CustomerType(idCustomerType, nameCusType)));
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return customerList;
    }

    private void printSQLException(SQLException e) {
    }
}
