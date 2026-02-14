# Error vs Exception in Java

## Introduction

In Java, both **Error** and **Exception** are subclasses of the `Throwable` class, but they serve different purposes and are handled differently.

---

## What is an Error?

An **Error** represents serious problems that a reasonable application **should not try to catch**. Errors are typically caused by the environment in which the application is running.

### Characteristics of Errors:
- **Unchecked**: Errors are not checked at compile-time
- **Irrecoverable**: Usually cannot be handled by the program
- **System-level**: Caused by system failures or resource exhaustion
- **Not caught**: Should not be caught in normal application code

### Common Types of Errors:

1. **StackOverflowError**: Occurs when the call stack exceeds its limit (usually due to infinite recursion)
2. **OutOfMemoryError**: Occurs when JVM runs out of memory
3. **VirtualMachineError**: Indicates JVM is broken or has run out of resources
4. **AssertionError**: Thrown when an assertion fails

### Example Scenarios:
```java
// StackOverflowError - Infinite recursion
public void infiniteRecursion() {
    infiniteRecursion(); // No base case
}

// OutOfMemoryError - Creating too many objects
int[] largeArray = new int[Integer.MAX_VALUE];
```

---

## What is an Exception?

An **Exception** represents conditions that a reasonable application **might want to catch**. Exceptions are problems that can be anticipated and handled in the code.

### Characteristics of Exceptions:
- **Can be checked or unchecked**: Some are checked at compile-time
- **Recoverable**: Can be handled using try-catch blocks
- **Application-level**: Caused by programming logic or user input
- **Should be caught**: Good practice to handle exceptions

### Types of Exceptions:

#### 1. Checked Exceptions (Compile-time Exceptions)
- Must be declared in method signature using `throws` or handled using `try-catch`
- Checked by compiler at compile-time
- Examples: `IOException`, `SQLException`, `FileNotFoundException`

#### 2. Unchecked Exceptions (Runtime Exceptions)
- Not checked at compile-time
- Subclasses of `RuntimeException`
- Examples: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

### Common Exceptions:

1. **ArithmeticException**: Division by zero
2. **NullPointerException**: Using null reference
3. **ArrayIndexOutOfBoundsException**: Invalid array index
4. **NumberFormatException**: Invalid string to number conversion
5. **ClassCastException**: Invalid type casting
6. **FileNotFoundException**: File not found
7. **IOException**: Input/Output operation failed

---

## Key Differences: Error vs Exception

| Aspect | Error | Exception |
|--------|-------|-----------|
| **Recovery** | Irrecoverable | Recoverable |
| **Type** | Always unchecked | Can be checked or unchecked |
| **Cause** | System/Environment issues | Programming logic/User input |
| **Handling** | Should NOT be caught | Should be caught and handled |
| **Package** | `java.lang.Error` | `java.lang.Exception` |
| **Examples** | OutOfMemoryError, StackOverflowError | IOException, NullPointerException |
| **Prevention** | Fix system resources | Write defensive code |

---

## Hierarchy

```
Throwable
├── Error (Unchecked)
│   ├── VirtualMachineError
│   │   ├── StackOverflowError
│   │   └── OutOfMemoryError
│   ├── AssertionError
│   └── LinkageError
│
└── Exception
    ├── IOException (Checked)
    ├── SQLException (Checked)
    ├── ClassNotFoundException (Checked)
    └── RuntimeException (Unchecked)
        ├── NullPointerException
        ├── ArithmeticException
        ├── ArrayIndexOutOfBoundsException
        └── NumberFormatException
```

---

## When to Use What?

### Errors:
- **Don't catch**: Let the application terminate
- **Fix the root cause**: Increase memory, fix infinite recursion
- **Example**: If OutOfMemoryError occurs, increase heap size

### Exceptions:
- **Catch and handle**: Use try-catch blocks
- **Validate input**: Prevent exceptions before they occur
- **Log and recover**: Handle gracefully and continue execution
- **Example**: If FileNotFoundException occurs, prompt user for correct file

---

## Best Practices

1. **Never catch Error**: Don't use `catch(Error e)` or `catch(Throwable t)`
2. **Handle specific exceptions**: Catch specific exception types, not generic `Exception`
3. **Use checked exceptions for recoverable conditions**: File operations, network calls
4. **Use unchecked exceptions for programming errors**: Null checks, invalid arguments
5. **Don't ignore exceptions**: Always log or handle them appropriately
6. **Clean up resources**: Use finally block or try-with-resources

---

## Summary

- **Errors** are serious system-level problems that should not be caught
- **Exceptions** are application-level problems that can and should be handled
- Understanding the difference helps write robust and maintainable code
- Always handle exceptions appropriately and let errors terminate the program
