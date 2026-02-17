// LinkedHashSet Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic LinkedHashSet (Maintains Insertion Order)
class LinkedHashSetBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic LinkedHashSet (Maintains Insertion Order)");

        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        System.out.println("Fruits (insertion order): " + fruits);
    }
}

// Example 2: Insertion Order vs HashSet
class LinkedHashSetVsHashSet {
    public static void demonstrate() {
        System.out.println("\nExample 2: Insertion Order vs HashSet");

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        int[] numbers = { 50, 20, 80, 10, 40 };

        for (int num : numbers) {
            hashSet.add(num);
            linkedHashSet.add(num);
        }

        System.out.println("HashSet (no order): " + hashSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
    }
}

// Example 3: Duplicates Ignored
class LinkedHashSetDuplicates {
    public static void demonstrate() {
        System.out.println("\nExample 3: Duplicates Ignored");

        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("A");
        set.add("B");
        set.add("A"); // Duplicate - ignored
        set.add("C");
        set.add("B"); // Duplicate - ignored

        System.out.println("Set (no duplicates): " + set);
    }
}

// Example 4: Removing Elements
class LinkedHashSetRemove {
    public static void demonstrate() {
        System.out.println("\nExample 4: Removing Elements");

        LinkedHashSet<String> colors = new LinkedHashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Before: " + colors);
        colors.remove("Green");
        System.out.println("After removing Green: " + colors);
    }
}

// Example 5: Iterating in Order
class LinkedHashSetIteration {
    public static void demonstrate() {
        System.out.println("\nExample 5: Iterating in Order");

        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        System.out.print("Iteration (insertion order): ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Example 6: Removing Duplicates While Preserving Order
class LinkedHashSetPreserveOrder {
    public static void demonstrate() {
        System.out.println("\nExample 6: Removing Duplicates While Preserving Order");

        List<String> listWithDuplicates = Arrays.asList("A", "B", "A", "C", "B", "D");

        System.out.println("Original list: " + listWithDuplicates);

        LinkedHashSet<String> uniqueSet = new LinkedHashSet<>(listWithDuplicates);
        System.out.println("Unique (order preserved): " + uniqueSet);
    }
}

// Example 7: Contains Check
class LinkedHashSetContains {
    public static void demonstrate() {
        System.out.println("\nExample 7: Contains Check");

        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        System.out.println("Contains Mumbai? " + cities.contains("Mumbai"));
        System.out.println("Contains Chennai? " + cities.contains("Chennai"));
    }
}

// Example 8: Size and Empty Check
class LinkedHashSetSize {
    public static void demonstrate() {
        System.out.println("\nExample 8: Size and Empty Check");

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        System.out.println("Is empty? " + set.isEmpty());

        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());
    }
}

// Example 9: Converting to ArrayList
class LinkedHashSetToList {
    public static void demonstrate() {
        System.out.println("\nExample 9: Converting to ArrayList");

        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("First");
        set.add("Second");
        set.add("Third");

        ArrayList<String> list = new ArrayList<>(set);

        System.out.println("LinkedHashSet: " + set);
        System.out.println("ArrayList: " + list);
    }
}

// Example 10: Clear Operation
class LinkedHashSetClear {
    public static void demonstrate() {
        System.out.println("\nExample 10: Clear Operation");

        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        System.out.println("Before clear: " + set);
        set.clear();
        System.out.println("After clear: " + set);
        System.out.println("Is empty? " + set.isEmpty());
    }
}

public class linkedhashset_examples {
    public static void main(String[] args) {
        System.out.println("=== LINKEDHASHSET EXAMPLES ===\n");

        LinkedHashSetBasics.demonstrate();
        LinkedHashSetVsHashSet.demonstrate();
        LinkedHashSetDuplicates.demonstrate();
        LinkedHashSetRemove.demonstrate();
        LinkedHashSetIteration.demonstrate();
        LinkedHashSetPreserveOrder.demonstrate();
        LinkedHashSetContains.demonstrate();
        LinkedHashSetSize.demonstrate();
        LinkedHashSetToList.demonstrate();
        LinkedHashSetClear.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
