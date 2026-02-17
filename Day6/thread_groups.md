# Thread Groups

## What is a Thread Group?

A **Thread Group** is a way to group multiple threads together. It helps in managing multiple threads as a single unit.

### Simple Analogy
Think of a school:
- **Thread Group** = Class (Group of students)
- **Threads** = Students
- You can manage entire class together (attendance, announcements)

---

## Why Use Thread Groups?

1. **Organize threads** logically
2. **Control multiple threads** at once
3. **Set common properties** for all threads
4. **Handle exceptions** for group
5. **Monitor thread activity**

---

## Creating Thread Group

### Basic Creation
```java
ThreadGroup group = new ThreadGroup("MyGroup");
```

### Creating Thread in Group
```java
Thread t = new Thread(group, () -> {
    System.out.println("Thread in group");
});
```

---

## Simple Example

```java
public class Main {
    public static void main(String[] args) {
        // Create thread group
        ThreadGroup group = new ThreadGroup("WorkerGroup");
        
        // Create threads in group
        Thread t1 = new Thread(group, () -> {
            System.out.println("Thread 1 running");
        }, "Thread-1");
        
        Thread t2 = new Thread(group, () -> {
            System.out.println("Thread 2 running");
        }, "Thread-2");
        
        // Start threads
        t1.start();
        t2.start();
        
        // Get group info
        System.out.println("Group name: " + group.getName());
        System.out.println("Active threads: " + group.activeCount());
    }
}
```

---

## Thread Group Methods

### 1. getName()
Get group name
```java
String name = group.getName();
```

### 2. activeCount()
Get number of active threads
```java
int count = group.activeCount();
```

### 3. list()
Print information about group
```java
group.list();
```

### 4. interrupt()
Interrupt all threads in group
```java
group.interrupt();
```

### 5. setMaxPriority()
Set maximum priority for group
```java
group.setMaxPriority(7);
```

---

## Complete Example

```java
class Worker implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        ThreadGroup group = new ThreadGroup("Workers");
        
        Thread t1 = new Thread(group, new Worker(), "Worker-1");
        Thread t2 = new Thread(group, new Worker(), "Worker-2");
        Thread t3 = new Thread(group, new Worker(), "Worker-3");
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Active threads: " + group.activeCount());
        
        Thread.sleep(1000);
        
        // Interrupt all threads in group
        group.interrupt();
        
        Thread.sleep(2000);
        System.out.println("Active threads: " + group.activeCount());
    }
}
```

---

## Nested Thread Groups

You can create groups within groups:

```java
ThreadGroup parentGroup = new ThreadGroup("Parent");
ThreadGroup childGroup = new ThreadGroup(parentGroup, "Child");

Thread t1 = new Thread(parentGroup, () -> {
    System.out.println("Thread in parent group");
});

Thread t2 = new Thread(childGroup, () -> {
    System.out.println("Thread in child group");
});
```

---

## Getting Thread Group Information

```java
ThreadGroup group = new ThreadGroup("MyGroup");

// Create some threads
Thread t1 = new Thread(group, () -> {});
Thread t2 = new Thread(group, () -> {});

t1.start();
t2.start();

// Get information
System.out.println("Group name: " + group.getName());
System.out.println("Active count: " + group.activeCount());
System.out.println("Max priority: " + group.getMaxPriority());

// List all threads
group.list();
```

---

## Useful Methods

### activeCount()
```java
int count = group.activeCount();
System.out.println("Active threads: " + count);
```

### enumerate()
```java
Thread[] threads = new Thread[group.activeCount()];
group.enumerate(threads);

for (Thread t : threads) {
    System.out.println(t.getName());
}
```

### getParent()
```java
ThreadGroup parent = group.getParent();
```

### destroy()
```java
group.destroy(); // Destroy empty group
```

---

## Default Thread Group

Every thread belongs to a thread group. If not specified, it belongs to parent thread's group.

```java
// Get current thread's group
ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
System.out.println("Current group: " + currentGroup.getName());
```

---

## Setting Priority for Group

```java
ThreadGroup group = new ThreadGroup("MyGroup");
group.setMaxPriority(7);

// All threads in this group will have max priority 7
Thread t = new Thread(group, () -> {});
t.setPriority(10); // Will be capped at 7
```

---

## Real-World Use Cases

### 1. Web Server
```java
ThreadGroup requestHandlers = new ThreadGroup("RequestHandlers");
// All request handling threads in one group
```

### 2. Background Tasks
```java
ThreadGroup backgroundTasks = new ThreadGroup("Background");
// All background threads together
```

### 3. Worker Pool
```java
ThreadGroup workers = new ThreadGroup("WorkerPool");
// Group of worker threads
```

---

## Important Points

✅ **Organize** related threads together  
✅ **Control** multiple threads at once  
✅ **Set** common properties  
✅ **Monitor** group activity  

❌ **Not commonly used** in modern Java  
❌ **ExecutorService** is preferred for thread management  
❌ **Limited functionality** compared to modern alternatives  

---

## Modern Alternative: ExecutorService

Instead of ThreadGroup, modern Java uses ExecutorService:

```java
ExecutorService executor = Executors.newFixedThreadPool(5);

executor.submit(() -> System.out.println("Task 1"));
executor.submit(() -> System.out.println("Task 2"));

executor.shutdown();
```

---

## Summary

- **Thread Group**: Group of threads managed together
- **Create**: `new ThreadGroup("name")`
- **Add thread**: `new Thread(group, runnable)`
- **Methods**: `activeCount()`, `list()`, `interrupt()`
- **Nested groups**: Groups within groups possible
- **Modern alternative**: ExecutorService preferred
- **Use case**: Organizing and managing related threads
