# Exception Handling using Throws Declaration

## Introduction

The **throws** keyword is used in method signatures to declare that a method might throw one or more exceptions. It's a way to **delegate exception handling** to the calling method.

---

## Syntax

```java
returnType methodName(parameters) throws ExceptionType1, ExceptionType2 {
    // Method body
}
```

### Components:
- **throws**: Keyword used in method signature
- **ExceptionType**: One or more exception classes separated by commas
- **Declaration**: Tells the caller that this method might throw these exceptions

---

## Why Use Throws?

1. **Delegate responsibility**: Let the caller handle the exception
2. **Checked exceptions**: Required for checked exceptions not handled in the method
3. **Method contract**: Clearly states what exceptions can occur
4. **Flexibility**: Caller decides how to handle the exception
5. **Cleaner code**: Avoid nested try-catch blocks

---

## Checked vs Unchecked Exceptions

### Checked Exceptions (Must Declare):
```java
// Must use throws or try-catch
public void readFile() throws IOException {
    FileReader fr = new FileReader("file.txt");
}
```

### Unchecked Exceptions (Optional):
```java
// No need to declare, but you can
public void divide(int a, int b) throws ArithmeticException {
    return a / b;
}

// Or simply
public void divide(int a, int b) {
    return a / b;  // No throws needed
}
```

---

## Basic Example

### Method with Throws:
```java
public class FileHandler {
    // Method declares it might throw IOException
    public void readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        // Read file operations
        fr.close();
    }
}
```

### Calling Method Must Handle:
```java
public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        
        // Option 1: Handle with try-catch
        try {
            handler.readFile("data.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
```

---

## Multiple Exceptions

Declare multiple exception types separated by commas:

```java
public void processData(String filename) 
        throws IOException, SQLException, ParseException {
    // Method might throw any of these exceptions
    FileReader fr = new FileReader(filename);
    Connection conn = DriverManager.getConnection(url);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdf.parse("invalid-date");
}
```

### Calling Method:
```java
try {
    processData("data.txt");
} catch (IOException e) {
    System.out.println("File error");
} catch (SQLException e) {
    System.out.println("Database error");
} catch (ParseException e) {
    System.out.println("Date parsing error");
}
```

---

## Exception Propagation

When a method declares throws, the exception propagates up the call stack:

```java
public class Example {
    // Method 3: Throws exception
    public void methodC() throws IOException {
        throw new IOException("Error in methodC");
    }
    
    // Method 2: Propagates exception
    public void methodB() throws IOException {
        methodC();  // Exception propagates from methodC
    }
    
    // Method 1: Propagates exception
    public void methodA() throws IOException {
        methodB();  // Exception propagates from methodB
    }
    
    // Main: Finally handles exception
    public static void main(String[] args) {
        Example ex = new Example();
        try {
            ex.methodA();
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

**Flow:**
```
methodC throws → methodB propagates → methodA propagates → main catches
```

---

## Two Options When Method Throws

When calling a method that declares throws, you have two options:

### Option 1: Handle with Try-Catch
```java
public void caller() {
    try {
        methodThatThrows();
    } catch (IOException e) {
        System.out.println("Handled here");
    }
}
```

### Option 2: Propagate Further
```java
public void caller() throws IOException {
    methodThatThrows();  // Propagate to caller's caller
}
```

---

## Throws with Method Overriding

### Rules for Overriding:

1. **Overriding method can throw**:
   - Same exception
   - Subclass of declared exception
   - No exception

2. **Overriding method CANNOT throw**:
   - Broader exception (parent class)
   - New checked exception

### Examples:

#### ✅ Valid Overriding:
```java
class Parent {
    public void method() throws IOException {
        // code
    }
}

class Child extends Parent {
    // Same exception
    @Override
    public void method() throws IOException {
        // code
    }
}
```

```java
class Child extends Parent {
    // Subclass exception
    @Override
    public void method() throws FileNotFoundException {
        // FileNotFoundException is subclass of IOException
    }
}
```

```java
class Child extends Parent {
    // No exception
    @Override
    public void method() {
        // No throws clause
    }
}
```

#### ❌ Invalid Overriding:
```java
class Child extends Parent {
    // Broader exception - COMPILATION ERROR
    @Override
    public void method() throws Exception {
        // Exception is parent of IOException
    }
}
```

```java
class Child extends Parent {
    // New checked exception - COMPILATION ERROR
    @Override
    public void method() throws SQLException {
        // SQLException not related to IOException
    }
}
```

---

## Throws in Constructors

Constructors can also declare throws:

```java
public class DatabaseConnection {
    private Connection conn;
    
    // Constructor throws exception
    public DatabaseConnection(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }
}
```

### Using Constructor:
```java
try {
    DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost");
} catch (SQLException e) {
    System.out.println("Connection failed: " + e.getMessage());
}
```

---

## Throws vs Try-Catch

### When to Use Throws:

1. **Method can't handle**: Method doesn't have enough context to handle
2. **Caller should decide**: Let caller choose how to handle
3. **Utility methods**: Generic methods used in different contexts
4. **Propagation needed**: Exception should bubble up

### When to Use Try-Catch:

1. **Can handle locally**: Method has enough context to handle
2. **Resource cleanup**: Need to close resources
3. **Recovery possible**: Can provide alternative action
4. **User interaction**: Need to show user-friendly message

### Example Comparison:

#### Using Throws:
```java
public int readAge(String filename) throws IOException {
    FileReader fr = new FileReader(filename);
    // Read and return age
    return age;
}
```
Caller decides how to handle file errors.

#### Using Try-Catch:
```java
public int readAge(String filename) {
    try {
        FileReader fr = new FileReader(filename);
        // Read and return age
        return age;
    } catch (IOException e) {
        System.out.println("Using default age");
        return 18;  // Default value
    }
}
```
Method handles error and provides default value.

---

## Common Patterns

### Pattern 1: Service Layer
```java
public class UserService {
    // Service method throws to controller
    public User getUser(int id) throws SQLException {
        return database.findUser(id);
    }
}

public class UserController {
    // Controller handles and shows user message
    public void displayUser(int id) {
        try {
            User user = userService.getUser(id);
            System.out.println(user);
        } catch (SQLException e) {
            System.out.println("Error loading user");
        }
    }
}
```

### Pattern 2: Utility Methods
```java
public class FileUtils {
    // Utility throws, caller handles
    public static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
```

---

## Best Practices

### 1. Be Specific:
```java
// ❌ Bad - Too generic
public void method() throws Exception {
}

// ✅ Good - Specific exceptions
public void method() throws IOException, SQLException {
}
```

### 2. Don't Overuse:
```java
// ❌ Bad - Declaring unnecessary exceptions
public int add(int a, int b) throws Exception {
    return a + b;
}

// ✅ Good - No throws needed
public int add(int a, int b) {
    return a + b;
}
```

### 3. Document Exceptions:
```java
/**
 * Reads user data from file
 * @param filename the file to read
 * @return User object
 * @throws IOException if file cannot be read
 * @throws ParseException if data format is invalid
 */
public User readUser(String filename) 
        throws IOException, ParseException {
    // code
}
```

### 4. Handle at Appropriate Level:
```java
// Low-level method throws
public void readData() throws IOException {
    // File operations
}

// Mid-level method propagates
public void processData() throws IOException {
    readData();
}

// High-level method handles
public void handleRequest() {
    try {
        processData();
    } catch (IOException e) {
        // Handle with user-friendly message
    }
}
```

---

## Common Mistakes

1. **Throwing Exception**: Too broad, be specific
2. **Not documenting**: Always document what exceptions mean
3. **Catching and rethrowing**: If you can't handle, just use throws
4. **Ignoring in override**: Remember overriding rules
5. **Overusing**: Don't declare throws for unchecked exceptions unnecessarily

---

## Summary

- **throws** keyword declares that a method might throw exceptions
- Used in **method signature** to delegate exception handling
- **Required** for checked exceptions not handled in the method
- **Optional** for unchecked exceptions
- Allows **exception propagation** up the call stack
- Caller must either **handle** (try-catch) or **propagate** (throws)
- Overriding methods have **specific rules** about throws declarations
- Use throws when method **can't or shouldn't** handle the exception
- Always be **specific** about exception types
- **Document** what each exception means
