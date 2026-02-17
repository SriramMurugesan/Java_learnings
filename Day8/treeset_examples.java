// TreeSet Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic TreeSet (Automatic Sorting)
class TreeSetBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic TreeSet (Automatic Sorting)");

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(40);

        System.out.println("TreeSet (sorted): " + numbers);
    }
}

// Example 2: String TreeSet
class TreeSetStrings {
    public static void demonstrate() {
        System.out.println("\nExample 2: String TreeSet");

        TreeSet<String> fruits = new TreeSet<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        System.out.println("Fruits (alphabetical): " + fruits);
    }
}

// Example 3: Duplicates Ignored
class TreeSetDuplicates {
    public static void demonstrate() {
        System.out.println("\nExample 3: Duplicates Ignored");

        TreeSet<Integer> set = new TreeSet<>();

        System.out.println("Adding 10: " + set.add(10)); // true
        System.out.println("Adding 20: " + set.add(20)); // true
        System.out.println("Adding 10 again: " + set.add(10)); // false

        System.out.println("Set: " + set);
    }
}

// Example 4: First and Last
class TreeSetFirstLast {
    public static void demonstrate() {
        System.out.println("\nExample 4: First and Last");

        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));

        System.out.println("Set: " + numbers);
        System.out.println("First (smallest): " + numbers.first());
        System.out.println("Last (largest): " + numbers.last());
    }
}

// Example 5: Higher and Lower
class TreeSetHigherLower {
    public static void demonstrate() {
        System.out.println("\nExample 5: Higher and Lower");

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("Set: " + set);
        System.out.println("Higher than 25: " + set.higher(25));
        System.out.println("Lower than 25: " + set.lower(25));
    }
}

// Example 6: Ceiling and Floor
class TreeSetCeilingFloor {
    public static void demonstrate() {
        System.out.println("\nExample 6: Ceiling and Floor");

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("Set: " + set);
        System.out.println("Ceiling of 25: " + set.ceiling(25)); // >= 25
        System.out.println("Floor of 25: " + set.floor(25)); // <= 25
        System.out.println("Ceiling of 30: " + set.ceiling(30)); // >= 30
    }
}

// Example 7: Descending Order
class TreeSetDescending {
    public static void demonstrate() {
        System.out.println("\nExample 7: Descending Order");

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));

        System.out.println("Ascending: " + set);
        System.out.println("Descending: " + set.descendingSet());
    }
}

// Example 8: SubSet (Range)
class TreeSetSubSet {
    public static void demonstrate() {
        System.out.println("\nExample 8: SubSet (Range)");

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

        System.out.println("Full set: " + set);
        System.out.println("SubSet (20 to 50): " + set.subSet(20, 50));
        System.out.println("HeadSet (< 40): " + set.headSet(40));
        System.out.println("TailSet (>= 40): " + set.tailSet(40));
    }
}

// Example 9: Custom Comparator (Reverse Order)
class TreeSetCustomComparator {
    public static void demonstrate() {
        System.out.println("\nExample 9: Custom Comparator (Reverse Order)");

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        set.add(50);
        set.add(20);
        set.add(80);
        set.add(10);

        System.out.println("Descending order: " + set);
    }
}

// Example 10: Polling Elements
class TreeSetPolling {
    public static void demonstrate() {
        System.out.println("\nExample 10: Polling Elements");

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("Original: " + set);
        System.out.println("Poll First: " + set.pollFirst()); // Remove smallest
        System.out.println("Poll Last: " + set.pollLast()); // Remove largest
        System.out.println("After polling: " + set);
    }
}

public class treeset_examples {
    public static void main(String[] args) {
        System.out.println("=== TREESET EXAMPLES ===\n");

        TreeSetBasics.demonstrate();
        TreeSetStrings.demonstrate();
        TreeSetDuplicates.demonstrate();
        TreeSetFirstLast.demonstrate();
        TreeSetHigherLower.demonstrate();
        TreeSetCeilingFloor.demonstrate();
        TreeSetDescending.demonstrate();
        TreeSetSubSet.demonstrate();
        TreeSetCustomComparator.demonstrate();
        TreeSetPolling.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
