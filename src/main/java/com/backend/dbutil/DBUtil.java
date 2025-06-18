package com.backend.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/gestioninterventions?useSSL=false";
            String user = "root";
            String password = "";

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
