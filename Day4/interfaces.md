# Interfaces in Java

## 📚 What is an Interface?

An **interface** is a **blueprint** of a class that contains only **abstract methods** and **constants**. It defines **what a class must do**, but not **how it does it**.

Think of it as a **contract** 📄 - any class that implements the interface must follow the contract and provide implementation for all methods!

### Real-World Analogy:
- **Electrical Socket** 🔌: Defines a standard interface - any device with matching plug can use it
- **USB Port** 💾: Standard interface - any USB device can connect
- **Remote Control Interface** 📺: Different brands implement the same buttons differently

---

## 🎯 Why Use Interfaces?

1. **100% Abstraction** - Complete abstraction (before Java 8)
2. **Multiple Inheritance** - A class can implement multiple interfaces
3. **Loose Coupling** - Reduces dependencies between classes
4. **Polymorphism** - Treat different classes uniformly
5. **Contract Enforcement** - Ensures classes implement required methods

---

## 📝 Basic Syntax

```java
interface InterfaceName {
    // Abstract methods (public abstract by default)
    void method1();
    int method2();
    
    // Constants (public static final by default)
    int CONSTANT = 100;
}

// Implementing the interface
class ClassName implements InterfaceName {
    @Override
    public void method1() {
        // Implementation
    }
    
    @Override
    public int method2() {
        // Implementation
        return 0;
    }
}
```

---

## 🎨 Simple Example

```java
interface Animal {
    // Abstract method (no body)
    void sound();
    void eat();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    
    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
    
    @Override
    public void eat() {
        System.out.println("Cat eats fish");
    }
}

// Usage:
Animal a1 = new Dog();
Animal a2 = new Cat();

a1.sound();  // Dog barks
a2.sound();  // Cat meows
```

---

## 📜 Rules for Interfaces

### 1️⃣ **All Methods are Public and Abstract by Default**

```java
interface MyInterface {
    // These are equivalent:
    void method1();
    public abstract void method1();
}
```

---

### 2️⃣ **All Variables are Public, Static, and Final by Default**

```java
interface Constants {
    // These are equivalent:
    int MAX_VALUE = 100;
    public static final int MAX_VALUE = 100;
}

// Usage:
System.out.println(Constants.MAX_VALUE);  // 100
```

---

### 3️⃣ **Cannot Have Constructors**

```java
interface MyInterface {
    // ❌ This is NOT allowed
    MyInterface() { }  // Compilation Error!
}
```

---

### 4️⃣ **Cannot Be Instantiated**

```java
interface Animal {
    void sound();
}

// ❌ This is NOT allowed
Animal a = new Animal();  // Compilation Error!

// ✅ This is allowed
Animal a = new Dog();  // Dog implements Animal
```

---

### 5️⃣ **A Class Can Implement Multiple Interfaces**

```java
interface Printable {
    void print();
}

interface Showable {
    void show();
}

// Implementing multiple interfaces
class Document implements Printable, Showable {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
    
    @Override
    public void show() {
        System.out.println("Showing document");
    }
}
```

---

### 6️⃣ **An Interface Can Extend Another Interface**

```java
interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }
    
    @Override
    public void play() {
        System.out.println("Dog plays");
    }
}
```

---

### 7️⃣ **An Interface Can Extend Multiple Interfaces**

```java
interface A {
    void methodA();
}

interface B {
    void methodB();
}

// Interface extending multiple interfaces
interface C extends A, B {
    void methodC();
}

class MyClass implements C {
    @Override
    public void methodA() { }
    
    @Override
    public void methodB() { }
    
    @Override
    public void methodC() { }
}
```

---

## 🆕 Java 8+ Features in Interfaces

### 1️⃣ Default Methods

**Default methods** have a body and provide default implementation. Classes can override them if needed.

```java
interface Vehicle {
    // Abstract method
    void start();
    
    // Default method (with implementation)
    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
    
    // Can override default method (optional)
    @Override
    public void stop() {
        System.out.println("Car stopped with brakes");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started");
    }
    
    // Uses default stop() method
}

// Usage:
Vehicle car = new Car();
car.start();  // Car started
car.stop();   // Car stopped with brakes

Vehicle bike = new Bike();
bike.start();  // Bike started
bike.stop();   // Vehicle stopped (default implementation)
```

**Why Default Methods?**
- Add new methods to interfaces without breaking existing implementations
- Provide common implementation for all implementing classes

---

### 2️⃣ Static Methods

**Static methods** belong to the interface and can be called using interface name.

```java
interface MathOperations {
    // Static method
    static int add(int a, int b) {
        return a + b;
    }
    
    static int multiply(int a, int b) {
        return a * b;
    }
}

// Usage:
int sum = MathOperations.add(5, 10);        // 15
int product = MathOperations.multiply(5, 10);  // 50

// ❌ Cannot call via implementing class
// MyClass.add(5, 10);  // Error!
```

---

## 🔄 Multiple Inheritance with Interfaces

Java doesn't support multiple inheritance with classes, but **supports it with interfaces**!

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// Multiple inheritance via interfaces
class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}

// Usage:
Duck duck = new Duck();
duck.fly();   // Duck is flying
duck.swim();  // Duck is swimming
```

---

## 🎨 Real-World Example: Payment System

```java
interface Payment {
    void processPayment(double amount);
    void refund(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding to credit card: $" + amount);
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding to PayPal: $" + amount);
    }
}

class UPIPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding to UPI: ₹" + amount);
    }
}

// Usage:
Payment payment1 = new CreditCardPayment();
Payment payment2 = new PayPalPayment();
Payment payment3 = new UPIPayment();

payment1.processPayment(100.0);
payment2.processPayment(50.0);
payment3.processPayment(2000.0);
```

---

## 📊 Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|----------------|
| **Methods** | Abstract (default/static in Java 8+) | Abstract + Concrete |
| **Variables** | Only constants (public static final) | Any type of variables |
| **Constructors** | ❌ Cannot have | ✅ Can have |
| **Multiple Inheritance** | ✅ Supported | ❌ Not supported |
| **Access Modifiers** | Methods are public by default | Can have any access modifier |
| **Keyword** | `implements` | `extends` |
| **Abstraction Level** | 100% (before Java 8) | 0% to 100% |
| **Use Case** | Define contract/capability | Partial implementation |
| **Example** | `interface Flyable` | `abstract class Animal` |

---

## 🔑 When to Use Interface vs Abstract Class?

### Use Interface When:
- ✅ You want 100% abstraction
- ✅ You need multiple inheritance
- ✅ Defining a contract/capability (Flyable, Runnable, Comparable)
- ✅ Unrelated classes need to implement same behavior

### Use Abstract Class When:
- ✅ You want to share code among related classes
- ✅ You need constructors or instance variables
- ✅ You want to provide partial implementation
- ✅ Classes have IS-A relationship

---

## 🎯 Functional Interfaces (Java 8+)

A **functional interface** is an interface with **exactly one abstract method**. Used for lambda expressions.

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);  // Single abstract method
}

// Using lambda expression
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(5, 10));       // 15
System.out.println(multiply.calculate(5, 10));  // 50
```

**Built-in Functional Interfaces:**
- `Runnable` - `void run()`
- `Callable<V>` - `V call()`
- `Comparator<T>` - `int compare(T o1, T o2)`
- `Predicate<T>` - `boolean test(T t)`

---

## 🎨 Marker Interfaces

**Marker interfaces** are empty interfaces (no methods) used to mark classes for special treatment.

```java
interface Serializable {
    // Empty interface - just a marker
}

class Student implements Serializable {
    String name;
    int age;
    // Now Student objects can be serialized
}
```

**Examples:**
- `Serializable` - Marks class for serialization
- `Cloneable` - Marks class for cloning
- `Remote` - Marks class for remote method invocation

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Use interfaces for defining contracts
interface Drawable {
    void draw();
}

// 2. Use meaningful names (often ends with -able)
interface Runnable, Comparable, Serializable

// 3. Keep interfaces focused (Single Responsibility)
interface Printable {
    void print();
}

// 4. Use @Override annotation
@Override
public void method() { }

// 5. Use @FunctionalInterface for single method interfaces
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

### ❌ DON'T:
```java
// 1. Don't try to instantiate interfaces
Animal a = new Animal();  // ❌ Error!

// 2. Don't put too many methods in one interface
interface Everything {
    void method1();
    void method2();
    // ... 20 more methods  // Bad design!
}

// 3. Don't forget to implement all methods
class MyClass implements MyInterface {
    // Must implement ALL methods!
}
```

---

## 🎯 Summary

1. **Interface** = Blueprint/contract with abstract methods
2. **100% Abstraction** = All methods are abstract (before Java 8)
3. **Multiple Inheritance** = A class can implement multiple interfaces
4. **Default Methods** = Methods with implementation (Java 8+)
5. **Static Methods** = Belong to interface, called via interface name
6. **Functional Interface** = Interface with single abstract method
7. **Marker Interface** = Empty interface for marking classes
8. **Cannot instantiate** = Cannot create objects of interface
9. **Use `implements`** = Keyword to implement interface

---

**Remember:** Interfaces define WHAT to do, classes define HOW to do it! 🎯
