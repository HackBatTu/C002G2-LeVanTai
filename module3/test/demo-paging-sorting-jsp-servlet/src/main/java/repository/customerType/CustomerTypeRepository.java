package repository.customerType;

import model.CustomerType;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private static final String SELECT_BY_ID = "select * from customer_type where id =?";
    private static final String SELECT_ALL = "select * from customer_type";
    private static final String DELETE_SQL = "delete from customer_type where id = ?;";
    private static final String UPDATE_SQL = "update customer_type set customer_type_name = ? where id = ?;";

    public List<CustomerType> selectAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_customer_type");
                String name = rs.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return customerTypeList;
    }

    private void printSQLException(SQLException e) {
    }
}
