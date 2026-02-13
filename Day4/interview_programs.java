// ==================== DAY 4 INTERVIEW PROGRAMS ====================

// Program 1: Create a Student class with encapsulation
class Student {
    private String name;
    private int rollNumber;
    private double[] marks;
    
    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }
    
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else return "F";
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Grade: " + getGrade());
    }
}

// Program 2: Inheritance - Employee Hierarchy
class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;
    
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    public double calculateSalary() {
        return baseSalary;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + calculateSalary());
    }
}

class Manager extends Employee {
    private double bonus;
    private double allowance;
    
    public Manager(String name, int id, double baseSalary, double bonus, double allowance) {
        super(name, id, baseSalary);
        this.bonus = bonus;
        this.allowance = allowance;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + bonus + allowance;
    }
}

class Developer extends Employee {
    private double projectBonus;
    
    public Developer(String name, int id, double baseSalary, double projectBonus) {
        super(name, id, baseSalary);
        this.projectBonus = projectBonus;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + projectBonus;
    }
}

// Program 3: Polymorphism - Shape Area Calculator
abstract class Shape {
    abstract double area();
    abstract double perimeter();
    
    void display() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return 3.14 * radius * radius;
    }
    
    @Override
    double perimeter() {
        return 2 * 3.14 * radius;
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
    double area() {
        return length * width;
    }
    
    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Program 4: Interface - Payment System
interface Payable {
    void processPayment(double amount);
    void generateReceipt();
}

class CreditCard implements Payable {
    String cardNumber;
    
    CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        System.out.println("Card: " + cardNumber);
    }
    
    @Override
    public void generateReceipt() {
        System.out.println("Credit card receipt generated");
    }
}

class UPI implements Payable {
    String upiId;
    
    UPI(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
        System.out.println("UPI ID: " + upiId);
    }
    
    @Override
    public void generateReceipt() {
        System.out.println("UPI receipt generated");
    }
}

// Program 5: Bank Account with Abstraction
abstract class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    abstract void calculateInterest();
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

// Program 6: Multiple Interface Implementation
interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

class Image implements Drawable, Resizable {
    String name;
    double width;
    double height;
    
    Image(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing image: " + name);
        System.out.println("Size: " + width + "x" + height);
    }
    
    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
        System.out.println("Resized to: " + width + "x" + height);
    }
}

// Program 7: Constructor Chaining
class Vehicle {
    String brand;
    int year;
    
    Vehicle() {
        this("Unknown", 2024);
    }
    
    Vehicle(String brand) {
        this(brand, 2024);
    }
    
    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Vehicle created: " + brand + " (" + year + ")");
    }
}

// Program 8: Method Overloading and Overriding
class Calculator {
    // Method Overloading
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

class ScientificCalculator extends Calculator {
    // Method Overriding
    @Override
    int add(int a, int b) {
        System.out.println("Scientific calculator adding...");
        return super.add(a, b);
    }
    
    // Additional method
    double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

// Program 9: Abstract Class with Template Method Pattern
abstract class DataProcessor {
    // Template method
    final void process() {
        readData();
        processData();
        writeData();
    }
    
    abstract void readData();
    abstract void processData();
    abstract void writeData();
}

class CSVProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("Reading CSV data");
    }
    
    @Override
    void processData() {
        System.out.println("Processing CSV data");
    }
    
    @Override
    void writeData() {
        System.out.println("Writing CSV data");
    }
}

// Program 10: Interface with Default Methods
interface Logger {
    void log(String message);
    
    default void logError(String error) {
        System.out.println("ERROR: " + error);
    }
    
    default void logInfo(String info) {
        System.out.println("INFO: " + info);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

// ==================== MAIN CLASS ====================
public class InterviewPrograms {
    public static void main(String[] args) {
        System.out.println("========== Program 1: Student Class ==========");
        double[] marks = {85, 90, 78, 92, 88};
        Student student = new Student("John Doe", 101, marks);
        student.displayInfo();
        
        System.out.println("\n========== Program 2: Employee Hierarchy ==========");
        Employee manager = new Manager("Alice", 1001, 5000, 2000, 1000);
        Employee developer = new Developer("Bob", 1002, 4000, 1500);
        
        manager.displayInfo();
        System.out.println();
        developer.displayInfo();
        
        System.out.println("\n========== Program 3: Shape Area Calculator ==========");
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 5);
        
        System.out.println("Circle:");
        circle.display();
        
        System.out.println("\nRectangle:");
        rectangle.display();
        
        System.out.println("\n========== Program 4: Payment System ==========");
        Payable creditCard = new CreditCard("1234-5678-9012-3456");
        Payable upi = new UPI("user@upi");
        
        creditCard.processPayment(100.0);
        creditCard.generateReceipt();
        
        System.out.println();
        upi.processPayment(2000.0);
        upi.generateReceipt();
        
        System.out.println("\n========== Program 5: Bank Account ==========");
        BankAccount savings = new SavingsAccount("SA001", "John", 10000);
        savings.displayBalance();
        savings.deposit(2000);
        savings.calculateInterest();
        savings.displayBalance();
        
        System.out.println("\n========== Program 6: Multiple Interfaces ==========");
        Image image = new Image("photo.jpg", 1920, 1080);
        image.draw();
        image.resize(0.5);
        image.draw();
        
        System.out.println("\n========== Program 7: Constructor Chaining ==========");
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle("Toyota");
        Vehicle v3 = new Vehicle("Honda", 2023);
        
        System.out.println("\n========== Program 8: Overloading and Overriding ==========");
        ScientificCalculator calc = new ScientificCalculator();
        System.out.println("add(5, 10) = " + calc.add(5, 10));
        System.out.println("add(5.5, 10.5) = " + calc.add(5.5, 10.5));
        System.out.println("add(5, 10, 15) = " + calc.add(5, 10, 15));
        System.out.println("power(2, 3) = " + calc.power(2, 3));
        
        System.out.println("\n========== Program 9: Template Method Pattern ==========");
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();
        
        System.out.println("\n========== Program 10: Interface with Default Methods ==========");
        Logger logger = new FileLogger();
        logger.log("Application started");
        logger.logInfo("User logged in");
        logger.logError("Connection failed");
    }
}
