// Runnable Interface Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic Runnable
class MyRunnable1 implements Runnable {
    public void run() {
        System.out.println("Runnable is running");
    }
}

// Example 2: Runnable with Loop
class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}

// Example 3: Runnable with Constructor
class RunnableTask implements Runnable {
    String taskName;
    
    RunnableTask(String name) {
        this.taskName = name;
    }
    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + ": " + i);
        }
    }
}

// Example 4: Shared Runnable
class RunnableCounter implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class runnable_examples {
    public static void main(String[] args) throws Exception {
        System.out.println("=== RUNNABLE INTERFACE EXAMPLES ===\n");
        
        // Example 1: Basic Runnable
        System.out.println("Example 1: Basic Runnable");
        MyRunnable1 r1 = new MyRunnable1();
        Thread t1 = new Thread(r1);
        t1.start();
        t1.join();
        
        // Example 2: Runnable with Loop
        System.out.println("\nExample 2: Runnable with Loop");
        MyRunnable2 r2 = new MyRunnable2();
        Thread t2 = new Thread(r2);
        t2.start();
        t2.join();
        
        // Example 3: Runnable with Constructor
        System.out.println("\nExample 3: Named Tasks");
        Thread t3 = new Thread(new RunnableTask("RunnableTask-A"));
        Thread t4 = new Thread(new RunnableTask("RunnableTask-B"));
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        
        // Example 4: Shared Runnable
        System.out.println("\nExample 4: Shared Runnable");
        RunnableCounter counter = new RunnableCounter();
        Thread t5 = new Thread(counter, "Thread-1");
        Thread t6 = new Thread(counter, "Thread-2");
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        
        // Example 5: Anonymous Class
        System.out.println("\nExample 5: Anonymous Class");
        Thread t7 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous runnable");
            }
        });
        t7.start();
        t7.join();
        
        // Example 6: Lambda Expression
        System.out.println("\nExample 6: Lambda Expression");
        Thread t8 = new Thread(() -> {
            System.out.println("Lambda runnable");
        });
        t8.start();
        t8.join();
        
        // Example 7: Lambda with Loop
        System.out.println("\nExample 7: Lambda with Loop");
        Thread t9 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda: " + i);
            }
        });
        t9.start();
        t9.join();
        
        // Example 8: Multiple Lambda Threads
        System.out.println("\nExample 8: Multiple Lambda Threads");
        Thread t10 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread A: " + i);
            }
        });
        
        Thread t11 = new Thread(() -> {
            for (char c = 'X'; c <= 'Z'; c++) {
                System.out.println("Thread B: " + c);
            }
        });
        
        t10.start();
        t11.start();
        t10.join();
        t11.join();
        
        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
