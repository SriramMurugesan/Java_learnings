// JDBC Connection Examples
// Demonstrates loading drivers and establishing database connections

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Example 1: Basic MySQL Connection
class MySQLConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";
        
        Connection connection = null;
        
        try {
            // Step 1: Load MySQL Driver (Optional in JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ Driver loaded successfully");
            
            // Step 2: Establish Connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✓ Connection established successfully");
            System.out.println("Database: " + connection.getCatalog());
            
        } catch (ClassNotFoundException e) {
            System.out.println("✗ MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("✗ Connection failed!");
            e.printStackTrace();
        } finally {
            // Step 3: Close Connection
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("✓ Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// Example 2: PostgreSQL Connection
class PostgreSQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "password";
        
        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");
            
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✓ PostgreSQL connected: " + connection.getCatalog());
            
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Example 3: Connection with Try-With-Resources (Recommended)
class ConnectionWithTryWithResources {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";
        
        // Try-with-resources automatically closes connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            
            System.out.println("✓ Connected to: " + connection.getCatalog());
            System.out.println("Database Product: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Driver Version: " + connection.getMetaData().getDriverVersion());
            
            // Connection automatically closed when try block ends
            
        } catch (SQLException e) {
            System.out.println("✗ Connection error!");
            e.printStackTrace();
        }
    }
}

// Example 4: Check Connection Status
class CheckConnectionStatus {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        
        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {
            
            // Check if connection is valid
            if (connection.isValid(2)) { // timeout in seconds
                System.out.println("✓ Connection is valid");
            }
            
            // Check if connection is closed
            if (!connection.isClosed()) {
                System.out.println("✓ Connection is open");
            }
            
            // Check if connection is read-only
            System.out.println("Read-only: " + connection.isReadOnly());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 5: Connection URL Breakdown
class ConnectionURLExamples {
    public static void main(String[] args) {
        // MySQL URL format:
        // jdbc:mysql://hostname:port/database_name
        String mysqlURL = "jdbc:mysql://localhost:3306/school_db";
        
        // PostgreSQL URL format:
        // jdbc:postgresql://hostname:port/database_name
        String postgresURL = "jdbc:postgresql://localhost:5432/school_db";
        
        // Oracle URL format:
        // jdbc:oracle:thin:@hostname:port:SID
        String oracleURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        
        System.out.println("MySQL URL: " + mysqlURL);
        System.out.println("PostgreSQL URL: " + postgresURL);
        System.out.println("Oracle URL: " + oracleURL);
    }
}

// Example 6: Create Database Connection Utility Class
class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    // Get connection method
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    // Close connection method
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Test the utility
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            System.out.println("✓ Connection successful!");
        } catch (SQLException e) {
            System.out.println("✗ Connection failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}

/*
 * KEY POINTS:
 * 
 * 1. Connection URL Format:
 *    jdbc:database_type://hostname:port/database_name
 * 
 * 2. Three Steps:
 *    - Load Driver (optional in JDBC 4.0+)
 *    - Get Connection
 *    - Close Connection
 * 
 * 3. Always close connections in finally block or use try-with-resources
 * 
 * 4. Common Methods:
 *    - getConnection() - establish connection
 *    - close() - close connection
 *    - isClosed() - check if closed
 *    - isValid() - check if valid
 *    - getCatalog() - get database name
 * 
 * 5. Download JDBC Driver:
 *    - MySQL: mysql-connector-java.jar
 *    - PostgreSQL: postgresql.jar
 *    - Add to classpath when compiling and running
 */
