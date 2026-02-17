// PriorityQueue Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic PriorityQueue (Min Heap)
class PriorityQueueBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic PriorityQueue (Min Heap)");

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);

        System.out.println("PriorityQueue: " + pq);
        System.out.println("Peek (highest priority): " + pq.peek());
    }
}

// Example 2: Polling Elements
class PriorityQueuePoll {
    public static void demonstrate() {
        System.out.println("\nExample 2: Polling Elements");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(20);
        pq.add(80);
        pq.add(10);

        System.out.println("Polling in priority order:");
        while (!pq.isEmpty()) {
            System.out.println("Polled: " + pq.poll());
        }
    }
}

// Example 3: Max Heap (Reverse Order)
class PriorityQueueMaxHeap {
    public static void demonstrate() {
        System.out.println("\nExample 3: Max Heap (Reverse Order)");

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(50);

        System.out.println("Max Heap - Peek: " + pq.peek());
        System.out.println("Polling: " + pq.poll());
        System.out.println("Next Peek: " + pq.peek());
    }
}

// Example 4: String PriorityQueue
class PriorityQueueStrings {
    public static void demonstrate() {
        System.out.println("\nExample 4: String PriorityQueue");

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Banana");
        pq.add("Apple");
        pq.add("Orange");
        pq.add("Mango");

        System.out.println("Alphabetical order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Example 5: Custom Objects with Comparable
class Task implements Comparable<Task> {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int compareTo(Task other) {
        return this.priority - other.priority; // Lower number = higher priority
    }

    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

class PriorityQueueCustomObjects {
    public static void demonstrate() {
        System.out.println("\nExample 5: Custom Objects with Comparable");

        PriorityQueue<Task> pq = new PriorityQueue<>();

        pq.add(new Task("Low Priority Task", 3));
        pq.add(new Task("High Priority Task", 1));
        pq.add(new Task("Medium Priority Task", 2));

        System.out.println("Processing tasks by priority:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Example 6: Custom Comparator
class PriorityQueueComparator {
    public static void demonstrate() {
        System.out.println("\nExample 6: Custom Comparator");

        // Sort by string length
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> a.length() - b.length());

        pq.add("Apple");
        pq.add("Banana");
        pq.add("Kiwi");
        pq.add("Strawberry");

        System.out.println("By length:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

// Example 7: Size and Contains
class PriorityQueueCheck {
    public static void demonstrate() {
        System.out.println("\nExample 7: Size and Contains");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);

        System.out.println("Size: " + pq.size());
        System.out.println("Contains 20? " + pq.contains(20));
        System.out.println("Contains 40? " + pq.contains(40));
    }
}

// Example 8: Remove Specific Element
class PriorityQueueRemove {
    public static void demonstrate() {
        System.out.println("\nExample 8: Remove Specific Element");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);

        System.out.println("Before: " + pq);
        pq.remove(30); // Remove specific element
        System.out.println("After removing 30: " + pq);
    }
}

// Example 9: Top K Elements
class PriorityQueueTopK {
    public static void demonstrate() {
        System.out.println("\nExample 9: Top K Elements");

        int[] numbers = { 5, 15, 10, 20, 8, 25, 18 };
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : numbers) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // Remove smallest
            }
        }

        System.out.println("Top " + k + " largest elements: " + pq);
    }
}

// Example 10: Clear Operation
class PriorityQueueClear {
    public static void demonstrate() {
        System.out.println("\nExample 10: Clear Operation");

        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("A");
        pq.add("B");
        pq.add("C");

        System.out.println("Before clear: " + pq);
        pq.clear();
        System.out.println("After clear: " + pq);
        System.out.println("Is empty? " + pq.isEmpty());
    }
}

public class priorityqueue_examples {
    public static void main(String[] args) {
        System.out.println("=== PRIORITYQUEUE EXAMPLES ===\n");

        PriorityQueueBasics.demonstrate();
        PriorityQueuePoll.demonstrate();
        PriorityQueueMaxHeap.demonstrate();
        PriorityQueueStrings.demonstrate();
        PriorityQueueCustomObjects.demonstrate();
        PriorityQueueComparator.demonstrate();
        PriorityQueueCheck.demonstrate();
        PriorityQueueRemove.demonstrate();
        PriorityQueueTopK.demonstrate();
        PriorityQueueClear.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
