# HashSet

## What is HashSet?

**HashSet** is a collection that stores unique elements with no duplicates. It uses hashing for fast operations.

### Simple Analogy
Think of HashSet as a **bag of unique items**:
- Each item can appear only once
- No specific order
- Very fast to check if item exists

---

## Key Features

✅ **No Duplicates**: Each element appears only once  
✅ **Unordered**: No guaranteed order  
✅ **Fast Operations**: O(1) for add, remove, contains  
✅ **Allows Null**: Can store one null element  
✅ **Not Synchronized**: Not thread-safe  

---

## Syntax

```java
import java.util.HashSet;

HashSet<Type> setName = new HashSet<>();
```

---

## Common Methods

| Method | Description |
|--------|-------------|
| `add(element)` | Add element (returns false if duplicate) |
| `remove(element)` | Remove element |
| `contains(element)` | Check if exists |
| `size()` | Get size |
| `isEmpty()` | Check if empty |
| `clear()` | Remove all |

---

## When to Use HashSet?

✅ Use when:
- Need unique elements
- Order doesn't matter
- Need fast lookups
- Want to remove duplicates

❌ Avoid when:
- Need to maintain order
- Need sorted elements
- Need duplicates

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Add | O(1) - Fast |
| Remove | O(1) - Fast |
| Contains | O(1) - Fast |
| Iteration | O(n) |

---

## Summary

- HashSet = Unique elements, no order
- Very fast operations
- Best for: Removing duplicates, fast lookups
