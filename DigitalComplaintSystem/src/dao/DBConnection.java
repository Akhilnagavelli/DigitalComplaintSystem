package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/digital_complaint_system";
    private static final String USER = "root"; // ✅ Replace with your MySQL username
    private static final String PASSWORD = "#Akhil@2003"; // ✅ Replace with your MySQL password

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Register JDBC Driver (optional in modern versions)
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connected to database successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("❌ Database connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error closing connection: " + e.getMessage());
        }
    }
}
