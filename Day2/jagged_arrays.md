# Jagged Arrays in Java

## 📚 What is a Jagged Array?

A **Jagged Array** (also called **Ragged Array**) is a 2D array where each row can have a **different number of columns**.

Think of a jagged array as a **staircase** - each step can have a different width!

---

## 🎯 Regular 2D Array vs Jagged Array

### Regular 2D Array:
```
All rows have same number of columns

[1] [2] [3]
[4] [5] [6]
[7] [8] [9]
```

### Jagged Array:
```
Rows have different number of columns

[1] [2]
[3] [4] [5] [6]
[7]
```

---

## 📝 Syntax

### Declaration and Initialization:

#### Method 1: Direct Initialization
```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5, 6},
    {7}
};
```

#### Method 2: Step-by-Step
```java
// Step 1: Declare with number of rows only
int[][] jagged = new int[3][];  // 3 rows, columns not specified

// Step 2: Define each row separately
jagged[0] = new int[2];      // Row 0 has 2 columns
jagged[1] = new int[4];      // Row 1 has 4 columns
jagged[2] = new int[1];      // Row 2 has 1 column

// Step 3: Assign values
jagged[0][0] = 1;
jagged[0][1] = 2;
jagged[1][0] = 3;
// ... and so on
```

---

## 📊 Visual Representation

### Example:
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};
```

### Table View:
```
Row 0: [1] [2] [3]
Row 1: [4] [5]
Row 2: [6] [7] [8] [9]
```

### Memory Layout:
```
jagged[0] → [1, 2, 3]
jagged[1] → [4, 5]
jagged[2] → [6, 7, 8, 9]
```

---

## 🔢 Accessing Elements

### Syntax: `arrayName[row][column]`

```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

System.out.println(jagged[0][0]);  // 1
System.out.println(jagged[0][2]);  // 3
System.out.println(jagged[1][1]);  // 5
System.out.println(jagged[2][3]);  // 9

// This would cause error!
// System.out.println(jagged[1][2]);  // Row 1 has only 2 elements (0, 1)
```

---

## 🔄 Iterating Through Jagged Arrays

### Method 1: Nested for Loop
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {  // Use jagged[i].length
        System.out.print(jagged[i][j] + " ");
    }
    System.out.println();
}
```

**Output:**
```
1 2 3 
4 5 
6 7 8 9 
```

**Key Point:** Use `jagged[i].length` for each row's length, not a fixed value!

### Method 2: Enhanced for Loop
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

for (int[] row : jagged) {
    for (int element : row) {
        System.out.print(element + " ");
    }
    System.out.println();
}
```

---

## 📏 Getting Dimensions

### Number of Rows:
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

int rows = jagged.length;  // 3
System.out.println("Number of rows: " + rows);
```

### Length of Each Row:
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

for (int i = 0; i < jagged.length; i++) {
    System.out.println("Row " + i + " length: " + jagged[i].length);
}
```

**Output:**
```
Row 0 length: 3
Row 1 length: 2
Row 2 length: 4
```

---

## 📊 Common Operations

### 1. **Sum of All Elements**
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

int sum = 0;
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        sum += jagged[i][j];
    }
}
System.out.println("Sum: " + sum);  // 45
```

### 2. **Finding Maximum Element**
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

int max = jagged[0][0];
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        if (jagged[i][j] > max) {
            max = jagged[i][j];
        }
    }
}
System.out.println("Maximum: " + max);  // 9
```

### 3. **Counting Total Elements**
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5},
    {6, 7, 8, 9}
};

int count = 0;
for (int i = 0; i < jagged.length; i++) {
    count += jagged[i].length;
}
System.out.println("Total elements: " + count);  // 9
```

---

## 📝 Taking Input for Jagged Arrays

### Using Scanner:
```java
import java.util.Scanner;

Scanner scn = new Scanner(System.in);

System.out.print("Enter number of rows: ");
int rows = scn.nextInt();

int[][] jagged = new int[rows][];

for (int i = 0; i < rows; i++) {
    System.out.print("Enter number of columns for row " + i + ": ");
    int cols = scn.nextInt();
    jagged[i] = new int[cols];
    
    System.out.println("Enter " + cols + " elements:");
    for (int j = 0; j < cols; j++) {
        jagged[i][j] = scn.nextInt();
    }
}

// Display
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        System.out.print(jagged[i][j] + " ");
    }
    System.out.println();
}
```

---

## 🎯 Why Use Jagged Arrays?

### Advantages:
1. **Memory Efficiency**
   - Save memory when rows have different sizes
   - No wasted space

2. **Flexibility**
   - Each row can have different length
   - Useful for irregular data

3. **Real-World Scenarios**
   - Student grades (different number of subjects)
   - Monthly data (different days per month)
   - Hierarchical data

---

## 💡 Regular vs Jagged Array

### Memory Comparison:

#### Regular 2D Array (3x4):
```java
int[][] regular = new int[3][4];  // 12 elements total
```
```
[0] [0] [0] [0]
[0] [0] [0] [0]
[0] [0] [0] [0]
```
**Memory:** 12 integers (even if you only need 6)

#### Jagged Array:
```java
int[][] jagged = {
    {0, 0},
    {0, 0},
    {0, 0}
};  // 6 elements total
```
```
[0] [0]
[0] [0]
[0] [0]
```
**Memory:** 6 integers (exactly what you need)

---

## ⚠️ Common Errors

### 1. **Assuming Fixed Column Size**
```java
int[][] jagged = {
    {1, 2, 3},
    {4, 5}
};

// Wrong - assumes all rows have 3 columns
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < 3; j++) {  // ERROR for row 1!
        System.out.print(jagged[i][j]);
    }
}

// Correct - use actual row length
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        System.out.print(jagged[i][j]);
    }
}
```

### 2. **Not Initializing Rows**
```java
int[][] jagged = new int[3][];  // Only rows declared

jagged[0][0] = 1;  // ERROR! Row 0 not initialized yet

// Correct
jagged[0] = new int[2];  // Initialize row 0 first
jagged[0][0] = 1;        // Now OK
```

---

## 🌟 Summary

1. **Jagged Array** = 2D array with rows of different lengths
2. **Declaration** = `int[][] arr = new int[rows][];`
3. **Each row** = Initialized separately with different sizes
4. **Access** = `arr[row][column]` (same as regular 2D)
5. **Iteration** = Use `arr[i].length` for each row
6. **Advantage** = Memory efficient for irregular data

---

## 🔍 Real-World Analogy

**Jagged Array** = Apartment building with different floor plans

- **Regular 2D Array**: All apartments have same number of rooms
- **Jagged Array**: Each apartment has different number of rooms
  - Floor 1: 2 rooms
  - Floor 2: 4 rooms
  - Floor 3: 1 room

---

## 📝 Best Practices

1. **Always use `arr[i].length`**
   ```java
   for (int j = 0; j < jagged[i].length; j++) {
       // Safe for any row length
   }
   ```

2. **Initialize rows before use**
   ```java
   int[][] jagged = new int[3][];
   jagged[0] = new int[2];  // Initialize first
   jagged[0][0] = 10;       // Then use
   ```

3. **Use when data is irregular**
   - Don't use jagged arrays if all rows have same length
   - Use regular 2D arrays for uniform data

---

**Remember:** Jagged arrays are perfect when you need flexibility in row sizes! 🚀
