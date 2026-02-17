# Day 8 Interview Questions - Collection Framework

## Theoretical Questions

### 1. What is the Collection Framework in Java?
**Answer**: The Collection Framework is a unified architecture for representing and manipulating collections of objects. It includes interfaces (List, Set, Queue), implementations (ArrayList, HashSet, etc.), and algorithms.

### 2. What is the difference between Collection and Collections?
**Answer**: 
- **Collection**: Interface that represents a group of objects
- **Collections**: Utility class with static methods for operations on collections (sort, reverse, etc.)

### 3. What is the difference between List and Set?
**Answer**:
- **List**: Ordered, allows duplicates, index-based access
- **Set**: Unordered (except TreeSet), no duplicates, no index-based access

### 4. Why use ArrayList over Array?
**Answer**:
- Dynamic size (grows/shrinks automatically)
- More utility methods (add, remove, contains)
- Type-safe with generics
- Can only store objects (not primitives)

### 5. When to use ArrayList vs LinkedList?
**Answer**:
- **ArrayList**: Fast random access, slow insertion/deletion in middle
- **LinkedList**: Slow random access, fast insertion/deletion anywhere

---

## ArrayList Questions

### 6. What is the default capacity of ArrayList?
**Answer**: 10

### 7. How does ArrayList grow?
**Answer**: When full, it creates a new array with 50% more capacity and copies elements.

### 8. Can ArrayList store null?
**Answer**: Yes, ArrayList can store null values.

### 9. Is ArrayList thread-safe?
**Answer**: No. Use `Collections.synchronizedList()` or `CopyOnWriteArrayList` for thread safety.

### 10. What is the time complexity of get() in ArrayList?
**Answer**: O(1) - constant time

---

## LinkedList Questions

### 11. What is the internal structure of LinkedList?
**Answer**: Doubly linked list where each node has data, next pointer, and previous pointer.

### 12. Can LinkedList be used as Stack and Queue?
**Answer**: Yes, LinkedList implements Deque interface, so it can be used as both.

### 13. What is the time complexity of add() at beginning in LinkedList?
**Answer**: O(1) - constant time

### 14. What is the difference between poll() and remove()?
**Answer**:
- **poll()**: Returns null if empty
- **remove()**: Throws NoSuchElementException if empty

---

## Queue Questions

### 15. What is the difference between Queue and Deque?
**Answer**:
- **Queue**: Single-ended (add at rear, remove from front)
- **Deque**: Double-ended (add/remove from both ends)

### 16. What is PriorityQueue?
**Answer**: A queue where elements are ordered by priority (natural order or custom comparator), not insertion order.

### 17. Can PriorityQueue store null?
**Answer**: No, PriorityQueue does not allow null elements.

### 18. What is the time complexity of offer() in PriorityQueue?
**Answer**: O(log n)

---

## Set Questions

### 19. What is the difference between HashSet, LinkedHashSet, and TreeSet?
**Answer**:
- **HashSet**: No order, O(1) operations
- **LinkedHashSet**: Insertion order, O(1) operations
- **TreeSet**: Sorted order, O(log n) operations

### 20. How does HashSet ensure uniqueness?
**Answer**: Uses hashCode() and equals() methods to check for duplicates.

### 21. Can HashSet store null?
**Answer**: Yes, one null element is allowed.

### 22. Can TreeSet store null?
**Answer**: No, TreeSet does not allow null (throws NullPointerException).

### 23. What is the internal structure of TreeSet?
**Answer**: Red-Black tree (self-balancing binary search tree).

### 24. What is the time complexity of add() in HashSet?
**Answer**: O(1) - average case

### 25. What is the time complexity of add() in TreeSet?
**Answer**: O(log n)

---

## Comparison Questions

### 26. ArrayList vs Vector?
**Answer**:
- **ArrayList**: Not synchronized, faster, grows by 50%
- **Vector**: Synchronized, slower, grows by 100%

### 27. HashSet vs TreeSet performance?
**Answer**:
- **HashSet**: O(1) for add/remove/contains
- **TreeSet**: O(log n) for add/remove/contains

### 28. When to use ArrayDeque over LinkedList?
**Answer**: ArrayDeque is faster for most operations and uses less memory. Use it for stack/queue operations.

---

## Coding Questions

### 29. Remove duplicates from ArrayList
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
Set<Integer> set = new LinkedHashSet<>(list);
list = new ArrayList<>(set);
```

### 30. Find first non-repeating element
```java
LinkedHashSet<Integer> unique = new LinkedHashSet<>();
Set<Integer> duplicates = new HashSet<>();

for (int num : list) {
    if (!unique.add(num)) {
        duplicates.add(num);
    }
}
unique.removeAll(duplicates);
return unique.iterator().next();
```

### 31. Implement Stack using ArrayList
```java
class Stack<T> {
    ArrayList<T> list = new ArrayList<>();
    
    void push(T item) { list.add(item); }
    T pop() { return list.remove(list.size() - 1); }
    T peek() { return list.get(list.size() - 1); }
    boolean isEmpty() { return list.isEmpty(); }
}
```

### 32. Find kth largest element using PriorityQueue
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int num : array) {
    pq.add(num);
    if (pq.size() > k) pq.poll();
}
return pq.peek();
```

---

## Advanced Questions

### 33. What is fail-fast iterator?
**Answer**: Iterator that throws ConcurrentModificationException if collection is modified during iteration.

### 34. How to make ArrayList read-only?
**Answer**: Use `Collections.unmodifiableList(list)`

### 35. What is the difference between Comparable and Comparator?
**Answer**:
- **Comparable**: Natural ordering (compareTo method in class)
- **Comparator**: Custom ordering (separate comparator class)

---

## Summary

Key points to remember:
1. **ArrayList**: Fast access, slow insertion/deletion
2. **LinkedList**: Slow access, fast insertion/deletion
3. **HashSet**: Unique, no order, O(1)
4. **TreeSet**: Unique, sorted, O(log n)
5. **LinkedHashSet**: Unique, insertion order, O(1)
6. **PriorityQueue**: Priority-based, O(log n)
7. **ArrayDeque**: Fast stack/queue, better than LinkedList
