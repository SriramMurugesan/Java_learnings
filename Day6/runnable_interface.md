# Multi-Threading using Runnable Interface

## What is Runnable Interface?

`Runnable` is an interface with a single method `run()`. It's a better way to create threads because Java doesn't support multiple inheritance.

---

## Why Use Runnable?

### Problem with Thread Class
```java
class MyClass extends SomeClass {
    // Can't extend Thread here!
    // Java allows only single inheritance
}
```

### Solution: Runnable Interface
```java
class MyClass extends SomeClass implements Runnable {
    // Now we can create threads!
    public void run() {
        // Thread code
    }
}
```

---

## Creating Thread using Runnable

### Step 1: Implement Runnable interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}
```

### Step 2: Create Thread object and start
```java
MyRunnable r = new MyRunnable();
Thread t = new Thread(r);
t.start();
```

---

## Complete Example

```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
    }
}
```

---

## Thread Class vs Runnable Interface

| Thread Class | Runnable Interface |
|--------------|-------------------|
| Extend Thread | Implement Runnable |
| Can't extend other class | Can extend other class |
| Less flexible | More flexible |
| `MyThread t = new MyThread()` | `Thread t = new Thread(runnable)` |

---

## Using Lambda Expression (Java 8)

Instead of creating a separate class, use lambda:

```java
public class Main {
    public static void main(String[] args) {
        // Old way
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread running");
            }
        };
        
        // Lambda way (Simple!)
        Runnable r2 = () -> {
            System.out.println("Thread running");
        };
        
        Thread t = new Thread(r2);
        t.start();
    }
}
```

### Even Simpler
```java
Thread t = new Thread(() -> {
    System.out.println("Thread running");
});
t.start();
```

---

## Multiple Threads Example

```java
class PrintTask implements Runnable {
    String name;
    
    PrintTask(String name) {
        this.name = name;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask("Thread-1"));
        Thread t2 = new Thread(new PrintTask("Thread-2"));
        
        t1.start();
        t2.start();
    }
}
```

---

## Runnable with Lambda - Multiple Examples

### Example 1: Print Numbers
```java
Thread t = new Thread(() -> {
    for (int i = 1; i <= 5; i++) {
        System.out.println(i);
    }
});
t.start();
```

### Example 2: Print Message
```java
Thread t = new Thread(() -> System.out.println("Hello from thread"));
t.start();
```

### Example 3: Multiple Threads
```java
Thread t1 = new Thread(() -> {
    for (int i = 1; i <= 3; i++) {
        System.out.println("Thread 1: " + i);
    }
});

Thread t2 = new Thread(() -> {
    for (char c = 'A'; c <= 'C'; c++) {
        System.out.println("Thread 2: " + c);
    }
});

t1.start();
t2.start();
```

---

## Passing Parameters

```java
class Task implements Runnable {
    int num;
    
    Task(int num) {
        this.num = num;
    }
    
    public void run() {
        System.out.println("Task " + num + " running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(1));
        Thread t2 = new Thread(new Task(2));
        
        t1.start();
        t2.start();
    }
}
```

---

## Anonymous Class Way

```java
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread running");
            }
        });
        t.start();
    }
}
```

---

## Which One to Use?

### Use Thread Class When:
- Simple, standalone thread
- Don't need to extend other class

### Use Runnable Interface When:
- Need to extend another class ✅
- Want to share same Runnable with multiple threads ✅
- Better design and flexibility ✅
- **Recommended approach** ✅

---

## Sharing Runnable Example

```java
class Counter implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        // Same Runnable, different threads
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        
        t1.start();
        t2.start();
    }
}
```

---

## Summary

- Implement `Runnable` interface for creating threads
- Override `run()` method
- Create `Thread` object with Runnable
- Use `start()` to begin execution
- **Runnable is preferred over Thread class**
- Can use lambda expressions for cleaner code
- Allows extending other classes
