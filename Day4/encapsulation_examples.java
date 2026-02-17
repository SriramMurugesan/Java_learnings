// ==================== ENCAPSULATION EXAMPLES ====================

// Example 1: Basic Encapsulation with Generic Getters and Setters
class Student {
    // Private variables (data hiding)
    private String name;
    private int age;
    private String course;

    // Generic Getter for name
    public String getName() {
        return name;
    }

    // Generic Setter for name
    public void setName(String name) {
        this.name = name; // 'this' resolves shadowing
    }

    // Generic Getter for age
    public int getAge() {
        return age;
    }

    // Generic Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Generic Getter for course
    public String getCourse() {
        return course;
    }

    // Generic Setter for course
    public void setCourse(String course) {
        this.course = course;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

// Example 2: Specific Getters and Setters with Validation
class Employee {
    private String name;
    private int age;
    private double salary;
    private String email;

    // Specific Setter with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    public String getName() {
        return name;
    }

    // Specific Setter with age validation
    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Age must be between 18 and 65!");
        }
    }

    public int getAge() {
        return age;
    }

    // Specific Setter with salary validation
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative!");
        }
    }

    // Specific Getter with formatting
    public String getFormattedSalary() {
        return "$" + salary;
    }

    // Specific Getter with calculation
    public double getAnnualSalary() {
        return salary * 12;
    }

    // Specific Setter with email validation
    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format!");
        }
    }

    public String getEmail() {
        return email;
    }
}

// Example 3: Demonstrating Shadowing Problem
class ShadowingDemo {
    private int value;

    // ❌ Wrong way - Shadowing problem
    public void setValueWrong(int value) {
        value = value; // This assigns parameter to itself!
        // Instance variable 'this.value' is NOT updated
    }

    // ✅ Correct way - Using 'this' keyword
    public void setValueCorrect(int value) {
        this.value = value; // 'this.value' refers to instance variable
    }

    public int getValue() {
        return value;
    }
}

// Example 4: Constructors - Default Constructor
class Book {
    private String title;
    private String author;
    private double price;

    // Default Constructor (no parameters)
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default constructor called");
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

// Example 5: Parameterized Constructor
class Car {
    private String brand;
    private String model;
    private int year;
    private double price;

    // Parameterized Constructor
    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
}

// Example 6: Constructor Overloading
class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String accountType;

    // Constructor 1: No parameters (default)
    public BankAccount() {
        this.accountNumber = "0000000000";
        this.holderName = "Unknown";
        this.balance = 0.0;
        this.accountType = "Savings";
    }

    // Constructor 2: Account number and holder name
    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
        this.accountType = "Savings";
    }

    // Constructor 3: All parameters
    public BankAccount(String accountNumber, String holderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Type: " + accountType);
    }
}

// Example 7: Constructor Chaining with this()
class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    // Constructor 1: Calls Constructor 4
    public Product() {
        this("Unknown", 0.0, 0, "General");
    }

    // Constructor 2: Calls Constructor 4
    public Product(String name) {
        this(name, 0.0, 0, "General");
    }

    // Constructor 3: Calls Constructor 4
    public Product(String name, double price) {
        this(name, price, 0, "General");
    }

    // Constructor 4: Main constructor with all logic
    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        System.out.println("Product created: " + name);
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Category: " + category);
    }
}

// Example 8: Real-World Example - Library System
class LibraryBook {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private int borrowCount;

    // Constructor
    public LibraryBook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowCount = 0;
    }

    // Specific methods with business logic
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            borrowCount++;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available!");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not borrowed!");
        }
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void displayInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Times Borrowed: " + borrowCount);
    }
}

// ==================== MAIN CLASS ====================
class EncapsulationExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Basic Encapsulation ==========");
        Student s1 = new Student();
        s1.setName("John Doe");
        s1.setAge(20);
        s1.setCourse("Computer Science");
        s1.displayInfo();

        System.out.println("\n========== Example 2: Specific Getters/Setters ==========");
        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setAge(25);
        emp.setSalary(5000);
        emp.setEmail("alice@example.com");
        System.out.println("Name: " + emp.getName());
        System.out.println("Formatted Salary: " + emp.getFormattedSalary());
        System.out.println("Annual Salary: " + emp.getAnnualSalary());

        System.out.println("\n========== Example 3: Shadowing Problem ==========");
        ShadowingDemo demo = new ShadowingDemo();
        demo.setValueWrong(100);
        System.out.println("After wrong setter: " + demo.getValue()); // 0 (not updated!)
        demo.setValueCorrect(100);
        System.out.println("After correct setter: " + demo.getValue()); // 100

        System.out.println("\n========== Example 4: Default Constructor ==========");
        Book book1 = new Book();
        book1.displayInfo();

        System.out.println("\n========== Example 5: Parameterized Constructor ==========");
        Car car1 = new Car("Toyota", "Camry", 2023, 30000);
        car1.displayInfo();

        System.out.println("\n========== Example 6: Constructor Overloading ==========");
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("1234567890", "Bob");
        BankAccount acc3 = new BankAccount("9876543210", "Charlie", 5000, "Current");
        System.out.println("Account 1:");
        acc1.displayInfo();
        System.out.println("\nAccount 2:");
        acc2.displayInfo();
        System.out.println("\nAccount 3:");
        acc3.displayInfo();

        System.out.println("\n========== Example 7: Constructor Chaining ==========");
        Product p1 = new Product();
        Product p2 = new Product("Laptop");
        Product p3 = new Product("Phone", 500);
        Product p4 = new Product("Tablet", 300, 10, "Electronics");

        System.out.println("\n========== Example 8: Library System ==========");
        LibraryBook book = new LibraryBook("978-0134685991", "Effective Java", "Joshua Bloch");
        book.displayInfo();
        System.out.println();
        book.borrowBook();
        book.displayInfo();
        System.out.println();
        book.returnBook();
        book.displayInfo();
    }
}
