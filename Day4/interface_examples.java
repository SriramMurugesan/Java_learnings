// ==================== INTERFACE EXAMPLES ====================

// Example 1: Basic Interface
interface Animal {
    void sound();
    void eat();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    
    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
    
    @Override
    public void eat() {
        System.out.println("Cat eats fish");
    }
}

// Example 2: Multiple Interface Implementation
interface Printable {
    void print();
}

interface Showable {
    void show();
}

class Document implements Printable, Showable {
    String content;
    
    Document(String content) {
        this.content = content;
    }
    
    @Override
    public void print() {
        System.out.println("Printing: " + content);
    }
    
    @Override
    public void show() {
        System.out.println("Showing: " + content);
    }
}

// Example 3: Interface with Constants
interface MathConstants {
    double PI = 3.14159;
    double E = 2.71828;
    int MAX_VALUE = 100;
}

class Calculator implements MathConstants {
    double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }
    
    void displayConstants() {
        System.out.println("PI: " + PI);
        System.out.println("E: " + E);
        System.out.println("MAX_VALUE: " + MAX_VALUE);
    }
}

// Example 4: Interface Extending Another Interface
interface Vehicle {
    void start();
    void stop();
}

interface FourWheeler extends Vehicle {
    void openDoor();
}

class Car implements FourWheeler {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
    
    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }
    
    @Override
    public void openDoor() {
        System.out.println("Opening car door");
    }
}

// Example 5: Default Methods (Java 8+)
interface Payment {
    void processPayment(double amount);
    
    // Default method
    default void printReceipt() {
        System.out.println("Printing receipt...");
    }
    
    default void sendConfirmation() {
        System.out.println("Sending confirmation email...");
    }
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
    
    // Can override default method if needed
    @Override
    public void printReceipt() {
        System.out.println("Printing detailed credit card receipt...");
    }
}

class UPIPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
    }
    
    // Uses default methods from interface
}

// Example 6: Static Methods in Interface (Java 8+)
interface MathOperations {
    // Static method
    static int add(int a, int b) {
        return a + b;
    }
    
    static int multiply(int a, int b) {
        return a * b;
    }
    
    // Abstract method
    int calculate(int a, int b);
}

class Addition implements MathOperations {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

// Example 7: Functional Interface (Java 8+)
@FunctionalInterface
interface Calculable {
    int calculate(int a, int b);
}

class FunctionalInterfaceDemo {
    static void performOperation(int a, int b, Calculable operation) {
        int result = operation.calculate(a, b);
        System.out.println("Result: " + result);
    }
}

// Example 8: Real-World Example - Shape Interface
interface Shape {
    double area();
    double perimeter();
    
    default void display() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

class Circle implements Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * 3.14 * radius;
    }
}

class Rectangle implements Shape {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
    
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Example 9: Multiple Inheritance via Interfaces
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface Walkable {
    void walk();
}

class Duck implements Flyable, Swimmable, Walkable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
    
    @Override
    public void walk() {
        System.out.println("Duck is walking");
    }
}

// Example 10: Real-World Example - Database Operations
interface DatabaseOperations {
    void connect();
    void disconnect();
    void executeQuery(String query);
    
    default void logOperation(String operation) {
        System.out.println("Logging: " + operation);
    }
}

class MySQLDatabase implements DatabaseOperations {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database");
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL database");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
        logOperation("MySQL query executed");
    }
}

class MongoDBDatabase implements DatabaseOperations {
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB database");
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MongoDB database");
    }
    
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MongoDB query: " + query);
        logOperation("MongoDB query executed");
    }
}

// Example 11: Interface with Nested Interface
interface OuterInterface {
    void outerMethod();
    
    interface InnerInterface {
        void innerMethod();
    }
}

class ImplementOuter implements OuterInterface {
    @Override
    public void outerMethod() {
        System.out.println("Outer method implementation");
    }
}

class ImplementInner implements OuterInterface.InnerInterface {
    @Override
    public void innerMethod() {
        System.out.println("Inner method implementation");
    }
}

// Example 12: Marker Interface (Empty Interface)
interface Serializable {
    // Empty interface - just a marker
}

class Student implements Serializable {
    String name;
    int rollNumber;
    
    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        if (this instanceof Serializable) {
            System.out.println("This object is serializable");
        }
    }
}

// ==================== MAIN CLASS ====================
public class InterfaceExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Basic Interface ==========");
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.sound();
        dog.eat();
        cat.sound();
        cat.eat();
        
        System.out.println("\n========== Example 2: Multiple Interfaces ==========");
        Document doc = new Document("Hello World");
        doc.print();
        doc.show();
        
        System.out.println("\n========== Example 3: Interface Constants ==========");
        Calculator calc = new Calculator();
        System.out.println("Circle Area: " + calc.calculateCircleArea(5));
        calc.displayConstants();
        
        System.out.println("\n========== Example 4: Interface Extending Interface ==========");
        Car car = new Car();
        car.start();
        car.openDoor();
        car.stop();
        
        System.out.println("\n========== Example 5: Default Methods ==========");
        Payment creditCard = new CreditCardPayment();
        Payment upi = new UPIPayment();
        
        creditCard.processPayment(100.0);
        creditCard.printReceipt();
        creditCard.sendConfirmation();
        
        System.out.println();
        upi.processPayment(2000.0);
        upi.printReceipt();  // Uses default implementation
        upi.sendConfirmation();
        
        System.out.println("\n========== Example 6: Static Methods ==========");
        System.out.println("Static add: " + MathOperations.add(5, 10));
        System.out.println("Static multiply: " + MathOperations.multiply(5, 10));
        
        Addition addition = new Addition();
        System.out.println("Instance calculate: " + addition.calculate(5, 10));
        
        System.out.println("\n========== Example 7: Functional Interface ==========");
        // Using lambda expressions
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a + b);
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a * b);
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a - b);
        
        System.out.println("\n========== Example 8: Shape Interface ==========");
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 5);
        
        System.out.println("Circle:");
        circle.display();
        
        System.out.println("\nRectangle:");
        rectangle.display();
        
        System.out.println("\n========== Example 9: Multiple Inheritance ==========");
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        duck.walk();
        
        System.out.println("\n========== Example 10: Database Operations ==========");
        DatabaseOperations mysql = new MySQLDatabase();
        DatabaseOperations mongo = new MongoDBDatabase();
        
        mysql.connect();
        mysql.executeQuery("SELECT * FROM users");
        mysql.disconnect();
        
        System.out.println();
        mongo.connect();
        mongo.executeQuery("db.users.find()");
        mongo.disconnect();
        
        System.out.println("\n========== Example 11: Nested Interface ==========");
        ImplementOuter outer = new ImplementOuter();
        outer.outerMethod();
        
        ImplementInner inner = new ImplementInner();
        inner.innerMethod();
        
        System.out.println("\n========== Example 12: Marker Interface ==========");
        Student student = new Student("John Doe", 101);
        student.displayInfo();
    }
}
