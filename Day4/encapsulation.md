# Encapsulation in Java

## 📚 What is Encapsulation?

**Encapsulation** is one of the four fundamental OOP concepts. It means **wrapping data (variables) and code (methods) together as a single unit** and **hiding the internal details** from the outside world.

Think of it like a **capsule** 💊 - the medicine is protected inside, and you can't directly access it!

### Real-World Analogy:
- **ATM Machine** 🏧: You can withdraw money using buttons (public methods), but you can't directly access the cash inside (private data)
- **TV Remote** 📺: You press buttons to change channels, but you don't need to know the internal circuitry

---

## 🎯 Why Use Encapsulation?

1. **Data Hiding** - Protects data from unauthorized access
2. **Control** - You control how data is accessed and modified
3. **Flexibility** - You can change internal implementation without affecting other code
4. **Security** - Prevents accidental data corruption
5. **Maintainability** - Easier to maintain and modify code

---

## 🔒 How to Achieve Encapsulation?

### Three Steps:

1. **Declare variables as `private`** - Hide data from outside access
2. **Provide `public` getter methods** - To read the data
3. **Provide `public` setter methods** - To modify the data

### Basic Example:
```java
class Student {
    // Step 1: Private variables (data hiding)
    private String name;
    private int age;
    
    // Step 2: Public getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Step 3: Public setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```

---

## 🔧 Generic Getters and Setters

**Generic getters and setters** are standard methods that simply return or set the value without any additional logic.

### Syntax Pattern:

```java
// Generic Getter
public DataType getVariableName() {
    return variableName;
}

// Generic Setter
public void setVariableName(DataType variableName) {
    this.variableName = variableName;
}
```

### Example:
```java
class BankAccount {
    private double balance;
    private String accountNumber;
    
    // Generic Getter - just returns the value
    public double getBalance() {
        return balance;
    }
    
    // Generic Setter - just sets the value
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Generic Getter
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Generic Setter
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
```

**Characteristics:**
- ✅ Simple and straightforward
- ✅ No validation or business logic
- ✅ Direct access to private variables
- ❌ No data protection or validation

---

## 🎨 Specific Getters and Setters

**Specific getters and setters** include additional logic like **validation, calculations, or business rules**.

### Example with Validation:
```java
class Employee {
    private String name;
    private int age;
    private double salary;
    
    // Specific Setter - with validation
    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Must be between 1 and 99.");
        }
    }
    
    // Specific Setter - with validation
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }
    
    // Specific Getter - with formatting
    public String getFormattedSalary() {
        return "$" + salary;
    }
    
    // Specific Getter - with calculation
    public double getAnnualSalary() {
        return salary * 12;
    }
}
```

### Benefits of Specific Getters/Setters:
- ✅ **Data Validation** - Ensures only valid data is stored
- ✅ **Business Logic** - Can apply rules before setting values
- ✅ **Calculated Values** - Can return computed values
- ✅ **Data Protection** - Prevents invalid states

---

## 🌑 The Shadowing Problem

**Shadowing** occurs when a **local variable** (parameter) has the **same name** as an **instance variable**, causing the local variable to "shadow" or hide the instance variable.

### Problem Example:
```java
class Person {
    private String name;
    private int age;
    
    // Shadowing problem!
    public void setName(String name) {
        name = name;  // ❌ This assigns parameter to itself!
        // The instance variable 'this.name' is NOT updated
    }
    
    public void setAge(int age) {
        age = age;  // ❌ Same problem!
    }
}
```

**What happens?**
- The parameter `name` shadows the instance variable `name`
- `name = name` assigns the parameter to itself
- The instance variable remains unchanged! 😱

---

## ✅ Solution: The `this` Keyword

The `this` keyword refers to the **current object** and helps distinguish between instance variables and parameters.

### Correct Implementation:
```java
class Person {
    private String name;
    private int age;
    
    // ✅ Using 'this' to resolve shadowing
    public void setName(String name) {
        this.name = name;  // this.name = instance variable
                          // name = parameter
    }
    
    public void setAge(int age) {
        this.age = age;  // Clear distinction!
    }
}
```

### How `this` Works:
```java
this.name = name;
//   ↑        ↑
//   |        |
//   |        └── Parameter (local variable)
//   └── Instance variable (belongs to object)
```

### Alternative Solution (Different Parameter Names):
```java
class Person {
    private String name;
    private int age;
    
    // Using different parameter names (no shadowing)
    public void setName(String n) {
        name = n;  // No 'this' needed, but less readable
    }
    
    public void setAge(int a) {
        age = a;
    }
}
```

**Best Practice:** Always use `this` keyword in setters for clarity! ✅

---

## 🏗️ Constructors in Java

A **constructor** is a special method used to **initialize objects**. It is called automatically when an object is created using the `new` keyword.

### Key Characteristics:
1. **Same name as class** - Constructor name must match class name exactly
2. **No return type** - Not even `void`
3. **Called automatically** - When object is created with `new`
4. **Used for initialization** - Sets initial values for object properties

---

## 🔹 Types of Constructors

### 1️⃣ Default Constructor (No Parameters)

A constructor with **no parameters**. If you don't create any constructor, Java provides one automatically.

```java
class Student {
    private String name;
    private int age;
    
    // Default Constructor
    public Student() {
        name = "Unknown";
        age = 0;
        System.out.println("Student object created!");
    }
}

// Usage:
Student s1 = new Student();  // Calls default constructor
```

**Java's Automatic Default Constructor:**
```java
class Student {
    private String name;
    private int age;
    
    // If you write NO constructor, Java adds this automatically:
    // public Student() { }
}
```

⚠️ **Important:** If you create ANY constructor (even parameterized), Java will NOT provide the default constructor automatically!

---

### 2️⃣ Parameterized Constructor

A constructor that **accepts parameters** to initialize object with specific values.

```java
class Student {
    private String name;
    private int age;
    
    // Parameterized Constructor
    public Student(String name, int age) {
        this.name = name;  // Using 'this' to avoid shadowing
        this.age = age;
    }
}

// Usage:
Student s1 = new Student("John", 20);  // Creates student with name and age
```

**Benefits:**
- ✅ Initialize objects with custom values immediately
- ✅ Ensures objects are created in a valid state
- ✅ More convenient than using setters

---

### 3️⃣ Constructor Overloading

Having **multiple constructors** with different parameters in the same class.

```java
class Student {
    private String name;
    private int age;
    private String course;
    
    // Constructor 1: No parameters
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.course = "Not Assigned";
    }
    
    // Constructor 2: Name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.course = "Not Assigned";
    }
    
    // Constructor 3: All parameters
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

// Usage:
Student s1 = new Student();                      // Calls constructor 1
Student s2 = new Student("Alice", 22);           // Calls constructor 2
Student s3 = new Student("Bob", 23, "Java");     // Calls constructor 3
```

**Rules for Constructor Overloading:**
- Different number of parameters, OR
- Different types of parameters, OR
- Different order of parameters

---

## 🔄 Constructor Chaining with `this()`

You can call one constructor from another using `this()` to avoid code duplication.

```java
class Student {
    private String name;
    private int age;
    private String course;
    
    // Constructor 1
    public Student() {
        this("Unknown", 0, "Not Assigned");  // Calls Constructor 3
    }
    
    // Constructor 2
    public Student(String name, int age) {
        this(name, age, "Not Assigned");  // Calls Constructor 3
    }
    
    // Constructor 3 - Main constructor with all logic
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

**Rules for `this()`:**
- ✅ Must be the **first statement** in constructor
- ✅ Can only call **one** other constructor
- ❌ Cannot have circular calls (Constructor A calls B, B calls A)

---

## 📊 Comparison Table

| Feature | Generic Getters/Setters | Specific Getters/Setters |
|---------|------------------------|--------------------------|
| **Validation** | No | Yes |
| **Business Logic** | No | Yes |
| **Complexity** | Simple | Can be complex |
| **Use Case** | Simple data access | Data protection, calculations |
| **Example** | `return name;` | `if (age > 0) this.age = age;` |

| Feature | Default Constructor | Parameterized Constructor |
|---------|---------------------|---------------------------|
| **Parameters** | None | One or more |
| **Purpose** | Default initialization | Custom initialization |
| **Auto-provided** | Yes (if no constructors exist) | No |
| **Example** | `public Student() { }` | `public Student(String name) { }` |

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Always use private variables
private String name;
private int age;

// 2. Use 'this' keyword in setters
public void setName(String name) {
    this.name = name;
}

// 3. Add validation in specific setters
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    }
}

// 4. Use constructor overloading for flexibility
public Student() { }
public Student(String name) { }
public Student(String name, int age) { }
```

### ❌ DON'T:
```java
// 1. Don't make variables public
public String name;  // Bad!

// 2. Don't forget 'this' in setters
public void setName(String name) {
    name = name;  // Wrong!
}

// 3. Don't skip validation
public void setAge(int age) {
    this.age = age;  // No validation!
}
```

---

## 🎯 Summary

1. **Encapsulation** = Data hiding + Controlled access through getters/setters
2. **Generic Getters/Setters** = Simple access without validation
3. **Specific Getters/Setters** = Include validation and business logic
4. **Shadowing Problem** = Local variable hides instance variable (solved with `this`)
5. **Constructors** = Special methods to initialize objects
6. **Constructor Types** = Default (no params) and Parameterized (with params)
7. **Constructor Overloading** = Multiple constructors with different parameters
8. **`this` keyword** = Refers to current object, resolves shadowing

---

**Remember:** Encapsulation is the foundation of secure and maintainable code! 🔒
