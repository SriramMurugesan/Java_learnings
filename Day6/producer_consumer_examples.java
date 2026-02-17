// Producer-Consumer Examples - Simple and Easy to Understand

import java.util.LinkedList;
import java.util.Queue;

// Example 1: Simple Producer-Consumer
class Buffer1 {
    int data;
    boolean hasData = false;

    synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer1 extends Thread {
    Buffer1 buffer;

    Producer1(Buffer1 buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer1 extends Thread {
    Buffer1 buffer;

    Consumer1(Buffer1 buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

// Example 2: With Queue
class Buffer2 {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 3;

    synchronized void produce(int value) {
        while (queue.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        queue.add(value);
        System.out.println("Produced: " + value + " (Queue size: " + queue.size() + ")");
        notify();
    }

    synchronized int consume() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value + " (Queue size: " + queue.size() + ")");
        notify();
        return value;
    }
}

class Producer2 extends Thread {
    Buffer2 buffer;

    Producer2(Buffer2 buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Consumer2 extends Thread {
    Buffer2 buffer;

    Consumer2(Buffer2 buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

class producer_consumer_examples {
    public static void main(String[] args) throws Exception {
        System.out.println("=== PRODUCER-CONSUMER EXAMPLES ===\n");

        // Example 1: Simple Producer-Consumer
        System.out.println("Example 1: Simple Producer-Consumer");
        Buffer1 buffer1 = new Buffer1();
        Producer1 p1 = new Producer1(buffer1);
        Consumer1 c1 = new Consumer1(buffer1);
        p1.start();
        c1.start();
        p1.join();
        c1.join();

        // Example 2: With Queue
        System.out.println("\nExample 2: Producer-Consumer with Queue");
        Buffer2 buffer2 = new Buffer2();
        Producer2 p2 = new Producer2(buffer2);
        Consumer2 c2 = new Consumer2(buffer2);
        p2.start();
        c2.start();
        p2.join();
        c2.join();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
