# PriorityQueue

## What is PriorityQueue?

**PriorityQueue** is a queue where elements are ordered by priority, not insertion order. The highest priority element is always at the front.

### Simple Analogy
Think of PriorityQueue as an **emergency room**:
- Critical patients are treated first (high priority)
- Less critical patients wait (low priority)
- Order depends on severity, not arrival time

---

## Key Features

✅ **Priority-based**: Elements ordered by priority  
✅ **Min Heap**: Smallest element at front (by default)  
✅ **No Random Access**: Cannot access by index  
✅ **Allows Duplicates**: Same element can appear multiple times  
✅ **No Null**: Cannot store null elements  

---

## Syntax

```java
import java.util.PriorityQueue;

// Min heap (smallest first)
PriorityQueue<Type> pq = new PriorityQueue<>();

// Max heap (largest first)
PriorityQueue<Type> pq = new PriorityQueue<>(Collections.reverseOrder());
```

---

## Common Methods

| Method | Description |
|--------|-------------|
| `add(element)` | Add element |
| `offer(element)` | Add element (preferred) |
| `poll()` | Remove and return highest priority |
| `peek()` | View highest priority (doesn't remove) |
| `remove(element)` | Remove specific element |
| `size()` | Get size |
| `isEmpty()` | Check if empty |
| `clear()` | Remove all |

---

## How Priority Works

### For Numbers
- **Default**: Smallest number = Highest priority
- **Reverse**: Largest number = Highest priority

### For Strings
- **Default**: Alphabetically first = Highest priority
- **Reverse**: Alphabetically last = Highest priority

### For Custom Objects
- Implement `Comparable` or provide `Comparator`

---

## When to Use PriorityQueue?

✅ Use when:
- Need to process items by priority
- Want automatic sorting
- Implementing algorithms (Dijkstra, Huffman)

❌ Avoid when:
- Need FIFO order (use Queue)
- Need random access (use List)
- Need to store null

---

## Performance

| Operation | Time Complexity |
|-----------|----------------|
| Add | O(log n) |
| Poll | O(log n) |
| Peek | O(1) |
| Remove | O(n) |
| Contains | O(n) |

---

## Use Cases

1. **Task Scheduling**: Process high-priority tasks first
2. **Dijkstra's Algorithm**: Shortest path
3. **Huffman Coding**: Data compression
4. **Event Simulation**: Process events by time
5. **Top K Problems**: Find K largest/smallest elements

---

## Important Points

1. **Not Sorted**: Internal structure is heap, not sorted array
2. **Iteration**: Iteration order is not guaranteed to be sorted
3. **Null**: Cannot add null elements
4. **Thread-Safe**: Use `PriorityBlockingQueue` for thread safety

---

## Summary

- PriorityQueue = Priority-based queue
- Smallest element at front (by default)
- Automatic ordering by priority
- Best for: Priority-based processing, algorithms
- Cannot store null elements
