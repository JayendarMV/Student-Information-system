package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database credentials - change these as per your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Method to get a database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
