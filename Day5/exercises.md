# Day 5 - Exception Handling Exercises

## Exercise 1: Basic Try-Catch
**Task**: Write a program that takes two numbers as input and divides them. Handle the `ArithmeticException` if division by zero occurs.

**Expected Output**:
```
Enter first number: 10
Enter second number: 0
Error: Cannot divide by zero
```

---

## Exercise 2: Multiple Catch Blocks
**Task**: Create a program that:
1. Takes a string input from user
2. Converts it to an integer
3. Accesses an array using that integer as index

Handle both `NumberFormatException` and `ArrayIndexOutOfBoundsException`.

---

## Exercise 3: Finally Block
**Task**: Write a program that opens a resource (simulate with a message), performs an operation that may throw an exception, and ensures the resource is closed in the finally block.

---

## Exercise 4: Custom Exception - Age Validator
**Task**: Create a custom exception `InvalidAgeException` and a class `Person` with a method `setAge(int age)` that:
- Throws `InvalidAgeException` if age < 0 or age > 150
- Otherwise sets the age

---

## Exercise 5: Bank Account with Custom Exceptions
**Task**: Create a `BankAccount` class with:
- `balance` field
- `deposit(double amount)` method
- `withdraw(double amount)` method

Create custom exceptions:
- `InsufficientFundsException` - when withdrawal amount > balance
- `InvalidAmountException` - when amount <= 0

---

## Exercise 6: Exception Propagation
**Task**: Create three methods:
- `methodA()` calls `methodB()`
- `methodB()` calls `methodC()`
- `methodC()` throws an `IOException`

Use `throws` to propagate the exception from `methodC` to `main`, where it should be caught and handled.

---

## Exercise 7: Try-With-Resources
**Task**: Create a custom class that implements `AutoCloseable` and demonstrates try-with-resources. The class should print messages when opened and closed.

---

## Exercise 8: Nested Try-Catch
**Task**: Write a program with nested try-catch blocks:
- Outer try-catch handles `NullPointerException`
- Inner try-catch handles `ArithmeticException`

Demonstrate both exceptions occurring.

---

## Exercise 9: Custom Exception with Additional Fields
**Task**: Create a custom exception `TemperatureException` with:
- `temperature` field
- `unit` field (Celsius/Fahrenheit)
- Constructor that takes both values
- Getter methods

Use it in a method that validates temperature ranges.

---

## Exercise 10: File Processing Exception Handler
**Task**: Create a program that:
1. Reads a filename from user
2. Attempts to open the file
3. Handles `FileNotFoundException`
4. Handles `IOException`
5. Uses finally to close resources

---

## Exercise 11: Multi-Catch
**Task**: Write a program that demonstrates multi-catch (Java 7+) by catching both `IOException` and `SQLException` in a single catch block.

---

## Exercise 12: Exception Chaining
**Task**: Create a method that:
1. Catches a `NumberFormatException`
2. Wraps it in a custom `DataProcessingException`
3. Throws the custom exception with the original as the cause

---

## Exercise 13: Validation Framework
**Task**: Create a `Validator` class with methods:
- `validateEmail(String email)` - throws `InvalidEmailException`
- `validatePhone(String phone)` - throws `InvalidPhoneException`
- `validateAge(int age)` - throws `InvalidAgeException`

Create a `User` class that uses these validators.

---

## Exercise 14: Exception Hierarchy
**Task**: Create a custom exception hierarchy:
```
ApplicationException
├── ValidationException
│   ├── InvalidInputException
│   └── MissingFieldException
└── ProcessingException
    ├── DatabaseException
    └── NetworkException
```

Demonstrate catching at different levels.

---

## Exercise 15: Re-throwing Exceptions
**Task**: Create a method that:
1. Catches an exception
2. Logs it (print to console)
3. Re-throws the same exception

Demonstrate this in a complete program.

---

## Exercise 16: Array Operations with Exception Handling
**Task**: Write a program that:
1. Creates an array of integers
2. Takes index input from user
3. Handles `ArrayIndexOutOfBoundsException`
4. Allows user to try again until valid index is entered

---

## Exercise 17: Calculator with Exception Handling
**Task**: Create a `Calculator` class with methods:
- `add(int a, int b)`
- `subtract(int a, int b)`
- `multiply(int a, int b)`
- `divide(int a, int b)` - throws custom `DivisionByZeroException`

---

## Exercise 18: Login System
**Task**: Create a login system with custom exceptions:
- `InvalidCredentialsException`
- `AccountLockedException`
- `SessionExpiredException`

Implement a `login(username, password)` method that throws appropriate exceptions.

---

## Exercise 19: Shopping Cart
**Task**: Create a shopping cart system with:
- `OutOfStockException` - includes product ID and available quantity
- `InvalidQuantityException` - for negative quantities
- `CartEmptyException` - when trying to checkout empty cart

---

## Exercise 20: Exception Best Practices
**Task**: Review the following code and fix all exception handling issues:

```java
public void processData(String data) {
    try {
        int value = Integer.parseInt(data);
        int result = 100 / value;
        System.out.println(result);
    } catch (Exception e) {
        // Empty catch block
    }
}
```

**Issues to fix**:
1. Too broad exception catching
2. Empty catch block
3. No meaningful error message
4. No resource cleanup

---

## Bonus Exercises

### Bonus 1: Custom Exception Builder
**Task**: Create a custom exception that uses the Builder pattern to construct detailed error messages with multiple fields.

### Bonus 2: Exception Logging Framework
**Task**: Create a simple exception logging framework that:
- Logs all exceptions to a file
- Includes timestamp, exception type, and stack trace
- Provides different log levels (ERROR, WARNING, INFO)

### Bonus 3: Retry Mechanism
**Task**: Implement a retry mechanism that:
- Attempts an operation up to 3 times
- Catches exceptions and retries
- Throws exception after 3 failed attempts

---

## Challenge Exercises

### Challenge 1: Exception Translator
**Task**: Create an exception translator that converts low-level exceptions (SQLException, IOException) to high-level business exceptions with meaningful messages.

### Challenge 2: Validation Chain
**Task**: Implement a validation chain where multiple validators can be chained together, and all validation errors are collected before throwing a single exception with all errors.

### Challenge 3: Circuit Breaker Pattern
**Task**: Implement a simple circuit breaker pattern that:
- Tracks failures
- Opens circuit after threshold
- Throws `CircuitOpenException` when open
- Allows retry after timeout

---

## Solutions Checklist

When completing these exercises, ensure:
- [ ] Exceptions are caught at appropriate levels
- [ ] Meaningful error messages are provided
- [ ] Resources are properly cleaned up
- [ ] Custom exceptions extend appropriate parent classes
- [ ] Exception hierarchy is logical
- [ ] Code follows best practices
- [ ] All edge cases are handled
- [ ] Code is well-documented
