# Day 8 - Collection Framework

## Topics Covered

### Introduction
- [Collection Framework Introduction](collections_intro.md)

### List Interface
- [ArrayList](arraylist.md) - [Examples](arraylist_examples.java)
- [LinkedList](linkedlist.md) - [Examples](linkedlist_examples.java)

### Queue Interface
- [ArrayDeque](arraydeque.md) - [Examples](arraydeque_examples.java)
- [PriorityQueue](priorityqueue.md) - [Examples](priorityqueue_examples.java)

### Set Interface
- [HashSet](hashset.md) - [Examples](hashset_examples.java)
- [TreeSet](treeset.md) - [Examples](treeset_examples.java)
- [LinkedHashSet](linkedhashset.md) - [Examples](linkedhashset_examples.java)

### Practice
- [Exercises](exercises.md)
- [Interview Questions](interview_questions.md)

### Capstone Project
- [Student Management System](capstone_project.java)

## Quick Reference

| Collection | Order | Duplicates | Null | Performance |
|------------|-------|------------|------|-------------|
| ArrayList | Insertion | Yes | Yes | O(1) access |
| LinkedList | Insertion | Yes | Yes | O(1) insert/delete |
| ArrayDeque | Insertion | Yes | No | O(1) both ends |
| PriorityQueue | Priority | Yes | No | O(log n) |
| HashSet | None | No | One | O(1) |
| LinkedHashSet | Insertion | No | One | O(1) |
| TreeSet | Sorted | No | No | O(log n) |

## How to Run Examples

```bash
# Compile
javac filename.java

# Run
java filename
```

## Learning Path

1. Start with **Collection Framework Introduction**
2. Learn **ArrayList** (most commonly used)
3. Compare with **LinkedList**
4. Understand **Queue** implementations
5. Master **Set** implementations
6. Practice with **Exercises**
7. Complete **Capstone Project**
8. Review **Interview Questions**
