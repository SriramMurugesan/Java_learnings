// JDBC Transaction Management Examples
// Demonstrates commit, rollback, and savepoints

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

// Example 1: Basic Transaction with Commit
class BasicTransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            // Disable auto-commit
            connection.setAutoCommit(false);

            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // First insert
            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 20);
            pstmt.setString(3, "A");
            pstmt.executeUpdate();
            System.out.println("✓ First insert executed");

            // Second insert
            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 21);
            pstmt.setString(3, "B");
            pstmt.executeUpdate();
            System.out.println("✓ Second insert executed");

            // Commit transaction
            connection.commit();
            System.out.println("✓ Transaction committed successfully");

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("✗ Transaction failed!");
            e.printStackTrace();
        }
    }
}

// Example 2: Transaction with Rollback
class TransactionRollbackExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "root", "password");
            connection.setAutoCommit(false);

            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // First insert
            pstmt.setString(1, "Charlie");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "C");
            pstmt.executeUpdate();
            System.out.println("✓ First insert executed");

            // Simulate error - invalid data
            pstmt.setString(1, "David");
            pstmt.setInt(2, -5); // Invalid age
            pstmt.setString(3, "D");
            pstmt.executeUpdate();

            // This won't be reached if error occurs
            connection.commit();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("✗ Error occurred! Rolling back...");
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// Example 3: Bank Transfer Transaction
class BankTransferExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "root", "password");
            connection.setAutoCommit(false);

            // Debit from Account A
            String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement debitStmt = connection.prepareStatement(debitSql);
            debitStmt.setDouble(1, 1000.00);
            debitStmt.setInt(2, 101);
            debitStmt.executeUpdate();
            System.out.println("✓ Debited 1000 from Account 101");

            // Credit to Account B
            String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement creditStmt = connection.prepareStatement(creditSql);
            creditStmt.setDouble(1, 1000.00);
            creditStmt.setInt(2, 102);
            creditStmt.executeUpdate();
            System.out.println("✓ Credited 1000 to Account 102");

            // Both operations successful - commit
            connection.commit();
            System.out.println("✓ Transfer completed successfully");

            debitStmt.close();
            creditStmt.close();

        } catch (SQLException e) {
            System.out.println("✗ Transfer failed! Rolling back...");
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back - no money transferred");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset to default
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// Example 4: Savepoints
class SavepointExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection connection = null;
        Savepoint savepoint1 = null;
        Savepoint savepoint2 = null;

        try {
            connection = DriverManager.getConnection(url, "root", "password");
            connection.setAutoCommit(false);

            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Insert 1
            pstmt.setString(1, "Student1");
            pstmt.setInt(2, 20);
            pstmt.setString(3, "A");
            pstmt.executeUpdate();
            System.out.println("✓ Insert 1 completed");

            // Create savepoint 1
            savepoint1 = connection.setSavepoint("Savepoint1");
            System.out.println("✓ Savepoint 1 created");

            // Insert 2
            pstmt.setString(1, "Student2");
            pstmt.setInt(2, 21);
            pstmt.setString(3, "B");
            pstmt.executeUpdate();
            System.out.println("✓ Insert 2 completed");

            // Create savepoint 2
            savepoint2 = connection.setSavepoint("Savepoint2");
            System.out.println("✓ Savepoint 2 created");

            // Insert 3 (this will fail)
            pstmt.setString(1, "Student3");
            pstmt.setInt(2, -10); // Invalid
            pstmt.setString(3, "C");
            pstmt.executeUpdate();

            connection.commit();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("✗ Error! Rolling back to Savepoint 2...");
            try {
                if (connection != null && savepoint2 != null) {
                    connection.rollback(savepoint2);
                    System.out.println("✓ Rolled back to Savepoint 2");
                    System.out.println("✓ Insert 1 and 2 are saved, Insert 3 is discarded");
                    connection.commit();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// Example 5: Transaction Isolation Levels
class TransactionIsolationExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";

        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {

            // Get current isolation level
            int currentLevel = connection.getTransactionIsolation();
            System.out.println("Current isolation level: " + currentLevel);

            // Set isolation level
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("✓ Isolation level set to READ_COMMITTED");

            /*
             * Isolation Levels:
             * 1. TRANSACTION_READ_UNCOMMITTED (1) - Lowest isolation
             * 2. TRANSACTION_READ_COMMITTED (2)
             * 3. TRANSACTION_REPEATABLE_READ (4)
             * 4. TRANSACTION_SERIALIZABLE (8) - Highest isolation
             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Example 6: Complete Transaction Example with Error Handling
class CompleteTransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Get connection
            connection = DriverManager.getConnection(url, "root", "password");

            // Start transaction
            connection.setAutoCommit(false);
            System.out.println("✓ Transaction started");

            // Prepare statement
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            // Execute multiple operations
            for (int i = 1; i <= 3; i++) {
                pstmt.setString(1, "Student" + i);
                pstmt.setInt(2, 20 + i);
                pstmt.setString(3, "A");
                pstmt.executeUpdate();
                System.out.println("✓ Insert " + i + " completed");
            }

            // Commit transaction
            connection.commit();
            System.out.println("✓ Transaction committed successfully");

        } catch (SQLException e) {
            // Rollback on error
            System.out.println("✗ Error occurred!");
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("✓ Transaction rolled back");
                } catch (SQLException ex) {
                    System.out.println("✗ Rollback failed!");
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();

        } finally {
            // Close resources
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * KEY POINTS:
 * 
 * 1. Transaction Basics:
 * - setAutoCommit(false) → Start transaction
 * - commit() → Save changes permanently
 * - rollback() → Undo all changes
 * - setAutoCommit(true) → Reset to default
 * 
 * 2. Why Use Transactions?
 * - Ensure data consistency
 * - All operations succeed or all fail (atomicity)
 * - Example: Bank transfers, order processing
 * 
 * 3. Savepoints:
 * - setSavepoint(name) → Create savepoint
 * - rollback(savepoint) → Rollback to specific point
 * - Useful for partial rollbacks
 * 
 * 4. Transaction Isolation Levels:
 * - READ_UNCOMMITTED → Lowest isolation, dirty reads possible
 * - READ_COMMITTED → Prevents dirty reads
 * - REPEATABLE_READ → Prevents dirty and non-repeatable reads
 * - SERIALIZABLE → Highest isolation, prevents all anomalies
 * 
 * 5. Best Practices:
 * - Always use try-catch for rollback
 * - Reset autoCommit in finally block
 * - Keep transactions short
 * - Close resources properly
 * 
 * 6. ACID Properties:
 * - Atomicity → All or nothing
 * - Consistency → Valid state always
 * - Isolation → Concurrent transactions don't interfere
 * - Durability → Committed changes are permanent
 */
