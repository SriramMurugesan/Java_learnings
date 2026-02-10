# Java Data Types

## 📚 What are Data Types?

Data types specify the **type of data** that a variable can hold. They tell the compiler how much memory to allocate and what operations can be performed on the data.

Think of data types as **containers** - just like you use different containers for water, rice, or books, Java uses different data types for numbers, text, or true/false values.

---

## 🔢 Categories of Data Types

Java has **two main categories** of data types:

```
Java Data Types
    |
    |-----> Primitive Data Types (8 types)
    |
    |-----> Non-Primitive Data Types (Reference Types)
```

---

## 1️⃣ Primitive Data Types

Primitive data types are the **most basic** data types in Java. They are **predefined** by the language and store simple values directly in memory.

### Characteristics:
- ✅ Store actual values
- ✅ Fixed size in memory
- ✅ Fast and efficient
- ✅ Start with lowercase letters
- ✅ Cannot be null

---

### 📊 The 8 Primitive Data Types

#### **A. Integer Types** (Whole Numbers)

| Type | Size | Range | Use Case |
|------|------|-------|----------|
| `byte` | 1 byte | -128 to 127 | Small numbers, saving memory |
| `short` | 2 bytes | -32,768 to 32,767 | Medium-range numbers |
| `int` | 4 bytes | -2 billion to 2 billion | Most common for whole numbers |
| `long` | 8 bytes | Very large range | Large numbers like population |

**Simple Explanation:**
- **byte**: Like a small box - holds tiny numbers
- **short**: Medium box - holds moderate numbers  
- **int**: Standard box - most commonly used for everyday numbers
- **long**: Extra-large box - for very big numbers

---

#### **B. Floating-Point Types** (Decimal Numbers)

| Type | Size | Precision | Use Case |
|------|------|-----------|----------|
| `float` | 4 bytes | 6-7 decimal digits | Decimal numbers (less precise) |
| `double` | 8 bytes | 15 decimal digits | Decimal numbers (more precise) |

**Simple Explanation:**
- **float**: Single-precision - good for basic decimal calculations
- **double**: Double-precision - better accuracy for scientific calculations

---

#### **C. Character Type** (Single Character)

| Type | Size | Range | Use Case |
|------|------|-------|----------|
| `char` | 2 bytes | 0 to 65,535 (Unicode) | Single letter, digit, or symbol |

**Simple Explanation:**
- Stores **one character** like 'A', '5', '@', '😊'
- Uses single quotes: `'a'`, `'Z'`, `'#'`

---

#### **D. Boolean Type** (True/False)

| Type | Size | Values | Use Case |
|------|------|--------|----------|
| `boolean` | 1 bit | `true` or `false` | Yes/No decisions, conditions |

**Simple Explanation:**
- Only two possible values: **true** or **false**
- Used for decision-making and conditions
- Like a light switch - either ON or OFF

---

### 🎯 Primitive Data Types Summary

```
Primitive Types (8)
    |
    |-----> Integer Types (4)
    |           |-----> byte
    |           |-----> short
    |           |-----> int
    |           |-----> long
    |
    |-----> Floating-Point Types (2)
    |           |-----> float
    |           |-----> double
    |
    |-----> Character Type (1)
    |           |-----> char
    |
    |-----> Boolean Type (1)
                |-----> boolean
```

---

## 2️⃣ Non-Primitive Data Types (Reference Types)

Non-primitive data types are **created by the programmer** and refer to objects. They are also called **reference types** because they store the memory address (reference) of the object, not the actual value.

### Characteristics:
- ✅ Store references (memory addresses)
- ✅ Can be null
- ✅ Start with uppercase letters
- ✅ Can call methods
- ✅ More complex than primitives
- ✅ Size is not fixed

---

### 📦 Types of Non-Primitive Data Types

#### **A. Strings**

**What is it?**  
A sequence of characters (text).

**Simple Explanation:**  
While `char` holds one character, `String` holds multiple characters together like a sentence or word.

**Example Use:**  
Names, addresses, messages, sentences

**Key Points:**
- Uses double quotes: `"Hello"`
- Immutable (cannot be changed once created)
- Most commonly used non-primitive type

---

#### **B. Arrays**

**What is it?**  
A collection of elements of the **same type** stored in contiguous memory.

**Simple Explanation:**  
Think of an array as a **row of boxes**, where each box holds the same type of item.

**Example Use:**  
List of numbers, collection of names, set of grades

**Key Points:**
- Fixed size (cannot grow or shrink)
- Index starts from 0
- Fast access to elements

---

#### **C. Classes**

**What is it?**  
A blueprint for creating objects. It defines properties and behaviors.

**Simple Explanation:**  
A class is like a **template** or **blueprint** for creating objects. For example, a "Car" class defines what properties (color, model) and actions (drive, brake) a car should have.

**Example Use:**  
Student, Employee, Book, Car - any real-world entity

**Key Points:**
- User-defined data types
- Can have variables (fields) and methods (functions)
- Objects are instances of classes

---

#### **D. Interfaces**

**What is it?**  
A contract that defines what methods a class must implement, without providing the implementation.

**Simple Explanation:**  
An interface is like a **job description** - it lists what tasks must be done, but not how to do them.

**Example Use:**  
Defining common behaviors across different classes

**Key Points:**
- Contains abstract methods (no body)
- A class can implement multiple interfaces
- Provides abstraction

---

#### **E. Enums**

**What is it?**  
A special data type that represents a group of constants (unchangeable values).

**Simple Explanation:**  
Enums are like a **fixed menu** - you can only choose from predefined options.

**Example Use:**  
Days of the week, months, directions (NORTH, SOUTH, EAST, WEST)

**Key Points:**
- Fixed set of values
- More readable than using numbers
- Type-safe

---

### 🎯 Non-Primitive Data Types Summary

```
Non-Primitive Types
    |
    |-----> String (text/sequence of characters)
    |
    |-----> Arrays (collection of same type)
    |
    |-----> Classes (user-defined blueprints)
    |
    |-----> Interfaces (contracts for classes)
    |
    |-----> Enums (fixed set of constants)
```

---

## 🆚 Primitive vs Non-Primitive Comparison

| Feature | Primitive | Non-Primitive |
|---------|-----------|---------------|
| **Definition** | Predefined by Java | Created by programmer |
| **Storage** | Stores actual value | Stores reference (address) |
| **Size** | Fixed size | Variable size |
| **Default Value** | 0, false, '\u0000' | null |
| **Naming** | Lowercase (int, char) | Uppercase (String, Array) |
| **Can be null?** | ❌ No | ✅ Yes |
| **Methods** | ❌ No methods | ✅ Has methods |
| **Examples** | int, boolean, char | String, Arrays, Classes |
| **Memory** | Stack memory | Heap memory |
| **Speed** | Faster | Slower |

---

## 🧠 Memory Representation

### Primitive Types (Direct Storage)
```
Variable: int a = 10
Memory: [a] → [10]
        (stores actual value)
```

### Non-Primitive Types (Reference Storage)
```
Variable: String name = "Java"
Memory: [name] → [0x1234] → ["Java"]
        (stores address)  (actual object in heap)
```

---

## 💡 Key Differences Explained Simply

### 1. **Value vs Reference**
- **Primitive**: Like writing a number directly on a sticky note
- **Non-Primitive**: Like writing the address of a house on a sticky note

### 2. **Null Assignment**
- **Primitive**: Cannot be empty (always has a default value)
- **Non-Primitive**: Can be null (no object assigned)

### 3. **Methods**
- **Primitive**: Just a value, no actions
- **Non-Primitive**: Can perform actions (methods)

### 4. **Memory Efficiency**
- **Primitive**: Takes less memory, faster
- **Non-Primitive**: Takes more memory, slower

---

## 📝 Default Values

### Primitive Types
- **byte, short, int, long** → `0`
- **float, double** → `0.0`
- **char** → `'\u0000'` (null character)
- **boolean** → `false`

### Non-Primitive Types
- All reference types → `null`

---

## 🎯 When to Use What?

### Use Primitive Types When:
- ✅ You need simple values (numbers, true/false)
- ✅ Performance is critical
- ✅ Memory efficiency matters
- ✅ You're doing mathematical calculations

### Use Non-Primitive Types When:
- ✅ You need to store complex data
- ✅ You need to use methods
- ✅ You need null values
- ✅ You're working with collections or objects

---

## 🌟 Summary

1. **Primitive Types** = Simple, fast, store actual values (8 types)
2. **Non-Primitive Types** = Complex, flexible, store references
3. **Primitive** = lowercase, **Non-Primitive** = Uppercase
4. **Primitive** cannot be null, **Non-Primitive** can be null
5. Choose based on your needs: simplicity vs functionality

---

## 🔍 Real-World Analogy

**Primitive Types** = Basic ingredients (flour, sugar, eggs)  
**Non-Primitive Types** = Complete dishes (cake, cookies, bread)

You use basic ingredients for simple needs, but combine them into complex dishes for complete meals!

---

**Remember:** Understanding data types is fundamental to Java programming. Choose the right type for the right job! 🚀
