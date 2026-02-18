// Capstone Project: CapstoneStudent Management System
// Uses multiple collection types to demonstrate their usage

import java.util.*;

// CapstoneStudent class
class CapstoneStudent implements Comparable<CapstoneStudent> {
    private int id;
    private String name;
    private double gpa;
    private String department;

    public CapstoneStudent(int id, String name, double gpa, String department) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getDepartment() {
        return department;
    }

    // For TreeSet sorting by GPA
    public int compareTo(CapstoneStudent other) {
        return Double.compare(other.gpa, this.gpa); // Descending order
    }

    public String toString() {
        return String.format("ID: %d, Name: %-15s, GPA: %.2f, Dept: %s",
                id, name, gpa, department);
    }
}

// Course class for PriorityQueue
class Course implements Comparable<Course> {
    String name;
    int priority; // 1 = High, 2 = Medium, 3 = Low

    Course(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int compareTo(Course other) {
        return this.priority - other.priority;
    }

    public String toString() {
        String level = priority == 1 ? "High" : priority == 2 ? "Medium" : "Low";
        return name + " (Priority: " + level + ")";
    }
}

public class capstone_project {

    // ArrayList: Store all students
    private static ArrayList<CapstoneStudent> allStudents = new ArrayList<>();

    // LinkedList: Waitlist for courses
    private static LinkedList<String> waitlist = new LinkedList<>();

    // HashSet: Unique student IDs
    private static HashSet<Integer> studentIds = new HashSet<>();

    // TreeSet: Students sorted by GPA
    private static TreeSet<CapstoneStudent> topStudents = new TreeSet<>();

    // LinkedHashSet: Enrollment order
    private static LinkedHashSet<String> enrollmentOrder = new LinkedHashSet<>();

    // PriorityQueue: Course registration priority
    private static PriorityQueue<Course> coursePriority = new PriorityQueue<>();

    // ArrayDeque: Recent activities
    private static ArrayDeque<String> recentActivities = new ArrayDeque<>();

    public static void main(String[] args) {
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===\n");

        // Initialize data
        initializeData();

        // Demonstrate each collection
        demonstrateArrayList();
        demonstrateLinkedList();
        demonstrateHashSet();
        demonstrateTreeSet();
        demonstrateLinkedHashSet();
        demonstratePriorityQueue();
        demonstrateArrayDeque();

        // Summary
        displaySummary();
    }

    private static void initializeData() {
        // Add students
        addStudent(101, "Alice Johnson", 3.8, "Computer Science");
        addStudent(102, "Bob Smith", 3.5, "Mathematics");
        addStudent(103, "Charlie Brown", 3.9, "Computer Science");
        addStudent(104, "Diana Prince", 3.7, "Physics");
        addStudent(105, "Eve Wilson", 3.6, "Mathematics");

        // Add to waitlist
        waitlist.add("Alice Johnson");
        waitlist.add("Bob Smith");
        waitlist.add("Charlie Brown");

        // Add courses
        coursePriority.add(new Course("Data Structures", 1));
        coursePriority.add(new Course("Web Development", 3));
        coursePriority.add(new Course("Algorithms", 1));
        coursePriority.add(new Course("Database Systems", 2));

        // Add enrollment
        enrollmentOrder.add("Alice Johnson");
        enrollmentOrder.add("Bob Smith");
        enrollmentOrder.add("Alice Johnson"); // Duplicate - ignored
        enrollmentOrder.add("Charlie Brown");
    }

    private static void addStudent(int id, String name, double gpa, String dept) {
        if (studentIds.add(id)) { // Check for duplicate ID
            CapstoneStudent student = new CapstoneStudent(id, name, gpa, dept);
            allStudents.add(student);
            topStudents.add(student);
            recentActivities.addFirst("Added student: " + name);
        } else {
            System.out.println("CapstoneStudent ID " + id + " already exists!");
        }
    }

    private static void demonstrateArrayList() {
        System.out.println("1. ARRAYLIST - All Students");
        System.out.println("Total students: " + allStudents.size());
        for (CapstoneStudent s : allStudents) {
            System.out.println("   " + s);
        }
        System.out.println();
    }

    private static void demonstrateLinkedList() {
        System.out.println("2. LINKEDLIST - Course Waitlist (FIFO)");
        System.out.println("Waitlist size: " + waitlist.size());

        // Process waitlist
        System.out.println("Processing waitlist:");
        while (!waitlist.isEmpty()) {
            System.out.println("   Enrolling: " + waitlist.poll());
        }
        System.out.println();
    }

    private static void demonstrateHashSet() {
        System.out.println("3. HASHSET - Unique CapstoneStudent IDs");
        System.out.println("Registered IDs: " + studentIds);
        System.out.println("Total unique IDs: " + studentIds.size());
        System.out.println();
    }

    private static void demonstrateTreeSet() {
        System.out.println("4. TREESET - Top Students by GPA");
        System.out.println("Students ranked by GPA:");
        int rank = 1;
        for (CapstoneStudent s : topStudents) {
            System.out.println("   Rank " + rank++ + ": " + s);
        }
        System.out.println();
    }

    private static void demonstrateLinkedHashSet() {
        System.out.println("5. LINKEDHASHSET - Enrollment Order");
        System.out.println("Students enrolled (in order):");
        for (String name : enrollmentOrder) {
            System.out.println("   " + name);
        }
        System.out.println("Total enrolled: " + enrollmentOrder.size());
        System.out.println();
    }

    private static void demonstratePriorityQueue() {
        System.out.println("6. PRIORITYQUEUE - Course Registration Priority");
        System.out.println("Courses to register (by priority):");
        while (!coursePriority.isEmpty()) {
            System.out.println("   " + coursePriority.poll());
        }
        System.out.println();
    }

    private static void demonstrateArrayDeque() {
        System.out.println("7. ARRAYDEQUE - Recent Activities");
        System.out.println("Last 5 activities:");
        int count = 0;
        for (String activity : recentActivities) {
            System.out.println("   " + activity);
            if (++count >= 5)
                break;
        }
        System.out.println();
    }

    private static void displaySummary() {
        System.out.println("=== SUMMARY ===");
        System.out.println("Collections Used:");
        System.out.println("✓ ArrayList      - Store all students");
        System.out.println("✓ LinkedList     - Manage waitlist (FIFO)");
        System.out.println("✓ HashSet        - Track unique IDs");
        System.out.println("✓ TreeSet        - Rank students by GPA");
        System.out.println("✓ LinkedHashSet  - Preserve enrollment order");
        System.out.println("✓ PriorityQueue  - Prioritize course registration");
        System.out.println("✓ ArrayDeque     - Track recent activities");
        System.out.println("\n=== PROJECT COMPLETED ===");
    }
}
