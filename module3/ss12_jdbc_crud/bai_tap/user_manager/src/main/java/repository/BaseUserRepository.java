package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseUserRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demos";
    private String jdbcUsername = "root";
    private String jdbcPassword = "account1496";
    private Connection connection;

    public Connection getConnectionJavaToDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
