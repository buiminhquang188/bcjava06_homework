package org.cybersoft.buoi25.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    private static final String url = "jdbc:mysql://localhost:3307/crmapp";
    private static final String username = "root";
    private static final String password = "admin123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return connection;
    }
}
