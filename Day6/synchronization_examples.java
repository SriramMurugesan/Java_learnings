// Synchronization Examples - Simple and Easy to Understand

// Example 1: Without Synchronization (Race Condition)
class Counter1 {
    int count = 0;
    
    void increment() {
        count++;
    }
}

// Example 2: With Synchronized Method
class Counter2 {
    int count = 0;
    
    synchronized void increment() {
        count++;
    }
}

// Example 3: Synchronized Block
class Counter3 {
    int count = 0;
    
    void increment() {
        synchronized(this) {
            count++;
        }
    }
}

// Example 4: Table Printing
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}

// Example 5: Bank Account
class BankAccount {
    int balance = 1000;
    
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
            balance -= amount;
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class synchronization_examples {
    public static void main(String[] args) throws Exception {
        System.out.println("=== SYNCHRONIZATION EXAMPLES ===\n");
        
        // Example 1: Race Condition
        System.out.println("Example 1: Without Synchronization");
        Counter1 c1 = new Counter1();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c1.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c1.increment();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count: " + c1.count + " (Expected: 2000)");
        
        // Example 2: With Synchronization
        System.out.println("\nExample 2: With Synchronization");
        Counter2 c2 = new Counter2();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c2.increment();
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c2.increment();
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Count: " + c2.count + " (Expected: 2000)");
        
        // Example 3: Synchronized Block
        System.out.println("\nExample 3: Synchronized Block");
        Counter3 c3 = new Counter3();
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c3.increment();
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c3.increment();
        });
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        System.out.println("Count: " + c3.count + " (Expected: 2000)");
        
        // Example 4: Table Printing
        System.out.println("\nExample 4: Synchronized Table Printing");
        Table table = new Table();
        Thread t7 = new Thread(() -> table.printTable(5));
        Thread t8 = new Thread(() -> table.printTable(10));
        t7.start();
        t8.start();
        t7.join();
        t8.join();
        
        // Example 5: Bank Account
        System.out.println("\nExample 5: Bank Account");
        BankAccount account = new BankAccount();
        Thread t9 = new Thread(() -> account.withdraw(600), "Person-1");
        Thread t10 = new Thread(() -> account.withdraw(600), "Person-2");
        t9.start();
        t10.start();
        t9.join();
        t10.join();
        
        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
