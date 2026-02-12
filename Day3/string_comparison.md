# String vs StringBuilder vs StringBuffer - Complete Comparison

## 📊 Quick Comparison Table

| Feature | String | StringBuilder | StringBuffer |
|---------|--------|---------------|--------------|
| **Mutability** | Immutable 🔒 | Mutable 🔓 | Mutable 🔓 |
| **Thread-Safe** | Yes ✅ | No ❌ | Yes ✅ |
| **Performance** | Slow for modifications 🐢 | Fast ⚡ | Medium 🚶 |
| **Memory** | String Pool + Heap | Heap only | Heap only |
| **Storage Location** | String Pool (literals) | Heap | Heap |
| **Synchronization** | Not applicable | Not synchronized | Synchronized |
| **Introduced** | Java 1.0 | Java 5 (1.5) | Java 1.0 |
| **Package** | java.lang | java.lang | java.lang |
| **Extends** | Object | AbstractStringBuilder | AbstractStringBuilder |
| **Implements** | Serializable, Comparable, CharSequence | Serializable, CharSequence | Serializable, CharSequence |

---

## 🎯 When to Use Each Type

### Use **String** When:

✅ **The value won't change**
```java
String name = "John";
String email = "user@example.com";
final String API_KEY = "abc123";
```

✅ **Need thread-safety without synchronization**
```java
// Safe to share across threads
public static final String CONFIG = "production";
```

✅ **Using as HashMap/HashSet key**
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);  // String is perfect for keys
```

✅ **Need String Pool benefits**
```java
String s1 = "Hello";  // Reuses from pool
String s2 = "Hello";  // Same object as s1
```

✅ **Working with literals**
```java
String message = "Welcome to Java!";
```

---

### Use **StringBuilder** When:

✅ **Building strings in loops**
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(",");
}
```

✅ **Frequent modifications needed**
```java
StringBuilder query = new StringBuilder("SELECT * FROM users");
query.append(" WHERE age > 18");
query.append(" AND active = true");
```

✅ **Single-threaded environment**
```java
// Local variable in a method
public String buildReport() {
    StringBuilder report = new StringBuilder();
    report.append("Report Header\n");
    // ... build report
    return report.toString();
}
```

✅ **Performance is critical**
```java
// Processing large amounts of text
StringBuilder result = new StringBuilder(10000);
// Pre-allocated capacity for efficiency
```

---

### Use **StringBuffer** When:

✅ **Multiple threads access the same object**
```java
public class Logger {
    private StringBuffer log = new StringBuffer();
    
    public synchronized void addLog(String message) {
        log.append(message).append("\n");
    }
}
```

✅ **Thread-safety is required**
```java
// Shared across threads
StringBuffer sharedBuffer = new StringBuffer();
// Multiple threads can safely append
```

✅ **Working with legacy code**
```java
// Old code that uses StringBuffer
// Keep using it for compatibility
```

---

## 🔍 Detailed Comparison

### 1. **Mutability**

#### String (Immutable):
```java
String s = "Hello";
s = s + " World";  // Creates NEW object
// Original "Hello" remains unchanged in memory
```

#### StringBuilder/StringBuffer (Mutable):
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // Modifies SAME object
// No new object created
```

---

### 2. **Thread-Safety**

#### String (Thread-Safe):
```java
// Multiple threads can safely read
public static final String CONSTANT = "Value";

// Thread 1
String s1 = CONSTANT;

// Thread 2
String s2 = CONSTANT;
// Both get same immutable object - safe!
```

#### StringBuilder (NOT Thread-Safe):
```java
StringBuilder sb = new StringBuilder();

// Thread 1
sb.append("A");

// Thread 2
sb.append("B");

// Result is UNPREDICTABLE! ❌
// Could be "AB", "BA", or corrupted
```

#### StringBuffer (Thread-Safe):
```java
StringBuffer sb = new StringBuffer();

// Thread 1
sb.append("A");

// Thread 2
sb.append("B");

// Result is PREDICTABLE ✅
// Will be either "AB" or "BA" (but not corrupted)
```

---

### 3. **Performance**

#### Concatenation Performance Test:
```java
int iterations = 10000;

// String - SLOWEST 🐢
long start = System.currentTimeMillis();
String s = "";
for (int i = 0; i < iterations; i++) {
    s = s + i;
}
long stringTime = System.currentTimeMillis() - start;

// StringBuilder - FASTEST ⚡
start = System.currentTimeMillis();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < iterations; i++) {
    sb.append(i);
}
long sbTime = System.currentTimeMillis() - start;

// StringBuffer - MEDIUM 🚶
start = System.currentTimeMillis();
StringBuffer sbf = new StringBuffer();
for (int i = 0; i < iterations; i++) {
    sbf.append(i);
}
long sbfTime = System.currentTimeMillis() - start;

// Typical results (10,000 iterations):
// String: ~500-1000ms
// StringBuilder: ~2-5ms
// StringBuffer: ~3-7ms
```

**Performance Ranking:**
1. 🥇 StringBuilder (fastest)
2. 🥈 StringBuffer (medium)
3. 🥉 String (slowest for modifications)

---

### 4. **Memory Usage**

#### String:
```java
String s1 = "Hello";  // String Pool
String s2 = "Hello";  // Reuses same object
String s3 = new String("Hello");  // Heap

// Memory: 2 objects (1 in pool, 1 in heap)
```

#### StringBuilder/StringBuffer:
```java
StringBuilder sb1 = new StringBuilder("Hello");
StringBuilder sb2 = new StringBuilder("Hello");

// Memory: 2 separate objects in heap
// No pooling mechanism
```

---

### 5. **Methods Comparison**

| Method | String | StringBuilder | StringBuffer |
|--------|--------|---------------|--------------|
| `append()` | ❌ | ✅ | ✅ |
| `insert()` | ❌ | ✅ | ✅ |
| `delete()` | ❌ | ✅ | ✅ |
| `reverse()` | ❌ | ✅ | ✅ |
| `replace()` | ✅ (returns new) | ✅ (modifies) | ✅ (modifies) |
| `substring()` | ✅ (returns new) | ✅ (returns String) | ✅ (returns String) |
| `concat()` | ✅ (returns new) | ❌ | ❌ |
| `charAt()` | ✅ | ✅ | ✅ |
| `length()` | ✅ | ✅ | ✅ |
| `toString()` | ❌ (already String) | ✅ | ✅ |

---

## 🎓 Decision Flow Chart

```
Need to work with text?
    |
    ├─→ Will it change?
    |       |
    |       ├─→ NO → Use String
    |       |
    |       └─→ YES → Multiple threads?
    |                   |
    |                   ├─→ NO → Use StringBuilder ⭐
    |                   |
    |                   └─→ YES → Use StringBuffer
    |
    └─→ Just storing/passing around?
            |
            └─→ Use String
```

---

## 💡 Best Practices

### 1. **Default Choice: String**
```java
// For simple, unchanging text
String name = "Alice";
String message = "Hello World";
```

### 2. **Building Strings: StringBuilder**
```java
// For constructing strings
StringBuilder html = new StringBuilder();
html.append("<html>")
    .append("<body>")
    .append("Content")
    .append("</body>")
    .append("</html>");
```

### 3. **Avoid String Concatenation in Loops**
```java
// ❌ BAD
String result = "";
for (int i = 0; i < 100; i++) {
    result += i;  // Creates 100 objects!
}

// ✅ GOOD
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 100; i++) {
    sb.append(i);  // Modifies same object
}
String result = sb.toString();
```

### 4. **Pre-allocate Capacity**
```java
// If you know approximate size
StringBuilder sb = new StringBuilder(1000);
// Avoids multiple resizing operations
```

### 5. **Convert to String When Done**
```java
StringBuilder sb = new StringBuilder();
// ... build string
String final = sb.toString();  // Convert once at end
```

---

## 📈 Performance Characteristics

### Time Complexity:

| Operation | String | StringBuilder | StringBuffer |
|-----------|--------|---------------|--------------|
| **Concatenation** | O(n²) in loop | O(n) | O(n) |
| **charAt()** | O(1) | O(1) | O(1) |
| **substring()** | O(n) | O(n) | O(n) |
| **length()** | O(1) | O(1) | O(1) |

### Space Complexity:

| Type | Space Usage |
|------|-------------|
| **String** | O(n) per concatenation |
| **StringBuilder** | O(n) total (amortized) |
| **StringBuffer** | O(n) total (amortized) |

---

## 🌟 Summary

### String:
- **Use for:** Fixed text, constants, HashMap keys
- **Pros:** Thread-safe, String Pool, simple
- **Cons:** Slow for modifications, creates many objects

### StringBuilder:
- **Use for:** Building strings, loops, single-threaded
- **Pros:** Fast, mutable, efficient
- **Cons:** Not thread-safe

### StringBuffer:
- **Use for:** Multi-threaded string building
- **Pros:** Thread-safe, mutable
- **Cons:** Slower than StringBuilder

---

## 🎯 Quick Reference

**90% of the time:** Use **String** for storage, **StringBuilder** for building

**Rare cases:** Use **StringBuffer** only when thread-safety is required

**Golden Rule:** 
- String = **Read-only text** 📖
- StringBuilder = **Building text (fast)** 🏗️
- StringBuffer = **Building text (thread-safe)** 🔒

---

**Remember:** Choose the right tool for the job - your code will be faster and cleaner! 🚀
