# Conditional Statements in Java

## 📚 What are Conditional Statements?

Conditional statements allow your program to make **decisions** based on certain conditions. They control the flow of execution based on whether a condition is **true** or **false**.

Think of conditional statements as **traffic signals** - they tell your program which path to take!

---

## 🔀 Types of Conditional Statements

Java has **three main types** of conditional statements:

```
Conditional Statements
    |
    |-----> if Statement
    |
    |-----> if-else Statement
    |
    |-----> switch Statement
```

---

## 1️⃣ if Statement

### What is it?
Executes a block of code **only if** the condition is true.

### Syntax:
```java
if (condition) {
    // code to execute if condition is true
}
```

### Simple Explanation:
"**IF** it's raining, **THEN** take an umbrella"

### When to Use:
- ✅ When you want to execute code only if a condition is true
- ✅ When there's no alternative action needed

---

## 2️⃣ if-else Statement

### What is it?
Executes one block of code if the condition is true, and another block if it's false.

### Syntax:
```java
if (condition) {
    // code if condition is true
} else {
    // code if condition is false
}
```

### Simple Explanation:
"**IF** it's raining, **THEN** take an umbrella, **ELSE** wear sunglasses"

### When to Use:
- ✅ When you have two possible paths
- ✅ When you need an alternative action

---

## 3️⃣ if-else-if Ladder

### What is it?
Tests multiple conditions in sequence.

### Syntax:
```java
if (condition1) {
    // code if condition1 is true
} else if (condition2) {
    // code if condition2 is true
} else if (condition3) {
    // code if condition3 is true
} else {
    // code if all conditions are false
}
```

### Simple Explanation:
"**IF** score >= 90, grade is A  
**ELSE IF** score >= 80, grade is B  
**ELSE IF** score >= 70, grade is C  
**ELSE** grade is F"

### When to Use:
- ✅ When you have multiple conditions to check
- ✅ When conditions are mutually exclusive

---

## 4️⃣ switch Statement

### What is it?
Selects one of many code blocks to execute based on the value of a variable.

### Syntax:
```java
switch (variable) {
    case value1:
        // code for value1
        break;
    case value2:
        // code for value2
        break;
    default:
        // code if no case matches
}
```

### Simple Explanation:
Like a **menu** - you choose one option from many predefined choices.

### When to Use:
- ✅ When you have multiple fixed values to check
- ✅ When checking equality (not ranges)
- ✅ More readable than multiple if-else for fixed values

### Important Notes:
- **break** statement prevents fall-through to next case
- **default** is optional, executes when no case matches
- Works with: int, char, String, enum

---

## 🆚 if-else vs switch

| Feature | if-else | switch |
|---------|---------|--------|
| **Use Case** | Any condition | Fixed values only |
| **Flexibility** | Can use ranges, complex conditions | Only equality checks |
| **Readability** | Can get messy with many conditions | Cleaner for multiple fixed values |
| **Performance** | Slower for many conditions | Faster for many fixed values |
| **Data Types** | Any boolean condition | int, char, String, enum |

---

## 🎯 Comparison Operators

Used in conditional statements to compare values:

| Operator | Meaning | Example |
|----------|---------|---------|
| `==` | Equal to | `a == b` |
| `!=` | Not equal to | `a != b` |
| `>` | Greater than | `a > b` |
| `<` | Less than | `a < b` |
| `>=` | Greater than or equal | `a >= b` |
| `<=` | Less than or equal | `a <= b` |

---

## 🔗 Logical Operators

Combine multiple conditions:

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `&&` | AND (both must be true) | `(a > 5 && b < 10)` | True if both conditions are true |
| `\|\|` | OR (at least one must be true) | `(a > 5 \|\| b < 10)` | True if either condition is true |
| `!` | NOT (reverses the condition) | `!(a > 5)` | True if a is NOT greater than 5 |

---

## 💡 Best Practices

### 1. **Use Curly Braces**
```java
// Good
if (condition) {
    doSomething();
}

// Avoid (can cause errors)
if (condition)
    doSomething();
```

### 2. **Use switch for Multiple Fixed Values**
```java
// Better with switch
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
}

// Avoid multiple if-else for fixed values
if (day == 1) System.out.println("Monday");
else if (day == 2) System.out.println("Tuesday");
```

### 3. **Don't Forget break in switch**
```java
// Without break, it falls through!
switch (num) {
    case 1:
        System.out.println("One");
        break;  // Important!
    case 2:
        System.out.println("Two");
        break;
}
```

---

## 🌟 Summary

1. **if** = Execute code only if condition is true
2. **if-else** = Choose between two paths
3. **if-else-if** = Choose from multiple conditions
4. **switch** = Choose from multiple fixed values
5. Use **comparison operators** (==, !=, >, <, >=, <=) to compare values
6. Use **logical operators** (&&, ||, !) to combine conditions

---

## 🔍 Real-World Analogy

**Conditional Statements** = Decision-making in daily life

- **if**: "If I'm hungry, I'll eat"
- **if-else**: "If it's sunny, I'll go out, else I'll stay home"
- **if-else-if**: "If it's morning, coffee; else if afternoon, tea; else water"
- **switch**: "Based on the day, I have a different schedule"

---

**Remember:** Conditional statements are the foundation of decision-making in programming! 🚀
