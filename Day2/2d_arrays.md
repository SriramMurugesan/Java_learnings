# 2D Arrays in Java

## 📚 What is a 2D Array?

A **2D (Two-Dimensional) Array** is an array of arrays. It stores data in a **table format** with rows and columns.

Think of a 2D array as a **spreadsheet** or **matrix** - data organized in rows and columns!

---

## 🎯 Syntax

### 1. **Declaration**
```java
dataType[][] arrayName;
// OR
dataType arrayName[][];
```

**Examples:**
```java
int[][] matrix;
String[][] table;
double[][] grid;
```

### 2. **Initialization**

#### Method 1: Declare and Allocate Memory
```java
int[][] matrix = new int[3][4];  // 3 rows, 4 columns
```

#### Method 2: Declare and Initialize with Values
```java
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};
```

#### Method 3: Separate Steps
```java
int[][] matrix;              // Declaration
matrix = new int[3][4];      // Memory allocation
matrix[0][0] = 1;            // Assignment
matrix[0][1] = 2;
```

---

## 📊 Visual Representation

### Example Array:
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Table View:
```
       Col 0  Col 1  Col 2
Row 0    1      2      3
Row 1    4      5      6
Row 2    7      8      9
```

### Index Notation:
```
matrix[0][0] = 1    matrix[0][1] = 2    matrix[0][2] = 3
matrix[1][0] = 4    matrix[1][1] = 5    matrix[1][2] = 6
matrix[2][0] = 7    matrix[2][1] = 8    matrix[2][2] = 9
```

---

## 🔢 Accessing Elements

### Syntax: `arrayName[row][column]`

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[0][0]);  // 1 (first row, first column)
System.out.println(matrix[1][2]);  // 6 (second row, third column)
System.out.println(matrix[2][1]);  // 8 (third row, second column)
```

---

## 🔄 Iterating Through 2D Arrays

### Method 1: Nested for Loop
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matrix.length; i++) {           // Rows
    for (int j = 0; j < matrix[i].length; j++) {    // Columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();  // New line after each row
}
```

**Output:**
```
1 2 3 
4 5 6 
7 8 9 
```

### Method 2: Enhanced for Loop (for-each)
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int[] row : matrix) {        // Each row
    for (int element : row) {     // Each element in row
        System.out.print(element + " ");
    }
    System.out.println();
}
```

---

## 📏 Array Dimensions

### Getting Dimensions:
```java
int[][] matrix = new int[3][4];  // 3 rows, 4 columns

int rows = matrix.length;           // 3 (number of rows)
int columns = matrix[0].length;     // 4 (number of columns)

System.out.println("Rows: " + rows);
System.out.println("Columns: " + columns);
```

---

## 📊 Common Operations

### 1. **Sum of All Elements**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

int sum = 0;
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        sum += matrix[i][j];
    }
}
System.out.println("Sum: " + sum);  // 45
```

### 2. **Sum of Each Row**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matrix.length; i++) {
    int rowSum = 0;
    for (int j = 0; j < matrix[i].length; j++) {
        rowSum += matrix[i][j];
    }
    System.out.println("Row " + i + " sum: " + rowSum);
}
```

**Output:**
```
Row 0 sum: 6
Row 1 sum: 15
Row 2 sum: 24
```

### 3. **Sum of Each Column**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

int columns = matrix[0].length;
for (int j = 0; j < columns; j++) {
    int colSum = 0;
    for (int i = 0; i < matrix.length; i++) {
        colSum += matrix[i][j];
    }
    System.out.println("Column " + j + " sum: " + colSum);
}
```

**Output:**
```
Column 0 sum: 12
Column 1 sum: 15
Column 2 sum: 18
```

### 4. **Transpose of Matrix**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

int rows = matrix.length;
int cols = matrix[0].length;
int[][] transpose = new int[cols][rows];

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        transpose[j][i] = matrix[i][j];
    }
}
```

**Original:**
```
1 2 3
4 5 6
```

**Transpose:**
```
1 4
2 5
3 6
```

---

## 📝 Taking Input for 2D Arrays

### Using Scanner:
```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);
int[][] matrix = new int[3][3];

System.out.println("Enter 9 elements:");
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        matrix[i][j] = scn.nextInt();
    }
}

// Display
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 🎯 Special Cases

### 1. **Square Matrix**
Equal rows and columns (3x3, 4x4, etc.)
```java
int[][] square = new int[5][5];  // 5 rows, 5 columns
```

### 2. **Rectangular Matrix**
Different rows and columns (3x4, 2x5, etc.)
```java
int[][] rect = new int[3][4];  // 3 rows, 4 columns
```

### 3. **Diagonal Elements** (Square Matrix)
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println("Diagonal elements:");
for (int i = 0; i < matrix.length; i++) {
    System.out.print(matrix[i][i] + " ");  // 1, 5, 9
}
```

---

## 💡 Important Points

1. **2D Array = Array of Arrays**
   - `matrix[i]` gives you the entire row i
   - `matrix[i][j]` gives you element at row i, column j

2. **Rows can have different lengths** (Jagged Arrays)
   - Regular 2D: All rows same length
   - Jagged: Rows can have different lengths

3. **Memory Layout**
   - Rows are stored separately
   - Not truly contiguous like 1D arrays

4. **Default Values**
   - Same as 1D arrays (0 for int, null for objects, etc.)

---

## ⚠️ Common Errors

### 1. **Wrong Index Order**
```java
// Wrong
matrix[column][row]

// Correct
matrix[row][column]
```

### 2. **ArrayIndexOutOfBoundsException**
```java
int[][] matrix = new int[3][4];
matrix[3][0] = 10;  // ERROR! Row 3 doesn't exist (0, 1, 2 only)
```

---

## 🌟 Summary

1. **2D Array** = Table with rows and columns
2. **Declaration** = `int[][] arr;`
3. **Initialization** = `int[][] arr = new int[3][4];`
4. **Access** = `arr[row][column]`
5. **Rows** = `arr.length`
6. **Columns** = `arr[0].length`
7. **Iteration** = Nested loops (outer for rows, inner for columns)

---

## 🔍 Real-World Analogy

**2D Array** = Seating arrangement in a cinema

- **Rows**: Horizontal rows of seats
- **Columns**: Vertical columns of seats
- **Index**: Row number + Seat number (e.g., Row 2, Seat 5)
- **Access**: Go to specific row, then specific seat
- **Fixed Size**: Cinema has fixed rows and seats per row

---

## 📝 Best Practices

1. **Use meaningful names**
   ```java
   int[][] studentGrades;  // Good
   int[][] arr;            // Bad
   ```

2. **Check bounds**
   ```java
   if (i < matrix.length && j < matrix[i].length) {
       System.out.println(matrix[i][j]);
   }
   ```

3. **Use nested loops systematically**
   - Outer loop: rows
   - Inner loop: columns

---

**Remember:** 2D arrays are perfect for representing tables, grids, and matrices! 🚀
