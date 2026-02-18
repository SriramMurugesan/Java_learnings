// JDBC ResultSet Interface Examples
// Demonstrates navigating and retrieving data from ResultSet

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Example 1: Basic ResultSet Navigation
class BasicResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

            // next() moves cursor to next row
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 2: Retrieve Data by Column Index
class RetrieveByIndexExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT id, name, age, grade FROM students")) {

            while (rs.next()) {
                // Retrieve by column index (starts from 1, not 0!)
                int id = rs.getInt(1); // First column
                String name = rs.getString(2); // Second column
                int age = rs.getInt(3); // Third column
                String grade = rs.getString(4); // Fourth column

                System.out.println(id + " | " + name + " | " + age + " | " + grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 3: Different Data Types
class DataTypesExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                // Different getter methods for different types
                int id = rs.getInt("id"); // Integer
                String name = rs.getString("name"); // String
                int age = rs.getInt("age"); // Integer
                double gpa = rs.getDouble("gpa"); // Double
                boolean active = rs.getBoolean("is_active"); // Boolean

                System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 4: Check for Empty ResultSet
class CheckEmptyResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students WHERE age > 100")) {

            if (!rs.next()) {
                System.out.println("No records found!");
            } else {
                // Process first row
                System.out.println("Found: " + rs.getString("name"));

                // Continue with remaining rows
                while (rs.next()) {
                    System.out.println("Found: " + rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 5: Scrollable ResultSet (Forward and Backward)
class ScrollableResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Scrollable
                        ResultSet.CONCUR_READ_ONLY)) { // Read-only

            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            // Move to last row
            if (rs.last()) {
                System.out.println("Last student: " + rs.getString("name"));
            }

            // Move to first row
            if (rs.first()) {
                System.out.println("First student: " + rs.getString("name"));
            }

            // Move to specific row (3rd row)
            if (rs.absolute(3)) {
                System.out.println("3rd student: " + rs.getString("name"));
            }

            // Move backward
            if (rs.previous()) {
                System.out.println("Previous student: " + rs.getString("name"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 6: Get Row Count
class GetRowCountExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {

            ResultSet rs = statement.executeQuery("SELECT * FROM students");

            // Move to last row and get row number
            rs.last();
            int rowCount = rs.getRow();
            System.out.println("Total rows: " + rowCount);

            // Move back to start
            rs.beforeFirst();

            // Process all rows
            while (rs.next()) {
                System.out.println("Row " + rs.getRow() + ": " + rs.getString("name"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 7: ResultSet Metadata
class ResultSetMetaDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

            // Get metadata
            var metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);

            // Print column names and types
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                int columnSize = metaData.getColumnDisplaySize(i);

                System.out.println("Column " + i + ": " + columnName +
                        " (" + columnType + ", Size: " + columnSize + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 8: Handle NULL Values
class HandleNullValuesExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // Check if value was NULL
                if (rs.wasNull()) {
                    System.out.println(name + " - Age: NULL");
                } else {
                    System.out.println(name + " - Age: " + age);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 9: Complete ResultSet Navigation Demo
class CompleteNavigationExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password");
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = statement.executeQuery("SELECT * FROM students ORDER BY id")) {

            System.out.println("=== Forward Navigation ===");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }

            System.out.println("\n=== Backward Navigation ===");
            while (rs.previous()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }

            System.out.println("\n=== Random Access ===");
            rs.first();
            System.out.println("First: " + rs.getString("name"));

            rs.last();
            System.out.println("Last: " + rs.getString("name"));

            rs.absolute(2);
            System.out.println("2nd: " + rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * KEY POINTS:
 * 
 * 1. ResultSet Navigation Methods:
 * - next() → Move to next row (most common)
 * - previous() → Move to previous row
 * - first() → Move to first row
 * - last() → Move to last row
 * - absolute(n) → Move to nth row
 * - beforeFirst() → Move before first row
 * - afterLast() → Move after last row
 * 
 * 2. Data Retrieval Methods:
 * - getInt(column) → Get integer value
 * - getString(column) → Get string value
 * - getDouble(column) → Get double value
 * - getBoolean(column) → Get boolean value
 * - getDate(column) → Get date value
 * 
 * 3. Column Reference:
 * - By name: rs.getString("name")
 * - By index: rs.getString(1) [starts from 1, not 0!]
 * 
 * 4. ResultSet Types:
 * - TYPE_FORWARD_ONLY (default) → Only next()
 * - TYPE_SCROLL_INSENSITIVE → Forward and backward
 * - TYPE_SCROLL_SENSITIVE → Forward and backward, reflects changes
 * 
 * 5. Always close ResultSet (or use try-with-resources)
 */
