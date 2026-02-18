// JDBC PreparedStatement Interface Examples
// Demonstrates parameterized queries and SQL injection prevention

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Example 1: Basic PreparedStatement Insert
class BasicPreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            // SQL with placeholders (?)
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Set parameters (index starts from 1)
            pstmt.setString(1, "John"); // First ?
            pstmt.setInt(2, 20); // Second ?
            pstmt.setString(3, "A"); // Third ?

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("✓ " + rowsAffected + " row inserted");

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 2: PreparedStatement vs Statement (SQL Injection)
class SQLInjectionPreventionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        // Malicious input
        String userInput = "John' OR '1'='1";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            // UNSAFE: Statement (vulnerable to SQL injection)
            System.out.println("=== UNSAFE Statement ===");
            var stmt = connection.createStatement();
            String unsafeSql = "SELECT * FROM students WHERE name = '" + userInput + "'";
            System.out.println("SQL: " + unsafeSql);
            // This would return ALL students! (SQL injection attack)

            // SAFE: PreparedStatement (prevents SQL injection)
            System.out.println("\n=== SAFE PreparedStatement ===");
            String safeSql = "SELECT * FROM students WHERE name = ?";
            PreparedStatement pstmt = connection.prepareStatement(safeSql);
            pstmt.setString(1, userInput);
            // This treats the entire input as a string literal
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("✓ No records found (SQL injection prevented!)");
            }

            rs.close();
            pstmt.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 3: PreparedStatement Select with Parameters
class PreparedStatementSelectExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "SELECT * FROM students WHERE age > ? AND grade = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, 18); // age > 18
            pstmt.setString(2, "A"); // grade = 'A'

            ResultSet rs = pstmt.executeQuery();

            System.out.println("Students with age > 18 and grade A:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " - Age: " + rs.getInt("age"));
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 4: PreparedStatement Update
class PreparedStatementUpdateExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "UPDATE students SET grade = ? WHERE name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "A+");
            pstmt.setString(2, "John");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("✓ " + rowsAffected + " row updated");

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 5: PreparedStatement Delete
class PreparedStatementDeleteExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, 5);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("✓ " + rowsAffected + " row deleted");

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 6: Reusing PreparedStatement (Performance)
class ReusePreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Insert multiple records using same PreparedStatement
            String[][] students = {
                    { "Alice", "20", "A" },
                    { "Bob", "21", "B" },
                    { "Charlie", "22", "C" }
            };

            for (String[] student : students) {
                pstmt.setString(1, student[0]);
                pstmt.setInt(2, Integer.parseInt(student[1]));
                pstmt.setString(3, student[2]);
                pstmt.executeUpdate();
            }

            System.out.println("✓ " + students.length + " records inserted");
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 7: Batch Processing with PreparedStatement
class PreparedStatementBatchExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Add to batch
            pstmt.setString(1, "Student1");
            pstmt.setInt(2, 20);
            pstmt.setString(3, "A");
            pstmt.addBatch();

            pstmt.setString(1, "Student2");
            pstmt.setInt(2, 21);
            pstmt.setString(3, "B");
            pstmt.addBatch();

            pstmt.setString(1, "Student3");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "C");
            pstmt.addBatch();

            // Execute all at once
            int[] results = pstmt.executeBatch();
            System.out.println("✓ Batch executed: " + results.length + " records inserted");

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 8: Different Data Types with PreparedStatement
class PreparedStatementDataTypesExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            String sql = "INSERT INTO employees (name, salary, hire_date, is_active) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Different setter methods for different types
            pstmt.setString(1, "John Doe"); // String
            pstmt.setDouble(2, 50000.50); // Double
            pstmt.setDate(3, java.sql.Date.valueOf("2024-01-15")); // Date
            pstmt.setBoolean(4, true); // Boolean

            pstmt.executeUpdate();
            System.out.println("✓ Employee record inserted");

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 9: Complete CRUD with PreparedStatement
class CompleteCRUDPreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            // CREATE
            System.out.println("\n=== CREATE ===");
            String insertSql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSql);
            insertStmt.setString(1, "David");
            insertStmt.setInt(2, 23);
            insertStmt.setString(3, "A");
            insertStmt.executeUpdate();
            System.out.println("✓ Record created");
            insertStmt.close();

            // READ
            System.out.println("\n=== READ ===");
            String selectSql = "SELECT * FROM students WHERE name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectSql);
            selectStmt.setString(1, "David");
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                System.out.println("Found: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
            rs.close();
            selectStmt.close();

            // UPDATE
            System.out.println("\n=== UPDATE ===");
            String updateSql = "UPDATE students SET age = ? WHERE name = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateSql);
            updateStmt.setInt(1, 24);
            updateStmt.setString(2, "David");
            int updated = updateStmt.executeUpdate();
            System.out.println("✓ " + updated + " record updated");
            updateStmt.close();

            // DELETE
            System.out.println("\n=== DELETE ===");
            String deleteSql = "DELETE FROM students WHERE name = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
            deleteStmt.setString(1, "David");
            int deleted = deleteStmt.executeUpdate();
            System.out.println("✓ " + deleted + " record deleted");
            deleteStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * KEY POINTS:
 * 
 * 1. PreparedStatement Advantages:
 * ✓ Prevents SQL injection attacks
 * ✓ Better performance (pre-compiled)
 * ✓ Easier to read and maintain
 * ✓ Automatic type conversion
 * 
 * 2. Creating PreparedStatement:
 * PreparedStatement pstmt = connection.prepareStatement(sql);
 * 
 * 3. Setting Parameters:
 * - setString(index, value)
 * - setInt(index, value)
 * - setDouble(index, value)
 * - setBoolean(index, value)
 * - setDate(index, value)
 * - Index starts from 1 (not 0!)
 * 
 * 4. Executing Queries:
 * - executeQuery() → SELECT (returns ResultSet)
 * - executeUpdate() → INSERT, UPDATE, DELETE (returns int)
 * 
 * 5. Batch Processing:
 * - addBatch() → Add to batch
 * - executeBatch() → Execute all
 * 
 * 6. ALWAYS use PreparedStatement instead of Statement!
 */
