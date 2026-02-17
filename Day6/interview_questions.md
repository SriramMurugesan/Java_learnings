# Day 6 - Threads & Java 8 Features Interview Questions

## Basic Questions

### 1. What is a thread?
**Answer**: A thread is the smallest unit of execution in a program. It's a lightweight process that runs independently within a program.

### 2. What is multi-threading?
**Answer**: Multi-threading is the ability to run multiple threads simultaneously, allowing concurrent execution of tasks.

### 3. What are the two ways to create a thread in Java?
**Answer**: 
1. Extend Thread class
2. Implement Runnable interface

### 4. What is the difference between Thread class and Runnable interface?
**Answer**:
- **Thread class**: Extend Thread, can't extend other class
- **Runnable interface**: Implement Runnable, can extend other class (preferred)

### 5. What is the difference between start() and run()?
**Answer**:
- **start()**: Creates new thread and calls run()
- **run()**: Just a normal method call, no new thread created

### 6. What is synchronization?
**Answer**: Synchronization is a mechanism to control access of multiple threads to shared resources, ensuring only one thread accesses at a time.

### 7. What is a race condition?
**Answer**: A race condition occurs when two or more threads access shared data simultaneously and try to change it, leading to unpredictable results.

### 8. What is the purpose of wait() and notify()?
**Answer**:
- **wait()**: Makes thread wait until another thread notifies
- **notify()**: Wakes up one waiting thread

### 9. What are thread states?
**Answer**: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

### 10. What is the Producer-Consumer problem?
**Answer**: A synchronization problem where producer creates data and consumer uses it, requiring coordination to avoid buffer overflow/underflow.

---

## Java 8 Features

### 11. What is a lambda expression?
**Answer**: A lambda expression is a short way to write anonymous functions using the syntax: `(parameters) -> expression`

### 12. What is a functional interface?
**Answer**: An interface with exactly one abstract method. Used with lambda expressions.

### 13. What is Optional class?
**Answer**: Optional is a container that may or may not contain a value, helping avoid NullPointerException.

### 14. What are the benefits of lambda expressions?
**Answer**:
- Cleaner, more concise code
- Better readability
- Enables functional programming
- Works well with streams

### 15. How to create an Optional object?
**Answer**:
- `Optional.of(value)` - throws exception if null
- `Optional.ofNullable(value)` - accepts null
- `Optional.empty()` - creates empty Optional

---

## Advanced Questions

### 16. What is deadlock?
**Answer**: Deadlock occurs when two or more threads wait for each other forever, each holding a resource the other needs.

### 17. What is thread priority?
**Answer**: Thread priority (1-10) suggests to scheduler which thread should get CPU time first. MIN_PRIORITY=1, NORM_PRIORITY=5, MAX_PRIORITY=10.

### 18. What is join() method?
**Answer**: join() makes current thread wait until the thread on which join() is called completes execution.

### 19. What is the difference between wait() and sleep()?
**Answer**:
- **wait()**: Releases lock, must be in synchronized context
- **sleep()**: Doesn't release lock, can be called anywhere

### 20. What is thread safety?
**Answer**: Thread safety means code works correctly when accessed by multiple threads simultaneously, without data corruption or race conditions.

---

## Summary
Key topics: Threads, Runnable, Synchronization, Race Condition, Producer-Consumer, Lambda Expressions, Optional Class
