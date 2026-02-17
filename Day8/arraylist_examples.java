// ArrayList Examples - Simple and Easy to Understand

import java.util.*;

// Example 1: Basic ArrayList Operations
class ArrayListBasics {
    public static void demonstrate() {
        System.out.println("Example 1: Basic ArrayList Operations");

        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
    }
}

// Example 2: Adding at Specific Position
class ArrayListInsert {
    public static void demonstrate() {
        System.out.println("\nExample 2: Adding at Specific Position");

        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add(1, "Green"); // Insert at index 1

        System.out.println("Colors: " + colors);
    }
}

// Example 3: Accessing Elements
class ArrayListAccess {
    public static void demonstrate() {
        System.out.println("\nExample 3: Accessing Elements");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("First element: " + numbers.get(0));
        System.out.println("Last element: " + numbers.get(numbers.size() - 1));
    }
}

// Example 4: Updating Elements
class ArrayListUpdate {
    public static void demonstrate() {
        System.out.println("\nExample 4: Updating Elements");

        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        System.out.println("Before: " + days);
        days.set(1, "TUESDAY"); // Update index 1
        System.out.println("After: " + days);
    }
}

// Example 5: Removing Elements
class ArrayListRemove {
    public static void demonstrate() {
        System.out.println("\nExample 5: Removing Elements");

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Bird");
        animals.add("Fish");

        System.out.println("Before: " + animals);
        animals.remove(0); // Remove by index
        animals.remove("Bird"); // Remove by value
        System.out.println("After: " + animals);
    }
}

// Example 6: Checking Elements
class ArrayListCheck {
    public static void demonstrate() {
        System.out.println("\nExample 6: Checking Elements");

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        System.out.println("Contains Delhi? " + cities.contains("Delhi"));
        System.out.println("Contains Chennai? " + cities.contains("Chennai"));
        System.out.println("Is empty? " + cities.isEmpty());
    }
}

// Example 7: Iterating ArrayList
class ArrayListIteration {
    public static void demonstrate() {
        System.out.println("\nExample 7: Iterating ArrayList");

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        // Method 1: For-each loop
        System.out.print("For-each: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Method 2: For loop with index
        System.out.print("For loop: ");
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }
}

// Example 8: ArrayList with Custom Objects
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

class ArrayListCustomObjects {
    public static void demonstrate() {
        System.out.println("\nExample 8: ArrayList with Custom Objects");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));

        System.out.println("Students: " + students);
    }
}

// Example 9: Sorting ArrayList
class ArrayListSort {
    public static void demonstrate() {
        System.out.println("\nExample 9: Sorting ArrayList");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);

        System.out.println("Before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("After sorting: " + numbers);
    }
}

// Example 10: ArrayList Operations
class ArrayListOperations {
    public static void demonstrate() {
        System.out.println("\nExample 10: ArrayList Operations");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("D");
        list2.add("E");

        // Add all elements from list2
        ArrayList<String> combined = new ArrayList<>(list1);
        combined.addAll(list2);
        System.out.println("Combined: " + combined);

        // Clear list
        list2.clear();
        System.out.println("After clear: " + list2);
    }
}

public class arraylist_examples {
    public static void main(String[] args) {
        System.out.println("=== ARRAYLIST EXAMPLES ===\n");

        ArrayListBasics.demonstrate();
        ArrayListInsert.demonstrate();
        ArrayListAccess.demonstrate();
        ArrayListUpdate.demonstrate();
        ArrayListRemove.demonstrate();
        ArrayListCheck.demonstrate();
        ArrayListIteration.demonstrate();
        ArrayListCustomObjects.demonstrate();
        ArrayListSort.demonstrate();
        ArrayListOperations.demonstrate();

        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
}
