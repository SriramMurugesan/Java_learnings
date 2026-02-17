// Day 8 Revision: Collection Framework

import java.util.*;

public class day8 {
    public static void main(String[] args) {

        // 1. ARRAYLIST
        System.out.println("=== ARRAYLIST ===");
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Mango");
        System.out.println("ArrayList: " + list);
        System.out.println("Get index 0: " + list.get(0));
        list.remove("Banana");
        System.out.println("After remove: " + list);
        System.out.println("Size: " + list.size());

        // 2. LINKEDLIST
        System.out.println("\n=== LINKEDLIST ===");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.addFirst(5);
        linkedList.addLast(40);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After remove: " + linkedList);

        // 3. ARRAYDEQUE (Stack)
        System.out.println("\n=== ARRAYDEQUE AS STACK ===");
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);

        // 4. ARRAYDEQUE (Queue)
        System.out.println("\n=== ARRAYDEQUE AS QUEUE ===");
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("After poll: " + queue);

        // 5. PRIORITYQUEUE (Min Heap)
        System.out.println("\n=== PRIORITYQUEUE (MIN HEAP) ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        System.out.println("Min Heap: " + minHeap);
        System.out.println("Peek (min): " + minHeap.peek());
        System.out.println("Poll (min): " + minHeap.poll());
        System.out.println("After poll: " + minHeap);

        // 6. PRIORITYQUEUE (Max Heap)
        System.out.println("\n=== PRIORITYQUEUE (MAX HEAP) ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(50);
        System.out.println("Max Heap: " + maxHeap);
        System.out.println("Peek (max): " + maxHeap.peek());
        System.out.println("Poll (max): " + maxHeap.poll());
        System.out.println("After poll: " + maxHeap);

        // 7. HASHSET
        System.out.println("\n=== HASHSET ===");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate - won't be added
        System.out.println("HashSet: " + hashSet);
        System.out.println("Contains Apple: " + hashSet.contains("Apple"));
        hashSet.remove("Banana");
        System.out.println("After remove: " + hashSet);
        System.out.println("Size: " + hashSet.size());

        // 8. TREESET
        System.out.println("\n=== TREESET ===");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        treeSet.add(30);
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println("First: " + treeSet.first());
        System.out.println("Last: " + treeSet.last());
        System.out.println("Higher than 30: " + treeSet.higher(30));
        System.out.println("Lower than 50: " + treeSet.lower(50));

        // 9. LINKEDHASHSET
        System.out.println("\n=== LINKEDHASHSET ===");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("Third");
        linkedHashSet.add("First"); // Duplicate - won't be added
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        // 10. SET OPERATIONS
        System.out.println("\n=== SET OPERATIONS ===");
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Union
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Intersection
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Difference
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);

        // 11. ITERATION
        System.out.println("\n=== ITERATION ===");
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

        // For-each loop
        System.out.print("For-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }

        // Iterator
        System.out.print("\nIterator: ");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // forEach with lambda
        System.out.print("\nLambda: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));

        // 12. SORTING
        System.out.println("\n\n=== SORTING ===");
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("Original: " + numbers);

        Collections.sort(numbers);
        System.out.println("Ascending: " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending: " + numbers);

        // 13. CUSTOM SORTING
        System.out.println("\n=== CUSTOM SORTING ===");
        ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Alice", "Bob", "Charlie"));
        System.out.println("Original: " + names);

        // Sort by length
        Collections.sort(names, (a, b) -> a.length() - b.length());
        System.out.println("By length: " + names);

        // Sort by reverse alphabetical
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println("Reverse alphabetical: " + names);

        // 14. SEARCHING
        System.out.println("\n=== SEARCHING ===");
        ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int index = Collections.binarySearch(sortedList, 30);
        System.out.println("Index of 30: " + index);

        // 15. CONVERSION
        System.out.println("\n=== CONVERSION ===");

        // Array to List
        String[] array = { "A", "B", "C" };
        List<String> listFromArray = Arrays.asList(array);
        System.out.println("Array to List: " + listFromArray);

        // List to Array
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        String[] arrayFromList = list2.toArray(new String[0]);
        System.out.println("List to Array: " + Arrays.toString(arrayFromList));

        // List to Set
        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
        HashSet<Integer> setFromList = new HashSet<>(listWithDuplicates);
        System.out.println("List to Set (removes duplicates): " + setFromList);

        // Set to List
        HashSet<String> set = new HashSet<>(Arrays.asList("Dog", "Cat", "Bird"));
        ArrayList<String> listFromSet = new ArrayList<>(set);
        System.out.println("Set to List: " + listFromSet);

        // 16. COMMON METHODS
        System.out.println("\n=== COMMON METHODS ===");
        ArrayList<String> items = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("isEmpty: " + items.isEmpty());
        System.out.println("contains C: " + items.contains("C"));
        System.out.println("indexOf B: " + items.indexOf("B"));
        items.clear();
        System.out.println("After clear: " + items);
        System.out.println("isEmpty: " + items.isEmpty());
    }
}
