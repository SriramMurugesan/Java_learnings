# Inheritance in Java

## 📚 What is Inheritance?

**Inheritance** is a mechanism where a **new class** (child/subclass) acquires the **properties and behaviors** of an **existing class** (parent/superclass).

Think of it like **family traits** 👨‍👩‍👧 - children inherit characteristics from their parents!

### Real-World Analogy:
- **Vehicle → Car, Bike, Truck** 🚗🏍️🚚
  - All vehicles have wheels, engine, speed
  - Car has specific features like 4 wheels, AC
  - Bike has 2 wheels, no AC
  
- **Animal → Dog, Cat, Bird** 🐕🐈🐦
  - All animals eat, sleep, move
  - Dog barks, Cat meows, Bird flies

---

## 🎯 Why Use Inheritance?

1. **Code Reusability** - Reuse existing code without rewriting
2. **Method Overriding** - Customize parent class behavior
3. **Polymorphism** - Treat objects of different classes uniformly
4. **Hierarchical Classification** - Organize classes logically
5. **Maintainability** - Changes in parent reflect in all children

---

## 🔑 Key Terminology

| Term | Description | Example |
|------|-------------|---------|
| **Parent Class** | Base class, Superclass | `Animal` |
| **Child Class** | Derived class, Subclass | `Dog extends Animal` |
| **`extends` keyword** | Used to inherit from a class | `class Dog extends Animal` |
| **`super` keyword** | Refers to parent class | `super.method()` |

---

## 📝 Basic Syntax

```java
// Parent Class (Superclass)
class Parent {
    // Parent class members
}

// Child Class (Subclass)
class Child extends Parent {
    // Child class members
    // Inherits all non-private members from Parent
}
```

### Simple Example:
```java
// Parent Class
class Animal {
    String name;
    
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child Class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Usage:
Dog d = new Dog();
d.name = "Buddy";  // Inherited from Animal
d.eat();           // Inherited from Animal
d.bark();          // Own method
```

---

## 📜 Rules of Inheritance

### 1️⃣ **Private Members are NOT Inherited**

```java
class Parent {
    private int privateVar = 10;  // ❌ Not inherited
    int defaultVar = 20;          // ✅ Inherited
    protected int protectedVar = 30;  // ✅ Inherited
    public int publicVar = 40;    // ✅ Inherited
}

class Child extends Parent {
    void display() {
        // System.out.println(privateVar);  // ❌ Error! Cannot access
        System.out.println(defaultVar);     // ✅ OK (same package)
        System.out.println(protectedVar);   // ✅ OK
        System.out.println(publicVar);      // ✅ OK
    }
}
```

### 2️⃣ **Constructors are NOT Inherited**

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        // super() is called automatically here
        System.out.println("Child constructor");
    }
}

// Output when creating Child object:
// Parent constructor
// Child constructor
```

### 3️⃣ **Java Does NOT Support Multiple Inheritance (with classes)**

```java
class A { }
class B { }

// ❌ This is NOT allowed in Java
class C extends A, B { }  // Compilation Error!

// ✅ Solution: Use interfaces for multiple inheritance
```

**Why?** To avoid the **Diamond Problem** (ambiguity when two parents have same method).

### 4️⃣ **A Class Can Have Only ONE Direct Parent**

```java
// ✅ Valid
class A { }
class B extends A { }

// ❌ Invalid
class C extends A, B { }  // Error!
```

### 5️⃣ **Child Class Can Be a Parent to Another Class**

```java
class A { }
class B extends A { }  // B is child of A
class C extends B { }  // C is child of B (and grandchild of A)
```

---

## 🌳 Types of Inheritance in Java

### 1️⃣ Single Inheritance

**One child** inherits from **one parent**.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

**Diagram:**
```
    Animal
      ↑
      |
     Dog
```

---

### 2️⃣ Multilevel Inheritance

A class inherits from a child class, forming a **chain**.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Weeping...");
    }
}

// Puppy inherits from Dog, which inherits from Animal
```

**Diagram:**
```
    Animal
      ↑
      |
     Dog
      ↑
      |
    Puppy
```

---

### 3️⃣ Hierarchical Inheritance

**Multiple children** inherit from **one parent**.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("Flying...");
    }
}
```

**Diagram:**
```
        Animal
       /  |  \
      /   |   \
    Dog  Cat  Bird
```

---

### ❌ Multiple Inheritance (NOT Supported with Classes)

One class inheriting from **multiple classes** directly.

```java
class A { }
class B { }

// ❌ NOT allowed in Java
class C extends A, B { }  // Error!
```

**Solution:** Use **interfaces** for multiple inheritance (covered in Interfaces section).

---

### ❌ Hybrid Inheritance (NOT Supported with Classes)

Combination of multiple types of inheritance.

**Not directly supported** with classes due to multiple inheritance restriction.

---

## 🔧 Types of Methods in Inheritance

### 1️⃣ Inherited Methods

Methods from parent class that child can use **directly**.

```java
class Parent {
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    // display() is inherited
}

// Usage:
Child c = new Child();
c.display();  // Calls Parent's display()
```

---

### 2️⃣ Overridden Methods

Child class provides its **own implementation** of parent's method.

```java
class Parent {
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    @Override  // Good practice to use @Override annotation
    void display() {
        System.out.println("Child method");
    }
}

// Usage:
Child c = new Child();
c.display();  // Calls Child's display() (overridden)
```

**Rules for Method Overriding:**
- ✅ Same method name
- ✅ Same parameters (number, type, order)
- ✅ Same or covariant return type
- ✅ Access modifier must be same or less restrictive
- ❌ Cannot override `private`, `static`, or `final` methods

---

### 3️⃣ Hidden Methods (Static Methods)

Static methods in child class **hide** parent's static method (not overriding).

```java
class Parent {
    static void display() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void display() {
        System.out.println("Child static method");
    }
}

// Usage:
Parent.display();  // Parent static method
Child.display();   // Child static method

Parent p = new Child();
p.display();  // Parent static method (method hiding, not overriding!)
```

**Key Difference:**
- **Overriding** = Instance methods (runtime polymorphism)
- **Hiding** = Static methods (compile-time binding)

---

### 4️⃣ Child-Specific Methods

Methods that exist **only in child** class.

```java
class Parent {
    void parentMethod() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    void childMethod() {
        System.out.println("Child-specific method");
    }
}

// Usage:
Child c = new Child();
c.parentMethod();  // Inherited
c.childMethod();   // Child-specific
```

---

## 🔑 The `super` Keyword

The `super` keyword refers to the **parent class** and is used to:

### 1️⃣ Access Parent Class Variables

```java
class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;
    
    void display() {
        System.out.println(x);        // 20 (child's x)
        System.out.println(super.x);  // 10 (parent's x)
    }
}
```

---

### 2️⃣ Call Parent Class Methods

```java
class Parent {
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    @Override
    void display() {
        super.display();  // Call parent's display()
        System.out.println("Child method");
    }
}

// Output:
// Parent method
// Child method
```

---

### 3️⃣ Call Parent Class Constructor

```java
class Parent {
    Parent(String name) {
        System.out.println("Parent: " + name);
    }
}

class Child extends Parent {
    Child() {
        super("John");  // Must be first statement!
        System.out.println("Child constructor");
    }
}

// Output:
// Parent: John
// Child constructor
```

**Rules for `super()`:**
- ✅ Must be the **first statement** in child constructor
- ✅ If not explicitly called, Java calls `super()` (no-arg constructor) automatically
- ❌ Cannot use both `super()` and `this()` in same constructor

---

## 🔄 Constructor Chaining in Inheritance

When you create a child object, **parent constructor is called first**, then child constructor.

```java
class GrandParent {
    GrandParent() {
        System.out.println("GrandParent constructor");
    }
}

class Parent extends GrandParent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

// Usage:
Child c = new Child();

// Output:
// GrandParent constructor
// Parent constructor
// Child constructor
```

**Execution Flow:**
1. `Child()` is called
2. `Child()` implicitly calls `super()` → `Parent()`
3. `Parent()` implicitly calls `super()` → `GrandParent()`
4. `GrandParent()` executes
5. `Parent()` executes
6. `Child()` executes

---

## 📊 Access Modifiers in Inheritance

| Modifier | Same Class | Same Package | Subclass (Different Package) | Other Classes |
|----------|------------|--------------|------------------------------|---------------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| `default` | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

**For Inheritance:**
- `private` members are **NOT inherited**
- `protected` members are **inherited** and accessible in child class
- `public` members are **inherited** and accessible everywhere

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Use @Override annotation
@Override
void display() { }

// 2. Call super() when needed
super.parentMethod();

// 3. Use protected for members meant to be inherited
protected int value;

// 4. Follow IS-A relationship
class Dog extends Animal { }  // Dog IS-A Animal ✅
```

### ❌ DON'T:
```java
// 1. Don't inherit just for code reuse (use composition instead)
class Employee extends Person { }  // Only if Employee IS-A Person

// 2. Don't override final methods
final void method() { }

// 3. Don't forget to call super() in constructors when needed
Child() {
    // super() should be called if parent has parameterized constructor
}
```

---

## 🎯 Summary

1. **Inheritance** = Child class acquires properties of parent class
2. **`extends` keyword** = Used to inherit from a class
3. **Types of Inheritance** = Single, Multilevel, Hierarchical (Multiple NOT supported)
4. **Private members** = NOT inherited
5. **Constructors** = NOT inherited (but called via `super()`)
6. **Method Types** = Inherited, Overridden, Hidden (static), Child-specific
7. **`super` keyword** = Access parent class members, methods, constructors
8. **Constructor Chaining** = Parent constructor called before child constructor

---

**Remember:** Inheritance promotes code reusability and establishes IS-A relationships! 🌳
