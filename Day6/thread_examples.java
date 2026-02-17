// Thread Class Examples - Simple and Easy to Understand

// Example 1: Basic Thread
class MyThread1 extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

// Example 2: Thread with Loop
class MyThread2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}

// Example 3: Thread with sleep()
class MyThread3 extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // Sleep 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Example 4: Multiple Threads
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

// Example 5: Thread with Constructor
class NamedThread extends Thread {
    String threadName;
    
    NamedThread(String name) {
        this.threadName = name;
    }
    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
}

// Example 6: Thread Priority
class PriorityThread extends Thread {
    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
    }
}

// Example 7: Thread Methods
class ThreadMethods extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread ID: " + getId());
        System.out.println("Is Alive: " + isAlive());
    }
}

public class thread_examples {
    public static void main(String[] args) throws Exception {
        System.out.println("=== THREAD CLASS EXAMPLES ===\n");
        
        // Example 1
        System.out.println("Example 1: Basic Thread");
        MyThread1 t1 = new MyThread1();
        t1.start();
        Thread.sleep(100);
        
        // Example 2
        System.out.println("\nExample 2: Thread with Loop");
        MyThread2 t2 = new MyThread2();
        t2.start();
        Thread.sleep(100);
        
        // Example 3
        System.out.println("\nExample 3: Thread with sleep()");
        MyThread3 t3 = new MyThread3();
        t3.start();
        t3.join(); // Wait for thread to finish
        
        // Example 4
        System.out.println("\nExample 4: Multiple Threads");
        PrintNumbers pn = new PrintNumbers();
        PrintLetters pl = new PrintLetters();
        pn.start();
        pl.start();
        pn.join();
        pl.join();
        
        // Example 5
        System.out.println("\nExample 5: Named Threads");
        NamedThread nt1 = new NamedThread("Thread-A");
        NamedThread nt2 = new NamedThread("Thread-B");
        nt1.start();
        nt2.start();
        nt1.join();
        nt2.join();
        
        // Example 6
        System.out.println("\nExample 6: Thread Priority");
        PriorityThread pt1 = new PriorityThread();
        PriorityThread pt2 = new PriorityThread();
        pt1.setPriority(Thread.MIN_PRIORITY);
        pt2.setPriority(Thread.MAX_PRIORITY);
        pt1.start();
        pt2.start();
        pt1.join();
        pt2.join();
        
        // Example 7
        System.out.println("\nExample 7: Thread Methods");
        ThreadMethods tm = new ThreadMethods();
        tm.setName("MyThread");
        tm.start();
        tm.join();
        
        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
