# Loops in Java

## 📚 What are Loops?

Loops allow you to **repeat** a block of code multiple times without writing the same code again and again.

Think of loops as **doing repetitive tasks** - like brushing each tooth one by one, or counting from 1 to 100!

---

## 🔁 Types of Loops

Java has **three main types** of loops:

```
Loops in Java
    |
    |-----> for Loop
    |
    |-----> while Loop
    |
    |-----> do-while Loop
```

---

## 1️⃣ for Loop

### What is it?
Repeats code a **specific number of times** when you know how many iterations you need.

### Syntax:
```java
for (initialization; condition; update) {
    // code to repeat
}
```

### Components:
1. **Initialization**: Starting point (executed once)
2. **Condition**: Checked before each iteration
3. **Update**: Executed after each iteration

### Example Breakdown:
```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```
- **int i = 1**: Start at 1
- **i <= 5**: Continue while i is less than or equal to 5
- **i++**: Increase i by 1 after each iteration

### Simple Explanation:
"Repeat this action **from** 1 **to** 5"

### When to Use:
- ✅ When you know the exact number of iterations
- ✅ When working with arrays (iterating through elements)
- ✅ When you need a counter variable

---

## 2️⃣ while Loop

### What is it?
Repeats code **as long as** a condition is true. You may not know how many times it will run.

### Syntax:
```java
while (condition) {
    // code to repeat
}
```

### Example:
```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```

### Simple Explanation:
"**While** you're hungry, keep eating"

### When to Use:
- ✅ When you don't know how many iterations you need
- ✅ When the loop depends on a changing condition
- ✅ When reading user input until a specific value

### Important:
- Condition is checked **before** executing the loop body
- If condition is false initially, loop never executes

---

## 3️⃣ do-while Loop

### What is it?
Similar to while loop, but **always executes at least once** because the condition is checked **after** the loop body.

### Syntax:
```java
do {
    // code to repeat
} while (condition);
```

### Example:
```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

### Simple Explanation:
"**Do** this action first, **then** check if you should continue"

### When to Use:
- ✅ When you want the loop to run at least once
- ✅ When displaying menus (show menu first, then check user choice)
- ✅ When validating user input

### Key Difference from while:
- **while**: Checks condition first, may not execute at all
- **do-while**: Executes first, then checks condition

---

## 🆚 Loop Comparison

| Feature | for Loop | while Loop | do-while Loop |
|---------|----------|------------|---------------|
| **When to Use** | Known iterations | Unknown iterations | At least one execution |
| **Condition Check** | Before each iteration | Before each iteration | After each iteration |
| **Initialization** | In loop header | Before loop | Before loop |
| **Minimum Executions** | 0 (if condition false) | 0 (if condition false) | 1 (always) |
| **Best For** | Arrays, counters | User input, conditions | Menus, validation |

---

## 🎯 Loop Control Statements

### 1. **break**
Exits the loop immediately.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Stop when i is 5
    }
    System.out.println(i);
}
// Output: 1 2 3 4
```

### 2. **continue**
Skips the current iteration and moves to the next one.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;  // Skip when i is 3
    }
    System.out.println(i);
}
// Output: 1 2 4 5
```

---

## 🔢 Common Loop Patterns

### 1. **Counting Up**
```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

### 2. **Counting Down**
```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

### 3. **Increment by 2**
```java
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i);  // 0, 2, 4, 6, 8, 10
}
```

### 4. **Infinite Loop** (use with caution!)
```java
while (true) {
    // This runs forever unless you use break
}
```

---

## 🔁 Nested Loops

Loops inside loops - used for patterns, 2D arrays, etc.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.print(i + "," + j + " ");
    }
    System.out.println();
}
```

**Output:**
```
1,1 1,2 1,3 
2,1 2,2 2,3 
3,1 3,2 3,3 
```

### Simple Explanation:
- **Outer loop**: Controls rows
- **Inner loop**: Controls columns

---

## 💡 Best Practices

### 1. **Avoid Infinite Loops**
```java
// Bad - infinite loop
int i = 1;
while (i <= 10) {
    System.out.println(i);
    // Forgot to increment i!
}

// Good
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;  // Don't forget this!
}
```

### 2. **Use Meaningful Variable Names**
```java
// Bad
for (int x = 0; x < 10; x++) { }

// Good
for (int studentCount = 0; studentCount < 10; studentCount++) { }
```

### 3. **Choose the Right Loop**
- **for**: When you know the count
- **while**: When you don't know the count
- **do-while**: When you need at least one execution

---

## 🌟 Summary

1. **for loop** = Use when you know how many times to repeat
2. **while loop** = Use when you don't know how many times to repeat
3. **do-while loop** = Use when you want to execute at least once
4. **break** = Exit the loop immediately
5. **continue** = Skip current iteration, move to next
6. **Nested loops** = Loops inside loops for 2D patterns

---

## 🔍 Real-World Analogy

**Loops** = Repetitive tasks in daily life

- **for loop**: "Do 10 push-ups" (you know the count)
- **while loop**: "Keep walking until you reach home" (unknown distance)
- **do-while loop**: "Try the door, then check if it's locked" (try first)
- **break**: "Stop eating when you're full"
- **continue**: "Skip vegetables, eat only fruits"

---

**Remember:** Loops save you from writing repetitive code. Master them to become efficient! 🚀
