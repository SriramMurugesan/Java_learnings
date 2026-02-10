# Day 2 - Interview Questions for Freshers

## 🔀 Conditional Statements

### Q1. What are conditional statements?
**Answer:** Conditional statements allow the program to make decisions based on conditions. They control the flow of execution.

**Types:** if, if-else, if-else-if, switch

### Q2. What is the difference between if and if-else?
**Answer:**
- **if**: Executes code only if condition is true
- **if-else**: Executes one block if true, another if false

```java
// if
if (age >= 18) {
    System.out.println("Adult");
}

// if-else
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

### Q3. What is a switch statement?
**Answer:** Switch statement selects one of many code blocks to execute based on the value of a variable.

```java
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid");
}
```

### Q4. Why do we use break in switch?
**Answer:** To prevent fall-through. Without break, execution continues to the next case.

```java
switch (num) {
    case 1:
        System.out.println("One");
        // No break - falls through!
    case 2:
        System.out.println("Two");
        break;
}
// If num = 1, prints: One, Two
```

### Q5. What are comparison operators?
**Answer:** Operators used to compare values: `==`, `!=`, `>`, `<`, `>=`, `<=`

### Q6. What are logical operators?
**Answer:**
- **&&** (AND): Both conditions must be true
- **||** (OR): At least one condition must be true
- **!** (NOT): Reverses the condition

```java
if (age >= 18 && hasLicense) {  // Both must be true
    System.out.println("Can drive");
}
```

---

## 🔁 Loops

### Q7. What is a loop?
**Answer:** A loop repeats a block of code multiple times until a condition is met.

### Q8. What are the types of loops in Java?
**Answer:** Three types:
- **for loop**: When you know the number of iterations
- **while loop**: When you don't know the number of iterations
- **do-while loop**: When you want to execute at least once

### Q9. What is the difference between while and do-while?
**Answer:**
- **while**: Checks condition first, may not execute at all
- **do-while**: Executes first, then checks condition (runs at least once)

```java
// while
int i = 10;
while (i < 5) {
    System.out.println(i);  // Never executes
}

// do-while
int i = 10;
do {
    System.out.println(i);  // Executes once
} while (i < 5);
```

### Q10. What is the syntax of a for loop?
**Answer:**
```java
for (initialization; condition; update) {
    // code
}

// Example
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

### Q11. What is the difference between break and continue?
**Answer:**
- **break**: Exits the loop completely
- **continue**: Skips current iteration, moves to next

```java
// break
for (int i = 1; i <= 10; i++) {
    if (i == 5) break;  // Stops at 5
    System.out.println(i);  // Prints: 1 2 3 4
}

// continue
for (int i = 1; i <= 5; i++) {
    if (i == 3) continue;  // Skips 3
    System.out.println(i);  // Prints: 1 2 4 5
}
```

### Q12. What is an infinite loop?
**Answer:** A loop that never ends because the condition is always true.

```java
while (true) {
    System.out.println("Infinite loop");
}

// Or
for (;;) {
    System.out.println("Infinite loop");
}
```

### Q13. What are nested loops?
**Answer:** Loops inside loops. The inner loop completes all iterations for each iteration of the outer loop.

```java
for (int i = 1; i <= 3; i++) {      // Outer loop
    for (int j = 1; j <= 3; j++) {  // Inner loop
        System.out.print(i + "," + j + " ");
    }
    System.out.println();
}
```

---

## 🎨 Pattern Programming

### Q14. How do you print a right-angled triangle pattern?
**Answer:**
```java
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

### Q15. What is the logic for printing a pyramid?
**Answer:** Print spaces first, then stars.

```java
for (int i = 1; i <= 5; i++) {
    // Print spaces
    for (int j = 1; j <= 5 - i; j++) {
        System.out.print(" ");
    }
    // Print stars
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

### Q16. How do you approach pattern problems?
**Answer:**
1. Count rows and columns
2. Find relationship between row and column
3. Identify spaces (if any)
4. Write outer loop for rows
5. Write inner loop(s) for columns/spaces

---

## 📊 Arrays

### Q17. What is an array?
**Answer:** An array is a collection of elements of the same data type stored in contiguous memory locations.

### Q18. How do you declare an array?
**Answer:**
```java
// Method 1
int[] arr = new int[5];

// Method 2
int[] arr = {10, 20, 30, 40, 50};

// Method 3
int[] arr;
arr = new int[5];
```

### Q19. What is array indexing?
**Answer:** Arrays use zero-based indexing. First element is at index 0, last element is at index `length - 1`.

```java
int[] arr = {10, 20, 30};
System.out.println(arr[0]);  // 10 (first element)
System.out.println(arr[2]);  // 30 (last element)
```

### Q20. How do you find the length of an array?
**Answer:** Using the `length` property (not a method).

```java
int[] arr = {10, 20, 30, 40, 50};
System.out.println(arr.length);  // 5
```

### Q21. What are the advantages of arrays?
**Answer:**
1. Store multiple values in one variable
2. Fast access using index (O(1))
3. Easy to iterate through elements
4. Memory efficient (contiguous storage)

### Q22. What are the disadvantages of arrays?
**Answer:**
1. Fixed size (cannot grow or shrink)
2. All elements must be same type
3. Insertion/deletion is costly (need to shift elements)
4. Memory waste if not fully used

### Q23. What is ArrayIndexOutOfBoundsException?
**Answer:** Exception thrown when trying to access an invalid index.

```java
int[] arr = {10, 20, 30};
System.out.println(arr[5]);  // ERROR! Index 5 doesn't exist
```

---

## 🔢 2D Arrays

### Q24. What is a 2D array?
**Answer:** A 2D array is an array of arrays, representing data in rows and columns (like a table or matrix).

### Q25. How do you declare a 2D array?
**Answer:**
```java
// Method 1
int[][] matrix = new int[3][4];  // 3 rows, 4 columns

// Method 2
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Q26. How do you access elements in a 2D array?
**Answer:** Using `array[row][column]`

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
System.out.println(matrix[0][0]);  // 1
System.out.println(matrix[1][2]);  // 6
```

### Q27. How do you find rows and columns in a 2D array?
**Answer:**
```java
int[][] matrix = new int[3][4];
int rows = matrix.length;           // 3
int columns = matrix[0].length;     // 4
```

### Q28. How do you iterate through a 2D array?
**Answer:** Using nested loops.

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 🎯 Jagged Arrays

### Q29. What is a jagged array?
**Answer:** A 2D array where each row can have a different number of columns.

```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5, 6},
    {7}
};
```

### Q30. What is the difference between 2D array and jagged array?
**Answer:**
- **2D Array**: All rows have same number of columns
- **Jagged Array**: Rows can have different number of columns

### Q31. How do you create a jagged array?
**Answer:**
```java
int[][] jagged = new int[3][];  // 3 rows, columns not specified
jagged[0] = new int[2];         // Row 0 has 2 columns
jagged[1] = new int[4];         // Row 1 has 4 columns
jagged[2] = new int[1];         // Row 2 has 1 column
```

### Q32. Why use jagged arrays?
**Answer:** Memory efficiency when rows have different sizes. Saves space compared to regular 2D arrays.

---

## 💡 Common Coding Questions

### Q33. Write a program to find the largest element in an array.
**Answer:**
```java
int[] arr = {10, 50, 30, 40, 20};
int max = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}
System.out.println("Maximum: " + max);
```

### Q34. Write a program to check if a number is even or odd.
**Answer:**
```java
int num = 7;
if (num % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

### Q35. Write a program to print numbers from 1 to 10.
**Answer:**
```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

### Q36. Write a program to find sum of array elements.
**Answer:**
```java
int[] arr = {10, 20, 30, 40, 50};
int sum = 0;
for (int num : arr) {
    sum += num;
}
System.out.println("Sum: " + sum);
```

### Q37. Write a program to reverse an array.
**Answer:**
```java
int[] arr = {10, 20, 30, 40, 50};
for (int i = arr.length - 1; i >= 0; i--) {
    System.out.print(arr[i] + " ");
}
```

---

## 🎯 Quick Tips for Interview

1. **Understand the question** before coding
2. **Think out loud** - explain your approach
3. **Start with simple solution** - optimize later
4. **Test with examples** - use sample inputs
5. **Handle edge cases** - empty arrays, negative numbers, etc.

---

## ⚡ Common Mistakes to Avoid

1. Forgetting to use `break` in switch
2. Off-by-one errors in loops (using `<` vs `<=`)
3. ArrayIndexOutOfBoundsException
4. Infinite loops (forgetting to update loop variable)
5. Confusing `arr.length` with `arr.length()`

---

## 📝 Practice Problems

1. Print all even numbers from 1 to 20
2. Find factorial of a number
3. Check if a number is prime
4. Print Fibonacci series
5. Find second largest element in array
6. Print a diamond pattern
7. Sum of diagonal elements in matrix
8. Count vowels in a string

---

**Remember:** Practice is key! Solve problems daily to build confidence. 🚀
