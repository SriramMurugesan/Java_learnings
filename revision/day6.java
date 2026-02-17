// Day 6 Revision: Threads & Java 8 Features

import java.util.*;

// Thread using Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

// Thread using Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}

// Synchronized class
class Counter {
    int count = 0;
    
    synchronized void increment() {
        count++;
    }
}

// Producer-Consumer
class Buffer {
    int data;
    boolean hasData = false;
    
    synchronized void produce(int value) {
        while (hasData) {
            try { wait(); } catch (Exception e) {}
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }
    
    synchronized int consume() {
        while (!hasData) {
            try { wait(); } catch (Exception e) {}
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class day6 {
    public static void main(String[] args) throws Exception {
        
        // 1. Thread Class
        System.out.println("=== THREAD CLASS ===");
        MyThread t1 = new MyThread();
        t1.start();
        t1.join();
        
        // 2. Runnable Interface
        System.out.println("\n=== RUNNABLE INTERFACE ===");
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        t2.join();
        
        // 3. Lambda Thread
        System.out.println("\n=== LAMBDA THREAD ===");
        Thread t3 = new Thread(() -> System.out.println("Lambda thread"));
        t3.start();
        t3.join();
        
        // 4. Synchronization
        System.out.println("\n=== SYNCHRONIZATION ===");
        Counter counter = new Counter();
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });
        t4.start();
        t5.start();
        t4.join();
        t5.join();
        System.out.println("Count: " + counter.count);
        
        // 5. Producer-Consumer
        System.out.println("\n=== PRODUCER-CONSUMER ===");
        Buffer buffer = new Buffer();
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) buffer.produce(i);
        });
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) buffer.consume();
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        
        // 6. Thread States
        System.out.println("\n=== THREAD STATES ===");
        Thread t6 = new Thread(() -> {
            try { Thread.sleep(100); } catch (Exception e) {}
        });
        System.out.println("State 1: " + t6.getState()); // NEW
        t6.start();
        System.out.println("State 2: " + t6.getState()); // RUNNABLE
        t6.join();
        System.out.println("State 3: " + t6.getState()); // TERMINATED
        
        // 7. Lambda Expression
        System.out.println("\n=== LAMBDA EXPRESSION ===");
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
        
        // 8. Lambda with Collections
        System.out.println("\n=== LAMBDA WITH COLLECTIONS ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Numbers:");
        numbers.forEach(n -> System.out.print(n + " "));
        
        System.out.println("\nEven numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.print(n + " "));
        
        // 9. Optional Class
        System.out.println("\n\n=== OPTIONAL CLASS ===");
        Optional<String> opt1 = Optional.of("Hello");
        Optional<String> opt2 = Optional.empty();
        
        System.out.println("opt1 present: " + opt1.isPresent());
        System.out.println("opt1 value: " + opt1.get());
        
        System.out.println("opt2 present: " + opt2.isPresent());
        System.out.println("opt2 value: " + opt2.orElse("Default"));
        
        opt1.ifPresent(value -> System.out.println("Value: " + value));
    }
}
