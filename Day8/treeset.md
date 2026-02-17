# TreeSet

## What is TreeSet?

**TreeSet** is a sorted set that stores unique elements in ascending order. It uses a Red-Black tree structure.

### Simple Analogy
Think of TreeSet as a **sorted bookshelf**:
- Books arranged alphabetically
- No duplicate books
- Easy to find books in order

---

## Key Features

✅ **Sorted**: Elements in natural ascending order  
✅ **No Duplicates**: Each element appears only once  
✅ **No Null**: Cannot store null (throws exception)  
✅ **Slower than HashSet**: O(log n) operations  
✅ **Implements NavigableSet**: Additional navigation methods  

---

## Syntax

```java
import java.util.TreeSet;

// Natural order
TreeSet<Type> setName = new TreeSet<>();

// Custom order
TreeSet<Type> setName = new TreeSet<>(comparator);
```

---

## Common Methods

### Basic Methods
| Method | Description |
|--------|-------------|
| `add(element)` | Add element |
| `remove(element)` | Remove element |
| `contains(element)` | Check if exists |
| `size()` | Get size |
| `clear()` | Remove all |

### Navigation Methods
| Method | Description |
|--------|-------------|
| `first()` | Get smallest element |
| `last()` | Get largest element |
| `higher(element)` | Get next higher element |
| `lower(element)` | Get next lower element |
| `ceiling(element)` | Get >= element |
| `floor(element)` | Get <= element |

---

## When to Use TreeSet?

✅ Use when:
- Need sorted unique elements
- Need range operations
- Need navigation methods

❌ Avoid when:
- Don't need sorting
- Need faster operations (use HashSet)
- Need to store null

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Add | O(log n) |
| Remove | O(log n) |
| Contains | O(log n) |
| First/Last | O(log n) |

---

## TreeSet vs HashSet

| Feature | TreeSet | HashSet |
|---------|---------|---------|
| Order | Sorted | No order |
| Performance | O(log n) | O(1) |
| Null | Not allowed | One null allowed |
| Use case | Sorted data | Fast lookups |

---

## Summary

- TreeSet = Sorted unique elements
- Automatically maintains order
- Slower than HashSet but provides sorting
- Best for: Sorted data, range queries
