# 1D Arrays in Java

## 📚 What is a 1D Array?

A **1D (One-Dimensional) Array** is a linear collection of elements of the same data type, stored in contiguous memory locations.

Think of a 1D array as a **single row of boxes** - each box holds one value!

---

## 🎯 Syntax

### 1. **Declaration**
```java
dataType[] arrayName;
// OR
dataType arrayName[];
```

**Examples:**
```java
int[] numbers;
String[] names;
double[] prices;
```

### 2. **Initialization**

#### Method 1: Declare and Allocate Memory
```java
int[] numbers = new int[5];  // Creates array of size 5
```

#### Method 2: Declare, Allocate, and Assign
```java
int[] numbers = {10, 20, 30, 40, 50};
```

#### Method 3: Separate Steps
```java
int[] numbers;           // Declaration
numbers = new int[5];    // Memory allocation
numbers[0] = 10;         // Assignment
numbers[1] = 20;
```

---

## 🔢 Accessing Elements

### Using Index (0-based):
```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]);  // 10 (first element)
System.out.println(numbers[2]);  // 30 (third element)
System.out.println(numbers[4]);  // 50 (last element)
```

### Visual Representation:
```
Array: numbers = {10, 20, 30, 40, 50}

Index:     0   1   2   3   4
Value:    10  20  30  40  50
```

---

## 🔄 Iterating Through Arrays

### Method 1: Traditional for Loop
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### Method 2: Enhanced for Loop (for-each)
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
```

**When to use which?**
- **Traditional**: When you need the index
- **Enhanced**: When you only need the values

---

## 📊 Common Operations

### 1. **Finding Length**
```java
int[] numbers = {10, 20, 30};
System.out.println(numbers.length);  // 3
```

### 2. **Finding Maximum**
```java
int[] numbers = {10, 50, 30, 40, 20};
int max = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] > max) {
        max = numbers[i];
    }
}
System.out.println("Maximum: " + max);  // 50
```

### 3. **Finding Minimum**
```java
int[] numbers = {10, 50, 30, 40, 20};
int min = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] < min) {
        min = numbers[i];
    }
}
System.out.println("Minimum: " + min);  // 10
```

### 4. **Sum of Elements**
```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int num : numbers) {
    sum += num;
}
System.out.println("Sum: " + sum);  // 150
```

### 5. **Average**
```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int num : numbers) {
    sum += num;
}
double average = (double) sum / numbers.length;
System.out.println("Average: " + average);  // 30.0
```

---

## 🔍 Searching in Arrays

### Linear Search:
```java
int[] numbers = {10, 20, 30, 40, 50};
int target = 30;
boolean found = false;

for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        System.out.println("Found at index: " + i);
        found = true;
        break;
    }
}

if (!found) {
    System.out.println("Not found");
}
```

---

## 📝 Taking Input for Arrays

### Using Scanner:
```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
int[] numbers = new int[5];

System.out.println("Enter 5 numbers:");
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = scn.nextInt();
}

// Display
for (int num : numbers) {
    System.out.println(num);
}
```

---

## ⚠️ Common Errors

### 1. **ArrayIndexOutOfBoundsException**
```java
int[] numbers = {10, 20, 30};
System.out.println(numbers[5]);  // ERROR! Index 5 doesn't exist
```

**Solution:** Always check bounds
```java
if (index >= 0 && index < numbers.length) {
    System.out.println(numbers[index]);
}
```

### 2. **NullPointerException**
```java
int[] numbers;
System.out.println(numbers[0]);  // ERROR! Array not initialized
```

**Solution:** Initialize before use
```java
int[] numbers = new int[5];
System.out.println(numbers[0]);  // OK, prints 0
```

---

## 💡 Important Points

1. **Index starts from 0**
   - First element: `arr[0]`
   - Last element: `arr[length - 1]`

2. **Fixed Size**
   - Size cannot change after creation

3. **Default Values**
   - `int`: 0
   - `double`: 0.0
   - `boolean`: false
   - `String`: null

4. **Array Length**
   - Use `arr.length` (not a method, no parentheses)

5. **Pass by Reference**
   - Arrays are objects, passed by reference

---

## 🌟 Summary

1. **1D Array** = Single row of elements
2. **Declaration** = `int[] arr;`
3. **Initialization** = `int[] arr = new int[5];` or `{1, 2, 3}`
4. **Access** = `arr[index]` (0-based indexing)
5. **Length** = `arr.length`
6. **Iteration** = for loop or for-each loop

---

## 🔍 Real-World Analogy

**1D Array** = Train with compartments

- **Fixed Size**: Train has fixed number of compartments
- **Index**: Each compartment has a number (0, 1, 2, ...)
- **Same Type**: All compartments hold same type of cargo
- **Sequential**: Compartments are in a line
- **Direct Access**: You can go directly to compartment #3

---

## 📝 Best Practices

1. **Use meaningful names**
   ```java
   int[] studentScores;  // Good
   int[] arr;            // Bad
   ```

2. **Check array bounds**
   ```java
   if (i < arr.length) {
       System.out.println(arr[i]);
   }
   ```

3. **Use enhanced for loop when index not needed**
   ```java
   for (int score : studentScores) {
       System.out.println(score);
   }
   ```

4. **Initialize before use**
   ```java
   int[] numbers = new int[10];  // Always initialize
   ```

---

**Remember:** 1D arrays are the foundation for understanding multi-dimensional arrays! 🚀
