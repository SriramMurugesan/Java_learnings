// Exception Handling Interview Programs in Java

import java.util.*;
import java.io.*;

// Program 1: Basic Exception Handling
class Program1_BasicExceptionHandling {
    public static void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 1: Basic Exception Handling ===");
        divide(10, 2);
        divide(10, 0);
        System.out.println();
    }
}

// Program 2: Multiple Catch Blocks
class Program2_MultipleCatchBlocks {
    public static void processInput(String input, int index) {
        try {
            int number = Integer.parseInt(input);
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println("Value at index " + index + ": " + arr[index]);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + input);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index: " + index);
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 2: Multiple Catch Blocks ===");
        processInput("123", 2);
        processInput("abc", 2);
        processInput("123", 10);
        System.out.println();
    }
}

// Program 3: Finally Block Usage
class Program3_FinallyBlock {
    public static void processData(boolean throwException) {
        try {
            System.out.println("  Processing data...");
            if (throwException) {
                throw new RuntimeException("Error occurred");
            }
            System.out.println("  Data processed successfully");
        } catch (RuntimeException e) {
            System.out.println("  Caught exception: " + e.getMessage());
        } finally {
            System.out.println("  Cleanup completed (finally block)");
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 3: Finally Block Usage ===");
        System.out.println("Case 1: No exception");
        processData(false);
        System.out.println("\nCase 2: With exception");
        processData(true);
        System.out.println();
    }
}

// Program 4: Custom Exception
class Day5InterviewInvalidAgeException extends Exception {
    public Day5InterviewInvalidAgeException(String message) {
        super(message);
    }
}

class Program4_CustomException {
    public static void validateAge(int age) throws Day5InterviewInvalidAgeException {
        if (age < 0 || age > 150) {
            throw new Day5InterviewInvalidAgeException("Age must be between 0 and 150. Got: " + age);
        }
        System.out.println("Valid age: " + age);
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 4: Custom Exception ===");
        try {
            validateAge(25);
            validateAge(200);
        } catch (Day5InterviewInvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }
}

// Program 5: Exception Propagation
class Program5_ExceptionPropagation {
    public static void methodC() throws IOException {
        System.out.println("  methodC: Throwing IOException");
        throw new IOException("Error in methodC");
    }
    
    public static void methodB() throws IOException {
        System.out.println("  methodB: Calling methodC");
        methodC();
    }
    
    public static void methodA() throws IOException {
        System.out.println("  methodA: Calling methodB");
        methodB();
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 5: Exception Propagation ===");
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("  main: Caught - " + e.getMessage());
        }
        System.out.println();
    }
}

// Program 6: Nested Try-Catch
class Program6_NestedTryCatch {
    public static void demonstrate() {
        System.out.println("=== Program 6: Nested Try-Catch ===");
        
        try {
            System.out.println("Outer try block");
            
            try {
                System.out.println("Inner try block");
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
            
            String str = null;
            str.length();
            
        } catch (NullPointerException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Program 7: Try-With-Resources
class CustomResource implements AutoCloseable {
    private String name;
    
    public CustomResource(String name) {
        this.name = name;
        System.out.println("  Opening resource: " + name);
    }
    
    public void use() {
        System.out.println("  Using resource: " + name);
    }
    
    @Override
    public void close() {
        System.out.println("  Closing resource: " + name);
    }
}

class Program7_TryWithResources {
    public static void demonstrate() {
        System.out.println("=== Program 7: Try-With-Resources ===");
        
        try (CustomResource resource = new CustomResource("Database")) {
            resource.use();
        }
        System.out.println("  Resource automatically closed");
        System.out.println();
    }
}

// Program 8: Bank Account with Custom Exceptions
class Day5InterviewInsufficientFundsException extends Exception {
    public Day5InterviewInsufficientFundsException(double balance, double amount) {
        super("Insufficient funds. Balance: $" + balance + ", Requested: $" + amount);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Day5InterviewBankAccount {
    private double balance;
    
    public Day5InterviewBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + ", New balance: $" + balance);
    }
    
    public void withdraw(double amount) throws InvalidAmountException, Day5InterviewInsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new Day5InterviewInsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + ", New balance: $" + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

class Program8_BankAccount {
    public static void demonstrate() {
        System.out.println("=== Program 8: Bank Account with Custom Exceptions ===");
        
        Day5InterviewBankAccount account = new Day5InterviewBankAccount(1000);
        
        try {
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(2000);
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } catch (Day5InterviewInsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Program 9: Exception Chaining
class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Program9_ExceptionChaining {
    public static void processData(String data) throws DataProcessingException {
        try {
            int number = Integer.parseInt(data);
            System.out.println("Processed: " + number);
        } catch (NumberFormatException e) {
            throw new DataProcessingException("Failed to process data: " + data, e);
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 9: Exception Chaining ===");
        
        try {
            processData("123");
            processData("abc");
        } catch (DataProcessingException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause());
        }
        
        System.out.println();
    }
}

// Program 10: Multi-Catch
class Program10_MultiCatch {
    public static void processOperation(int choice) {
        try {
            if (choice == 1) {
                int result = 10 / 0;
            } else if (choice == 2) {
                int[] arr = {1, 2, 3};
                System.out.println(arr[10]);
            } else {
                Integer.parseInt("abc");
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Arithmetic or Array error: " + e.getClass().getSimpleName());
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 10: Multi-Catch ===");
        processOperation(1);
        processOperation(2);
        processOperation(3);
        System.out.println();
    }
}

// Program 11: User Input Validation
class Program11_UserInputValidation {
    public static void validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters");
        }
        if (username.length() > 20) {
            throw new IllegalArgumentException("Username cannot exceed 20 characters");
        }
        System.out.println("Valid username: " + username);
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 11: User Input Validation ===");
        
        String[] usernames = {"john", "ab", "validusername", null, "verylongusernamethatexceedslimit"};
        
        for (String username : usernames) {
            try {
                System.out.print("Testing: " + username + " → ");
                validateUsername(username);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Program 12: Array Operations
class Program12_ArrayOperations {
    public static void accessArray(int[] arr, int index) {
        try {
            System.out.println("Accessing index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index + " (Array length: " + arr.length + ")");
        } catch (NullPointerException e) {
            System.out.println("Array is null");
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 12: Array Operations ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        accessArray(numbers, 2);
        accessArray(numbers, 10);
        accessArray(null, 0);
        
        System.out.println();
    }
}

// Program 13: String Parsing
class Program13_StringParsing {
    public static void parseAndProcess(String[] inputs) {
        System.out.println("=== Program 13: String Parsing ===");
        
        for (String input : inputs) {
            try {
                int number = Integer.parseInt(input);
                int result = 100 / number;
                System.out.println(input + " → Parsed: " + number + ", Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println(input + " → Invalid number format");
            } catch (ArithmeticException e) {
                System.out.println(input + " → Division by zero");
            }
        }
        
        System.out.println();
    }
    
    public static void demonstrate() {
        String[] inputs = {"10", "5", "abc", "0", "20"};
        parseAndProcess(inputs);
    }
}

// Program 14: Day5InterviewCalculator with Exception Handling
class Day5InterviewCalculator {
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public static double squareRoot(double num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(num);
    }
}

class Program14_Calculator {
    public static void demonstrate() {
        System.out.println("=== Program 14: Day5InterviewCalculator with Exception Handling ===");
        
        try {
            System.out.println("10 / 2 = " + Day5InterviewCalculator.divide(10, 2));
            System.out.println("10 / 0 = " + Day5InterviewCalculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            System.out.println("√16 = " + Day5InterviewCalculator.squareRoot(16));
            System.out.println("√-4 = " + Day5InterviewCalculator.squareRoot(-4));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Program 15: File Operations Simulation
class Program15_FileOperations {
    public static void readFile(String filename) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new FileNotFoundException("Filename cannot be null or empty");
        }
        if (!filename.endsWith(".txt")) {
            throw new FileNotFoundException("Invalid file format. Expected .txt file");
        }
        System.out.println("Reading file: " + filename);
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 15: File Operations Simulation ===");
        
        String[] files = {"data.txt", "config.xml", "", null};
        
        for (String file : files) {
            try {
                System.out.print("File: " + file + " → ");
                readFile(file);
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Program 16: Exception Hierarchy Demonstration
class Program16_ExceptionHierarchy {
    public static void testException(int type) throws Exception {
        switch (type) {
            case 1:
                throw new NumberFormatException("Number format error");
            case 2:
                throw new IllegalArgumentException("Illegal argument");
            case 3:
                throw new RuntimeException("Runtime error");
            case 4:
                throw new Exception("General exception");
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 16: Exception Hierarchy ===");
        
        for (int i = 1; i <= 4; i++) {
            try {
                System.out.print("Test " + i + ": ");
                testException(i);
            } catch (NumberFormatException e) {
                System.out.println("Caught NumberFormatException");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught IllegalArgumentException");
            } catch (RuntimeException e) {
                System.out.println("Caught RuntimeException");
            } catch (Exception e) {
                System.out.println("Caught Exception");
            }
        }
        
        System.out.println();
    }
}

// Program 17: Login System
class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

class Program17_LoginSystem {
    public static void login(String username, String password) throws LoginException {
        if (username == null || password == null) {
            throw new LoginException("Username and password cannot be null");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new LoginException("Username and password cannot be empty");
        }
        if (!username.equals("admin") || !password.equals("admin123")) {
            throw new LoginException("Invalid credentials");
        }
        System.out.println("Login successful for user: " + username);
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 17: Login System ===");
        
        try {
            login("admin", "admin123");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        try {
            login("user", "wrong");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        try {
            login("", "");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Program 18: Re-throwing Exceptions
class Program18_RethrowingExceptions {
    public static void processData(String data) throws Exception {
        try {
            int number = Integer.parseInt(data);
            System.out.println("Processed: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Logging error: " + e.getMessage());
            throw e; // Re-throw
        }
    }
    
    public static void demonstrate() {
        System.out.println("=== Program 18: Re-throwing Exceptions ===");
        
        try {
            processData("123");
            processData("abc");
        } catch (Exception e) {
            System.out.println("Caught re-thrown exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
}

// Main class to run all programs
public class interview_programs {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   EXCEPTION HANDLING INTERVIEW PROGRAMS    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all programs
        Program1_BasicExceptionHandling.demonstrate();
        Program2_MultipleCatchBlocks.demonstrate();
        Program3_FinallyBlock.demonstrate();
        Program4_CustomException.demonstrate();
        Program5_ExceptionPropagation.demonstrate();
        Program6_NestedTryCatch.demonstrate();
        Program7_TryWithResources.demonstrate();
        Program8_BankAccount.demonstrate();
        Program9_ExceptionChaining.demonstrate();
        Program10_MultiCatch.demonstrate();
        Program11_UserInputValidation.demonstrate();
        Program12_ArrayOperations.demonstrate();
        Program13_StringParsing.demonstrate();
        Program14_Calculator.demonstrate();
        Program15_FileOperations.demonstrate();
        Program16_ExceptionHierarchy.demonstrate();
        Program17_LoginSystem.demonstrate();
        Program18_RethrowingExceptions.demonstrate();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL PROGRAMS COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
