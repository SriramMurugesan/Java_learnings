# Polymorphism in Java

## 📚 What is Polymorphism?

**Polymorphism** means **"many forms"** (poly = many, morph = forms). It's the ability of an object to take on **different forms** or behave in **different ways**.

In Java, polymorphism allows you to perform a **single action in different ways**.

### Real-World Analogy:
- **A person** can be a **student**, **employee**, **parent** - same person, different roles! 👨‍🎓👨‍💼👨‍👧
- **A smartphone** can act as a **phone**, **camera**, **music player** - same device, different functions! 📱📷🎵

---

## 🎯 Why Use Polymorphism?

1. **Flexibility** - Same interface, different implementations
2. **Code Reusability** - Write once, use in multiple forms
3. **Maintainability** - Easy to extend and modify
4. **Dynamic Behavior** - Decide behavior at runtime
5. **Loose Coupling** - Reduces dependencies between classes

---

## 🌟 Types of Polymorphism

Java supports **two types** of polymorphism:

| Type | Also Known As | Binding Time | Example |
|------|---------------|--------------|---------|
| **Compile-time** | Static Polymorphism | Compile time | Method Overloading |
| **Runtime** | Dynamic Polymorphism | Runtime | Method Overriding |

---

## 1️⃣ Compile-Time Polymorphism (Method Overloading)

**Method Overloading** means having **multiple methods** with the **same name** but **different parameters** in the same class.

### Rules for Method Overloading:
- ✅ Same method name
- ✅ Different parameters (number, type, or order)
- ✅ Can have different return types
- ✅ Can have different access modifiers
- ❌ Return type alone is NOT enough to overload

---

### Example 1: Different Number of Parameters

```java
class Calculator {
    // Method 1: Two parameters
    int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: Three parameters (Overloaded)
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Usage:
Calculator calc = new Calculator();
System.out.println(calc.add(5, 10));        // Calls Method 1 → 15
System.out.println(calc.add(5, 10, 15));    // Calls Method 2 → 30
```

---

### Example 2: Different Types of Parameters

```java
class Calculator {
    // Method 1: Integer parameters
    int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: Double parameters (Overloaded)
    double add(double a, double b) {
        return a + b;
    }
}

// Usage:
Calculator calc = new Calculator();
System.out.println(calc.add(5, 10));        // Calls Method 1 → 15
System.out.println(calc.add(5.5, 10.5));    // Calls Method 2 → 16.0
```

---

### Example 3: Different Order of Parameters

```java
class Display {
    // Method 1: String first, then int
    void show(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    // Method 2: int first, then String (Overloaded)
    void show(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
}

// Usage:
Display d = new Display();
d.show("John", 25);    // Calls Method 1
d.show(25, "John");    // Calls Method 2
```

---

### ❌ Invalid Overloading Examples

```java
class Test {
    // ❌ Only return type is different - NOT valid overloading!
    int add(int a, int b) {
        return a + b;
    }
    
    double add(int a, int b) {  // Compilation Error!
        return a + b;
    }
}
```

---

### 🎯 Benefits of Method Overloading

1. **Readability** - Same name for similar operations
2. **Convenience** - No need to remember different method names
3. **Flexibility** - Handle different types of inputs

**Real-World Example:**
```java
System.out.println(10);           // Prints integer
System.out.println(10.5);         // Prints double
System.out.println("Hello");      // Prints string
System.out.println(true);         // Prints boolean

// All use the same method name 'println' but different parameters!
```

---

## 2️⃣ Runtime Polymorphism (Method Overriding)

**Method Overriding** means a child class provides its **own implementation** of a method that is already defined in the parent class.

### Rules for Method Overriding:
- ✅ Must have inheritance (parent-child relationship)
- ✅ Same method name
- ✅ Same parameters (number, type, order)
- ✅ Same or covariant return type
- ✅ Access modifier must be same or less restrictive
- ❌ Cannot override `private`, `static`, or `final` methods
- ✅ Use `@Override` annotation (recommended)

---

### Basic Example:

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Usage:
Animal a1 = new Dog();
Animal a2 = new Cat();

a1.sound();  // Dog barks (runtime polymorphism!)
a2.sound();  // Cat meows (runtime polymorphism!)
```

**Key Point:** The method to be called is determined at **runtime** based on the **actual object type**, not the reference type!

---

## 🔄 Dynamic Method Dispatch

**Dynamic Method Dispatch** is the mechanism by which a call to an overridden method is resolved at **runtime** rather than compile time.

### How It Works:

```java
class Parent {
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child display");
    }
}

// Dynamic Method Dispatch
Parent obj = new Child();  // Parent reference, Child object
obj.display();  // Calls Child's display() - decided at runtime!
```

**Explanation:**
- **Reference type:** `Parent` (compile time)
- **Object type:** `Child` (runtime)
- **Method called:** `Child's display()` (determined at runtime)

---

### More Complex Example:

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a triangle");
    }
}

// Usage:
Shape s1 = new Circle();
Shape s2 = new Rectangle();
Shape s3 = new Triangle();

s1.draw();  // Drawing a circle
s2.draw();  // Drawing a rectangle
s3.draw();  // Drawing a triangle

// Same method call, different behaviors! 🎨
```

---

## 🔍 Compile-Time vs Runtime Polymorphism

| Feature | Compile-Time | Runtime |
|---------|--------------|---------|
| **Mechanism** | Method Overloading | Method Overriding |
| **Binding** | Early Binding (Compile time) | Late Binding (Runtime) |
| **Inheritance** | Not required | Required |
| **Performance** | Faster | Slightly slower |
| **Example** | `add(int, int)` vs `add(double, double)` | Parent ref, Child object |
| **Decision Made** | At compile time | At runtime |

---

## 🎨 Real-World Polymorphism Example

### Banking System:

```java
class Account {
    void calculateInterest() {
        System.out.println("Calculating general interest");
    }
}

class SavingsAccount extends Account {
    @Override
    void calculateInterest() {
        System.out.println("Calculating interest at 4% for Savings Account");
    }
}

class CurrentAccount extends Account {
    @Override
    void calculateInterest() {
        System.out.println("No interest for Current Account");
    }
}

class FixedDeposit extends Account {
    @Override
    void calculateInterest() {
        System.out.println("Calculating interest at 7% for Fixed Deposit");
    }
}

// Usage:
Account acc1 = new SavingsAccount();
Account acc2 = new CurrentAccount();
Account acc3 = new FixedDeposit();

acc1.calculateInterest();  // 4% interest
acc2.calculateInterest();  // No interest
acc3.calculateInterest();  // 7% interest

// Same method, different implementations! 💰
```

---

## 🚀 Polymorphism with Arrays

You can store different child objects in a parent type array:

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

class Bird extends Animal {
    @Override
    void sound() {
        System.out.println("Chirp");
    }
}

// Polymorphic array
Animal[] animals = new Animal[3];
animals[0] = new Dog();
animals[1] = new Cat();
animals[2] = new Bird();

// Loop through and call sound()
for (Animal animal : animals) {
    animal.sound();  // Different sounds for each!
}

// Output:
// Bark
// Meow
// Chirp
```

---

## ⚠️ Important Points

### 1️⃣ Cannot Override Private Methods

```java
class Parent {
    private void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    // This is NOT overriding, it's a new method!
    private void display() {
        System.out.println("Child");
    }
}
```

---

### 2️⃣ Cannot Override Static Methods (Method Hiding)

```java
class Parent {
    static void display() {
        System.out.println("Parent static");
    }
}

class Child extends Parent {
    // This is method HIDING, not overriding!
    static void display() {
        System.out.println("Child static");
    }
}

// Usage:
Parent obj = new Child();
obj.display();  // Prints "Parent static" (no polymorphism!)
```

---

### 3️⃣ Cannot Override Final Methods

```java
class Parent {
    final void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    // ❌ Compilation Error! Cannot override final method
    void display() {
        System.out.println("Child");
    }
}
```

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Use @Override annotation
@Override
void method() { }

// 2. Use polymorphism for flexibility
Animal animal = new Dog();

// 3. Overload methods for convenience
int add(int a, int b) { }
double add(double a, double b) { }

// 4. Use parent reference for child objects
Shape shape = new Circle();
```

### ❌ DON'T:
```java
// 1. Don't confuse overloading with overriding
// Overloading = same class, different parameters
// Overriding = parent-child, same signature

// 2. Don't override final methods
final void method() { }

// 3. Don't make overridden method more restrictive
// Parent: public void method()
// Child: private void method()  // ❌ Error!
```

---

## 🎯 Summary

1. **Polymorphism** = One interface, multiple implementations
2. **Two Types:**
   - **Compile-time** = Method Overloading (same name, different parameters)
   - **Runtime** = Method Overriding (parent-child, same signature)
3. **Method Overloading** = Different parameters in same class
4. **Method Overriding** = Child provides own implementation of parent method
5. **Dynamic Method Dispatch** = Method call resolved at runtime
6. **Cannot override** = `private`, `static`, `final` methods
7. **Use `@Override`** = Good practice for overriding methods

---

**Remember:** Polymorphism is the key to flexible and maintainable code! 🔑
