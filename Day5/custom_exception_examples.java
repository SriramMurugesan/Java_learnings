// Custom Exception Examples in Java

// Example 1: Basic Custom Exception (Checked)
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class BasicCustomException {
    public static void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be between 0 and 150.");
        }
        System.out.println("Age set successfully: " + age);
    }
    
    public static void demonstrateBasicCustom() {
        System.out.println("=== Basic Custom Exception ===");
        
        try {
            setAge(25);
            setAge(200);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 2: Custom Unchecked Exception
class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

class CustomUncheckedException {
    public static void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new ValidationException("Invalid email format: " + email);
        }
        System.out.println("Email is valid: " + email);
    }
    
    public static void demonstrateUncheckedCustom() {
        System.out.println("=== Custom Unchecked Exception ===");
        
        try {
            validateEmail("user@example.com");
            validateEmail("invalid-email");
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 3: Custom Exception with Multiple Constructors
class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds in account");
    }
    
    public InsufficientFundsException(String message) {
        super(message);
    }
    
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }
}

class MultipleConstructors {
    public static void demonstrateMultipleConstructors() {
        System.out.println("=== Multiple Constructors Example ===");
        
        try {
            throw new InsufficientFundsException();
        } catch (InsufficientFundsException e) {
            System.out.println("1. Default: " + e.getMessage());
        }
        
        try {
            throw new InsufficientFundsException("Balance: $50, Required: $100");
        } catch (InsufficientFundsException e) {
            System.out.println("2. With message: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 4: Custom Exception with Additional Fields
class InsufficientBalanceException extends Exception {
    private double balance;
    private double requestedAmount;
    
    public InsufficientBalanceException(double balance, double requestedAmount) {
        super("Insufficient balance. Available: $" + balance + ", Requested: $" + requestedAmount);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
    
    public double getShortfall() {
        return requestedAmount - balance;
    }
}

class AdditionalFields {
    public static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        System.out.println("Withdrawal successful");
    }
    
    public static void demonstrateAdditionalFields() {
        System.out.println("=== Custom Exception with Additional Fields ===");
        
        try {
            withdraw(500, 1000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Current balance: $" + e.getBalance());
            System.out.println("Requested amount: $" + e.getRequestedAmount());
            System.out.println("Shortfall: $" + e.getShortfall());
        }
        
        System.out.println();
    }
}

// Example 5: Banking System Custom Exceptions
class BankingException extends Exception {
    private String accountNumber;
    
    public BankingException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

class AccountNotFoundException extends BankingException {
    public AccountNotFoundException(String accountNumber) {
        super("Account not found", accountNumber);
    }
}

class AccountFrozenException extends BankingException {
    public AccountFrozenException(String accountNumber) {
        super("Account is frozen", accountNumber);
    }
}

class BankingSystem {
    public static void processTransaction(String accountNumber, boolean exists, boolean frozen) 
            throws BankingException {
        if (!exists) {
            throw new AccountNotFoundException(accountNumber);
        }
        if (frozen) {
            throw new AccountFrozenException(accountNumber);
        }
        System.out.println("Transaction processed for account: " + accountNumber);
    }
    
    public static void demonstrateBankingExceptions() {
        System.out.println("=== Banking System Custom Exceptions ===");
        
        try {
            processTransaction("ACC001", true, false);
        } catch (BankingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            processTransaction("ACC002", false, false);
        } catch (BankingException e) {
            System.out.println("Error: " + e.getMessage() + " - " + e.getAccountNumber());
        }
        
        try {
            processTransaction("ACC003", true, true);
        } catch (BankingException e) {
            System.out.println("Error: " + e.getMessage() + " - " + e.getAccountNumber());
        }
        
        System.out.println();
    }
}

// Example 6: Authentication Custom Exceptions
class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

class InvalidCredentialsException extends AuthenticationException {
    public InvalidCredentialsException() {
        super("Invalid username or password");
    }
}

class AccountLockedException extends AuthenticationException {
    private int lockDurationMinutes;
    
    public AccountLockedException(int minutes) {
        super("Account locked for " + minutes + " minutes");
        this.lockDurationMinutes = minutes;
    }
    
    public int getLockDurationMinutes() {
        return lockDurationMinutes;
    }
}

class SessionExpiredException extends AuthenticationException {
    public SessionExpiredException() {
        super("Session has expired. Please login again.");
    }
}

class AuthenticationSystem {
    public static void login(String username, String password, boolean locked, boolean expired) 
            throws AuthenticationException {
        if (expired) {
            throw new SessionExpiredException();
        }
        if (locked) {
            throw new AccountLockedException(30);
        }
        if (!username.equals("admin") || !password.equals("pass123")) {
            throw new InvalidCredentialsException();
        }
        System.out.println("Login successful for user: " + username);
    }
    
    public static void demonstrateAuthenticationExceptions() {
        System.out.println("=== Authentication Custom Exceptions ===");
        
        try {
            login("admin", "pass123", false, false);
        } catch (AuthenticationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            login("admin", "wrong", false, false);
        } catch (AuthenticationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            login("admin", "pass123", true, false);
        } catch (AccountLockedException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wait time: " + e.getLockDurationMinutes() + " minutes");
        } catch (AuthenticationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 7: E-commerce Custom Exceptions
class OrderException extends RuntimeException {
    private String orderId;
    
    public OrderException(String message, String orderId) {
        super(message);
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return orderId;
    }
}

class OutOfStockException extends OrderException {
    private String productId;
    private int availableQuantity;
    
    public OutOfStockException(String orderId, String productId, int available) {
        super("Product out of stock", orderId);
        this.productId = productId;
        this.availableQuantity = available;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public int getAvailableQuantity() {
        return availableQuantity;
    }
}

class InvalidDiscountCodeException extends OrderException {
    public InvalidDiscountCodeException(String orderId, String code) {
        super("Invalid discount code: " + code, orderId);
    }
}

class EcommerceSystem {
    public static void placeOrder(String orderId, String productId, int quantity, String discountCode) {
        if (quantity > 5) {
            throw new OutOfStockException(orderId, productId, 5);
        }
        if (discountCode != null && !discountCode.equals("SAVE10")) {
            throw new InvalidDiscountCodeException(orderId, discountCode);
        }
        System.out.println("Order placed successfully: " + orderId);
    }
    
    public static void demonstrateEcommerceExceptions() {
        System.out.println("=== E-commerce Custom Exceptions ===");
        
        try {
            placeOrder("ORD001", "PROD001", 3, "SAVE10");
        } catch (OrderException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            placeOrder("ORD002", "PROD002", 10, null);
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Product: " + e.getProductId());
            System.out.println("Available: " + e.getAvailableQuantity());
        } catch (OrderException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            placeOrder("ORD003", "PROD003", 2, "INVALID");
        } catch (OrderException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Order ID: " + e.getOrderId());
        }
        
        System.out.println();
    }
}

// Example 8: Exception Hierarchy for Application
class ApplicationException extends Exception {
    private String errorCode;
    
    public ApplicationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}

class BusinessException extends ApplicationException {
    public BusinessException(String message, String errorCode) {
        super(message, errorCode);
    }
}

class DataAccessException extends ApplicationException {
    public DataAccessException(String message, String errorCode) {
        super(message, errorCode);
    }
}

class ApplicationExceptionHierarchy {
    public static void demonstrateApplicationHierarchy() {
        System.out.println("=== Application Exception Hierarchy ===");
        
        try {
            throw new BusinessException("Invalid business rule", "BUS001");
        } catch (ApplicationException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Code: " + e.getErrorCode());
        }
        
        try {
            throw new DataAccessException("Database connection failed", "DB001");
        } catch (ApplicationException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Code: " + e.getErrorCode());
        }
        
        System.out.println();
    }
}

// Example 9: File Processing Custom Exception
class FileProcessingException extends Exception {
    private String filename;
    private int lineNumber;
    
    public FileProcessingException(String filename, int lineNumber, String message) {
        super("Error in file '" + filename + "' at line " + lineNumber + ": " + message);
        this.filename = filename;
        this.lineNumber = lineNumber;
    }
    
    public String getFilename() {
        return filename;
    }
    
    public int getLineNumber() {
        return lineNumber;
    }
}

class FileProcessing {
    public static void processFile(String filename, int lineNumber, boolean hasError) 
            throws FileProcessingException {
        if (hasError) {
            throw new FileProcessingException(filename, lineNumber, "Invalid data format");
        }
        System.out.println("File processed successfully: " + filename);
    }
    
    public static void demonstrateFileProcessing() {
        System.out.println("=== File Processing Custom Exception ===");
        
        try {
            processFile("data.csv", 0, false);
        } catch (FileProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            processFile("data.csv", 42, true);
        } catch (FileProcessingException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("File: " + e.getFilename());
            System.out.println("Line: " + e.getLineNumber());
        }
        
        System.out.println();
    }
}

// Example 10: Wrapper Exception Pattern
class ServiceException extends RuntimeException {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

class WrapperPattern {
    public static void performDatabaseOperation() {
        try {
            // Simulate database error
            throw new java.sql.SQLException("Connection timeout");
        } catch (java.sql.SQLException e) {
            throw new ServiceException("Failed to save user data", e);
        }
    }
    
    public static void demonstrateWrapperPattern() {
        System.out.println("=== Wrapper Exception Pattern ===");
        
        try {
            performDatabaseOperation();
        } catch (ServiceException e) {
            System.out.println("Service Error: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
        
        System.out.println();
    }
}

// Example 11: Validation Exception with Multiple Errors
class MultiValidationException extends RuntimeException {
    private java.util.List<String> errors;
    
    public MultiValidationException(java.util.List<String> errors) {
        super("Validation failed with " + errors.size() + " error(s)");
        this.errors = errors;
    }
    
    public java.util.List<String> getErrors() {
        return errors;
    }
}

class MultiValidation {
    public static void validateForm(String name, String email, int age) {
        java.util.List<String> errors = new java.util.ArrayList<>();
        
        if (name == null || name.isEmpty()) {
            errors.add("Name is required");
        }
        if (email == null || !email.contains("@")) {
            errors.add("Invalid email format");
        }
        if (age < 18) {
            errors.add("Must be 18 or older");
        }
        
        if (!errors.isEmpty()) {
            throw new MultiValidationException(errors);
        }
        
        System.out.println("Form validation passed");
    }
    
    public static void demonstrateMultiValidation() {
        System.out.println("=== Multi-Validation Exception ===");
        
        try {
            validateForm("John", "john@example.com", 25);
        } catch (MultiValidationException e) {
            System.out.println("Errors: " + e.getErrors());
        }
        
        try {
            validateForm("", "invalid-email", 15);
        } catch (MultiValidationException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Details:");
            for (String error : e.getErrors()) {
                System.out.println("  - " + error);
            }
        }
        
        System.out.println();
    }
}

// Main class to run all examples
public class custom_exception_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     CUSTOM EXCEPTION EXAMPLES IN JAVA      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all demonstrations
        BasicCustomException.demonstrateBasicCustom();
        CustomUncheckedException.demonstrateUncheckedCustom();
        MultipleConstructors.demonstrateMultipleConstructors();
        AdditionalFields.demonstrateAdditionalFields();
        BankingSystem.demonstrateBankingExceptions();
        AuthenticationSystem.demonstrateAuthenticationExceptions();
        EcommerceSystem.demonstrateEcommerceExceptions();
        ApplicationExceptionHierarchy.demonstrateApplicationHierarchy();
        FileProcessing.demonstrateFileProcessing();
        WrapperPattern.demonstrateWrapperPattern();
        MultiValidation.demonstrateMultiValidation();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
