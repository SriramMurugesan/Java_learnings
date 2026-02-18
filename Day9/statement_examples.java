// JDBC Statement Interface Examples
// Demonstrates CRUD operations using Statement interface

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Example 1: Create Table using Statement
class CreateTableExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // SQL to create table
            String sql = "CREATE TABLE students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "grade VARCHAR(10))";

            statement.executeUpdate(sql);
            System.out.println("✓ Table 'students' created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 2: Insert Data using Statement
class InsertDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // Insert single record
            String sql = "INSERT INTO students (name, age, grade) VALUES ('John', 20, 'A')";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("✓ " + rowsAffected + " row inserted");

            // Insert multiple records
            statement.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Alice', 22, 'B')");
            statement.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Bob', 21, 'A')");
            System.out.println("✓ Multiple rows inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 3: Select Data using Statement
class SelectDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

            System.out.println("ID\tName\tAge\tGrade");
            System.out.println("--------------------------------");

            // Process results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");

                System.out.println(id + "\t" + name + "\t" + age + "\t" + grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 4: Update Data using Statement
class UpdateDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // Update single record
            String sql = "UPDATE students SET grade = 'A+' WHERE name = 'Alice'";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("✓ " + rowsAffected + " row updated");

            // Update multiple records
            sql = "UPDATE students SET age = age + 1 WHERE grade = 'A'";
            rowsAffected = statement.executeUpdate(sql);
            System.out.println("✓ " + rowsAffected + " rows updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 5: Delete Data using Statement
class DeleteDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // Delete single record
            String sql = "DELETE FROM students WHERE id = 1";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("✓ " + rowsAffected + " row deleted");

            // Delete multiple records
            sql = "DELETE FROM students WHERE age < 21";
            rowsAffected = statement.executeUpdate(sql);
            System.out.println("✓ " + rowsAffected + " rows deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 6: Execute vs ExecuteUpdate vs ExecuteQuery
class StatementMethodsExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // 1. executeQuery() - for SELECT (returns ResultSet)
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            System.out.println("✓ executeQuery() used for SELECT");
            rs.close();

            // 2. executeUpdate() - for INSERT, UPDATE, DELETE (returns int)
            int rows = statement.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('Test', 20, 'C')");
            System.out.println("✓ executeUpdate() returned: " + rows + " rows affected");

            // 3. execute() - for any SQL (returns boolean)
            boolean hasResultSet = statement.execute("SELECT * FROM students");
            if (hasResultSet) {
                System.out.println("✓ execute() returned ResultSet");
            } else {
                System.out.println("✓ execute() returned update count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 7: Batch Updates
class BatchUpdateExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // Add multiple SQL statements to batch
            statement.addBatch("INSERT INTO students (name, age, grade) VALUES ('Student1', 20, 'A')");
            statement.addBatch("INSERT INTO students (name, age, grade) VALUES ('Student2', 21, 'B')");
            statement.addBatch("INSERT INTO students (name, age, grade) VALUES ('Student3', 22, 'C')");

            // Execute all at once
            int[] results = statement.executeBatch();
            System.out.println("✓ Batch executed: " + results.length + " statements");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 8: Complete CRUD Operations
class CompleteCRUDExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement()) {

            // CREATE
            System.out.println("\n=== CREATE ===");
            statement.executeUpdate("INSERT INTO students (name, age, grade) VALUES ('David', 23, 'A')");
            System.out.println("✓ Record created");

            // READ
            System.out.println("\n=== READ ===");
            ResultSet rs = statement.executeQuery("SELECT * FROM students WHERE name = 'David'");
            while (rs.next()) {
                System.out.println("Found: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
            rs.close();

            // UPDATE
            System.out.println("\n=== UPDATE ===");
            int updated = statement.executeUpdate("UPDATE students SET age = 24 WHERE name = 'David'");
            System.out.println("✓ " + updated + " record updated");

            // DELETE
            System.out.println("\n=== DELETE ===");
            int deleted = statement.executeUpdate("DELETE FROM students WHERE name = 'David'");
            System.out.println("✓ " + deleted + " record deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * KEY POINTS:
 * 
 * 1. Statement Methods:
 * - executeQuery() → SELECT queries (returns ResultSet)
 * - executeUpdate() → INSERT, UPDATE, DELETE (returns int)
 * - execute() → Any SQL (returns boolean)
 * 
 * 2. Creating Statement:
 * Statement stmt = connection.createStatement();
 * 
 * 3. Always close Statement and ResultSet
 * 
 * 4. Statement Limitations:
 * - No parameterized queries
 * - Vulnerable to SQL injection
 * - Less efficient (no pre-compilation)
 * → Use PreparedStatement instead!
 * 
 * 5. Batch Updates:
 * - Use addBatch() and executeBatch()
 * - More efficient for multiple operations
 */
