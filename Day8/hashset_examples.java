// HashSet Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic HashSet Operations
class HashSetBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic HashSet Operations");

        HashSet<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate - will be ignored

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
    }
}

// Example 2: Adding Duplicates
class HashSetDuplicates {
    public static void demonstrate() {
        System.out.println("\nExample 2: Adding Duplicates");

        HashSet<Integer> numbers = new HashSet<>();

        System.out.println("Adding 10: " + numbers.add(10)); // true
        System.out.println("Adding 20: " + numbers.add(20)); // true
        System.out.println("Adding 10 again: " + numbers.add(10)); // false (duplicate)

        System.out.println("Set: " + numbers);
    }
}

// Example 3: Removing Elements
class HashSetRemove {
    public static void demonstrate() {
        System.out.println("\nExample 3: Removing Elements");

        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("Before: " + colors);
        colors.remove("Green");
        System.out.println("After removing Green: " + colors);
    }
}

// Example 4: Contains Check
class HashSetContains {
    public static void demonstrate() {
        System.out.println("\nExample 4: Contains Check");

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        System.out.println("Contains Delhi? " + cities.contains("Delhi"));
        System.out.println("Contains Chennai? " + cities.contains("Chennai"));
    }
}

// Example 5: Iterating HashSet
class HashSetIteration {
    public static void demonstrate() {
        System.out.println("\nExample 5: Iterating HashSet");

        HashSet<Integer> nums = new HashSet<>();
        nums.add(5);
        nums.add(2);
        nums.add(8);
        nums.add(1);

        System.out.print("Elements (unordered): ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Example 6: Removing Duplicates from List
class HashSetRemoveDuplicates {
    public static void demonstrate() {
        System.out.println("\nExample 6: Removing Duplicates from List");

        List<String> listWithDuplicates = Arrays.asList("A", "B", "A", "C", "B", "D");

        System.out.println("Original list: " + listWithDuplicates);

        HashSet<String> uniqueSet = new HashSet<>(listWithDuplicates);
        System.out.println("Unique elements: " + uniqueSet);
    }
}

// Example 7: Set Operations - Union
class HashSetUnion {
    public static void demonstrate() {
        System.out.println("\nExample 7: Set Operations - Union");

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + union);
    }
}

// Example 8: Set Operations - Intersection
class HashSetIntersection {
    public static void demonstrate() {
        System.out.println("\nExample 8: Set Operations - Intersection");

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Intersection: " + intersection);
    }
}

// Example 9: Set Operations - Difference
class HashSetDifference {
    public static void demonstrate() {
        System.out.println("\nExample 9: Set Operations - Difference");

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Difference (Set1 - Set2): " + difference);
    }
}

// Example 10: Clear and Empty Check
class HashSetClear {
    public static void demonstrate() {
        System.out.println("\nExample 10: Clear and Empty Check");

        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");

        System.out.println("Before clear: " + set);
        System.out.println("Is empty? " + set.isEmpty());

        set.clear();
        System.out.println("After clear: " + set);
        System.out.println("Is empty? " + set.isEmpty());
    }
}

public class hashset_examples {
    public static void main(String[] args) {
        System.out.println("=== HASHSET EXAMPLES ===\n");

        HashSetBasics.demonstrate();
        HashSetDuplicates.demonstrate();
        HashSetRemove.demonstrate();
        HashSetContains.demonstrate();
        HashSetIteration.demonstrate();
        HashSetRemoveDuplicates.demonstrate();
        HashSetUnion.demonstrate();
        HashSetIntersection.demonstrate();
        HashSetDifference.demonstrate();
        HashSetClear.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
