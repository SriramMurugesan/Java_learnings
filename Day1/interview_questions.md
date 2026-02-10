# Day 1 - Interview Questions for Freshers

## 📚 Java Basics

### Q1. What is Java?
**Answer:** Java is a high-level, object-oriented programming language that is platform-independent. It follows the principle "Write Once, Run Anywhere" (WORA).

### Q2. What is JVM?
**Answer:** JVM (Java Virtual Machine) is a virtual machine that executes Java bytecode. It makes Java platform-independent by converting bytecode into machine-specific code.

### Q3. What is JDK?
**Answer:** JDK (Java Development Kit) is a software development kit that contains tools needed to develop Java applications, including JRE, compiler (javac), and other development tools.

### Q4. What is JRE?
**Answer:** JRE (Java Runtime Environment) contains JVM and libraries needed to run Java applications. It does not include development tools like compiler.

### Q5. Difference between JDK, JRE, and JVM?
**Answer:**
- **JDK** = JRE + Development Tools (for developers)
- **JRE** = JVM + Libraries (to run Java programs)
- **JVM** = Executes bytecode (platform-specific)

---

## 🔤 Variables and Data Types

### Q6. What is a variable?
**Answer:** A variable is a container that holds data. It has a name, data type, and value.

**Example:**
```java
int age = 25;  // 'age' is variable, 'int' is type, '25' is value
```

### Q7. What are data types in Java?
**Answer:** Data types specify the type of data a variable can hold. Java has two categories:
- **Primitive types**: int, float, double, char, boolean, byte, short, long
- **Non-primitive types**: String, Arrays, Classes

### Q8. What is the difference between primitive and non-primitive data types?
**Answer:**
| Primitive | Non-Primitive |
|-----------|---------------|
| Stores actual value | Stores reference (address) |
| Cannot be null | Can be null |
| Lowercase (int, char) | Uppercase (String, Array) |
| Fixed size | Variable size |

### Q9. What is the size of int in Java?
**Answer:** 4 bytes (32 bits), range: -2,147,483,648 to 2,147,483,647

### Q10. What is the difference between int and Integer?
**Answer:**
- **int**: Primitive data type, stores actual value, cannot be null
- **Integer**: Wrapper class (non-primitive), stores reference, can be null, has methods

---

## 📝 Identifiers and Keywords

### Q11. What are identifiers?
**Answer:** Identifiers are names given to variables, methods, classes, etc.

**Rules:**
- Must start with letter, $, or _
- Cannot start with digit
- Cannot use keywords
- Case-sensitive

### Q12. What are keywords in Java?
**Answer:** Keywords are reserved words with special meaning in Java. Examples: `int`, `class`, `public`, `static`, `void`, `if`, `for`, `while`

### Q13. Can we use keywords as variable names?
**Answer:** No, keywords cannot be used as identifiers.

```java
int int = 10;  // ERROR! 'int' is a keyword
int number = 10;  // Correct
```

---

## 🔄 Type Casting

### Q14. What is type casting?
**Answer:** Type casting is converting one data type to another.

**Types:**
- **Widening (Implicit)**: Smaller to larger type (automatic)
- **Narrowing (Explicit)**: Larger to smaller type (manual)

### Q15. What is widening type casting?
**Answer:** Automatic conversion from smaller to larger data type.

```java
int a = 10;
double b = a;  // int to double (automatic)
```

### Q16. What is narrowing type casting?
**Answer:** Manual conversion from larger to smaller data type.

```java
double a = 10.5;
int b = (int) a;  // double to int (manual, loses decimal)
```

### Q17. What happens when you cast double to int?
**Answer:** The decimal part is lost (truncated).

```java
double a = 10.9;
int b = (int) a;  // b = 10 (not 11!)
```

---

## 📥 User Input

### Q18. How do you take input from user in Java?
**Answer:** Using the `Scanner` class.

```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
int num = scn.nextInt();  // Read integer
String name = scn.next();  // Read string
```

### Q19. What is the difference between next() and nextLine()?
**Answer:**
- **next()**: Reads single word (stops at space)
- **nextLine()**: Reads entire line (including spaces)

```java
Scanner scn = new Scanner(System.in);
String word = scn.next();      // "Hello"
String line = scn.nextLine();  // "Hello World"
```

---

## 🎯 Methods

### Q20. What is a method?
**Answer:** A method is a block of code that performs a specific task. It can be reused multiple times.

### Q21. What is the syntax of a method?
**Answer:**
```java
returnType methodName(parameters) {
    // code
    return value;
}
```

### Q22. What is the difference between parameters and arguments?
**Answer:**
- **Parameters**: Variables in method definition
- **Arguments**: Actual values passed when calling method

```java
void add(int a, int b) {  // a, b are parameters
    System.out.println(a + b);
}

add(5, 10);  // 5, 10 are arguments
```

### Q23. What is method overloading?
**Answer:** Having multiple methods with the same name but different parameters.

```java
void add(int a, int b) { }
void add(int a, int b, int c) { }
void add(double a, double b) { }
```

---

## 💡 General Questions

### Q24. What is the main method in Java?
**Answer:** The main method is the entry point of a Java program.

```java
public static void main(String[] args) {
    // Program starts here
}
```

### Q25. Why is main method static?
**Answer:** So that JVM can call it without creating an object of the class.

### Q26. What does System.out.println() do?
**Answer:**
- **System**: Class in java.lang package
- **out**: Static object of PrintStream class
- **println()**: Method to print with new line

### Q27. What is the difference between println() and print()?
**Answer:**
- **println()**: Prints and moves to next line
- **print()**: Prints on same line

```java
System.out.print("Hello");
System.out.print("World");  // Output: HelloWorld

System.out.println("Hello");
System.out.println("World");  // Output: Hello (newline) World
```

### Q28. What are wrapper classes?
**Answer:** Wrapper classes convert primitive types to objects.

| Primitive | Wrapper Class |
|-----------|---------------|
| int | Integer |
| double | Double |
| char | Character |
| boolean | Boolean |

### Q29. What is autoboxing and unboxing?
**Answer:**
- **Autoboxing**: Automatic conversion from primitive to wrapper
- **Unboxing**: Automatic conversion from wrapper to primitive

```java
int a = 10;
Integer b = a;  // Autoboxing (int to Integer)
int c = b;      // Unboxing (Integer to int)
```

### Q30. What is the default value of variables?
**Answer:**
- **int, byte, short, long**: 0
- **float, double**: 0.0
- **boolean**: false
- **char**: '\u0000'
- **Object references**: null

---

## 🎯 Quick Tips for Interview

1. **Speak clearly** and explain your thought process
2. **Use examples** to demonstrate concepts
3. **Admit if you don't know** - it's better than guessing
4. **Practice coding** on paper or whiteboard
5. **Understand concepts** rather than memorizing

---

## ⚡ Common Mistakes to Avoid

1. Confusing JDK, JRE, and JVM
2. Using keywords as variable names
3. Forgetting to import Scanner class
4. Mixing up primitive and wrapper classes
5. Not understanding type casting properly

---

**Remember:** These are basic questions for freshers. Focus on understanding concepts clearly! 🚀
