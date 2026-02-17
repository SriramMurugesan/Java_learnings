# Introduction to Threads

## What is a Thread?

A **thread** is a lightweight process - the smallest unit of execution in a program. Think of it as a separate path of execution within your program.

### Simple Analogy
Imagine you're cooking:
- **Single Thread**: You cook one dish at a time (boil rice, then cook curry, then make salad)
- **Multi-Thread**: You cook multiple dishes simultaneously (rice boiling while you chop vegetables)

---

## Why Use Threads?

1. **Better Performance**: Do multiple tasks at the same time
2. **Better Resource Utilization**: Use CPU efficiently
3. **Responsive Applications**: UI remains responsive while background tasks run
4. **Parallel Processing**: Complete tasks faster

---

## Single-Threaded vs Multi-Threaded

### Single-Threaded Program
```
Task 1 → Task 2 → Task 3
(Sequential execution)
```

### Multi-Threaded Program
```
Task 1 ↘
Task 2 → All running together
Task 3 ↗
(Parallel execution)
```

---

## Simple Example

```java
// Without threads - Sequential
System.out.println("Task 1");
System.out.println("Task 2");
System.out.println("Task 3");

// With threads - Parallel
Thread t1 = new Thread(() -> System.out.println("Task 1"));
Thread t2 = new Thread(() -> System.out.println("Task 2"));
Thread t3 = new Thread(() -> System.out.println("Task 3"));

t1.start();
t2.start();
t3.start();
```

---

## Key Concepts

### Process vs Thread

| Process | Thread |
|---------|--------|
| Heavy weight | Light weight |
| Separate memory | Shared memory |
| Independent | Part of a process |
| Slow creation | Fast creation |

### Main Thread

Every Java program has at least one thread - the **main thread**. It's created automatically when your program starts.

```java
public static void main(String[] args) {
    // This runs in the main thread
    System.out.println("Main thread");
}
```

---

## Real-World Examples

1. **Web Browser**: 
   - One thread downloads images
   - Another thread renders the page
   - Another thread handles user input

2. **Video Player**:
   - One thread plays video
   - Another thread plays audio
   - Another thread handles controls

3. **Game**:
   - One thread for graphics
   - Another for physics
   - Another for user input

---

## Benefits of Multi-Threading

✅ **Faster Execution**: Multiple tasks run simultaneously  
✅ **Better CPU Usage**: CPU doesn't sit idle  
✅ **Responsive UI**: Application doesn't freeze  
✅ **Resource Sharing**: Threads share memory efficiently  

---

## When to Use Threads?

- Long-running operations (file downloads, database queries)
- Background tasks (auto-save, notifications)
- Parallel processing (image processing, data analysis)
- Server applications (handling multiple clients)

---

## Simple Thread Example

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // Start the thread
    }
}
```

**Output**: `Thread is running`

---

## Important Points

1. Threads run **independently** of each other
2. Threads **share** the same memory space
3. Thread execution order is **not guaranteed**
4. Use threads for **concurrent** tasks, not sequential ones

---

## Summary

- Thread = Lightweight process
- Multi-threading = Running multiple threads simultaneously
- Benefits: Better performance, responsiveness, CPU utilization
- Use for: Parallel tasks, background operations, responsive UIs
