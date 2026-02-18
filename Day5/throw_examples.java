// Throw Keyword Examples in Java

// Example 1: Basic Throw Statement
class BasicThrow {
    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Age is valid: " + age);
    }
    
    public static void demonstrateBasicThrow() {
        System.out.println("=== Basic Throw Example ===");
        
        try {
            validateAge(25);
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 2: Throwing Checked Exceptions
class ThrowingCheckedException {
    public static void readConfig(String filename) throws Exception {
        if (filename == null || filename.isEmpty()) {
            throw new Exception("Filename cannot be null or empty");
        }
        System.out.println("Reading config from: " + filename);
    }
    
    public static void demonstrateCheckedThrow() {
        System.out.println("=== Throwing Checked Exception ===");
        
        try {
            readConfig("config.properties");
            readConfig("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 3: Throwing Unchecked Exceptions
class ThrowingUncheckedException {
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        System.out.println(a + " / " + b + " = " + (a / b));
    }
    
    public static void demonstrateUncheckedThrow() {
        System.out.println("=== Throwing Unchecked Exception ===");
        
        try {
            divide(10, 2);
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 4: Input Validation
class InputValidation {
    public static void setUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        if (username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters");
        }
        if (username.length() > 20) {
            throw new IllegalArgumentException("Username cannot exceed 20 characters");
        }
        System.out.println("Username set: " + username);
    }
    
    public static void demonstrateInputValidation() {
        System.out.println("=== Input Validation Example ===");
        
        String[] usernames = {"john", "ab", "validusername", null};
        
        for (String username : usernames) {
            try {
                System.out.print("Testing: " + username + " → ");
                setUsername(username);
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Example 5: Business Logic Validation
class ThrowBankAccount {
    private double balance;
    
    public ThrowBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException(
                "Insufficient funds. Balance: " + balance + ", Requested: " + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New balance: " + balance);
    }
}

class BusinessLogicValidation {
    public static void demonstrateBusinessLogic() {
        System.out.println("=== Business Logic Validation ===");
        
        ThrowBankAccount account = new ThrowBankAccount(1000);
        
        try {
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(2000); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 6: Re-throwing Exceptions
class RethrowingExceptions {
    public static void processData(String data) throws Exception {
        try {
            int number = Integer.parseInt(data);
            System.out.println("Processed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Logging error...");
            throw e; // Re-throw the same exception
        }
    }
    
    public static void demonstrateRethrowing() {
        System.out.println("=== Re-throwing Exceptions ===");
        
        try {
            processData("123");
            processData("abc");
        } catch (Exception e) {
            System.out.println("Caught re-thrown exception: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 7: Wrapping Exceptions
class WrappingExceptions {
    public static void loadConfiguration(String filename) throws Exception {
        try {
            if (filename.equals("invalid")) {
                throw new java.io.IOException("File not found");
            }
            System.out.println("Configuration loaded");
        } catch (java.io.IOException e) {
            // Wrap IOException in a more general Exception
            throw new Exception("Failed to load configuration: " + filename, e);
        }
    }
    
    public static void demonstrateWrapping() {
        System.out.println("=== Wrapping Exceptions ===");
        
        try {
            loadConfiguration("config.xml");
            loadConfiguration("invalid");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Caused by: " + e.getCause().getMessage());
            }
        }
        
        System.out.println();
    }
}

// Example 8: Throw in Conditional Statements
class ConditionalThrow {
    public static String getGrade(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        
        if (marks >= 90) return "A";
        if (marks >= 80) return "B";
        if (marks >= 70) return "C";
        if (marks >= 60) return "D";
        return "F";
    }
    
    public static void demonstrateConditionalThrow() {
        System.out.println("=== Throw in Conditional Statements ===");
        
        int[] marksList = {95, 75, 50, 105, -10};
        
        for (int marks : marksList) {
            try {
                String grade = getGrade(marks);
                System.out.println("Marks: " + marks + " → Grade: " + grade);
            } catch (IllegalArgumentException e) {
                System.out.println("Marks: " + marks + " → Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Example 9: Throw in Switch Statement
class SwitchThrow {
    public static void processCommand(String command) {
        switch (command.toUpperCase()) {
            case "START":
                System.out.println("Starting process...");
                break;
            case "STOP":
                System.out.println("Stopping process...");
                break;
            case "PAUSE":
                System.out.println("Pausing process...");
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
    
    public static void demonstrateSwitchThrow() {
        System.out.println("=== Throw in Switch Statement ===");
        
        String[] commands = {"START", "STOP", "INVALID", "PAUSE"};
        
        for (String command : commands) {
            try {
                processCommand(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Example 10: Multiple Throw Statements
class MultipleThrowStatements {
    public static void validateUser(String username, String password, int age) {
        if (username == null || username.isEmpty()) {
            throw new NullPointerException("Username cannot be null or empty");
        }
        if (username.length() < 3) {
            throw new IllegalArgumentException("Username too short (min 3 characters)");
        }
        if (password == null || password.isEmpty()) {
            throw new NullPointerException("Password cannot be null or empty");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password too short (min 8 characters)");
        }
        if (age < 18) {
            throw new IllegalArgumentException("User must be 18 or older");
        }
        System.out.println("User validation successful");
    }
    
    public static void demonstrateMultipleThrows() {
        System.out.println("=== Multiple Throw Statements ===");
        
        try {
            validateUser("john", "password123", 25);
            System.out.println("Test 1 passed");
        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }
        
        try {
            validateUser("ab", "password123", 25);
        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }
        
        try {
            validateUser("john", "pass", 25);
        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }
        
        try {
            validateUser("john", "password123", 15);
        } catch (Exception e) {
            System.out.println("Test 4 failed: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 11: Throw with Finally
class ThrowWithFinally {
    public static void processWithCleanup(boolean shouldFail) {
        try {
            System.out.println("  Processing...");
            if (shouldFail) {
                throw new RuntimeException("Process failed");
            }
            System.out.println("  Process completed");
        } finally {
            System.out.println("  Cleanup executed (finally block)");
        }
    }
    
    public static void demonstrateThrowWithFinally() {
        System.out.println("=== Throw with Finally ===");
        
        System.out.println("Case 1: Success");
        try {
            processWithCleanup(false);
        } catch (RuntimeException e) {
            System.out.println("  Caught: " + e.getMessage());
        }
        
        System.out.println("\nCase 2: Failure");
        try {
            processWithCleanup(true);
        } catch (RuntimeException e) {
            System.out.println("  Caught: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 12: Precondition Checking
class PreconditionChecking {
    public static void processArray(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        System.out.println("Processing array of length: " + arr.length);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void demonstratePreconditions() {
        System.out.println("=== Precondition Checking ===");
        
        try {
            processArray(new int[]{1, 2, 3});
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            processArray(new int[]{});
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            processArray(null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 13: State Validation
class Connection {
    private boolean connected = false;
    
    public void connect() {
        if (connected) {
            throw new IllegalStateException("Already connected");
        }
        connected = true;
        System.out.println("Connected successfully");
    }
    
    public void sendData(String data) {
        if (!connected) {
            throw new IllegalStateException("Not connected. Call connect() first");
        }
        System.out.println("Sending data: " + data);
    }
    
    public void disconnect() {
        if (!connected) {
            throw new IllegalStateException("Not connected");
        }
        connected = false;
        System.out.println("Disconnected");
    }
}

class StateValidation {
    public static void demonstrateStateValidation() {
        System.out.println("=== State Validation Example ===");
        
        Connection conn = new Connection();
        
        try {
            conn.connect();
            conn.sendData("Hello");
            conn.disconnect();
            conn.sendData("World"); // Will throw exception
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 14: Throw vs Throws Comparison
class ThrowVsThrows {
    // Using throw - actually throws an exception
    public static void methodWithThrow(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        System.out.println("Value: " + value);
    }
    
    // Using throws - declares that method might throw
    public static void methodWithThrows(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Value cannot be negative");
        }
        System.out.println("Value: " + value);
    }
    
    public static void demonstrateComparison() {
        System.out.println("=== Throw vs Throws Comparison ===");
        
        System.out.println("1. throw keyword (creates and throws):");
        try {
            methodWithThrow(10);
            methodWithThrow(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println("\n2. throws keyword (declares possibility):");
        try {
            methodWithThrows(10);
            methodWithThrows(-5);
        } catch (Exception e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Main class to run all examples
public class throw_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       THROW KEYWORD EXAMPLES IN JAVA       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all demonstrations
        BasicThrow.demonstrateBasicThrow();
        ThrowingCheckedException.demonstrateCheckedThrow();
        ThrowingUncheckedException.demonstrateUncheckedThrow();
        InputValidation.demonstrateInputValidation();
        BusinessLogicValidation.demonstrateBusinessLogic();
        RethrowingExceptions.demonstrateRethrowing();
        WrappingExceptions.demonstrateWrapping();
        ConditionalThrow.demonstrateConditionalThrow();
        SwitchThrow.demonstrateSwitchThrow();
        MultipleThrowStatements.demonstrateMultipleThrows();
        ThrowWithFinally.demonstrateThrowWithFinally();
        PreconditionChecking.demonstratePreconditions();
        StateValidation.demonstrateStateValidation();
        ThrowVsThrows.demonstrateComparison();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
