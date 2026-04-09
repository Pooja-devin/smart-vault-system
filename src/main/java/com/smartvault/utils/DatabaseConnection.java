package com.smartvault.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection Utility Class
 * Manages JDBC connection to MySQL database
 */
public class DatabaseConnection {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SmartVault";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Update with your MySQL password
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connected successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            throw new SQLException("Driver not found");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed!");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection!");
            e.printStackTrace();
        }
    }
}