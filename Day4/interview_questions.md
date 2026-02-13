# Day 4 - OOP & Regular Expressions Interview Questions

## 📚 Encapsulation Questions

### Q1: What is encapsulation in Java?
**Answer:** Encapsulation is the process of wrapping data (variables) and code (methods) together as a single unit and hiding the internal details from the outside world. It is achieved by declaring variables as private and providing public getter and setter methods.

---

### Q2: What is the difference between generic and specific getters/setters?
**Answer:**
- **Generic Getters/Setters**: Simply return or set the value without any validation or business logic
- **Specific Getters/Setters**: Include validation, calculations, or business rules before setting/getting values

---

### Q3: What is the shadowing problem in Java?
**Answer:** Shadowing occurs when a local variable (parameter) has the same name as an instance variable, causing the local variable to "shadow" or hide the instance variable. It is resolved using the `this` keyword to refer to the instance variable.

---

### Q4: What is a constructor in Java?
**Answer:** A constructor is a special method used to initialize objects. It has the same name as the class, no return type, and is called automatically when an object is created using the `new` keyword.

---

### Q5: What is constructor overloading?
**Answer:** Constructor overloading is having multiple constructors in the same class with different parameters (number, type, or order). It allows creating objects in different ways.

---

### Q6: Can we have private constructors?
**Answer:** Yes, private constructors are used in Singleton pattern to prevent object creation from outside the class.

---

### Q7: What is the difference between encapsulation and abstraction?
**Answer:**
- **Encapsulation**: Hiding data (implementation level) - HOW to do
- **Abstraction**: Hiding complexity (design level) - WHAT to do

---

## 🌳 Inheritance Questions

### Q8: What is inheritance in Java?
**Answer:** Inheritance is a mechanism where a new class (child/subclass) acquires properties and behaviors of an existing class (parent/superclass) using the `extends` keyword.

---

### Q9: What are the types of inheritance in Java?
**Answer:**
1. **Single Inheritance**: One child inherits from one parent
2. **Multilevel Inheritance**: Chain of inheritance (A → B → C)
3. **Hierarchical Inheritance**: Multiple children inherit from one parent
4. **Multiple Inheritance**: NOT supported with classes (use interfaces)
5. **Hybrid Inheritance**: NOT supported with classes

---

### Q10: Why doesn't Java support multiple inheritance with classes?
**Answer:** To avoid the Diamond Problem - ambiguity when two parent classes have the same method. Java supports multiple inheritance through interfaces.

---

### Q11: What is the `super` keyword?
**Answer:** The `super` keyword refers to the parent class and is used to:
1. Access parent class variables
2. Call parent class methods
3. Call parent class constructors (must be first statement)

---

### Q12: What is constructor chaining in inheritance?
**Answer:** When a child object is created, parent constructor is called first (implicitly or explicitly using `super()`), then child constructor executes. This creates a chain of constructor calls.

---

### Q13: Can we override private methods?
**Answer:** No, private methods are not inherited, so they cannot be overridden.

---

### Q14: What is method hiding?
**Answer:** Method hiding occurs with static methods. When a child class has a static method with the same signature as parent's static method, it hides the parent method (not overriding).

---

## 🎭 Polymorphism Questions

### Q15: What is polymorphism in Java?
**Answer:** Polymorphism means "many forms". It allows performing a single action in different ways. Java supports two types:
1. **Compile-time Polymorphism** (Method Overloading)
2. **Runtime Polymorphism** (Method Overriding)

---

### Q16: What is method overloading?
**Answer:** Method overloading is having multiple methods with the same name but different parameters (number, type, or order) in the same class. It is resolved at compile time.

---

### Q17: What is method overriding?
**Answer:** Method overriding is when a child class provides its own implementation of a method already defined in the parent class. It is resolved at runtime.

---

### Q18: What are the rules for method overriding?
**Answer:**
1. Same method name
2. Same parameters (number, type, order)
3. Same or covariant return type
4. Access modifier must be same or less restrictive
5. Cannot override private, static, or final methods
6. Use @Override annotation (recommended)

---

### Q19: What is dynamic method dispatch?
**Answer:** Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at runtime based on the actual object type, not the reference type.

---

### Q20: Can we overload main method?
**Answer:** Yes, we can overload the main method, but JVM will only call `public static void main(String[] args)`.

---

### Q21: What is the difference between overloading and overriding?
**Answer:**

| Feature | Overloading | Overriding |
|---------|-------------|------------|
| **Definition** | Same name, different parameters | Same signature in parent-child |
| **Binding** | Compile-time | Runtime |
| **Inheritance** | Not required | Required |
| **Return Type** | Can be different | Must be same or covariant |
| **Access Modifier** | Can be different | Same or less restrictive |

---

## 🎨 Abstraction Questions

### Q22: What is abstraction in Java?
**Answer:** Abstraction is the process of hiding implementation details and showing only essential features. It is achieved using abstract classes and interfaces.

---

### Q23: What is an abstract class?
**Answer:** An abstract class is a class that cannot be instantiated and may contain abstract methods (methods without implementation). It is declared using the `abstract` keyword.

---

### Q24: What is an abstract method?
**Answer:** An abstract method is a method declared without implementation (no body). It must be overridden in the child class.

---

### Q25: Can an abstract class have constructors?
**Answer:** Yes, abstract classes can have constructors. They are called when a child class object is created.

---

### Q26: Can an abstract class have final methods?
**Answer:** Yes, abstract classes can have final methods that cannot be overridden by child classes.

---

### Q27: Can we have abstract class without abstract methods?
**Answer:** Yes, we can have an abstract class without any abstract methods. It just cannot be instantiated.

---

### Q28: What is the difference between abstract class and concrete class?
**Answer:**
- **Abstract Class**: Cannot be instantiated, may have abstract methods
- **Concrete Class**: Can be instantiated, all methods have implementation

---

## 🔌 Interface Questions

### Q29: What is an interface in Java?
**Answer:** An interface is a blueprint of a class that contains only abstract methods and constants. It defines what a class must do, but not how it does it.

---

### Q30: What are the rules for interfaces?
**Answer:**
1. All methods are public and abstract by default
2. All variables are public, static, and final by default
3. Cannot have constructors
4. Cannot be instantiated
5. A class can implement multiple interfaces
6. An interface can extend multiple interfaces

---

### Q31: What is the difference between abstract class and interface?
**Answer:**

| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| **Methods** | Abstract + Concrete | Abstract (default/static in Java 8+) |
| **Variables** | Any type | Only constants |
| **Constructors** | Can have | Cannot have |
| **Multiple Inheritance** | Not supported | Supported |
| **Keyword** | `extends` | `implements` |
| **Abstraction** | 0% to 100% | 100% (before Java 8) |

---

### Q32: What are default methods in interfaces?
**Answer:** Default methods (Java 8+) are methods with implementation in interfaces. They provide default behavior that implementing classes can use or override.

---

### Q33: What are static methods in interfaces?
**Answer:** Static methods (Java 8+) belong to the interface and can be called using the interface name. They cannot be overridden.

---

### Q34: What is a functional interface?
**Answer:** A functional interface is an interface with exactly one abstract method. It is used for lambda expressions and is annotated with `@FunctionalInterface`.

---

### Q35: What is a marker interface?
**Answer:** A marker interface is an empty interface (no methods) used to mark classes for special treatment. Examples: Serializable, Cloneable.

---

### Q36: Can an interface extend a class?
**Answer:** No, an interface cannot extend a class. It can only extend other interfaces.

---

## 🔍 Regular Expressions Questions

### Q37: What are regular expressions in Java?
**Answer:** Regular expressions (regex) are patterns used to search, match, and manipulate text. Java provides Pattern and Matcher classes for regex operations.

---

### Q38: What is the Pattern class?
**Answer:** The Pattern class is used to compile regex patterns. It provides methods to create Matcher objects for pattern matching.

---

### Q39: What is the Matcher class?
**Answer:** The Matcher class performs matching operations on text using a compiled pattern. It provides methods like find(), matches(), replaceAll().

---

### Q40: What is the difference between matches() and find()?
**Answer:**
- **matches()**: Checks if the entire string matches the pattern
- **find()**: Searches for the pattern anywhere in the string

---

### Q41: What are common regex metacharacters?
**Answer:**
- `\d` - digit
- `\w` - word character
- `\s` - whitespace
- `.` - any character
- `*` - 0 or more
- `+` - 1 or more
- `?` - 0 or 1
- `^` - start of line
- `$` - end of line

---

### Q42: How to make regex case-insensitive?
**Answer:** Use the Pattern.CASE_INSENSITIVE flag:
```java
Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
```

---

### Q43: What is the difference between greedy and lazy quantifiers?
**Answer:**
- **Greedy**: Matches as much as possible (default)
- **Lazy**: Matches as little as possible (use `?` after quantifier)

---

## 🎯 Scenario-Based Questions

### Q44: When to use abstract class vs interface?
**Answer:**
- **Use Abstract Class**: When you want to share code among related classes, need constructors or instance variables, or want partial implementation
- **Use Interface**: When you want 100% abstraction, multiple inheritance, or defining a contract/capability

---

### Q45: Can you achieve 100% abstraction with abstract class?
**Answer:** Yes, if all methods in the abstract class are abstract (no concrete methods). However, interfaces are preferred for 100% abstraction.

---

### Q46: What happens if a class implements two interfaces with same method?
**Answer:** The class must provide a single implementation that satisfies both interfaces.

---

### Q47: Can we override static methods?
**Answer:** No, static methods cannot be overridden. They can be hidden (method hiding).

---

### Q48: What is the use of `this()` in constructors?
**Answer:** `this()` is used to call another constructor in the same class (constructor chaining). It must be the first statement.

---

### Q49: Can we have both `this()` and `super()` in the same constructor?
**Answer:** No, both must be the first statement, so we can have only one.

---

### Q50: What is the diamond problem in Java?
**Answer:** The diamond problem occurs in multiple inheritance when two parent classes have the same method, causing ambiguity about which method to inherit. Java solves this by not supporting multiple inheritance with classes, but allows it with interfaces (using default methods).

---

**Remember:** Understanding these concepts is crucial for Java interviews! 🚀
