# Abstraction in Java

## 📚 What is Abstraction?

**Abstraction** is the process of **hiding implementation details** and showing only the **essential features** to the user.

Think of it as using a **TV remote** 📺 - you press buttons to change channels, but you don't need to know how the remote sends signals to the TV!

### Real-World Analogy:
- **Car** 🚗: You use steering wheel, pedals, gear - you don't need to know how the engine works internally
- **ATM** 🏧: You withdraw money using a card - you don't see the complex banking operations
- **Coffee Machine** ☕: You press a button to get coffee - you don't see the brewing process

---

## 🎯 Why Use Abstraction?

1. **Simplicity** - Hide complex details, show only what's necessary
2. **Security** - Sensitive implementation details are hidden
3. **Maintainability** - Changes in implementation don't affect users
4. **Reduce Complexity** - Users work with simple interfaces
5. **Focus on "What" not "How"** - What it does, not how it does it

---

## 🔑 Abstraction vs Encapsulation

| Feature | Abstraction | Encapsulation |
|---------|-------------|---------------|
| **Purpose** | Hide complexity | Hide data |
| **Focus** | Design level | Implementation level |
| **Achieved by** | Abstract classes, Interfaces | Private variables, getters/setters |
| **Example** | `Animal` class (what animals do) | `private int age` with `getAge()` |
| **Level** | What to do | How to do |

**Simple Difference:**
- **Abstraction** = Hiding **how** it works
- **Encapsulation** = Hiding **data** and providing controlled access

---

## 🎨 How to Achieve Abstraction in Java?

Two ways:
1. **Abstract Classes** (0% to 100% abstraction)
2. **Interfaces** (100% abstraction - covered in next section)

---

## 🏗️ Abstract Classes

An **abstract class** is a class that **cannot be instantiated** (you cannot create objects of it) and may contain **abstract methods** (methods without implementation).

### Syntax:
```java
abstract class ClassName {
    // Abstract method (no body)
    abstract void methodName();
    
    // Concrete method (with body)
    void concreteMethod() {
        // Implementation
    }
}
```

---

## 📝 Abstract Methods

An **abstract method** is a method that is **declared without implementation** (no body). It must be overridden in the child class.

### Syntax:
```java
abstract returnType methodName();
```

### Example:
```java
abstract class Animal {
    // Abstract method (no implementation)
    abstract void sound();
    
    // Concrete method (with implementation)
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {
    // Must override abstract method
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    // Must override abstract method
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Usage:
// Animal a = new Animal();  // ❌ Error! Cannot instantiate abstract class
Animal a1 = new Dog();  // ✅ OK
Animal a2 = new Cat();  // ✅ OK

a1.sound();  // Dog barks
a2.sound();  // Cat meows
a1.sleep();  // Animal is sleeping (inherited concrete method)
```

---

## 📜 Rules for Abstract Classes

### 1️⃣ **Cannot Create Objects of Abstract Class**

```java
abstract class Animal {
    abstract void sound();
}

// ❌ This will give compilation error
Animal a = new Animal();  // Error: Cannot instantiate abstract class
```

---

### 2️⃣ **Can Have Abstract and Concrete Methods**

```java
abstract class Vehicle {
    // Abstract method
    abstract void start();
    
    // Concrete method
    void stop() {
        System.out.println("Vehicle stopped");
    }
}
```

---

### 3️⃣ **Child Class Must Override All Abstract Methods**

```java
abstract class Shape {
    abstract void draw();
    abstract double area();
}

class Circle extends Shape {
    double radius;
    
    // Must override all abstract methods
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
    
    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}
```

**Exception:** If child class doesn't override all abstract methods, it must also be declared `abstract`.

```java
abstract class Shape {
    abstract void draw();
    abstract double area();
}

// Child is also abstract (doesn't override all methods)
abstract class Polygon extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing polygon");
    }
    // area() is not overridden, so Polygon must be abstract
}
```

---

### 4️⃣ **Can Have Constructors**

```java
abstract class Animal {
    String name;
    
    // Constructor in abstract class
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }
    
    abstract void sound();
}

class Dog extends Animal {
    Dog(String name) {
        super(name);  // Call parent constructor
    }
    
    @Override
    void sound() {
        System.out.println(name + " barks");
    }
}

// Usage:
Dog d = new Dog("Buddy");
// Output: Animal constructor called
```

---

### 5️⃣ **Can Have Instance Variables**

```java
abstract class Employee {
    String name;
    int id;
    
    abstract double calculateSalary();
}
```

---

### 6️⃣ **Can Have Static Methods**

```java
abstract class MathOperations {
    // Static method in abstract class
    static int add(int a, int b) {
        return a + b;
    }
    
    abstract int multiply(int a, int b);
}

// Usage:
int result = MathOperations.add(5, 10);  // ✅ OK
```

---

### 7️⃣ **Can Have Final Methods**

```java
abstract class Animal {
    // Final method (cannot be overridden)
    final void breathe() {
        System.out.println("Animal is breathing");
    }
    
    abstract void sound();
}
```

---

## 🎨 Real-World Example: Banking System

```java
abstract class Account {
    String accountNumber;
    String holderName;
    double balance;
    
    // Constructor
    Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    // Abstract method - each account type calculates interest differently
    abstract void calculateInterest();
    
    // Concrete method - common for all accounts
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.04;  // 4% interest
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        System.out.println("No interest for current account");
    }
}

// Usage:
Account acc1 = new SavingsAccount("SA001", "John", 10000);
Account acc2 = new CurrentAccount("CA001", "Alice", 5000);

acc1.deposit(2000);
acc1.calculateInterest();  // 4% interest
acc1.displayBalance();

acc2.deposit(1000);
acc2.calculateInterest();  // No interest
acc2.displayBalance();
```

---

## 🎨 Real-World Example: Shape Hierarchy

```java
abstract class Shape {
    String color;
    
    // Constructor
    Shape(String color) {
        this.color = color;
    }
    
    // Abstract methods - each shape calculates differently
    abstract double area();
    abstract double perimeter();
    
    // Concrete method - common for all shapes
    void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double area() {
        return 3.14 * radius * radius;
    }
    
    @Override
    double perimeter() {
        return 2 * 3.14 * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    
    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    double area() {
        return length * width;
    }
    
    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Usage:
Shape s1 = new Circle("Red", 5);
Shape s2 = new Rectangle("Blue", 10, 5);

System.out.println("Circle Area: " + s1.area());
System.out.println("Circle Perimeter: " + s1.perimeter());
s1.displayColor();

System.out.println("Rectangle Area: " + s2.area());
System.out.println("Rectangle Perimeter: " + s2.perimeter());
s2.displayColor();
```

---

## 🤔 When to Use Abstract Classes?

Use abstract classes when:

1. **Partial Implementation** - You want to provide some common implementation
2. **Code Reusability** - Share code among related classes
3. **Template Method Pattern** - Define skeleton, let subclasses fill details
4. **IS-A Relationship** - When child classes have a clear "is-a" relationship with parent

### Example Scenarios:
- `Animal` → `Dog`, `Cat`, `Bird` (all are animals)
- `Vehicle` → `Car`, `Bike`, `Truck` (all are vehicles)
- `Shape` → `Circle`, `Rectangle`, `Triangle` (all are shapes)
- `Employee` → `Manager`, `Developer`, `Designer` (all are employees)

---

## 🚫 When NOT to Use Abstract Classes?

Don't use abstract classes when:

1. **No Common Implementation** - Use interfaces instead
2. **Multiple Inheritance Needed** - Java doesn't support multiple inheritance with classes
3. **100% Abstraction** - Use interfaces for complete abstraction
4. **No State Required** - If you don't need instance variables, use interfaces

---

## 📊 Abstract Class vs Concrete Class

| Feature | Abstract Class | Concrete Class |
|---------|----------------|----------------|
| **Instantiation** | ❌ Cannot create objects | ✅ Can create objects |
| **Abstract Methods** | ✅ Can have | ❌ Cannot have |
| **Concrete Methods** | ✅ Can have | ✅ Can have |
| **Keyword** | `abstract` | No keyword |
| **Purpose** | Provide template | Provide complete implementation |
| **Example** | `abstract class Animal` | `class Dog` |

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Use abstract classes for partial abstraction
abstract class Vehicle {
    abstract void start();
    void stop() { }  // Common implementation
}

// 2. Use meaningful names for abstract classes
abstract class Shape { }  // Good
abstract class S { }      // Bad

// 3. Override all abstract methods in child class
class Circle extends Shape {
    @Override
    double area() { return 0; }
}

// 4. Use abstract classes for IS-A relationships
class Dog extends Animal { }  // Dog IS-A Animal
```

### ❌ DON'T:
```java
// 1. Don't try to instantiate abstract class
Animal a = new Animal();  // ❌ Error!

// 2. Don't declare abstract methods as private
abstract private void method();  // ❌ Error!

// 3. Don't declare abstract methods as final
abstract final void method();  // ❌ Error!

// 4. Don't declare abstract methods as static
abstract static void method();  // ❌ Error!
```

---

## 🎯 Summary

1. **Abstraction** = Hiding implementation details, showing only essential features
2. **Abstract Class** = Class that cannot be instantiated, may have abstract methods
3. **Abstract Method** = Method without implementation (no body)
4. **Rules:**
   - Cannot create objects of abstract class
   - Can have abstract and concrete methods
   - Child must override all abstract methods
   - Can have constructors, variables, static/final methods
5. **Use When:** Partial implementation, code reusability, IS-A relationship
6. **Keywords:** `abstract` for class and methods
7. **Difference from Interfaces:** Abstract classes can have concrete methods and state

---

**Remember:** Abstraction focuses on WHAT an object does, not HOW it does it! 🎯
