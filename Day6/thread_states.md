# States of Thread

## What are Thread States?

A thread can be in different states during its lifetime. Understanding these states helps in thread management and debugging.

---

## Thread Lifecycle

```
NEW → RUNNABLE → RUNNING → TERMINATED
         ↓           ↓
      BLOCKED    WAITING
```

---

## 6 Thread States

### 1. NEW
Thread is created but not yet started

```java
Thread t = new Thread();
// State: NEW
```

### 2. RUNNABLE
Thread is ready to run, waiting for CPU

```java
t.start();
// State: RUNNABLE
```

### 3. RUNNING
Thread is currently executing

```java
// When CPU picks this thread
// State: RUNNING
```

### 4. BLOCKED/WAITING
Thread is waiting for a resource or another thread

```java
// Waiting for lock
// State: BLOCKED

// Waiting for notification
wait();
// State: WAITING
```

### 5. TIMED_WAITING
Thread is waiting for a specific time

```java
Thread.sleep(1000);
// State: TIMED_WAITING
```

### 6. TERMINATED
Thread has completed execution

```java
// After run() method completes
// State: TERMINATED
```

---

## Detailed Explanation

### 1. NEW State
```java
Thread t = new Thread(() -> {
    System.out.println("Running");
});
// t is in NEW state
System.out.println(t.getState()); // NEW
```

**Characteristics**:
- Thread object created
- Not yet started
- No resources allocated

---

### 2. RUNNABLE State
```java
t.start();
// t is now RUNNABLE
System.out.println(t.getState()); // RUNNABLE
```

**Characteristics**:
- Thread is ready to run
- Waiting for CPU time
- May or may not be executing

---

### 3. RUNNING State
```java
// When CPU scheduler picks this thread
// Thread is actually executing
```

**Characteristics**:
- Thread is executing
- Has CPU time
- Running the run() method

**Note**: Java doesn't have explicit RUNNING state in `Thread.State` enum. It's part of RUNNABLE.

---

### 4. BLOCKED State
```java
synchronized void method() {
    // If another thread holds lock
    // This thread is BLOCKED
}
```

**Characteristics**:
- Waiting for monitor lock
- Another thread holds the lock
- Will become RUNNABLE when lock is available

---

### 5. WAITING State
```java
synchronized void method() {
    wait(); // Thread is WAITING
}
```

**Characteristics**:
- Waiting indefinitely
- Waiting for another thread to notify
- Released the lock

**Methods causing WAITING**:
- `wait()`
- `join()`
- `LockSupport.park()`

---

### 6. TIMED_WAITING State
```java
Thread.sleep(1000); // TIMED_WAITING for 1 second
```

**Characteristics**:
- Waiting for specific time
- Will automatically wake up after timeout
- Or can be interrupted

**Methods causing TIMED_WAITING**:
- `Thread.sleep(time)`
- `wait(time)`
- `join(time)`

---

### 7. TERMINATED State
```java
// After run() method completes
System.out.println(t.getState()); // TERMINATED
```

**Characteristics**:
- Thread completed execution
- Cannot be restarted
- Resources released

---

## Complete Example

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        System.out.println("Thread ending");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        MyThread t = new MyThread();
        
        System.out.println("State 1: " + t.getState()); // NEW
        
        t.start();
        System.out.println("State 2: " + t.getState()); // RUNNABLE
        
        Thread.sleep(500);
        System.out.println("State 3: " + t.getState()); // TIMED_WAITING
        
        t.join();
        System.out.println("State 4: " + t.getState()); // TERMINATED
    }
}
```

**Output**:
```
State 1: NEW
State 2: RUNNABLE
Thread running
State 3: TIMED_WAITING
Thread ending
State 4: TERMINATED
```

---

## State Transitions

### NEW → RUNNABLE
```java
thread.start();
```

### RUNNABLE → RUNNING
```
CPU scheduler picks the thread
```

### RUNNING → RUNNABLE
```
CPU time slice ends
```

### RUNNING → BLOCKED
```java
synchronized(obj) {
    // Waiting for lock
}
```

### RUNNING → WAITING
```java
wait();
```

### RUNNING → TIMED_WAITING
```java
Thread.sleep(1000);
```

### WAITING → RUNNABLE
```java
notify(); // or notifyAll()
```

### TIMED_WAITING → RUNNABLE
```
Timeout expires
```

### BLOCKED → RUNNABLE
```
Lock becomes available
```

### RUNNING → TERMINATED
```
run() method completes
```

---

## Checking Thread State

```java
Thread t = new Thread(() -> {
    System.out.println("Running");
});

// Get current state
Thread.State state = t.getState();
System.out.println("State: " + state);

// Check if alive
boolean alive = t.isAlive();
System.out.println("Alive: " + alive);
```

---

## Thread.State Enum Values

```java
Thread.State.NEW
Thread.State.RUNNABLE
Thread.State.BLOCKED
Thread.State.WAITING
Thread.State.TIMED_WAITING
Thread.State.TERMINATED
```

---

## Practical Example: Monitoring Thread

```java
class MonitorThread extends Thread {
    Thread target;
    
    MonitorThread(Thread target) {
        this.target = target;
    }
    
    public void run() {
        while (target.getState() != Thread.State.TERMINATED) {
            System.out.println("Target state: " + target.getState());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        System.out.println("Target terminated");
    }
}
```

---

## Important Methods

```java
t.getState()        // Get current state
t.isAlive()         // Check if thread is alive
t.start()           // NEW → RUNNABLE
t.join()            // Wait for thread to die
Thread.sleep(ms)    // TIMED_WAITING
wait()              // WAITING
notify()            // Wake up waiting thread
```

---

## Summary

**6 Thread States**:
1. **NEW**: Created but not started
2. **RUNNABLE**: Ready to run
3. **BLOCKED**: Waiting for lock
4. **WAITING**: Waiting indefinitely
5. **TIMED_WAITING**: Waiting for specific time
6. **TERMINATED**: Execution completed

**Key Points**:
- Use `getState()` to check current state
- Thread cannot go back to NEW after starting
- TERMINATED thread cannot be restarted
- Understanding states helps in debugging thread issues
