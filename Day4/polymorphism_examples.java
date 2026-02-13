// ==================== POLYMORPHISM EXAMPLES ====================

// ========== COMPILE-TIME POLYMORPHISM (METHOD OVERLOADING) ==========

// Example 1: Method Overloading - Different Number of Parameters
class Calculator {
    // Method 1: Two parameters
    int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: Three parameters (Overloaded)
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method 3: Four parameters (Overloaded)
    int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}

// Example 2: Method Overloading - Different Types of Parameters
class MathOperations {
    // Integer addition
    int add(int a, int b) {
        System.out.println("Adding integers");
        return a + b;
    }
    
    // Double addition
    double add(double a, double b) {
        System.out.println("Adding doubles");
        return a + b;
    }
    
    // String concatenation
    String add(String a, String b) {
        System.out.println("Concatenating strings");
        return a + b;
    }
}

// Example 3: Method Overloading - Different Order of Parameters
class Display {
    void show(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    void show(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    
    void show(String name, double salary) {
        System.out.println("Name: " + name + ", Salary: $" + salary);
    }
}

// Example 4: Constructor Overloading (Also Compile-time Polymorphism)
class Box {
    double length;
    double width;
    double height;
    
    // Constructor 1: No parameters
    Box() {
        length = width = height = 1;
    }
    
    // Constructor 2: Cube (one parameter)
    Box(double side) {
        length = width = height = side;
    }
    
    // Constructor 3: All different dimensions
    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    double volume() {
        return length * width * height;
    }
}

// ========== RUNTIME POLYMORPHISM (METHOD OVERRIDING) ==========

// Example 5: Basic Method Overriding
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
    
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows: Meow! Meow!");
    }
}

class Cow extends Animal {
    @Override
    void sound() {
        System.out.println("Cow moos: Moo! Moo!");
    }
}

// Example 6: Dynamic Method Dispatch
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
    
    double area() {
        return 0.0;
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
    
    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;
    
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    void draw() {
        System.out.println("Drawing a triangle");
    }
    
    @Override
    double area() {
        return 0.5 * base * height;
    }
}

// Example 7: Real-World Example - Payment System
class Payment {
    void processPayment(double amount) {
        System.out.println("Processing payment: $" + amount);
    }
}

class CreditCardPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Credit Card payment: $" + amount);
        System.out.println("Charging to credit card...");
    }
}

class DebitCardPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Debit Card payment: $" + amount);
        System.out.println("Deducting from bank account...");
    }
}

class UPIPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
        System.out.println("Sending UPI request...");
    }
}

// Example 8: Polymorphism with Arrays
class Employee {
    String name;
    
    Employee(String name) {
        this.name = name;
    }
    
    void work() {
        System.out.println(name + " is working");
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name);
    }
    
    @Override
    void work() {
        System.out.println(name + " is managing the team");
    }
}

class Developer extends Employee {
    Developer(String name) {
        super(name);
    }
    
    @Override
    void work() {
        System.out.println(name + " is writing code");
    }
}

class Designer extends Employee {
    Designer(String name) {
        super(name);
    }
    
    @Override
    void work() {
        System.out.println(name + " is designing UI");
    }
}

// Example 9: Real-World Example - Banking System
class Account {
    String accountNumber;
    double balance;
    
    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    void calculateInterest() {
        System.out.println("Calculating general interest");
    }
    
    void displayBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.04;  // 4% interest
        balance += interest;
        System.out.println("Savings Account - Interest added: $" + interest);
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    void calculateInterest() {
        System.out.println("Current Account - No interest");
    }
}

class FixedDeposit extends Account {
    FixedDeposit(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.07;  // 7% interest
        balance += interest;
        System.out.println("Fixed Deposit - Interest added: $" + interest);
    }
}

// Example 10: Overloading vs Overriding Demonstration
class Parent {
    // Method to be overridden
    void display() {
        System.out.println("Parent display");
    }
    
    // Method to be overloaded
    void show(int x) {
        System.out.println("Parent show: " + x);
    }
}

class Child extends Parent {
    // Overriding parent's display method
    @Override
    void display() {
        System.out.println("Child display");
    }
    
    // Overloading parent's show method
    void show(int x, int y) {
        System.out.println("Child show: " + x + ", " + y);
    }
    
    // Overloading own show method
    void show(String message) {
        System.out.println("Child show: " + message);
    }
}

// ==================== MAIN CLASS ====================
public class PolymorphismExamples {
    public static void main(String[] args) {
        System.out.println("========== COMPILE-TIME POLYMORPHISM ==========\n");
        
        System.out.println("Example 1: Method Overloading - Different Parameters");
        Calculator calc = new Calculator();
        System.out.println("add(5, 10) = " + calc.add(5, 10));
        System.out.println("add(5, 10, 15) = " + calc.add(5, 10, 15));
        System.out.println("add(5, 10, 15, 20) = " + calc.add(5, 10, 15, 20));
        
        System.out.println("\nExample 2: Method Overloading - Different Types");
        MathOperations math = new MathOperations();
        System.out.println("Result: " + math.add(5, 10));
        System.out.println("Result: " + math.add(5.5, 10.5));
        System.out.println("Result: " + math.add("Hello", "World"));
        
        System.out.println("\nExample 3: Method Overloading - Different Order");
        Display display = new Display();
        display.show("John", 25);
        display.show(25, "John");
        display.show("Alice", 50000.0);
        
        System.out.println("\nExample 4: Constructor Overloading");
        Box box1 = new Box();
        Box box2 = new Box(5);
        Box box3 = new Box(10, 5, 3);
        System.out.println("Box1 volume: " + box1.volume());
        System.out.println("Box2 volume: " + box2.volume());
        System.out.println("Box3 volume: " + box3.volume());
        
        System.out.println("\n========== RUNTIME POLYMORPHISM ==========\n");
        
        System.out.println("Example 5: Basic Method Overriding");
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Cow();
        a1.sound();
        a2.sound();
        a3.sound();
        
        System.out.println("\nExample 6: Dynamic Method Dispatch");
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(10, 5);
        Shape s3 = new Triangle(10, 8);
        
        s1.draw();
        System.out.println("Area: " + s1.area());
        
        s2.draw();
        System.out.println("Area: " + s2.area());
        
        s3.draw();
        System.out.println("Area: " + s3.area());
        
        System.out.println("\nExample 7: Payment System");
        Payment p1 = new CreditCardPayment();
        Payment p2 = new DebitCardPayment();
        Payment p3 = new UPIPayment();
        
        p1.processPayment(100.0);
        System.out.println();
        p2.processPayment(50.0);
        System.out.println();
        p3.processPayment(2000.0);
        
        System.out.println("\nExample 8: Polymorphism with Arrays");
        Employee[] employees = new Employee[3];
        employees[0] = new Manager("Alice");
        employees[1] = new Developer("Bob");
        employees[2] = new Designer("Charlie");
        
        for (Employee emp : employees) {
            emp.work();
        }
        
        System.out.println("\nExample 9: Banking System");
        Account[] accounts = new Account[3];
        accounts[0] = new SavingsAccount("SA001", 10000);
        accounts[1] = new CurrentAccount("CA001", 5000);
        accounts[2] = new FixedDeposit("FD001", 20000);
        
        for (Account acc : accounts) {
            acc.displayBalance();
            acc.calculateInterest();
            acc.displayBalance();
            System.out.println();
        }
        
        System.out.println("Example 10: Overloading vs Overriding");
        Child child = new Child();
        child.display();  // Overridden method
        child.show(10);   // Inherited method
        child.show(10, 20);  // Overloaded method
        child.show("Hello");  // Overloaded method
    }
}
