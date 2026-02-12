# Mutable Strings in Java

## 🔓 What are Mutable Strings?

**Mutable** means **"can be changed"**. Unlike the String class, mutable strings can be modified without creating new objects.

Think of mutable strings like a **whiteboard** - you can erase and rewrite as many times as you want! 🖍️

---

## 🎯 Why Do We Need Mutable Strings?

### Problem with Immutable Strings:
```java
String result = "";
for (int i = 0; i < 1000; i++) {
    result = result + i;  // Creates 1000 new objects! ❌
}
// Slow and memory-intensive!
```

### Solution: Mutable Strings
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Modifies same object! ✅
}
String result = sb.toString();
// Fast and memory-efficient!
```

---

## 📦 Two Mutable String Classes in Java

Java provides **two classes** for mutable strings:

```
Mutable Strings
    |
    |-----> StringBuilder (Faster, not thread-safe)
    |
    |-----> StringBuffer (Slower, thread-safe)
```

---

## 1️⃣ StringBuilder Class

### What is it?
A **mutable** sequence of characters that can be modified efficiently.

### Key Features:
- ✅ **Mutable** - Can be changed without creating new objects
- ✅ **Fast** - No synchronization overhead
- ❌ **Not thread-safe** - Not safe for concurrent access
- ✅ **Recommended** for single-threaded applications

### When to Use:
- Building strings in loops
- Frequent string modifications
- Single-threaded environment
- Performance is critical

### Basic Syntax:
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();  // "Hello World"
```

---

## 2️⃣ StringBuffer Class

### What is it?
A **mutable** sequence of characters that is **thread-safe** (synchronized).

### Key Features:
- ✅ **Mutable** - Can be changed without creating new objects
- ✅ **Thread-safe** - Safe for concurrent access
- ❌ **Slower** - Synchronization adds overhead
- ✅ **Legacy class** - Exists since Java 1.0

### When to Use:
- Multi-threaded environment
- When thread-safety is required
- Legacy code compatibility

### Basic Syntax:
```java
StringBuffer sb = new StringBuffer();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();  // "Hello World"
```

---

## 🆚 StringBuilder vs StringBuffer

| Feature | StringBuilder | StringBuffer |
|---------|---------------|--------------|
| **Mutability** | Mutable ✅ | Mutable ✅ |
| **Thread-Safe** | No ❌ | Yes ✅ |
| **Performance** | Faster ⚡ | Slower 🐢 |
| **Synchronization** | Not synchronized | Synchronized |
| **Introduced** | Java 5 (2004) | Java 1.0 (1996) |
| **Use Case** | Single-threaded | Multi-threaded |
| **Recommended** | Yes (for most cases) | Only when thread-safety needed |

### Simple Rule:
- **Use StringBuilder** - 99% of the time (default choice)
- **Use StringBuffer** - Only when multiple threads access the same object

---

## 🛠️ Common Methods (StringBuilder & StringBuffer)

Both classes have the **same methods**. Here are the most important ones:

### 1. **append()** - Add to End
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // "Hello World"
sb.append("!");       // "Hello World!"
```

**Supports method chaining:**
```java
StringBuilder sb = new StringBuilder();
sb.append("Java").append(" ").append("Programming");
// "Java Programming"
```

### 2. **insert()** - Insert at Position
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.insert(6, "Beautiful ");  // "Hello Beautiful World"
//        ↑ index 6
```

### 3. **delete()** - Remove Characters
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.delete(5, 11);  // "Hello"
//        ↑   ↑
//      start end (exclusive)
```

### 4. **deleteCharAt()** - Remove Single Character
```java
StringBuilder sb = new StringBuilder("Hello");
sb.deleteCharAt(1);  // "Hllo"
//              ↑ index 1
```

### 5. **reverse()** - Reverse the String
```java
StringBuilder sb = new StringBuilder("Hello");
sb.reverse();  // "olleH"
```

### 6. **replace()** - Replace Range
```java
StringBuilder sb = new StringBuilder("Hello World");
sb.replace(6, 11, "Java");  // "Hello Java"
//         ↑   ↑
//       start end (exclusive)
```

### 7. **substring()** - Extract Part (Returns String)
```java
StringBuilder sb = new StringBuilder("Hello World");
String sub = sb.substring(0, 5);  // "Hello"
// Note: Returns String, doesn't modify StringBuilder
```

### 8. **charAt()** - Get Character at Index
```java
StringBuilder sb = new StringBuilder("Hello");
char ch = sb.charAt(0);  // 'H'
```

### 9. **setCharAt()** - Change Character at Index
```java
StringBuilder sb = new StringBuilder("Hello");
sb.setCharAt(0, 'J');  // "Jello"
```

### 10. **length()** - Get Current Length
```java
StringBuilder sb = new StringBuilder("Hello");
int len = sb.length();  // 5
```

### 11. **capacity()** - Get Current Capacity
```java
StringBuilder sb = new StringBuilder();
int cap = sb.capacity();  // 16 (default)
```

### 12. **toString()** - Convert to String
```java
StringBuilder sb = new StringBuilder("Hello");
String str = sb.toString();  // "Hello" (immutable String)
```

---

## 📊 Method Chaining

StringBuilder and StringBuffer support **method chaining** for cleaner code:

```java
// Without chaining
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" ");
sb.append("is");
sb.append(" ");
sb.append("awesome");

// With chaining (cleaner!)
StringBuilder sb = new StringBuilder();
sb.append("Java").append(" ").append("is").append(" ").append("awesome");

// Even cleaner
String result = new StringBuilder()
    .append("Java")
    .append(" is ")
    .append("awesome")
    .toString();
```

---

## 💾 Capacity and Memory Management

### Initial Capacity:
```java
StringBuilder sb1 = new StringBuilder();  // Capacity: 16
StringBuilder sb2 = new StringBuilder(50);  // Capacity: 50
StringBuilder sb3 = new StringBuilder("Hello");  // Capacity: 16 + 5 = 21
```

### How Capacity Works:
- **Default capacity**: 16 characters
- When exceeded, capacity **doubles + 2**
- Example: 16 → 34 → 70 → 142...

### Why Capacity Matters:
```java
// Good: Pre-allocate if you know the size
StringBuilder sb = new StringBuilder(1000);
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
// No resizing needed!

// Less efficient: Multiple resizings
StringBuilder sb = new StringBuilder();  // Starts at 16
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Will resize multiple times
}
```

---

## ⚡ Performance Comparison

### String vs StringBuilder (1000 concatenations):

```java
// String (Immutable) - SLOW ❌
long start = System.currentTimeMillis();
String s = "";
for (int i = 0; i < 1000; i++) {
    s = s + i;  // Creates 1000 objects!
}
long end = System.currentTimeMillis();
System.out.println("String: " + (end - start) + "ms");
// Output: ~15-20ms (varies by system)

// StringBuilder (Mutable) - FAST ✅
start = System.currentTimeMillis();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Modifies same object!
}
String result = sb.toString();
end = System.currentTimeMillis();
System.out.println("StringBuilder: " + (end - start) + "ms");
// Output: ~1-2ms (varies by system)
```

**Result:** StringBuilder is **10-20x faster** for concatenation in loops! 🚀

---

## 🎯 When to Use Each Type

### Use **String** when:
- ✅ Value won't change
- ✅ Need thread-safety without synchronization
- ✅ Need to use as HashMap/HashSet key
- ✅ Need String Pool benefits

### Use **StringBuilder** when:
- ✅ Building strings in loops
- ✅ Frequent modifications needed
- ✅ Single-threaded environment
- ✅ Performance is important

### Use **StringBuffer** when:
- ✅ Multiple threads access same object
- ✅ Thread-safety is required
- ✅ Working with legacy code

---

## 📋 Complete Comparison Table

| Feature | String | StringBuilder | StringBuffer |
|---------|--------|---------------|--------------|
| **Mutability** | Immutable | Mutable | Mutable |
| **Thread-Safe** | Yes | No | Yes |
| **Performance** | Slow (for modifications) | Fast | Medium |
| **Memory** | Uses String Pool | Heap only | Heap only |
| **Use Case** | Fixed text | Single-threaded building | Multi-threaded building |
| **Synchronization** | N/A | No | Yes |
| **Storage** | String Pool + Heap | Heap | Heap |

---

## 💡 Best Practices

### 1. **Choose the Right Type**
```java
// Fixed text - use String
String name = "John";

// Building in loop - use StringBuilder
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 100; i++) {
    sb.append(i);
}

// Multi-threaded - use StringBuffer
StringBuffer buffer = new StringBuffer();
// Multiple threads can safely append
```

### 2. **Pre-allocate Capacity if Known**
```java
// Good
StringBuilder sb = new StringBuilder(1000);

// Less efficient
StringBuilder sb = new StringBuilder();  // Will resize multiple times
```

### 3. **Convert to String When Done**
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" World");
String result = sb.toString();  // Convert once at the end
```

### 4. **Use Method Chaining**
```java
String result = new StringBuilder()
    .append("First")
    .append(" ")
    .append("Last")
    .toString();
```

---

## 🔍 Real-World Analogy

### String (Immutable) = **Printed Book** 📖
- Once printed, can't change
- Need new book for different content

### StringBuilder = **Whiteboard** 🖍️
- Erase and rewrite freely
- Fast and flexible
- One person at a time

### StringBuffer = **Shared Whiteboard with Lock** 🔒
- Multiple people can use it
- Only one person writes at a time
- Slower due to coordination

---

## 🌟 Summary

1. **StringBuilder** and **StringBuffer** are **mutable** alternatives to String
2. **StringBuilder** is **faster** but **not thread-safe**
3. **StringBuffer** is **thread-safe** but **slower**
4. Use **StringBuilder** for most cases (99% of the time)
5. Both support **method chaining** for cleaner code
6. Much **faster** than String for concatenation in loops
7. **Pre-allocate capacity** if you know the size
8. Convert to **String** with `toString()` when done

---

**Remember:** Use StringBuilder for efficient string building - your code will thank you! 🚀
