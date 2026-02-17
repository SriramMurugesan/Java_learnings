# Java 8 Features: Lambda Expression & Optional Classes

## Lambda Expression

### What is Lambda Expression?

A **lambda expression** is a short way to write anonymous functions (functions without a name).

### Simple Analogy
Instead of writing a full letter, you send a quick text message!

---

## Why Lambda?

### Before Lambda (Verbose)
```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};
```

### With Lambda (Concise)
```java
Runnable r = () -> System.out.println("Hello");
```

**Much shorter and cleaner!**

---

## Lambda Syntax

### Basic Syntax
```
(parameters) -> expression
```

or

```
(parameters) -> { statements; }
```

---

## Lambda Examples

### 1. No Parameters
```java
() -> System.out.println("Hello")
```

### 2. One Parameter
```java
(x) -> x * x
// or simply
x -> x * x
```

### 3. Multiple Parameters
```java
(x, y) -> x + y
```

### 4. Multiple Statements
```java
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

---

## Functional Interface

Lambda works with **functional interfaces** (interfaces with single abstract method).

### Example: Runnable
```java
@FunctionalInterface
interface Runnable {
    void run(); // Single method
}
```

### Using Lambda
```java
Runnable r = () -> System.out.println("Running");
r.run();
```

---

## Common Functional Interfaces

### 1. Runnable
```java
Runnable r = () -> System.out.println("Hello");
new Thread(r).start();
```

### 2. Comparator
```java
List<String> names = Arrays.asList("John", "Alice", "Bob");
names.sort((a, b) -> a.compareTo(b));
```

### 3. ActionListener (GUI)
```java
button.addActionListener(e -> System.out.println("Clicked"));
```

---

## Custom Functional Interface

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Addition
        Calculator add = (a, b) -> a + b;
        System.out.println("Sum: " + add.calculate(5, 3));
        
        // Multiplication
        Calculator multiply = (a, b) -> a * b;
        System.out.println("Product: " + multiply.calculate(5, 3));
    }
}
```

**Output**:
```
Sum: 8
Product: 15
```

---

## Lambda with Collections

### forEach
```java
List<String> names = Arrays.asList("John", "Alice", "Bob");
names.forEach(name -> System.out.println(name));
```

### filter
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

### map
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```

---

## Optional Class

### What is Optional?

**Optional** is a container that may or may not contain a value. It helps avoid `NullPointerException`.

### Simple Analogy
Think of a gift box:
- May contain a gift (value)
- May be empty (null)
- Check before opening!

---

## Why Optional?

### Problem: NullPointerException
```java
String name = getName(); // May return null
System.out.println(name.length()); // NullPointerException!
```

### Solution: Optional
```java
Optional<String> name = getName();
if (name.isPresent()) {
    System.out.println(name.get().length());
}
```

---

## Creating Optional

### 1. Optional.of()
```java
Optional<String> opt = Optional.of("Hello");
// Throws exception if null
```

### 2. Optional.ofNullable()
```java
Optional<String> opt = Optional.ofNullable(null);
// Accepts null, creates empty Optional
```

### 3. Optional.empty()
```java
Optional<String> opt = Optional.empty();
// Creates empty Optional
```

---

## Optional Methods

### 1. isPresent()
Check if value exists
```java
if (opt.isPresent()) {
    System.out.println("Value exists");
}
```

### 2. get()
Get the value
```java
String value = opt.get(); // Throws exception if empty
```

### 3. orElse()
Get value or default
```java
String value = opt.orElse("Default");
```

### 4. orElseGet()
Get value or compute default
```java
String value = opt.orElseGet(() -> "Computed Default");
```

### 5. ifPresent()
Execute if value exists
```java
opt.ifPresent(value -> System.out.println(value));
```

---

## Optional Examples

### Example 1: Basic Usage
```java
Optional<String> name = Optional.of("John");

if (name.isPresent()) {
    System.out.println("Name: " + name.get());
}
```

### Example 2: orElse
```java
Optional<String> name = Optional.empty();
String result = name.orElse("Unknown");
System.out.println(result); // Unknown
```

### Example 3: ifPresent
```java
Optional<String> name = Optional.of("John");
name.ifPresent(n -> System.out.println("Hello " + n));
```

---

## Complete Example

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create Optional
        Optional<String> name1 = Optional.of("John");
        Optional<String> name2 = Optional.empty();
        
        // Check and get
        if (name1.isPresent()) {
            System.out.println("Name 1: " + name1.get());
        }
        
        // orElse
        System.out.println("Name 2: " + name2.orElse("Unknown"));
        
        // ifPresent
        name1.ifPresent(n -> System.out.println("Hello " + n));
        
        // map
        Optional<Integer> length = name1.map(String::length);
        System.out.println("Length: " + length.orElse(0));
    }
}
```

**Output**:
```
Name 1: John
Name 2: Unknown
Hello John
Length: 4
```

---

## Optional with Streams

```java
List<String> names = Arrays.asList("John", "Alice", null, "Bob");

names.stream()
     .map(Optional::ofNullable)
     .filter(Optional::isPresent)
     .map(Optional::get)
     .forEach(System.out::println);
```

---

## Best Practices

### ✅ DO's
- Use Optional for return types
- Use `orElse()` for default values
- Use `ifPresent()` instead of `isPresent() + get()`
- Use `map()` for transformations

### ❌ DON'Ts
- Don't use Optional for fields
- Don't use Optional for method parameters
- Don't call `get()` without checking `isPresent()`
- Don't use Optional just to avoid null checks everywhere

---

## Summary

### Lambda Expression
- **Short syntax** for anonymous functions
- **Syntax**: `(parameters) -> expression`
- Works with **functional interfaces**
- Makes code **cleaner and more readable**
- Used with **collections, streams, threads**

### Optional Class
- **Container** for value that may be null
- **Avoids** NullPointerException
- **Methods**: `isPresent()`, `get()`, `orElse()`, `ifPresent()`
- Use for **return types**
- Makes **null handling** explicit and safe

---

## Quick Reference

### Lambda
```java
// No parameters
() -> System.out.println("Hello")

// One parameter
x -> x * 2

// Multiple parameters
(x, y) -> x + y

// Multiple statements
(x, y) -> {
    int sum = x + y;
    return sum;
}
```

### Optional
```java
// Create
Optional.of(value)
Optional.ofNullable(value)
Optional.empty()

// Check and get
opt.isPresent()
opt.get()
opt.orElse(default)
opt.ifPresent(consumer)
```
