# Race Condition and Solution

## What is a Race Condition?

A **race condition** occurs when two or more threads access shared data at the same time and try to change it.

### Simple Analogy
Imagine two people trying to edit the same document simultaneously - they might overwrite each other's changes!

---

## Example of Race Condition

```java
class Counter {
    int count = 0;
    
    void increment() {
        count++; // Problem here!
    }
}
```

### What Happens?
```
Thread 1: Read count (0) → Add 1 → Write (1)
Thread 2: Read count (0) → Add 1 → Write (1)

Expected: 2
Actual: 1 (Lost update!)
```

---

## Complete Example

```java
class Counter {
    int count = 0;
    
    void increment() {
        count++;
    }
}

class MyThread extends Thread {
    Counter counter;
    
    MyThread(Counter counter) {
        this.counter = counter;
    }
    
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Count: " + counter.count);
        // Expected: 2000
        // Actual: Less than 2000 (Race condition!)
    }
}
```

---

## Why Does This Happen?

The operation `count++` is actually 3 steps:
1. **Read** current value
2. **Add** 1 to it
3. **Write** back

These steps are not atomic (not done in one go), so threads can interfere!

---

## Solution: Synchronization

Use `synchronized` keyword to make method thread-safe:

```java
class Counter {
    int count = 0;
    
    synchronized void increment() {
        count++;
    }
}
```

### How It Works
- Only **one thread** can execute synchronized method at a time
- Other threads **wait** until the first thread finishes
- No more race condition!

---

## Before and After

### Before (Race Condition)
```java
void increment() {
    count++; // Multiple threads can execute together
}
```

### After (Thread-Safe)
```java
synchronized void increment() {
    count++; // Only one thread at a time
}
```

---

## Another Example: Bank Account

### Problem
```java
class BankAccount {
    int balance = 1000;
    
    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount; // Race condition!
        }
    }
}
```

### Solution
```java
class BankAccount {
    int balance = 1000;
    
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount; // Safe now!
        }
    }
}
```

---

## Synchronized Block

Instead of synchronizing entire method, synchronize only critical section:

```java
class Counter {
    int count = 0;
    
    void increment() {
        synchronized(this) {
            count++; // Only this part is synchronized
        }
    }
}
```

---

## Real-World Example

### Problem: Ticket Booking
```java
class TicketCounter {
    int availableSeats = 10;
    
    void bookSeat() {
        if (availableSeats > 0) {
            System.out.println("Seat booked");
            availableSeats--;
        } else {
            System.out.println("No seats available");
        }
    }
}
```

**Problem**: Two people might book the same last seat!

### Solution
```java
class TicketCounter {
    int availableSeats = 10;
    
    synchronized void bookSeat() {
        if (availableSeats > 0) {
            System.out.println("Seat booked");
            availableSeats--;
        } else {
            System.out.println("No seats available");
        }
    }
}
```

---

## Important Points

### When Race Condition Occurs?
- Multiple threads access **shared data**
- At least one thread **modifies** the data
- No **synchronization** mechanism

### How to Prevent?
- Use `synchronized` keyword
- Use locks
- Use atomic variables
- Avoid shared mutable state

---

## Summary

- **Race Condition**: Multiple threads accessing shared data simultaneously
- **Problem**: Data corruption, lost updates, inconsistent state
- **Solution**: Use `synchronized` keyword
- **synchronized method**: Only one thread can execute at a time
- **synchronized block**: Synchronize only critical section
