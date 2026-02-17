# LinkedList

## What is LinkedList?

**LinkedList** is a doubly-linked list implementation of the List and Deque interfaces. Each element points to the next and previous element.

### Simple Analogy
Think of LinkedList as a **train**:
- Each coach (node) is connected to the next and previous coach
- Easy to add/remove coaches from any position
- Must walk through coaches to reach a specific one

---

## Key Features

✅ **Doubly Linked**: Each node has next and previous pointers  
✅ **Fast Insertion/Deletion**: Efficient at any position  
✅ **Implements List & Deque**: Can be used as list, stack, or queue  
✅ **Allows Duplicates**: Same element can appear multiple times  
✅ **Maintains Order**: Elements stay in insertion order  

---

## Syntax

```java
import java.util.LinkedList;

LinkedList<Type> listName = new LinkedList<>();
```

---

## Common Methods

### List Methods
| Method | Description |
|--------|-------------|
| `add(element)` | Add at end |
| `add(index, element)` | Add at position |
| `get(index)` | Get element |
| `remove(index)` | Remove by index |
| `size()` | Get size |

### Deque Methods (First/Last)
| Method | Description |
|--------|-------------|
| `addFirst(element)` | Add at beginning |
| `addLast(element)` | Add at end |
| `getFirst()` | Get first element |
| `getLast()` | Get last element |
| `removeFirst()` | Remove first |
| `removeLast()` | Remove last |

---

## LinkedList vs ArrayList

| Feature | LinkedList | ArrayList |
|---------|-----------|-----------|
| Structure | Doubly linked nodes | Dynamic array |
| Access by index | Slow O(n) | Fast O(1) |
| Insert/Delete | Fast O(1) | Slow O(n) |
| Memory | More (stores pointers) | Less |
| Best for | Frequent modifications | Frequent access |

---

## When to Use LinkedList?

✅ Use when:
- Frequent insertions/deletions
- Don't need random access
- Implementing queue/stack

❌ Avoid when:
- Need fast access by index
- Memory is limited
- Mostly reading data

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Access by index | O(n) - Slow |
| Add at beginning | O(1) - Fast |
| Add at end | O(1) - Fast |
| Remove from beginning | O(1) - Fast |
| Remove from end | O(1) - Fast |
| Search | O(n) - Linear |

---

## Use Cases

1. **Queue**: FIFO operations
2. **Stack**: LIFO operations
3. **Deque**: Both ends operations
4. **Undo functionality**: Easy to add/remove
5. **Music playlist**: Add/remove songs

---

## Important Points

1. **Memory**: Uses more memory than ArrayList
2. **Access**: Slower for random access
3. **Modification**: Faster for insertions/deletions
4. **Null**: Can store null values
5. **Not Synchronized**: Not thread-safe

---

## Summary

- LinkedList = Doubly linked nodes
- Fast insertion/deletion at any position
- Slow access by index
- Best for: Frequent modifications, queue/stack operations
- Worst for: Random access, memory-constrained environments
