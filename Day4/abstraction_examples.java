// ==================== ABSTRACTION EXAMPLES ====================

// Example 1: Basic Abstract Class
abstract class Animal {
    String name;
    
    // Constructor in abstract class
    Animal(String name) {
        this.name = name;
    }
    
    // Abstract method (no implementation)
    abstract void sound();
    
    // Concrete method (with implementation)
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    
    @Override
    void sound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    
    @Override
    void sound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

// Example 2: Abstract Class with Multiple Abstract Methods
abstract class Shape {
    String color;
    
    Shape(String color) {
        this.color = color;
    }
    
    // Abstract methods
    abstract double area();
    abstract double perimeter();
    
    // Concrete method
    void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(String color, double radius) {
        super(color);
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
    
    Rectangle(String color, double length, double width) {
        super(color);
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

// Example 3: Real-World Example - Banking System
abstract class BankAccount {
    String accountNumber;
    String holderName;
    double balance;
    
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    // Abstract method - each account type calculates interest differently
    abstract void calculateInterest();
    
    // Concrete methods - common for all accounts
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
    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.04;  // 4% interest
        balance += interest;
        System.out.println("Savings Account - Interest added: $" + interest);
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        System.out.println("Current Account - No interest");
    }
}

class FixedDeposit extends BankAccount {
    FixedDeposit(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * 0.07;  // 7% interest
        balance += interest;
        System.out.println("Fixed Deposit - Interest added: $" + interest);
    }
}

// Example 4: Abstract Class with Final and Static Methods
abstract class Vehicle {
    String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    // Abstract method
    abstract void start();
    
    // Final method (cannot be overridden)
    final void stop() {
        System.out.println(brand + " is stopping");
    }
    
    // Static method
    static void displayInfo() {
        System.out.println("This is a vehicle class");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }
    
    @Override
    void start() {
        System.out.println(brand + " car is starting with key");
    }
}

class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }
    
    @Override
    void start() {
        System.out.println(brand + " bike is starting with kick");
    }
}

// Example 5: Partial Abstract Class (Some methods abstract, some not)
abstract class Employee {
    String name;
    int id;
    double baseSalary;
    
    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    // Abstract method - each employee type calculates differently
    abstract double calculateSalary();
    
    // Abstract method - each employee has different work
    abstract void work();
    
    // Concrete method - common for all employees
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + calculateSalary());
    }
}

class Manager extends Employee {
    double bonus;
    
    Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
    
    @Override
    void work() {
        System.out.println(name + " is managing the team");
    }
}

class Developer extends Employee {
    String programmingLanguage;
    
    Developer(String name, int id, double baseSalary, String programmingLanguage) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    double calculateSalary() {
        return baseSalary;
    }
    
    @Override
    void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }
}

// Example 6: Abstract Class Hierarchy
abstract class LivingBeing {
    abstract void breathe();
}

abstract class Mammal extends LivingBeing {
    @Override
    void breathe() {
        System.out.println("Breathing through lungs");
    }
    
    abstract void reproduce();
}

class Human extends Mammal {
    @Override
    void reproduce() {
        System.out.println("Giving birth to babies");
    }
    
    void speak() {
        System.out.println("Speaking...");
    }
}

// Example 7: Real-World Example - Payment Processing
abstract class Payment {
    double amount;
    String transactionId;
    
    Payment(double amount, String transactionId) {
        this.amount = amount;
        this.transactionId = transactionId;
    }
    
    // Abstract methods
    abstract void processPayment();
    abstract void refund();
    
    // Concrete method
    void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + amount);
    }
}

class CreditCardPayment extends Payment {
    String cardNumber;
    
    CreditCardPayment(double amount, String transactionId, String cardNumber) {
        super(amount, transactionId);
        this.cardNumber = cardNumber;
    }
    
    @Override
    void processPayment() {
        System.out.println("Processing credit card payment");
        System.out.println("Card: " + cardNumber);
        System.out.println("Amount charged: $" + amount);
    }
    
    @Override
    void refund() {
        System.out.println("Refunding $" + amount + " to card " + cardNumber);
    }
}

class UPIPayment extends Payment {
    String upiId;
    
    UPIPayment(double amount, String transactionId, String upiId) {
        super(amount, transactionId);
        this.upiId = upiId;
    }
    
    @Override
    void processPayment() {
        System.out.println("Processing UPI payment");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: ₹" + amount);
    }
    
    @Override
    void refund() {
        System.out.println("Refunding ₹" + amount + " to UPI ID " + upiId);
    }
}

// Example 8: Abstract Class with Instance Variables
abstract class Book {
    String title;
    String author;
    double price;
    
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    abstract void displayType();
    
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

class EBook extends Book {
    double fileSize;  // in MB
    
    EBook(String title, String author, double price, double fileSize) {
        super(title, author, price);
        this.fileSize = fileSize;
    }
    
    @Override
    void displayType() {
        System.out.println("Type: E-Book");
        System.out.println("File Size: " + fileSize + " MB");
    }
}

class PhysicalBook extends Book {
    int pages;
    
    PhysicalBook(String title, String author, double price, int pages) {
        super(title, author, price);
        this.pages = pages;
    }
    
    @Override
    void displayType() {
        System.out.println("Type: Physical Book");
        System.out.println("Pages: " + pages);
    }
}

// ==================== MAIN CLASS ====================
public class AbstractionExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Basic Abstract Class ==========");
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        dog.sound();
        dog.sleep();
        cat.sound();
        cat.sleep();
        
        System.out.println("\n========== Example 2: Multiple Abstract Methods ==========");
        Shape circle = new Circle("Red", 5);
        Shape rectangle = new Rectangle("Blue", 10, 5);
        
        circle.displayColor();
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());
        
        System.out.println();
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());
        
        System.out.println("\n========== Example 3: Banking System ==========");
        BankAccount savings = new SavingsAccount("SA001", "John", 10000);
        BankAccount current = new CurrentAccount("CA001", "Alice", 5000);
        BankAccount fd = new FixedDeposit("FD001", "Bob", 20000);
        
        savings.displayBalance();
        savings.calculateInterest();
        savings.displayBalance();
        
        System.out.println();
        current.displayBalance();
        current.calculateInterest();
        
        System.out.println();
        fd.displayBalance();
        fd.calculateInterest();
        fd.displayBalance();
        
        System.out.println("\n========== Example 4: Final and Static Methods ==========");
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Honda");
        
        car.start();
        car.stop();
        
        bike.start();
        bike.stop();
        
        Vehicle.displayInfo();
        
        System.out.println("\n========== Example 5: Employee System ==========");
        Employee manager = new Manager("Alice", 101, 5000, 2000);
        Employee developer = new Developer("Bob", 102, 4000, "Java");
        
        manager.displayInfo();
        manager.work();
        
        System.out.println();
        developer.displayInfo();
        developer.work();
        
        System.out.println("\n========== Example 6: Abstract Class Hierarchy ==========");
        Human human = new Human();
        human.breathe();
        human.reproduce();
        human.speak();
        
        System.out.println("\n========== Example 7: Payment Processing ==========");
        Payment creditCard = new CreditCardPayment(100.0, "TXN001", "1234-5678-9012-3456");
        Payment upi = new UPIPayment(2000.0, "TXN002", "user@upi");
        
        creditCard.displayTransaction();
        creditCard.processPayment();
        System.out.println();
        creditCard.refund();
        
        System.out.println();
        upi.displayTransaction();
        upi.processPayment();
        System.out.println();
        upi.refund();
        
        System.out.println("\n========== Example 8: Book System ==========");
        Book ebook = new EBook("Java Programming", "James Gosling", 29.99, 5.2);
        Book physicalBook = new PhysicalBook("Clean Code", "Robert Martin", 39.99, 464);
        
        ebook.displayInfo();
        ebook.displayType();
        
        System.out.println();
        physicalBook.displayInfo();
        physicalBook.displayType();
    }
}
