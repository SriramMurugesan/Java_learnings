# Day 5 - Exception Handling Interview Questions

## Basic Questions

### 1. What is an exception in Java?
**Answer**: An exception is an event that disrupts the normal flow of program execution. It's an object that represents an error or unexpected condition that occurs during runtime. Exceptions are instances of classes that extend `Throwable`.

---

### 2. What is the difference between Error and Exception?
**Answer**:
- **Error**: Represents serious problems that applications should not try to catch (e.g., `OutOfMemoryError`, `StackOverflowError`). Errors are irrecoverable and caused by system-level issues.
- **Exception**: Represents conditions that applications can catch and handle (e.g., `IOException`, `NullPointerException`). Exceptions are recoverable and caused by application logic.

---

### 3. What are checked and unchecked exceptions?
**Answer**:
- **Checked Exceptions**: Must be declared using `throws` or handled using `try-catch`. Checked at compile-time. Examples: `IOException`, `SQLException`.
- **Unchecked Exceptions**: Not required to be declared or handled. Extend `RuntimeException`. Checked at runtime. Examples: `NullPointerException`, `ArithmeticException`.

---

### 4. What is the exception hierarchy in Java?
**Answer**:
```
Throwable
├── Error (Unchecked)
│   ├── VirtualMachineError
│   └── AssertionError
└── Exception
    ├── IOException (Checked)
    ├── SQLException (Checked)
    └── RuntimeException (Unchecked)
        ├── NullPointerException
        ├── ArithmeticException
        └── ArrayIndexOutOfBoundsException
```

---

### 5. What is the difference between throw and throws?
**Answer**:
- **throw**: Keyword used to explicitly throw an exception. Used inside method body. Example: `throw new Exception("Error")`
- **throws**: Keyword used in method signature to declare that method might throw exceptions. Example: `public void method() throws IOException`

---

## Intermediate Questions

### 6. What is the purpose of the finally block?
**Answer**: The `finally` block always executes, whether an exception occurs or not. It's used for cleanup operations like closing files, database connections, or releasing resources. It executes even if there's a return statement in try or catch blocks.

---

### 7. Can we have try without catch?
**Answer**: Yes, we can have `try` without `catch` if we have a `finally` block. We can also use try-with-resources without catch. Examples:
```java
try {
    // code
} finally {
    // cleanup
}

try (Resource r = new Resource()) {
    // code
}
```

---

### 8. What is try-with-resources?
**Answer**: Try-with-resources (Java 7+) automatically closes resources that implement `AutoCloseable` interface. Resources are declared in parentheses after `try` keyword and are automatically closed when the try block exits, even if an exception occurs.

```java
try (FileReader fr = new FileReader("file.txt")) {
    // use resource
} // automatically closed
```

---

### 9. Can we have multiple catch blocks for a single try?
**Answer**: Yes, we can have multiple catch blocks. They must be ordered from most specific to most general exception types. Only one catch block executes - the first one that matches the exception type.

---

### 10. What is exception propagation?
**Answer**: Exception propagation is the process where an uncaught exception moves up the call stack from the method where it occurred to the calling method, and so on, until it's caught or reaches the main method. If not caught, the default exception handler handles it.

---

## Advanced Questions

### 11. What happens if an exception is thrown in the finally block?
**Answer**: If an exception is thrown in the finally block, it will override any exception thrown in the try or catch block. The original exception will be lost. This is why it's generally not recommended to throw exceptions from finally blocks.

---

### 12. Can we re-throw an exception?
**Answer**: Yes, we can re-throw an exception by using the `throw` keyword in a catch block. This is useful when you want to log the exception locally but still propagate it to the caller.

```java
try {
    // code
} catch (IOException e) {
    System.out.println("Logging error");
    throw e; // re-throw
}
```

---

### 13. What is exception chaining or wrapping?
**Answer**: Exception chaining is wrapping a low-level exception in a high-level exception while preserving the original exception as the cause. This provides better abstraction and context.

```java
try {
    // database operation
} catch (SQLException e) {
    throw new ServiceException("Failed to save data", e);
}
```

---

### 14. What is the difference between final, finally, and finalize?
**Answer**:
- **final**: Keyword for constants, preventing inheritance, and preventing method overriding
- **finally**: Block that always executes after try-catch for cleanup
- **finalize**: Method called by garbage collector before object is destroyed (deprecated in Java 9)

---

### 15. Can we catch multiple exceptions in one catch block?
**Answer**: Yes (Java 7+), using multi-catch with pipe `|` operator:
```java
try {
    // code
} catch (IOException | SQLException e) {
    // handle both
}
```
The exception types must not be related (no parent-child relationship).

---

### 16. What is a custom exception and when should we create one?
**Answer**: A custom exception is a user-defined exception class that extends `Exception` (checked) or `RuntimeException` (unchecked). Create custom exceptions when:
- Representing domain-specific errors
- Need additional fields or methods
- Want meaningful exception names
- Need to group related exceptions

---

### 17. What are the rules for exception handling in method overriding?
**Answer**:
- Overriding method can throw same exception, subclass exception, or no exception
- Overriding method CANNOT throw broader (parent) exception
- Overriding method CANNOT throw new checked exceptions not declared in parent
- Can throw any unchecked exception

---

### 18. What is the default exception handler?
**Answer**: The default exception handler is JVM's built-in mechanism that handles uncaught exceptions. It prints the exception type, message, and stack trace to the console, then terminates the program abnormally.

---

### 19. Can we have a try block without catch or finally?
**Answer**: No, a try block must be followed by either a catch block, a finally block, or both. However, try-with-resources can stand alone without catch or finally.

---

### 20. What is the purpose of printStackTrace()?
**Answer**: `printStackTrace()` prints the exception type, message, and the sequence of method calls (stack trace) that led to the exception. It's useful for debugging but should not be used in production code. Use proper logging instead.

---

## Scenario-Based Questions

### 21. What happens in this code?
```java
try {
    return 1;
} finally {
    return 2;
}
```
**Answer**: The method returns 2. The finally block executes before the return statement, and if finally has a return statement, it overrides the try block's return value. This is bad practice.

---

### 22. What is the output?
```java
try {
    System.out.println("Try");
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Catch");
} finally {
    System.out.println("Finally");
}
System.out.println("After");
```
**Answer**:
```
Try
Catch
Finally
After
```

---

### 23. Will this code compile?
```java
class Parent {
    void method() throws IOException { }
}
class Child extends Parent {
    void method() throws Exception { }
}
```
**Answer**: No, compilation error. Overriding method cannot throw broader checked exception than parent method.

---

### 24. What is wrong with this code?
```java
try {
    // code
} catch (Exception e) {
    // handle
} catch (IOException e) {
    // handle
}
```
**Answer**: Compilation error. `IOException` is a subclass of `Exception`, so it's unreachable. Specific exceptions must come before general ones.

---

### 25. Can we have nested try-catch blocks?
**Answer**: Yes, we can have nested try-catch blocks. Inner try-catch handles exceptions in inner scope, and outer try-catch handles exceptions in outer scope or exceptions not caught by inner catch.

---

## Best Practices Questions

### 26. What are exception handling best practices?
**Answer**:
1. Catch specific exceptions, not generic `Exception`
2. Never use empty catch blocks
3. Use try-with-resources for automatic resource management
4. Don't use exceptions for control flow
5. Provide meaningful error messages
6. Log exceptions properly
7. Clean up resources in finally block
8. Don't catch `Throwable` or `Error`
9. Create custom exceptions for domain-specific errors
10. Document exceptions in Javadoc

---

### 27. When should you use checked vs unchecked exceptions?
**Answer**:
- **Checked exceptions**: For recoverable conditions that caller should handle (file operations, network calls, database operations)
- **Unchecked exceptions**: For programming errors that indicate bugs (null pointers, invalid arguments, illegal state)

---

### 28. Why shouldn't we catch Throwable?
**Answer**: Catching `Throwable` catches both `Exception` and `Error`. Errors represent serious system problems that applications should not try to handle (e.g., `OutOfMemoryError`). Catching them prevents proper error handling and can mask critical issues.

---

### 29. What is the difference between System.exit() and exception?
**Answer**:
- **System.exit()**: Terminates JVM immediately, finally blocks don't execute
- **Exception**: Allows graceful handling, finally blocks execute, program can continue

---

### 30. How do you handle exceptions in a multi-threaded environment?
**Answer**: Each thread has its own call stack, so exceptions in one thread don't affect others. Use:
- Try-catch in thread's run method
- `Thread.UncaughtExceptionHandler` for uncaught exceptions
- `ExecutorService` with `Future.get()` to catch exceptions from submitted tasks
- Proper synchronization and exception handling in shared resources

---

## Tricky Questions

### 31. What is the output?
```java
public static int test() {
    try {
        return 1;
    } finally {
        return 2;
    }
}
```
**Answer**: Returns 2. Finally block's return overrides try block's return. This is bad practice and should be avoided.

---

### 32. Can finally block prevent exception from being thrown?
**Answer**: Yes, if finally block throws an exception or has a return statement, it will override the original exception, effectively preventing it from being thrown.

---

### 33. What is the difference between ClassNotFoundException and NoClassDefFoundError?
**Answer**:
- **ClassNotFoundException**: Checked exception thrown when trying to load a class using `Class.forName()` or `ClassLoader.loadClass()` and class is not found
- **NoClassDefFoundError**: Error thrown when class was available at compile time but not at runtime

---

### 34. Can we throw exception from static block?
**Answer**: We cannot throw checked exceptions from static blocks directly. We can only throw unchecked exceptions. For checked exceptions, we need to use try-catch within the static block.

---

### 35. What is suppressed exception?
**Answer**: In try-with-resources, if both the try block and the automatic resource closing throw exceptions, the exception from try block is thrown and the exception from closing is suppressed. Suppressed exceptions can be retrieved using `getSuppressed()` method.

---

## Summary

Key topics covered:
- Exception basics and hierarchy
- Checked vs unchecked exceptions
- Try-catch-finally blocks
- Throw vs throws
- Custom exceptions
- Exception propagation
- Best practices
- Advanced scenarios
