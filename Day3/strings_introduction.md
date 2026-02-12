# Strings Introduction in Java

## 📚 What is a String?

A **String** is a sequence of characters. In Java, strings are used to store and manipulate text data like names, addresses, messages, etc.

Think of a String as a **chain of letters** - just like beads on a necklace! 📿

### Examples of Strings:
- `"Hello World"`
- `"Java Programming"`
- `"12345"`
- `"user@email.com"`

---

## 🔍 String: Class vs Primitive Type

### Important Concept:
In Java, **String is NOT a primitive data type** - it's a **class**!

| Primitive Types | String (Class) |
|-----------------|----------------|
| int, char, boolean, double | String |
| Stored directly in memory | Stored as objects |
| No methods | Has many built-in methods |
| Example: `int x = 5;` | Example: `String name = "John";` |

### Why is String a Class?
- Strings need **complex operations** (searching, replacing, splitting)
- Strings need to be **flexible** in size
- Strings need **special memory management** (String Pool)

---

## 🎯 Two Ways to Create Strings

### 1️⃣ String Literal (Recommended)
```java
String name = "Java";
```

**How it works:**
- Java checks the **String Pool** (special memory area)
- If "Java" already exists, it reuses that memory
- If not, it creates a new string in the pool
- **Memory efficient!** ✅

### 2️⃣ Using `new` Keyword
```java
String name = new String("Java");
```

**How it works:**
- Always creates a **new object** in heap memory
- Does NOT check String Pool first
- **Less memory efficient** ❌
- Use only when you specifically need a new object

---

## 🏊 What is String Pool?

The **String Pool** is a special memory area where Java stores string literals to save memory.

### Visual Representation:
```
String Pool (Special Memory Area)
┌─────────────────────────────┐
│  "Hello"                    │
│  "Java"                     │
│  "Programming"              │
└─────────────────────────────┘

Heap Memory (Regular Objects)
┌─────────────────────────────┐
│  new String("Hello")        │
│  new String("World")        │
└─────────────────────────────┘
```

### Example:
```java
String s1 = "Hello";  // Created in String Pool
String s2 = "Hello";  // Reuses same "Hello" from pool
String s3 = new String("Hello");  // New object in heap

// s1 and s2 point to SAME memory location
// s3 points to DIFFERENT memory location
```

**Benefit:** Saves memory by reusing common strings! 💾

---

## 🛠️ Common String Operations

### 1. **Finding Length**
```java
String text = "Hello";
int len = text.length();  // Returns 5
```

### 2. **Accessing Characters**
```java
String text = "Java";
char ch = text.charAt(0);  // Returns 'J'
```

### 3. **Concatenation (Joining Strings)**
```java
String first = "Hello";
String second = "World";
String result = first + " " + second;  // "Hello World"
```

### 4. **Comparing Strings**
```java
String s1 = "Java";
String s2 = "Java";

// Wrong way (compares memory addresses)
if (s1 == s2) { }

// Correct way (compares content)
if (s1.equals(s2)) { }
```

---

## ⚠️ String Comparison: `==` vs `equals()`

### `==` Operator
- Compares **memory addresses** (reference)
- Checks if both variables point to the **same object**

### `equals()` Method
- Compares **actual content** (characters)
- Checks if both strings have the **same text**

### Example:
```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");

System.out.println(s1 == s2);        // true (same pool reference)
System.out.println(s1 == s3);        // false (different objects)
System.out.println(s1.equals(s3));   // true (same content)
```

**Rule:** Always use `equals()` to compare string content! ✅

---

## 📋 Most Useful String Methods

| Method | Description | Example |
|--------|-------------|---------|
| `length()` | Returns string length | `"Java".length()` → 4 |
| `charAt(index)` | Returns character at index | `"Java".charAt(0)` → 'J' |
| `concat(str)` | Joins two strings | `"Hello".concat(" World")` |
| `equals(str)` | Compares content | `"Java".equals("Java")` → true |
| `equalsIgnoreCase(str)` | Compares ignoring case | `"Java".equalsIgnoreCase("java")` → true |
| `toUpperCase()` | Converts to uppercase | `"java".toUpperCase()` → "JAVA" |
| `toLowerCase()` | Converts to lowercase | `"JAVA".toLowerCase()` → "java" |
| `trim()` | Removes leading/trailing spaces | `" Java ".trim()` → "Java" |
| `substring(start, end)` | Extracts part of string | `"Hello".substring(0, 3)` → "Hel" |
| `replace(old, new)` | Replaces characters | `"Java".replace('a', 'o')` → "Jovo" |
| `contains(str)` | Checks if contains substring | `"Java".contains("av")` → true |
| `startsWith(str)` | Checks if starts with | `"Java".startsWith("Ja")` → true |
| `endsWith(str)` | Checks if ends with | `"Java".endsWith("va")` → true |
| `indexOf(str)` | Finds first occurrence | `"Java".indexOf('a')` → 1 |
| `split(delimiter)` | Splits into array | `"a,b,c".split(",")` → ["a","b","c"] |

---

## 🔗 String Concatenation

### Three Ways to Join Strings:

#### 1. Using `+` Operator
```java
String result = "Hello" + " " + "World";  // "Hello World"
```

#### 2. Using `concat()` Method
```java
String result = "Hello".concat(" ").concat("World");  // "Hello World"
```

#### 3. Using `StringBuilder` (Best for multiple concatenations)
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World");
String result = sb.toString();  // "Hello World"
```

**Performance Tip:** Use `StringBuilder` when concatenating in loops! 🚀

---

## 🌟 Key Characteristics of Strings

1. **Immutable** - Once created, cannot be changed (more on this in next section)
2. **Stored in String Pool** - For memory efficiency
3. **Thread-Safe** - Can be safely used in multi-threaded programs
4. **Final Class** - Cannot be inherited
5. **Implements CharSequence** - Can be used wherever CharSequence is expected

---

## 🔍 Real-World Analogy

**String** = A printed book 📖

- Once printed, you **can't change** the text (immutable)
- If you want different text, you need a **new book** (new String object)
- Multiple people can read the **same book** (String Pool reuse)
- You can **search** for words, **count** pages, **extract** chapters (String methods)

---

## 💡 Best Practices

### ✅ DO:
```java
// Use string literals
String name = "Java";

// Use equals() for comparison
if (name.equals("Java")) { }

// Use StringBuilder for multiple concatenations
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 100; i++) {
    sb.append(i);
}
```

### ❌ DON'T:
```java
// Avoid unnecessary new String()
String name = new String("Java");  // Wasteful!

// Don't use == for content comparison
if (name == "Java") { }  // Wrong!

// Don't use + in loops
String result = "";
for (int i = 0; i < 100; i++) {
    result = result + i;  // Very slow!
}
```

---

## 🎯 Summary

1. **String** is a class, not a primitive type
2. Create strings using **literals** (recommended) or `new` keyword
3. **String Pool** saves memory by reusing string literals
4. Use **`equals()`** to compare string content, not `==`
5. Strings have many **useful methods** for manipulation
6. Strings are **immutable** (cannot be changed after creation)
7. Use **StringBuilder** for efficient concatenation in loops

---

**Remember:** Strings are one of the most commonly used classes in Java - master them well! 🚀
