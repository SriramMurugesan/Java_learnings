# LinkedHashSet

## What is LinkedHashSet?

**LinkedHashSet** is a HashSet that maintains insertion order. It combines the benefits of HashSet (uniqueness) with predictable iteration order.

### Simple Analogy
Think of LinkedHashSet as a **guest list**:
- Each guest appears only once (unique)
- Guests listed in order they registered (insertion order)
- Fast to check if someone is on the list

---

## Key Features

✅ **No Duplicates**: Each element appears only once  
✅ **Maintains Insertion Order**: Elements in order they were added  
✅ **Fast Operations**: O(1) for add, remove, contains  
✅ **Allows Null**: Can store one null element  
✅ **Slightly Slower than HashSet**: Due to maintaining order  

---

## Syntax

```java
import java.util.LinkedHashSet;

LinkedHashSet<Type> setName = new LinkedHashSet<>();
```

---

## Common Methods

| Method | Description |
|--------|-------------|
| `add(element)` | Add element |
| `remove(element)` | Remove element |
| `contains(element)` | Check if exists |
| `size()` | Get size |
| `isEmpty()` | Check if empty |
| `clear()` | Remove all |

---

## When to Use LinkedHashSet?

✅ Use when:
- Need unique elements
- Need to maintain insertion order
- Want predictable iteration

❌ Avoid when:
- Don't care about order (use HashSet)
- Need sorted order (use TreeSet)

---

## Comparison

| Feature | HashSet | LinkedHashSet | TreeSet |
|---------|---------|---------------|---------|
| Order | No order | Insertion order | Sorted |
| Performance | Fastest | Fast | Slower |
| Null | One null | One null | No null |

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Add | O(1) |
| Remove | O(1) |
| Contains | O(1) |
| Iteration | O(n) |

---

## Summary

- LinkedHashSet = Unique elements + Insertion order
- Combines HashSet speed with predictable order
- Best for: Unique elements with order preservation
