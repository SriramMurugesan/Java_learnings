# Custom Exception Handling in Java

## Introduction

**Custom exceptions** are user-defined exception classes that extend existing exception classes. They allow you to create domain-specific exceptions that make your code more readable and maintainable.

---

## Why Create Custom Exceptions?

1. **Domain-specific**: Represent business logic errors
2. **Meaningful names**: Make code self-documenting
3. **Additional information**: Include custom fields and methods
4. **Better organization**: Group related exceptions
5. **Clearer intent**: Show what went wrong in business terms
6. **Easier debugging**: Specific exception types for specific problems

---

## Creating Custom Exceptions

### Basic Syntax:

#### Checked Exception:
```java
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```

#### Unchecked Exception:
```java
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
```

---

## Choosing Parent Class

### Extend Exception (Checked):
- **When**: Recoverable conditions
- **Examples**: File operations, network calls, configuration errors
- **Requirement**: Must be declared or handled

```java
public class ConfigurationException extends Exception {
    public ConfigurationException(String message) {
        super(message);
    }
}
```

### Extend RuntimeException (Unchecked):
- **When**: Programming errors, validation failures
- **Examples**: Invalid input, illegal state, business rule violations
- **Requirement**: Optional to declare or handle

```java
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
```

---

## Basic Custom Exception

### Simple Custom Exception:
```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

### Using It:
```java
public class Person {
    private int age;
    
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        this.age = age;
    }
}
```

### Handling:
```java
try {
    Person person = new Person();
    person.setAge(-5);
} catch (InvalidAgeException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## Custom Exception with Multiple Constructors

```java
public class InsufficientFundsException extends Exception {
    // Constructor with message
    public InsufficientFundsException(String message) {
        super(message);
    }
    
    // Constructor with message and cause
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    // Constructor with cause only
    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }
    
    // Default constructor
    public InsufficientFundsException() {
        super("Insufficient funds in account");
    }
}
```

### Usage:
```java
// With message
throw new InsufficientFundsException("Balance: $50, Required: $100");

// With cause
throw new InsufficientFundsException("Withdrawal failed", originalException);

// Default message
throw new InsufficientFundsException();
```

---

## Custom Exception with Additional Fields

```java
public class InsufficientFundsException extends Exception {
    private double balance;
    private double requestedAmount;
    
    public InsufficientFundsException(double balance, double requestedAmount) {
        super("Insufficient funds. Balance: " + balance + 
              ", Requested: " + requestedAmount);
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
```

### Using Additional Fields:
```java
try {
    account.withdraw(1000);
} catch (InsufficientFundsException e) {
    System.out.println("Error: " + e.getMessage());
    System.out.println("You are short by: $" + e.getShortfall());
}
```

---

## Real-World Examples

### Example 1: Banking System
```java
// Custom exception for banking operations
public class BankingException extends Exception {
    private String accountNumber;
    private String transactionId;
    
    public BankingException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Specific banking exceptions
public class InsufficientFundsException extends BankingException {
    public InsufficientFundsException(String accountNumber, double balance) {
        super("Insufficient funds. Balance: " + balance, accountNumber);
    }
}

public class AccountNotFoundException extends BankingException {
    public AccountNotFoundException(String accountNumber) {
        super("Account not found", accountNumber);
    }
}

public class AccountFrozenException extends BankingException {
    public AccountFrozenException(String accountNumber) {
        super("Account is frozen", accountNumber);
    }
}
```

### Usage:
```java
public void withdraw(String accountNumber, double amount) 
        throws BankingException {
    Account account = findAccount(accountNumber);
    
    if (account == null) {
        throw new AccountNotFoundException(accountNumber);
    }
    if (account.isFrozen()) {
        throw new AccountFrozenException(accountNumber);
    }
    if (account.getBalance() < amount) {
        throw new InsufficientFundsException(accountNumber, account.getBalance());
    }
    
    account.debit(amount);
}
```

---

### Example 2: User Authentication
```java
public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

public class InvalidCredentialsException extends AuthenticationException {
    public InvalidCredentialsException() {
        super("Invalid username or password");
    }
}

public class AccountLockedException extends AuthenticationException {
    private int lockDurationMinutes;
    
    public AccountLockedException(int minutes) {
        super("Account locked for " + minutes + " minutes");
        this.lockDurationMinutes = minutes;
    }
    
    public int getLockDurationMinutes() {
        return lockDurationMinutes;
    }
}

public class SessionExpiredException extends AuthenticationException {
    public SessionExpiredException() {
        super("Session has expired. Please login again.");
    }
}
```

---

### Example 3: E-commerce System
```java
public class OrderException extends RuntimeException {
    private String orderId;
    
    public OrderException(String message, String orderId) {
        super(message);
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return orderId;
    }
}

public class OutOfStockException extends OrderException {
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

public class InvalidDiscountCodeException extends OrderException {
    public InvalidDiscountCodeException(String orderId, String code) {
        super("Invalid discount code: " + code, orderId);
    }
}
```

---

## Exception Hierarchy for Applications

```java
// Base application exception
public class ApplicationException extends Exception {
    private String errorCode;
    
    public ApplicationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}

// Business logic exceptions
public class BusinessException extends ApplicationException {
    public BusinessException(String message, String errorCode) {
        super(message, errorCode);
    }
}

// Data access exceptions
public class DataAccessException extends ApplicationException {
    public DataAccessException(String message, String errorCode) {
        super(message, errorCode);
    }
}

// Validation exceptions
public class ValidationException extends ApplicationException {
    public ValidationException(String message, String errorCode) {
        super(message, errorCode);
    }
}
```

---

## Best Practices

### 1. Meaningful Names:
```java
// ❌ Bad
public class MyException extends Exception { }

// ✅ Good
public class InvalidEmailFormatException extends Exception { }
```

### 2. Provide Multiple Constructors:
```java
public class CustomException extends Exception {
    public CustomException() {
        super();
    }
    
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CustomException(Throwable cause) {
        super(cause);
    }
}
```

### 3. Include Relevant Information:
```java
// ✅ Good - Includes context
public class FileProcessingException extends Exception {
    private String filename;
    private int lineNumber;
    
    public FileProcessingException(String filename, int lineNumber, String message) {
        super("Error in file " + filename + " at line " + lineNumber + ": " + message);
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
```

### 4. Document Exceptions:
```java
/**
 * Thrown when user age validation fails
 * 
 * @author Your Name
 * @version 1.0
 */
public class InvalidAgeException extends Exception {
    /**
     * Creates exception with age details
     * @param age the invalid age value
     */
    public InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Age must be between 0 and 150.");
    }
}
```

### 5. Use Appropriate Parent:
```java
// Checked - for recoverable conditions
public class ConfigurationException extends Exception { }

// Unchecked - for programming errors
public class ValidationException extends RuntimeException { }
```

### 6. Group Related Exceptions:
```java
// Base exception for all database operations
public class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

// Specific database exceptions
public class ConnectionFailedException extends DatabaseException {
    public ConnectionFailedException() {
        super("Failed to connect to database");
    }
}

public class QueryExecutionException extends DatabaseException {
    public QueryExecutionException(String query) {
        super("Failed to execute query: " + query);
    }
}
```

---

## Common Patterns

### Pattern 1: Wrapper Exception
```java
public class ServiceException extends RuntimeException {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Usage
try {
    // Database operation
} catch (SQLException e) {
    throw new ServiceException("Failed to save user", e);
}
```

### Pattern 2: Error Codes
```java
public class ApplicationException extends Exception {
    private ErrorCode errorCode;
    
    public ApplicationException(ErrorCode code, String message) {
        super(message);
        this.errorCode = code;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

enum ErrorCode {
    INVALID_INPUT,
    DATABASE_ERROR,
    NETWORK_ERROR,
    AUTHENTICATION_FAILED
}
```

### Pattern 3: Builder Pattern
```java
public class ValidationException extends RuntimeException {
    private List<String> errors;
    
    private ValidationException(Builder builder) {
        super(builder.message);
        this.errors = builder.errors;
    }
    
    public List<String> getErrors() {
        return errors;
    }
    
    public static class Builder {
        private String message;
        private List<String> errors = new ArrayList<>();
        
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        
        public Builder addError(String error) {
            errors.add(error);
            return this;
        }
        
        public ValidationException build() {
            return new ValidationException(this);
        }
    }
}

// Usage
throw new ValidationException.Builder()
    .message("Validation failed")
    .addError("Invalid email")
    .addError("Password too short")
    .build();
```

---

## Common Mistakes

1. **Too many custom exceptions**: Create only when needed
2. **Generic names**: Use descriptive, domain-specific names
3. **No constructors**: Always provide multiple constructors
4. **Losing cause**: Always preserve the original exception
5. **Wrong parent**: Choose Exception vs RuntimeException carefully
6. **No documentation**: Document when and why exception is thrown

---

## Summary

- **Custom exceptions** make code more readable and maintainable
- Extend **Exception** for checked, **RuntimeException** for unchecked
- Provide **multiple constructors** for flexibility
- Include **additional fields** for context
- Use **meaningful names** that reflect business domain
- **Document** when and why exceptions are thrown
- Group **related exceptions** under a common parent
- Always **preserve the cause** when wrapping exceptions
- Don't create custom exceptions for **every error condition**
- Use custom exceptions to represent **domain-specific problems**
