# Hierarchy of Exceptions in Java

## Introduction

Java's exception handling is built on a well-defined **class hierarchy**. Understanding this hierarchy is crucial for effective exception handling and writing robust code.

---

## Complete Exception Hierarchy

```
java.lang.Object
    │
    └── java.lang.Throwable
            │
            ├── java.lang.Error (Unchecked)
            │   ├── VirtualMachineError
            │   │   ├── StackOverflowError
            │   │   ├── OutOfMemoryError
            │   │   └── InternalError
            │   ├── AssertionError
            │   ├── LinkageError
            │   │   ├── NoClassDefFoundError
            │   │   └── ExceptionInInitializerError
            │   └── AWTError
            │
            └── java.lang.Exception
                    │
                    ├── IOException (Checked)
                    │   ├── FileNotFoundException
                    │   ├── EOFException
                    │   └── SocketException
                    │
                    ├── SQLException (Checked)
                    ├── ClassNotFoundException (Checked)
                    ├── InterruptedException (Checked)
                    ├── ReflectiveOperationException (Checked)
                    │   ├── ClassNotFoundException
                    │   ├── NoSuchMethodException
                    │   └── IllegalAccessException
                    │
                    └── RuntimeException (Unchecked)
                            ├── NullPointerException
                            ├── ArithmeticException
                            ├── ArrayIndexOutOfBoundsException
                            ├── ClassCastException
                            ├── IllegalArgumentException
                            │   └── NumberFormatException
                            ├── IllegalStateException
                            ├── UnsupportedOperationException
                            └── IndexOutOfBoundsException
                                ├── ArrayIndexOutOfBoundsException
                                └── StringIndexOutOfBoundsException
```

---

## Throwable Class

**Throwable** is the root class for all exceptions and errors in Java.

### Key Methods:
```java
String getMessage()           // Returns error message
String toString()             // Returns class name and message
void printStackTrace()        // Prints stack trace
StackTraceElement[] getStackTrace()  // Gets stack trace elements
Throwable getCause()          // Returns cause of exception
```

### Two Main Branches:
1. **Error**: Serious problems (should not catch)
2. **Exception**: Recoverable problems (should catch)

---

## Error Class

Represents **serious problems** that applications should not try to catch.

### Characteristics:
- **Unchecked**: Not checked at compile-time
- **Irrecoverable**: Cannot be handled
- **System-level**: JVM or environment issues
- **Extends**: Throwable

### Common Error Types:

#### 1. VirtualMachineError
JVM-related errors:
```java
// StackOverflowError
public void recursion() {
    recursion();  // Infinite recursion
}

// OutOfMemoryError
int[] huge = new int[Integer.MAX_VALUE];
```

#### 2. AssertionError
Assertion failures:
```java
assert false : "This should not happen";
```

#### 3. LinkageError
Class loading errors:
```java
// NoClassDefFoundError - Class was available at compile time but not runtime
// ExceptionInInitializerError - Static initializer failed
```

---

## Exception Class

Represents **conditions** that applications might want to catch.

### Two Categories:

#### 1. Checked Exceptions
- Must be declared or handled
- Checked at compile-time
- Extend Exception (but not RuntimeException)

#### 2. Unchecked Exceptions
- Not required to be declared or handled
- Checked at runtime
- Extend RuntimeException

---

## Checked Exceptions

Must be either caught or declared using `throws`.

### Common Checked Exceptions:

#### 1. IOException
Input/Output operations:
```java
try {
    FileReader fr = new FileReader("file.txt");
} catch (IOException e) {
    System.out.println("IO Error: " + e.getMessage());
}
```

**Subclasses:**
- `FileNotFoundException`: File not found
- `EOFException`: End of file reached unexpectedly
- `SocketException`: Socket operation failed

#### 2. SQLException
Database operations:
```java
try {
    Connection conn = DriverManager.getConnection(url);
} catch (SQLException e) {
    System.out.println("Database Error: " + e.getMessage());
}
```

#### 3. ClassNotFoundException
Class loading:
```java
try {
    Class.forName("com.example.MyClass");
} catch (ClassNotFoundException e) {
    System.out.println("Class not found: " + e.getMessage());
}
```

#### 4. InterruptedException
Thread interruption:
```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    System.out.println("Thread interrupted");
}
```

---

## Unchecked Exceptions (RuntimeException)

Do not need to be declared or caught (but can be).

### Common RuntimeException Types:

#### 1. NullPointerException
Accessing null reference:
```java
String str = null;
System.out.println(str.length());  // NullPointerException
```

#### 2. ArithmeticException
Arithmetic errors:
```java
int result = 10 / 0;  // ArithmeticException: / by zero
```

#### 3. ArrayIndexOutOfBoundsException
Invalid array index:
```java
int[] arr = {1, 2, 3};
System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException
```

#### 4. ClassCastException
Invalid type casting:
```java
Object obj = "Hello";
Integer num = (Integer) obj;  // ClassCastException
```

#### 5. IllegalArgumentException
Invalid method argument:
```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
}
```

**Subclass:**
- `NumberFormatException`: Invalid string to number conversion
```java
int num = Integer.parseInt("abc");  // NumberFormatException
```

#### 6. IllegalStateException
Invalid object state:
```java
public void withdraw(double amount) {
    if (!isActive) {
        throw new IllegalStateException("Account not active");
    }
}
```

#### 7. UnsupportedOperationException
Unsupported operation:
```java
List<String> list = Arrays.asList("A", "B");
list.add("C");  // UnsupportedOperationException
```

#### 8. IndexOutOfBoundsException
Invalid index (parent of ArrayIndexOutOfBoundsException):
```java
String str = "Hello";
char ch = str.charAt(10);  // StringIndexOutOfBoundsException
```

---

## Checked vs Unchecked Summary

| Aspect | Checked | Unchecked |
|--------|---------|-----------|
| **Extends** | Exception | RuntimeException or Error |
| **Compile-time** | Must handle/declare | Not required |
| **Purpose** | Recoverable conditions | Programming errors |
| **Examples** | IOException, SQLException | NullPointerException, ArithmeticException |
| **When to use** | External resources | Input validation |
| **Handling** | Required | Optional |

---

## Catching Exceptions by Hierarchy

### Specific to General:
```java
try {
    // Code
} catch (FileNotFoundException e) {
    // Most specific
    System.out.println("File not found");
} catch (IOException e) {
    // More general
    System.out.println("IO error");
} catch (Exception e) {
    // Most general
    System.out.println("Some error");
}
```

### Parent Catches Child:
```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (RuntimeException e) {
    // Catches ArrayIndexOutOfBoundsException
    // Because it extends RuntimeException
    System.out.println("Runtime error");
}
```

---

## Exception Hierarchy in Practice

### Example 1: Catching Parent
```java
try {
    String str = null;
    System.out.println(str.length());
} catch (RuntimeException e) {
    // Catches NullPointerException
    System.out.println("Runtime exception: " + e.getClass().getName());
}
```

**Output:**
```
Runtime exception: java.lang.NullPointerException
```

### Example 2: Multiple Levels
```java
try {
    int num = Integer.parseInt("abc");
} catch (NumberFormatException e) {
    // Most specific
    System.out.println("Number format error");
} catch (IllegalArgumentException e) {
    // Parent of NumberFormatException
    System.out.println("Illegal argument");
} catch (RuntimeException e) {
    // Grandparent
    System.out.println("Runtime exception");
}
```

First catch block executes because it's most specific.

---

## Creating Custom Exceptions

Custom exceptions fit into the hierarchy:

### Checked Custom Exception:
```java
// Extends Exception - Checked
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

Usage:
```java
public void setAge(int age) throws InvalidAgeException {
    if (age < 0) {
        throw new InvalidAgeException("Age cannot be negative");
    }
}
```

### Unchecked Custom Exception:
```java
// Extends RuntimeException - Unchecked
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

Usage:
```java
public void withdraw(double amount) {
    if (amount > balance) {
        throw new InsufficientFundsException("Insufficient funds");
    }
}
```

---

## Best Practices

### 1. Catch Specific Exceptions:
```java
// ❌ Bad - Too general
try {
    // code
} catch (Exception e) {
}

// ✅ Good - Specific
try {
    // code
} catch (FileNotFoundException e) {
    // Handle file not found
} catch (IOException e) {
    // Handle other IO errors
}
```

### 2. Order Matters:
```java
// ✅ Correct order - Specific to general
try {
    // code
} catch (FileNotFoundException e) {
    // Child first
} catch (IOException e) {
    // Parent second
}
```

### 3. Don't Catch Throwable:
```java
// ❌ Bad - Catches everything including Errors
try {
    // code
} catch (Throwable t) {
}

// ✅ Good - Catch Exception
try {
    // code
} catch (Exception e) {
}
```

### 4. Use Appropriate Level:
```java
// For checked exceptions - extend Exception
public class ConfigException extends Exception {
}

// For unchecked exceptions - extend RuntimeException
public class ValidationException extends RuntimeException {
}
```

---

## Common Exception Families

### IO Family:
```
IOException
├── FileNotFoundException
├── EOFException
├── SocketException
└── InterruptedIOException
```

### Reflection Family:
```
ReflectiveOperationException
├── ClassNotFoundException
├── NoSuchMethodException
├── NoSuchFieldException
└── IllegalAccessException
```

### Index Family:
```
IndexOutOfBoundsException
├── ArrayIndexOutOfBoundsException
└── StringIndexOutOfBoundsException
```

---

## Summary

- **Throwable** is the root of all exceptions and errors
- **Error** represents serious system problems (don't catch)
- **Exception** represents recoverable problems (should catch)
- **Checked exceptions** must be handled or declared
- **Unchecked exceptions** (RuntimeException) are optional to handle
- Exception hierarchy allows catching **parent to handle children**
- Always catch **specific exceptions** before general ones
- Custom exceptions extend **Exception** (checked) or **RuntimeException** (unchecked)
- Understanding hierarchy helps write **better exception handling** code
- Never catch **Throwable** or **Error** in application code
