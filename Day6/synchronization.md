# Synchronization in Threads

## What is Synchronization?

**Synchronization** is a way to control access of multiple threads to shared resources. It ensures only one thread accesses the resource at a time.

### Simple Analogy
Think of a public toilet:
- Only **one person** can use it at a time
- Others must **wait** in line
- Person **locks** the door while inside

---

## Why Synchronization?

Without synchronization:
- **Race conditions** occur
- **Data corruption** happens
- **Inconsistent results**

With synchronization:
- **Thread-safe** code
- **Data integrity** maintained
- **Predictable results**

---

## Types of Synchronization

### 1. Synchronized Method
```java
synchronized void method() {
    // Only one thread can execute this
}
```

### 2. Synchronized Block
```java
void method() {
    synchronized(this) {
        // Only this part is synchronized
    }
}
```

### 3. Static Synchronization
```java
synchronized static void method() {
    // Class-level lock
}
```

---

## Synchronized Method Example

```java
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {}
        }
    }
}

class MyThread extends Thread {
    Table t;
    int num;
    
    MyThread(Table t, int num) {
        this.t = t;
        this.num = num;
    }
    
    public void run() {
        t.printTable(num);
    }
}

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        
        MyThread t1 = new MyThread(table, 5);
        MyThread t2 = new MyThread(table, 100);
        
        t1.start();
        t2.start();
    }
}
```

**Output** (synchronized):
```
5
10
15
20
25
100
200
300
400
500
```

---

## Synchronized Block Example

```java
class Table {
    void printTable(int n) {
        synchronized(this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
            }
        }
    }
}
```

---

## Locking Mechanism

### How It Works
1. Thread **acquires lock** on object
2. Thread **executes** synchronized code
3. Thread **releases lock**
4. Next thread **acquires lock**

### Lock Object
```java
synchronized(lockObject) {
    // Critical section
}
```

---

## Different Lock Objects

### Using 'this'
```java
synchronized(this) {
    // Lock on current object
}
```

### Using Class
```java
synchronized(ClassName.class) {
    // Lock on class
}
```

### Using Custom Object
```java
Object lock = new Object();

synchronized(lock) {
    // Lock on custom object
}
```

---

## Static Synchronization

For static methods, lock is on **class** not object:

```java
class Counter {
    static int count = 0;
    
    synchronized static void increment() {
        count++;
    }
}
```

---

## Inter-Thread Communication

### wait()
Makes thread wait until another thread notifies

```java
synchronized void method() {
    wait(); // Wait here
}
```

### notify()
Wakes up one waiting thread

```java
synchronized void method() {
    notify(); // Wake up one thread
}
```

### notifyAll()
Wakes up all waiting threads

```java
synchronized void method() {
    notifyAll(); // Wake up all threads
}
```

---

## Simple wait() and notify() Example

```java
class Message {
    String msg;
    
    synchronized void setMessage(String msg) {
        this.msg = msg;
        notify(); // Notify waiting thread
    }
    
    synchronized String getMessage() {
        try {
            wait(); // Wait for message
        } catch (InterruptedException e) {}
        return msg;
    }
}
```

---

## Synchronized vs Unsynchronized

### Without Synchronization
```java
void printNumbers() {
    for (int i = 1; i <= 5; i++) {
        System.out.println(i);
    }
}
```
**Output**: Mixed from different threads

### With Synchronization
```java
synchronized void printNumbers() {
    for (int i = 1; i <= 5; i++) {
        System.out.println(i);
    }
}
```
**Output**: Complete sequence from one thread, then another

---

## Deadlock (Problem to Avoid)

When two threads wait for each other forever:

```java
Thread 1: Locks A, waits for B
Thread 2: Locks B, waits for A
// Both wait forever!
```

### How to Avoid
- Always acquire locks in **same order**
- Use **timeout** for lock acquisition
- Avoid **nested locks** if possible

---

## Best Practices

✅ **Synchronize only critical section** (not entire method if not needed)  
✅ **Keep synchronized block small** (better performance)  
✅ **Avoid nested synchronization** (prevents deadlock)  
✅ **Use same lock object** for related operations  
✅ **Document synchronization** strategy  

❌ **Don't synchronize everything** (reduces concurrency)  
❌ **Don't hold locks too long** (other threads wait)  
❌ **Don't call external methods** inside synchronized block  

---

## Performance Impact

### Without Synchronization
- **Faster** execution
- **Risk** of data corruption

### With Synchronization
- **Slower** execution (threads wait)
- **Safe** and correct results

**Trade-off**: Safety vs Speed

---

## Summary

- **Synchronization** controls thread access to shared resources
- **synchronized keyword** ensures only one thread executes at a time
- **Synchronized method**: Entire method is synchronized
- **Synchronized block**: Only specific code is synchronized
- **wait()**: Thread waits
- **notify()**: Wake up waiting thread
- Use synchronization to prevent race conditions
- Avoid deadlocks by careful lock management
