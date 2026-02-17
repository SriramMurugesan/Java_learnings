# ArrayList

## What is ArrayList?

**ArrayList** is a resizable array implementation of the List interface. It can grow and shrink dynamically.

### Simple Analogy
Think of ArrayList as a **flexible shopping list**:
- You can add items (list grows)
- You can remove items (list shrinks)
- You can access any item by position
- Items stay in the order you added them

---

## Key Features

✅ **Dynamic Size**: Grows automatically when full  
✅ **Index-based Access**: Fast access using index  
✅ **Allows Duplicates**: Same element can appear multiple times  
✅ **Maintains Order**: Elements stay in insertion order  
✅ **Not Synchronized**: Not thread-safe  

---

## Syntax

```java
import java.util.ArrayList;

ArrayList<Type> listName = new ArrayList<>();
```

---

## Common Methods

| Method | Description | Example |
|--------|-------------|---------|
| `add(element)` | Add element at end | `list.add("Apple")` |
| `add(index, element)` | Add at specific position | `list.add(0, "Banana")` |
| `get(index)` | Get element at index | `list.get(0)` |
| `set(index, element)` | Replace element | `list.set(0, "Orange")` |
| `remove(index)` | Remove by index | `list.remove(0)` |
| `remove(element)` | Remove by value | `list.remove("Apple")` |
| `size()` | Get size | `list.size()` |
| `isEmpty()` | Check if empty | `list.isEmpty()` |
| `contains(element)` | Check if exists | `list.contains("Apple")` |
| `clear()` | Remove all | `list.clear()` |

---

## When to Use ArrayList?

✅ Use when:
- Need fast access by index
- Mostly reading data
- Order matters

❌ Avoid when:
- Frequent insertions/deletions in middle
- Need thread safety
- Fixed size is enough (use array)

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Access by index | O(1) - Fast |
| Add at end | O(1) - Fast |
| Add at beginning | O(n) - Slow |
| Remove from end | O(1) - Fast |
| Remove from beginning | O(n) - Slow |
| Search | O(n) - Linear |

---

## ArrayList vs Array

| ArrayList | Array |
|-----------|-------|
| Dynamic size | Fixed size |
| Only objects | Primitives + Objects |
| More methods | Basic operations |
| Slower | Faster |

---

## Important Points

1. **Initial Capacity**: Default is 10, grows by 50% when full
2. **Generics**: Use `<Type>` for type safety
3. **Index**: Starts from 0
4. **Null**: Can store null values
5. **Iteration**: Use for-each or iterator

---

## Common Pitfalls

```java
// ❌ Wrong - ConcurrentModificationException
for (String item : list) {
    list.remove(item); // Don't modify while iterating
}

// ✅ Correct - Use iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    it.next();
    it.remove();
}
```

---

## Summary

- ArrayList = Resizable array
- Fast access by index
- Allows duplicates and maintains order
- Best for: Reading data, accessing by index
- Worst for: Frequent insertions/deletions in middle
