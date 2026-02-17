# Introduction to Collection Framework

## What is Collection Framework?

The **Collection Framework** is a set of classes and interfaces that provide a way to store and manipulate groups of objects.

### Simple Analogy
Think of collections as different types of containers:
- **ArrayList**: Like a resizable array (shopping list that can grow)
- **LinkedList**: Like a chain of items (train with connected coaches)
- **HashSet**: Like a bag of unique items (no duplicates allowed)
- **TreeSet**: Like a sorted shelf (items arranged in order)

---

## Why Use Collections?

1. **Ready-to-use**: No need to write complex data structures
2. **Efficient**: Optimized for performance
3. **Flexible**: Different types for different needs
4. **Type-safe**: Generics prevent errors

---

## Collection Hierarchy

```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (Interface)
    ├── PriorityQueue
    ├── ArrayDeque
    └── LinkedList
```

---

## Main Interfaces

### 1. List
- **Ordered** collection
- **Allows duplicates**
- **Index-based** access
- Examples: ArrayList, LinkedList

### 2. Set
- **No duplicates**
- **Unordered** (except TreeSet)
- Examples: HashSet, TreeSet, LinkedHashSet

### 3. Queue
- **FIFO** (First In First Out)
- Used for processing items in order
- Examples: PriorityQueue, ArrayDeque

---

## Common Methods

All collections share these methods:

```java
add(element)        // Add element
remove(element)     // Remove element
size()             // Get size
isEmpty()          // Check if empty
clear()            // Remove all elements
contains(element)  // Check if element exists
```

---

## Choosing the Right Collection

| Need | Use |
|------|-----|
| Fast access by index | ArrayList |
| Fast insertion/deletion | LinkedList |
| Unique elements | HashSet |
| Sorted unique elements | TreeSet |
| Maintain insertion order | LinkedHashSet |
| Priority-based processing | PriorityQueue |
| Stack/Queue operations | ArrayDeque |

---

## Simple Example

```java
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // ArrayList - ordered, allows duplicates
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // duplicate allowed
        System.out.println("List: " + list);
        
        // HashSet - no duplicates
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // duplicate ignored
        System.out.println("Set: " + set);
    }
}
```

**Output**:
```
List: [Apple, Banana, Apple]
Set: [Apple, Banana]
```

---

## Key Points

1. **List** = Ordered + Duplicates allowed
2. **Set** = Unique elements only
3. **Queue** = Process in order (FIFO)
4. Use **generics** for type safety: `List<String>`
5. Import `java.util.*` to use collections

---

## Summary

- Collection Framework provides ready-to-use data structures
- Choose based on your needs: ordering, duplicates, speed
- All collections have common methods (add, remove, size, etc.)
- Use generics for type safety
