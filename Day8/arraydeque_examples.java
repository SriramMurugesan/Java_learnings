// ArrayDeque Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic ArrayDeque Operations
class ArrayDequeBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic ArrayDeque Operations");

        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.add("A");
        deque.add("B");
        deque.add("C");

        System.out.println("Deque: " + deque);
        System.out.println("Size: " + deque.size());
    }
}

// Example 2: Adding at Both Ends
class ArrayDequeAddBothEnds {
    public static void demonstrate() {
        System.out.println("\nExample 2: Adding at Both Ends");

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10); // Add at front
        deque.addLast(20); // Add at end
        deque.addFirst(5); // Add at front
        deque.addLast(25); // Add at end

        System.out.println("Deque: " + deque);
    }
}

// Example 3: Removing from Both Ends
class ArrayDequeRemoveBothEnds {
    public static void demonstrate() {
        System.out.println("\nExample 3: Removing from Both Ends");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("First");
        deque.add("Middle");
        deque.add("Last");

        System.out.println("Before: " + deque);
        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from end: " + deque.removeLast());
        System.out.println("After: " + deque);
    }
}

// Example 4: ArrayDeque as Stack (LIFO)
class ArrayDequeAsStack {
    public static void demonstrate() {
        System.out.println("\nExample 4: ArrayDeque as Stack (LIFO)");

        ArrayDeque<String> stack = new ArrayDeque<>();

        // Push operations
        stack.push("Book 1");
        stack.push("Book 2");
        stack.push("Book 3");

        System.out.println("Stack: " + stack);

        // Pop operations
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Remaining: " + stack);
    }
}

// Example 5: ArrayDeque as Queue (FIFO)
class ArrayDequeAsQueue {
    public static void demonstrate() {
        System.out.println("\nExample 5: ArrayDeque as Queue (FIFO)");

        ArrayDeque<String> queue = new ArrayDeque<>();

        // Enqueue (offer)
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");

        System.out.println("Queue: " + queue);

        // Dequeue (poll)
        System.out.println("Processing: " + queue.poll());
        System.out.println("Processing: " + queue.poll());
        System.out.println("Remaining: " + queue);
    }
}

// Example 6: Peek Operations
class ArrayDequePeek {
    public static void demonstrate() {
        System.out.println("\nExample 6: Peek Operations");

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);

        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());
        System.out.println("Deque unchanged: " + deque);
    }
}

// Example 7: Iterating ArrayDeque
class ArrayDequeIteration {
    public static void demonstrate() {
        System.out.println("\nExample 7: Iterating ArrayDeque");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("Red");
        deque.add("Green");
        deque.add("Blue");

        System.out.print("Forward: ");
        for (String color : deque) {
            System.out.print(color + " ");
        }
        System.out.println();

        System.out.print("Reverse: ");
        Iterator<String> it = deque.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}

// Example 8: Contains and Size
class ArrayDequeCheck {
    public static void demonstrate() {
        System.out.println("\nExample 8: Contains and Size");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("Apple");
        deque.add("Banana");
        deque.add("Orange");

        System.out.println("Contains Banana? " + deque.contains("Banana"));
        System.out.println("Size: " + deque.size());
        System.out.println("Is empty? " + deque.isEmpty());
    }
}

// Example 9: Clear Operation
class ArrayDequeClear {
    public static void demonstrate() {
        System.out.println("\nExample 9: Clear Operation");

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println("Before clear: " + deque);
        deque.clear();
        System.out.println("After clear: " + deque);
        System.out.println("Is empty? " + deque.isEmpty());
    }
}

// Example 10: Poll vs Remove
class ArrayDequePollVsRemove {
    public static void demonstrate() {
        System.out.println("\nExample 10: Poll vs Remove");

        ArrayDeque<String> deque = new ArrayDeque<>();

        // poll() returns null if empty
        System.out.println("Poll from empty: " + deque.pollFirst());

        deque.add("Element");
        System.out.println("Poll from non-empty: " + deque.pollFirst());

        // remove() throws exception if empty
        try {
            deque.removeFirst(); // Will throw exception
        } catch (NoSuchElementException e) {
            System.out.println("Remove from empty throws exception");
        }
    }
}

public class arraydeque_examples {
    public static void main(String[] args) {
        System.out.println("=== ARRAYDEQUE EXAMPLES ===\n");

        ArrayDequeBasics.demonstrate();
        ArrayDequeAddBothEnds.demonstrate();
        ArrayDequeRemoveBothEnds.demonstrate();
        ArrayDequeAsStack.demonstrate();
        ArrayDequeAsQueue.demonstrate();
        ArrayDequePeek.demonstrate();
        ArrayDequeIteration.demonstrate();
        ArrayDequeCheck.demonstrate();
        ArrayDequeClear.demonstrate();
        ArrayDequePollVsRemove.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
