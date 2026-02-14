# Exception Handling using Throw Keyword

## Introduction

The **throw** keyword is used to **explicitly throw an exception** in Java. While `throws` declares exceptions, `throw` actually creates and throws the exception object.

---

## Syntax

```java
throw new ExceptionType("Error message");
```

### Components:
- **throw**: Keyword to throw an exception
- **new**: Creates a new exception object
- **ExceptionType**: The exception class to throw
- **Error message**: Optional descriptive message

---

## Throw vs Throws

| Aspect | throw | throws |
|--------|-------|--------|
| **Purpose** | Throw an exception | Declare exceptions |
| **Location** | Inside method body | In method signature |
| **Usage** | `throw new Exception()` | `throws Exception` |
| **Quantity** | One exception at a time | Multiple exceptions |
| **Type** | Keyword | Keyword |
| **Action** | Creates and throws | Declares possibility |

---

## Basic Example

```java
public class AgeValidator {
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Age is valid");
    }
}
```

### Using the Method:
```java
public static void main(String[] args) {
    AgeValidator validator = new AgeValidator();
    try {
        validator.validateAge(15);
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
```

**Output:**
```
Error: Age must be 18 or above
```

---

## When to Use Throw

1. **Input validation**: Check method parameters
2. **Business rules**: Enforce business logic
3. **Preconditions**: Verify conditions before processing
4. **Error conditions**: Signal that something went wrong
5. **Re-throwing**: Catch and re-throw with more context

---

## Throwing Checked Exceptions

When throwing checked exceptions, the method must declare `throws`:

```java
public void readFile(String filename) throws IOException {
    if (filename == null) {
        throw new IOException("Filename cannot be null");
    }
    // Read file
}
```

### Must Handle:
```java
try {
    readFile(null);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

---

## Throwing Unchecked Exceptions

Unchecked exceptions don't require `throws` declaration:

```java
public void divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    System.out.println(a / b);
}
```

### Can Handle or Ignore:
```java
// Option 1: Handle
try {
    divide(10, 0);
} catch (ArithmeticException e) {
    System.out.println(e.getMessage());
}

// Option 2: Let it propagate
divide(10, 0);  // Will crash if exception occurs
```

---

## Common Exceptions to Throw

### 1. IllegalArgumentException
For invalid method arguments:
```java
public void setAge(int age) {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException("Invalid age: " + age);
    }
    this.age = age;
}
```

### 2. NullPointerException
For null values when not allowed:
```java
public void setName(String name) {
    if (name == null) {
        throw new NullPointerException("Name cannot be null");
    }
    this.name = name;
}
```

### 3. IllegalStateException
For invalid object state:
```java
public void withdraw(double amount) {
    if (!isActive) {
        throw new IllegalStateException("Account is not active");
    }
    balance -= amount;
}
```

### 4. UnsupportedOperationException
For unsupported operations:
```java
public void delete() {
    throw new UnsupportedOperationException("Delete not supported");
}
```

---

## Re-throwing Exceptions

Catch an exception, add context, and re-throw:

### Example 1: Re-throw Same Exception
```java
public void processFile(String filename) throws IOException {
    try {
        FileReader fr = new FileReader(filename);
        // Process file
    } catch (IOException e) {
        System.out.println("Logging error...");
        throw e;  // Re-throw the same exception
    }
}
```

### Example 2: Wrap in Different Exception
```java
public void loadConfig(String filename) throws ConfigException {
    try {
        FileReader fr = new FileReader(filename);
        // Load config
    } catch (IOException e) {
        throw new ConfigException("Failed to load config", e);
    }
}
```

### Example 3: Add Context
```java
public void processData(String data) throws DataException {
    try {
        // Process data
        int value = Integer.parseInt(data);
    } catch (NumberFormatException e) {
        throw new DataException("Invalid data: " + data, e);
    }
}
```

---

## Throw in Different Scenarios

### Scenario 1: Validation
```java
public class User {
    private String email;
    
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
}
```

### Scenario 2: Business Logic
```java
public class BankAccount {
    private double balance;
    
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient balance: " + balance
            );
        }
        balance -= amount;
    }
}
```

### Scenario 3: State Checking
```java
public class Connection {
    private boolean connected;
    
    public void sendData(String data) {
        if (!connected) {
            throw new IllegalStateException("Not connected");
        }
        // Send data
    }
}
```

### Scenario 4: Precondition Checking
```java
public void processArray(int[] arr) {
    if (arr == null) {
        throw new NullPointerException("Array cannot be null");
    }
    if (arr.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty");
    }
    // Process array
}
```

---

## Throw with Finally

Finally block executes even when exception is thrown:

```java
public void method() {
    try {
        System.out.println("Try block");
        throw new RuntimeException("Error");
    } finally {
        System.out.println("Finally block");
    }
}
```

**Output:**
```
Try block
Finally block
Exception in thread "main" java.lang.RuntimeException: Error
```

---

## Multiple Throw Statements

A method can have multiple throw statements:

```java
public void validateUser(String username, String password) {
    if (username == null) {
        throw new NullPointerException("Username cannot be null");
    }
    if (username.length() < 3) {
        throw new IllegalArgumentException("Username too short");
    }
    if (password == null) {
        throw new NullPointerException("Password cannot be null");
    }
    if (password.length() < 8) {
        throw new IllegalArgumentException("Password too short");
    }
    // Validation passed
}
```

---

## Throw in Conditional Statements

### If-Else:
```java
public String getGrade(int marks) {
    if (marks < 0 || marks > 100) {
        throw new IllegalArgumentException("Invalid marks: " + marks);
    }
    if (marks >= 90) return "A";
    if (marks >= 80) return "B";
    if (marks >= 70) return "C";
    return "F";
}
```

### Switch:
```java
public void processCommand(String command) {
    switch (command) {
        case "START":
            start();
            break;
        case "STOP":
            stop();
            break;
        default:
            throw new IllegalArgumentException("Unknown command: " + command);
    }
}
```

### Ternary Operator:
```java
public void setAge(int age) {
    this.age = age >= 0 ? age : 
        throw new IllegalArgumentException("Age cannot be negative");
    // Note: This syntax is valid in Java 14+
}
```

---

## Creating Exception Objects

### With Message:
```java
throw new Exception("Error message");
```

### With Cause:
```java
try {
    // code
} catch (IOException e) {
    throw new RuntimeException("Wrapper exception", e);
}
```

### With Message and Cause:
```java
throw new CustomException("Error occurred", originalException);
```

### Without Message:
```java
throw new NullPointerException();
```

---

## Best Practices

### 1. Provide Meaningful Messages:
```java
// ❌ Bad
throw new Exception("Error");

// ✅ Good
throw new IllegalArgumentException(
    "Age must be between 0 and 150, got: " + age
);
```

### 2. Use Appropriate Exception Types:
```java
// ❌ Bad - Too generic
throw new Exception("Invalid input");

// ✅ Good - Specific
throw new IllegalArgumentException("Invalid input");
```

### 3. Don't Throw in Finally:
```java
// ❌ Bad - Masks original exception
try {
    // code
} finally {
    throw new Exception();  // Don't do this
}

// ✅ Good
try {
    // code
} finally {
    // Cleanup only
}
```

### 4. Validate Early:
```java
// ✅ Good - Fail fast
public void process(String data) {
    if (data == null) {
        throw new NullPointerException("Data cannot be null");
    }
    // Continue processing
}
```

### 5. Include Context:
```java
// ✅ Good - Helpful context
throw new FileNotFoundException(
    "Config file not found: " + filename + 
    " in directory: " + directory
);
```

---

## Common Patterns

### Pattern 1: Guard Clauses
```java
public void processOrder(Order order) {
    if (order == null) {
        throw new NullPointerException("Order cannot be null");
    }
    if (order.getItems().isEmpty()) {
        throw new IllegalArgumentException("Order has no items");
    }
    if (order.getTotal() <= 0) {
        throw new IllegalArgumentException("Invalid order total");
    }
    // Process order
}
```

### Pattern 2: Factory Methods
```java
public static User createUser(String name, int age) {
    if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Name required");
    }
    if (age < 18) {
        throw new IllegalArgumentException("Must be 18+");
    }
    return new User(name, age);
}
```

### Pattern 3: Builder Pattern
```java
public class UserBuilder {
    private String name;
    
    public User build() {
        if (name == null) {
            throw new IllegalStateException("Name not set");
        }
        return new User(name);
    }
}
```

---

## Common Mistakes

1. **Throwing in finally**: Masks original exceptions
2. **Generic exceptions**: Use specific exception types
3. **No message**: Always provide descriptive messages
4. **Swallowing exceptions**: Don't catch and throw generic exception
5. **Throwing Error**: Never throw Error or its subclasses

---

## Summary

- **throw** keyword explicitly throws an exception
- Used to **create and throw** exception objects
- Different from **throws** which declares exceptions
- Can throw **checked** (needs throws declaration) or **unchecked** exceptions
- Common use cases: **validation**, **business rules**, **preconditions**
- Can **re-throw** exceptions with additional context
- Always provide **meaningful error messages**
- Use **appropriate exception types** for the situation
- **Validate early** and fail fast
- Never throw exceptions in **finally** blocks
