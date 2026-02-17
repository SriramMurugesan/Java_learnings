# ArrayDeque

## What is ArrayDeque?

**ArrayDeque** (Array Double Ended Queue) is a resizable array implementation of the Deque interface. You can add/remove elements from both ends.

### Simple Analogy
Think of ArrayDeque as a **flexible line**:
- People can join from front or back
- People can leave from front or back
- Faster than LinkedList for most operations

---

## Key Features

✅ **Double Ended**: Add/remove from both ends  
✅ **No Capacity Limit**: Grows as needed  
✅ **Faster than LinkedList**: Better performance  
✅ **No Null Elements**: Cannot store null  
✅ **Not Thread-Safe**: Not synchronized  

---

## Syntax

```java
import java.util.ArrayDeque;

ArrayDeque<Type> dequeName = new ArrayDeque<>();
```

---

## Common Methods

### Add Operations
| Method | Description |
|--------|-------------|
| `addFirst(e)` | Add at front |
| `addLast(e)` | Add at end |
| `offerFirst(e)` | Add at front (returns boolean) |
| `offerLast(e)` | Add at end (returns boolean) |

### Remove Operations
| Method | Description |
|--------|-------------|
| `removeFirst()` | Remove from front |
| `removeLast()` | Remove from end |
| `pollFirst()` | Remove from front (returns null if empty) |
| `pollLast()` | Remove from end (returns null if empty) |

### Peek Operations
| Method | Description |
|--------|-------------|
| `getFirst()` | Get first element |
| `getLast()` | Get last element |
| `peekFirst()` | Get first (returns null if empty) |
| `peekLast()` | Get last (returns null if empty) |

---

## Use Cases

1. **Stack**: LIFO operations (push/pop)
2. **Queue**: FIFO operations (offer/poll)
3. **Deque**: Both ends operations
4. **Undo/Redo**: Browser history
5. **Sliding Window**: Algorithm problems

---

## ArrayDeque vs LinkedList

| Feature | ArrayDeque | LinkedList |
|---------|-----------|------------|
| Structure | Resizable array | Doubly linked nodes |
| Performance | Faster | Slower |
| Memory | Less | More |
| Null | Not allowed | Allowed |

---

## When to Use ArrayDeque?

✅ Use when:
- Need stack or queue
- Want better performance than LinkedList
- Don't need null elements

❌ Avoid when:
- Need to store null
- Need random access by index

---

## Summary

- ArrayDeque = Resizable double-ended queue
- Faster than LinkedList
- Cannot store null
- Best for: Stack, Queue, Deque operations
