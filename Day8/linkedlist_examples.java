// LinkedList Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic LinkedList Operations
class LinkedListBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic LinkedList Operations");

        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
    }
}

// Example 2: Adding at First and Last
class LinkedListFirstLast {
    public static void demonstrate() {
        System.out.println("\nExample 2: Adding at First and Last");

        LinkedList<String> colors = new LinkedList<>();
        colors.add("Green");
        colors.addFirst("Red"); // Add at beginning
        colors.addLast("Blue"); // Add at end

        System.out.println("Colors: " + colors);
    }
}

// Example 3: Getting First and Last
class LinkedListGetFirstLast {
    public static void demonstrate() {
        System.out.println("\nExample 3: Getting First and Last");

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("First: " + numbers.getFirst());
        System.out.println("Last: " + numbers.getLast());
    }
}

// Example 4: Removing First and Last
class LinkedListRemoveFirstLast {
    public static void demonstrate() {
        System.out.println("\nExample 4: Removing First and Last");

        LinkedList<String> days = new LinkedList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");

        System.out.println("Before: " + days);
        days.removeFirst();
        days.removeLast();
        System.out.println("After: " + days);
    }
}

// Example 5: LinkedList as Queue (FIFO)
class LinkedListAsQueue {
    public static void demonstrate() {
        System.out.println("\nExample 5: LinkedList as Queue (FIFO)");

        LinkedList<String> queue = new LinkedList<>();

        // Enqueue (add to end)
        queue.offer("Customer 1");
        queue.offer("Customer 2");
        queue.offer("Customer 3");

        System.out.println("Queue: " + queue);

        // Dequeue (remove from front)
        System.out.println("Serving: " + queue.poll());
        System.out.println("Serving: " + queue.poll());
        System.out.println("Remaining: " + queue);
    }
}

// Example 6: LinkedList as Stack (LIFO)
class LinkedListAsStack {
    public static void demonstrate() {
        System.out.println("\nExample 6: LinkedList as Stack (LIFO)");

        LinkedList<String> stack = new LinkedList<>();

        // Push (add to top)
        stack.push("Plate 1");
        stack.push("Plate 2");
        stack.push("Plate 3");

        System.out.println("Stack: " + stack);

        // Pop (remove from top)
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Remaining: " + stack);
    }
}

// Example 7: Iterating LinkedList
class LinkedListIteration {
    public static void demonstrate() {
        System.out.println("\nExample 7: Iterating LinkedList");

        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        System.out.print("Elements: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Example 8: Peek Operations
class LinkedListPeek {
    public static void demonstrate() {
        System.out.println("\nExample 8: Peek Operations");

        LinkedList<String> list = new LinkedList<>();
        list.add("First");
        list.add("Middle");
        list.add("Last");

        // Peek doesn't remove elements
        System.out.println("Peek First: " + list.peekFirst());
        System.out.println("Peek Last: " + list.peekLast());
        System.out.println("List unchanged: " + list);
    }
}

// Example 9: Contains and Index
class LinkedListSearch {
    public static void demonstrate() {
        System.out.println("\nExample 9: Contains and Index");

        LinkedList<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        System.out.println("Contains Mumbai? " + cities.contains("Mumbai"));
        System.out.println("Index of Bangalore: " + cities.indexOf("Bangalore"));
    }
}

// Example 10: Converting to Array
class LinkedListToArray {
    public static void demonstrate() {
        System.out.println("\nExample 10: Converting to Array");

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Convert to array
        String[] array = list.toArray(new String[0]);

        System.out.print("Array: ");
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

public class linkedlist_examples {
    public static void main(String[] args) {
        System.out.println("=== LINKEDLIST EXAMPLES ===\n");

        LinkedListBasics.demonstrate();
        LinkedListFirstLast.demonstrate();
        LinkedListGetFirstLast.demonstrate();
        LinkedListRemoveFirstLast.demonstrate();
        LinkedListAsQueue.demonstrate();
        LinkedListAsStack.demonstrate();
        LinkedListIteration.demonstrate();
        LinkedListPeek.demonstrate();
        LinkedListSearch.demonstrate();
        LinkedListToArray.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
