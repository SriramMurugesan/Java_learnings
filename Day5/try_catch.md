# Exception Handling using Try and Catch

## Introduction

**Try-catch** is the fundamental mechanism in Java for handling exceptions. It allows you to write code that can recover from errors gracefully instead of crashing.

---

## Basic Syntax

```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

### Components:
- **try block**: Contains code that might throw an exception
- **catch block**: Contains code to handle the exception
- **Exception parameter**: Variable that holds the exception object

---

## How Try-Catch Works

### Execution Flow:

1. **Normal execution**: Code in try block executes line by line
2. **Exception occurs**: If an exception is thrown, execution stops immediately
3. **Jump to catch**: Control transfers to the matching catch block
4. **Handle exception**: Code in catch block executes
5. **Continue**: Program continues after the try-catch block

### Example:
```java
try {
    System.out.println("Before exception");
    int result = 10 / 0;  // Exception occurs here
    System.out.println("After exception");  // This line is skipped
} catch (ArithmeticException e) {
    System.out.println("Caught: " + e.getMessage());
}
System.out.println("Program continues");
```

**Output:**
```
Before exception
Caught: / by zero
Program continues
```

---

## Single Catch Block

Handle one specific type of exception:

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid array index!");
}
```

---

## Multiple Catch Blocks

Handle different types of exceptions differently:

```java
try {
    String str = null;
    System.out.println(str.length());
} catch (NullPointerException e) {
    System.out.println("Null reference error!");
} catch (ArithmeticException e) {
    System.out.println("Math error!");
} catch (Exception e) {
    System.out.println("Some other error!");
}
```

### Important Rules:

1. **Order matters**: Catch blocks are checked from top to bottom
2. **Specific to general**: More specific exceptions must come before general ones
3. **Only one executes**: Only the first matching catch block runs
4. **Parent-child**: Child exception must be caught before parent

---

## Catch Block Order Rules

### ❌ Wrong Order (Compilation Error):
```java
try {
    int result = 10 / 0;
} catch (Exception e) {          // Parent class
    System.out.println("General exception");
} catch (ArithmeticException e) {  // Child class - UNREACHABLE!
    System.out.println("Arithmetic exception");
}
```
**Error:** `exception ArithmeticException has already been caught`

### ✅ Correct Order:
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {  // Child class first
    System.out.println("Arithmetic exception");
} catch (Exception e) {            // Parent class last
    System.out.println("General exception");
}
```

---

## Multi-Catch (Java 7+)

Catch multiple exception types in a single catch block:

```java
try {
    // Some code
} catch (IOException | SQLException e) {
    System.out.println("IO or SQL error: " + e.getMessage());
}
```

### Rules for Multi-Catch:
- Use pipe `|` to separate exception types
- Exception types cannot be related (no parent-child)
- Exception parameter is implicitly final

---

## Finally Block

The **finally block** always executes, whether an exception occurs or not.

### Syntax:
```java
try {
    // Code that might throw exception
} catch (Exception e) {
    // Handle exception
} finally {
    // Always executes
}
```

### When Finally Executes:

1. **No exception**: try → finally
2. **Exception caught**: try → catch → finally
3. **Exception not caught**: try → finally → propagate exception
4. **Return in try/catch**: finally executes before return

### Example:
```java
try {
    System.out.println("Try block");
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Catch block");
} finally {
    System.out.println("Finally block");
}
```

**Output:**
```
Try block
Catch block
Finally block
```

---

## Common Use Cases for Finally

### 1. Resource Cleanup:
```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Read file
} catch (IOException e) {
    System.out.println("Error reading file");
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
```

### 2. Database Connection:
```java
Connection conn = null;
try {
    conn = DriverManager.getConnection(url);
    // Database operations
} catch (SQLException e) {
    System.out.println("Database error");
} finally {
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection");
        }
    }
}
```

---

## Try-With-Resources (Java 7+)

Automatically closes resources that implement `AutoCloseable`:

### Syntax:
```java
try (ResourceType resource = new ResourceType()) {
    // Use resource
} catch (Exception e) {
    // Handle exception
}
// Resource automatically closed
```

### Example:
```java
try (FileReader reader = new FileReader("file.txt");
     BufferedReader br = new BufferedReader(reader)) {
    String line = br.readLine();
    System.out.println(line);
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// reader and br automatically closed
```

### Advantages:
- **Automatic cleanup**: No need for finally block
- **Cleaner code**: Less boilerplate
- **Safe**: Resources closed even if exception occurs
- **Multiple resources**: Can declare multiple resources

---

## Nested Try-Catch

Try-catch blocks can be nested:

```java
try {
    System.out.println("Outer try");
    try {
        System.out.println("Inner try");
        int result = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner catch");
    }
    String str = null;
    System.out.println(str.length());
} catch (NullPointerException e) {
    System.out.println("Outer catch");
}
```

**Output:**
```
Outer try
Inner try
Inner catch
Outer catch
```

---

## Getting Exception Information

### Methods Available on Exception Object:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Get exception message
    System.out.println("Message: " + e.getMessage());
    
    // Get exception class name
    System.out.println("Type: " + e.getClass().getName());
    
    // Print stack trace
    e.printStackTrace();
    
    // Get string representation
    System.out.println("ToString: " + e.toString());
}
```

**Output:**
```
Message: / by zero
Type: java.lang.ArithmeticException
java.lang.ArithmeticException: / by zero
    at Example.main(Example.java:3)
ToString: java.lang.ArithmeticException: / by zero
```

---

## Best Practices

### 1. Catch Specific Exceptions:
```java
// ❌ Bad
try {
    // code
} catch (Exception e) {
    // Too generic
}

// ✅ Good
try {
    // code
} catch (FileNotFoundException e) {
    // Specific handling
} catch (IOException e) {
    // Different specific handling
}
```

### 2. Don't Catch and Ignore:
```java
// ❌ Bad
try {
    // code
} catch (Exception e) {
    // Empty catch - swallows exception
}

// ✅ Good
try {
    // code
} catch (Exception e) {
    e.printStackTrace();
    // Or log the exception
}
```

### 3. Don't Use Exceptions for Control Flow:
```java
// ❌ Bad
try {
    int i = 0;
    while (true) {
        System.out.println(arr[i++]);
    }
} catch (ArrayIndexOutOfBoundsException e) {
    // Using exception to exit loop
}

// ✅ Good
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### 4. Provide Meaningful Messages:
```java
// ✅ Good
try {
    // code
} catch (IOException e) {
    System.out.println("Failed to read configuration file: " + e.getMessage());
    // Provide context and actionable information
}
```

### 5. Use Try-With-Resources:
```java
// ✅ Good - Automatic resource management
try (FileReader fr = new FileReader("file.txt")) {
    // Use resource
} catch (IOException e) {
    // Handle exception
}
```

---

## Common Mistakes

1. **Empty catch blocks**: Never ignore exceptions silently
2. **Catching Exception**: Too broad, catch specific types
3. **Wrong order**: Specific exceptions must come before general ones
4. **Not closing resources**: Use finally or try-with-resources
5. **Overusing try-catch**: Don't wrap every line, group related code
6. **Catching Throwable**: Never catch Error or Throwable

---

## Summary

- **Try-catch** is the primary mechanism for exception handling in Java
- **Try block** contains code that might throw exceptions
- **Catch block** handles specific exception types
- **Multiple catch blocks** handle different exceptions differently
- **Order matters**: Catch specific exceptions before general ones
- **Finally block** always executes, used for cleanup
- **Try-with-resources** automatically manages resource cleanup
- Always provide **meaningful error messages** and **log exceptions**
- Never use **empty catch blocks** or catch exceptions you can't handle
