# Multi-Threading using Thread Class

## What is Thread Class?

`Thread` is a built-in Java class that allows you to create and control threads. It's the simplest way to create threads.

---

## Two Ways to Create Threads

1. **Extend Thread class** (This file)
2. Implement Runnable interface (Next file)

---

## Creating Thread by Extending Thread Class

### Step 1: Create a class that extends Thread
```java
class MyThread extends Thread {
    // Override run() method
    public void run() {
        System.out.println("Thread is running");
    }
}
```

### Step 2: Create object and start
```java
MyThread t = new MyThread();
t.start(); // Starts the thread
```

---

## Complete Example

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

**Output**:
```
Thread: 1
Thread: 2
Thread: 3
Thread: 4
Thread: 5
```

---

## Important Methods

### 1. start()
Starts the thread execution
```java
thread.start();
```

### 2. run()
Contains the code that thread will execute
```java
public void run() {
    // Your code here
}
```

### 3. sleep()
Pauses thread for specified milliseconds
```java
Thread.sleep(1000); // Sleep for 1 second
```

### 4. getName() / setName()
Get or set thread name
```java
thread.setName("MyThread");
System.out.println(thread.getName());
```

### 5. currentThread()
Get reference to currently executing thread
```java
Thread t = Thread.currentThread();
```

---

## Example with sleep()

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
```

---

## Multiple Threads Example

```java
class PrintNumbers extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Numbers: " + i);
        }
    }
}

class PrintLetters extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letters: " + c);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PrintNumbers t1 = new PrintNumbers();
        PrintLetters t2 = new PrintLetters();
        
        t1.start();
        t2.start();
    }
}
```

**Possible Output** (order may vary):
```
Numbers: 1
Letters: A
Numbers: 2
Letters: B
Numbers: 3
Letters: C
...
```

---

## Thread with Constructor

```java
class MyThread extends Thread {
    String name;
    
    MyThread(String name) {
        this.name = name;
    }
    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + ": " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        
        t1.start();
        t2.start();
    }
}
```

---

## Important Points

### ✅ DO's
- Always override `run()` method
- Use `start()` to begin thread execution
- Handle `InterruptedException` when using `sleep()`

### ❌ DON'Ts
- Don't call `run()` directly - use `start()`
- Don't call `start()` twice on same thread
- Don't extend Thread if your class already extends another class

---

## start() vs run()

| start() | run() |
|---------|-------|
| Creates new thread | Runs in same thread |
| Calls run() internally | Just a normal method call |
| Can't call twice | Can call multiple times |
| **Use this** | Don't use directly |

```java
// CORRECT
thread.start(); // Creates new thread

// WRONG
thread.run(); // Runs in main thread, no multithreading!
```

---

## Common Methods Summary

```java
Thread t = new Thread();

t.start();              // Start thread
t.run();                // Code to execute
t.sleep(1000);          // Sleep 1 second
t.setName("MyThread");  // Set name
t.getName();            // Get name
t.getPriority();        // Get priority
t.setPriority(5);       // Set priority (1-10)
t.isAlive();            // Check if running
```

---

## Summary

- Extend `Thread` class to create threads
- Override `run()` method with your code
- Use `start()` to begin execution
- Use `sleep()` to pause thread
- Multiple threads run independently
- Execution order is not guaranteed
