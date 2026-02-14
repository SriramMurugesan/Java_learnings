# Default Exception Handler in Java

## Introduction

When an exception occurs in a Java program and is **not caught** by any try-catch block, the **Default Exception Handler** takes over. This is Java's built-in mechanism to handle uncaught exceptions.

---

## What is the Default Exception Handler?

The **Default Exception Handler** is a mechanism provided by the JVM that handles exceptions when:
- No try-catch block catches the exception
- The exception propagates all the way up the call stack
- No custom exception handler is defined

---

## How Does It Work?

### Step-by-Step Process:

1. **Exception is thrown**: An exception occurs in the code
2. **JVM searches for handler**: JVM looks for a matching catch block
3. **Propagation**: If no catch block is found, exception moves up the call stack
4. **Reaches main method**: Exception propagates to the main method
5. **Default handler activates**: If main doesn't catch it, default handler takes over
6. **Prints stack trace**: Default handler prints exception details
7. **Terminates program**: Program execution stops abnormally

---

## What Does the Default Handler Do?

### 1. Prints Exception Information
The default handler prints three key pieces of information:

```
Exception in thread "thread-name" ExceptionType: ExceptionMessage
    at ClassName.methodName(FileName.java:LineNumber)
    at ClassName.methodName(FileName.java:LineNumber)
    ...
```

### Components:
- **Thread name**: Which thread threw the exception (usually "main")
- **Exception type**: The class name of the exception
- **Exception message**: Descriptive message about what went wrong
- **Stack trace**: Sequence of method calls leading to the exception

### 2. Terminates the Program
After printing the stack trace, the program terminates abnormally with a non-zero exit code.

---

## Understanding Stack Trace

A **stack trace** shows the path of method calls that led to the exception, from the point where it occurred back to the main method.

### Example Stack Trace:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Example.divide(Example.java:10)
    at Example.calculate(Example.java:6)
    at Example.main(Example.java:3)
```

### Reading the Stack Trace:
1. **Bottom to Top**: Read from bottom (main) to top (where exception occurred)
2. **Line numbers**: Shows exact line where each method was called
3. **Method chain**: Shows the sequence of method calls

### What Each Line Means:
- `at Example.main(Example.java:3)` → main method called calculate at line 3
- `at Example.calculate(Example.java:6)` → calculate method called divide at line 6
- `at Example.divide(Example.java:10)` → divide method threw exception at line 10

---

## Example Scenarios

### Scenario 1: ArithmeticException
```java
public class Test {
    public static void main(String[] args) {
        int result = 10 / 0;  // Line 3
        System.out.println(result);
    }
}
```

**Output:**
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Test.main(Test.java:3)
```

**Explanation:**
- Exception occurred at line 3
- No try-catch block to handle it
- Default handler printed the stack trace
- Program terminated

---

### Scenario 2: NullPointerException
```java
public class Test {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());  // Line 4
    }
}
```

**Output:**
```
Exception in thread "main" java.lang.NullPointerException
    at Test.main(Test.java:4)
```

---

### Scenario 3: Multiple Method Calls
```java
public class Test {
    public static void main(String[] args) {
        methodA();  // Line 3
    }
    
    static void methodA() {
        methodB();  // Line 7
    }
    
    static void methodB() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]);  // Line 12
    }
}
```

**Output:**
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
    at Test.methodB(Test.java:12)
    at Test.methodA(Test.java:7)
    at Test.main(Test.java:3)
```

**Reading the trace:**
- main called methodA at line 3
- methodA called methodB at line 7
- methodB threw exception at line 12

---

## Program Termination Behavior

### Normal Termination:
```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println("End");
    }
}
```
**Output:**
```
Start
End
```
Program completes successfully.

---

### Abnormal Termination (Default Handler):
```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Start");
        int result = 10 / 0;
        System.out.println("End");  // This line never executes
    }
}
```
**Output:**
```
Start
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Test.main(Test.java:4)
```
Program terminates at the exception. "End" is never printed.

---

## Limitations of Default Handler

1. **Abrupt termination**: Program stops immediately
2. **No recovery**: Cannot continue execution
3. **Limited information**: Only prints stack trace, no custom messages
4. **Poor user experience**: Technical error messages shown to users
5. **No cleanup**: Resources may not be released properly
6. **No logging**: Errors not logged for debugging

---

## Why We Need Custom Exception Handling

The default handler is not suitable for production applications because:

1. **User-friendly messages**: Need to show meaningful messages to users
2. **Graceful degradation**: Continue execution when possible
3. **Resource cleanup**: Close files, database connections, etc.
4. **Logging**: Record errors for debugging and monitoring
5. **Alternative actions**: Provide fallback options
6. **Professional appearance**: Hide technical details from end users

---

## Overriding Default Behavior

### Using Try-Catch:
```java
public class Test {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
        System.out.println("Program continues...");
    }
}
```
**Output:**
```
Cannot divide by zero!
Program continues...
```
Program continues execution instead of terminating.

---

### Custom Uncaught Exception Handler:
```java
public class Test {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Custom handler caught: " + exception.getMessage());
        });
        
        int result = 10 / 0;
    }
}
```
**Output:**
```
Custom handler caught: / by zero
```

---

## Best Practices

1. **Don't rely on default handler**: Always handle exceptions explicitly
2. **Use try-catch blocks**: Handle exceptions where they can occur
3. **Provide meaningful messages**: Help users understand what went wrong
4. **Log exceptions**: Keep records for debugging
5. **Clean up resources**: Use finally or try-with-resources
6. **Fail gracefully**: Provide alternative actions when possible
7. **Test exception scenarios**: Ensure proper handling in all cases

---

## Summary

- The **Default Exception Handler** is JVM's last resort for uncaught exceptions
- It prints the **stack trace** showing where and how the exception occurred
- After printing, it **terminates the program** abnormally
- Stack traces are read **bottom-to-top** to understand the call sequence
- Default handler is **not suitable for production** code
- Always use **try-catch blocks** for proper exception handling
- Understanding the default handler helps in **debugging** and **writing better code**
