# Producer Consumer Problem

## What is Producer-Consumer Problem?

A classic synchronization problem where:
- **Producer** creates data and puts it in a buffer
- **Consumer** takes data from the buffer and uses it

### Simple Analogy
Think of a bakery:
- **Baker (Producer)**: Makes bread and puts on shelf
- **Customer (Consumer)**: Takes bread from shelf
- **Shelf (Buffer)**: Limited space

---

## The Problem

### Issues Without Synchronization

1. **Producer Problem**: Shelf is full, but baker keeps making bread (overflow!)
2. **Consumer Problem**: Shelf is empty, but customer tries to take bread (underflow!)
3. **Race Condition**: Both access shelf at same time (chaos!)

---

## Solution: wait() and notify()

- **Producer**: If buffer full, `wait()`
- **Consumer**: If buffer empty, `wait()`
- After producing: `notify()` consumer
- After consuming: `notify()` producer

---

## Simple Implementation

```java
class Buffer {
    int data;
    boolean hasData = false;
    
    synchronized void produce(int value) {
        while (hasData) {
            try {
                wait(); // Wait if buffer full
            } catch (InterruptedException e) {}
        }
        
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }
    
    synchronized int consume() {
        while (!hasData) {
            try {
                wait(); // Wait if buffer empty
            } catch (InterruptedException e) {}
        }
        
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify producer
        return data;
    }
}
```

---

## Producer Thread

```java
class Producer extends Thread {
    Buffer buffer;
    
    Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}
```

---

## Consumer Thread

```java
class Consumer extends Thread {
    Buffer buffer;
    
    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}
```

---

## Main Program

```java
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        
        producer.start();
        consumer.start();
    }
}
```

**Output**:
```
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
```

---

## How It Works

### Step-by-Step

1. **Producer** produces item 1
2. **Producer** notifies consumer
3. **Consumer** wakes up and consumes item 1
4. **Consumer** notifies producer
5. **Producer** wakes up and produces item 2
6. ... and so on

### Synchronization

- `synchronized` ensures only one thread accesses buffer
- `wait()` makes thread wait
- `notify()` wakes up waiting thread

---

## With Multiple Items (Queue)

```java
import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;
    
    synchronized void produce(int value) {
        while (queue.size() == capacity) {
            try {
                wait(); // Wait if queue full
            } catch (InterruptedException e) {}
        }
        
        queue.add(value);
        System.out.println("Produced: " + value);
        notify();
    }
    
    synchronized int consume() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait if queue empty
            } catch (InterruptedException e) {}
        }
        
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify();
        return value;
    }
}
```

---

## Real-World Examples

### 1. Print Queue
- **Producer**: Applications sending print jobs
- **Consumer**: Printer processing jobs
- **Buffer**: Print queue

### 2. Download Manager
- **Producer**: Downloader adding files to queue
- **Consumer**: Writer saving files to disk
- **Buffer**: Download queue

### 3. Message Queue
- **Producer**: Sender sending messages
- **Consumer**: Receiver reading messages
- **Buffer**: Message queue

---

## Key Concepts

### wait()
- Releases lock
- Thread goes to WAITING state
- Waits for notify()

### notify()
- Wakes up one waiting thread
- Thread moves to RUNNABLE state
- Must be called from synchronized context

### notifyAll()
- Wakes up all waiting threads
- Use when multiple consumers/producers

---

## Common Mistakes

### ❌ Wrong: Using if instead of while
```java
if (hasData) {
    wait(); // Problem: Spurious wakeup
}
```

### ✅ Correct: Using while
```java
while (hasData) {
    wait(); // Safe from spurious wakeup
}
```

### ❌ Wrong: Not synchronizing
```java
void produce(int value) {
    // No synchronized - Race condition!
}
```

### ✅ Correct: Synchronizing
```java
synchronized void produce(int value) {
    // Thread-safe
}
```

---

## Summary

- **Producer-Consumer**: Classic synchronization problem
- **Producer**: Creates data, waits if buffer full
- **Consumer**: Uses data, waits if buffer empty
- **Buffer**: Shared resource with limited capacity
- **wait()**: Thread waits
- **notify()**: Wake up waiting thread
- **synchronized**: Ensures thread safety
- Use `while` loop with `wait()` for safety
