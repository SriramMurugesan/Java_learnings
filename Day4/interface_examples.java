// ==================== INTERFACE EXAMPLES ====================

// Example 1: Basic Interface
interface InterfaceAnimal {
    void sound();

    void eat();
}

class InterfaceDog implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("InterfaceDog barks");
    }

    @Override
    public void eat() {
        System.out.println("InterfaceDog eats bones");
    }
}

class InterfaceCat implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("InterfaceCat meows");
    }

    @Override
    public void eat() {
        System.out.println("InterfaceCat eats fish");
    }
}

// Example 2: Multiple Interface Implementation
interface InterfacePrintable {
    void print();
}

interface InterfaceShowable {
    void show();
}

class InterfaceDocument implements InterfacePrintable, InterfaceShowable {
    String content;

    InterfaceDocument(String content) {
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
interface InterfaceMathConstants {
    double PI = 3.14159;
    double E = 2.71828;
    int MAX_VALUE = 100;
}

class InterfaceCalculator implements InterfaceMathConstants {
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
interface InterfaceVehicle {
    void start();

    void stop();
}

interface InterfaceFourWheeler extends InterfaceVehicle {
    void openDoor();
}

class InterfaceCar implements InterfaceFourWheeler {
    @Override
    public void start() {
        System.out.println("InterfaceCar is starting");
    }

    @Override
    public void stop() {
        System.out.println("InterfaceCar is stopping");
    }

    @Override
    public void openDoor() {
        System.out.println("Opening car door");
    }
}

// Example 5: Default Methods (Java 8+)
interface InterfacePayment {
    void processPayment(double amount);

    // Default method
    default void printReceipt() {
        System.out.println("Printing receipt...");
    }

    default void sendConfirmation() {
        System.out.println("Sending confirmation email...");
    }
}

class InterfaceCreditCardPayment implements InterfacePayment {
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

class InterfaceUPIPayment implements InterfacePayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment: ₹" + amount);
    }

    // Uses default methods from interface
}

// Example 6: Static Methods in Interface (Java 8+)
interface InterfaceMathOperations {
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

class InterfaceAddition implements InterfaceMathOperations {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

// Example 7: Functional Interface (Java 8+)
@FunctionalInterface
interface InterfaceCalculable {
    int calculate(int a, int b);
}

class FunctionalInterfaceDemo {
    static void performOperation(int a, int b, InterfaceCalculable operation) {
        int result = operation.calculate(a, b);
        System.out.println("Result: " + result);
    }
}

// Example 8: Real-World Example - InterfaceShape Interface
interface InterfaceShape {
    double area();

    double perimeter();

    default void display() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

class InterfaceCircle implements InterfaceShape {
    double radius;

    InterfaceCircle(double radius) {
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

class InterfaceRectangle implements InterfaceShape {
    double length;
    double width;

    InterfaceRectangle(double length, double width) {
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
interface InterfaceFlyable {
    void fly();
}

interface InterfaceSwimmable {
    void swim();
}

interface InterfaceWalkable {
    void walk();
}

class InterfaceDuck implements InterfaceFlyable, InterfaceSwimmable, InterfaceWalkable {
    @Override
    public void fly() {
        System.out.println("InterfaceDuck is flying");
    }

    @Override
    public void swim() {
        System.out.println("InterfaceDuck is swimming");
    }

    @Override
    public void walk() {
        System.out.println("InterfaceDuck is walking");
    }
}

// Example 10: Real-World Example - Database Operations
interface InterfaceDatabaseOperations {
    void connect();

    void disconnect();

    void executeQuery(String query);

    default void logOperation(String operation) {
        System.out.println("Logging: " + operation);
    }
}

class InterfaceMySQLDatabase implements InterfaceDatabaseOperations {
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

class InterfaceMongoDBDatabase implements InterfaceDatabaseOperations {
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
interface InterfaceOuterInterface {
    void outerMethod();

    interface InnerInterface {
        void innerMethod();
    }
}

class ImplementOuter implements InterfaceOuterInterface {
    @Override
    public void outerMethod() {
        System.out.println("Outer method implementation");
    }
}

class ImplementInner implements InterfaceOuterInterface.InnerInterface {
    @Override
    public void innerMethod() {
        System.out.println("Inner method implementation");
    }
}

// Example 12: Marker Interface (Empty Interface)
interface InterfaceSerializable {
    // Empty interface - just a marker
}

class InterfaceStudent implements InterfaceSerializable {
    String name;
    int rollNumber;

    InterfaceStudent(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        if (this instanceof InterfaceSerializable) {
            System.out.println("This object is serializable");
        }
    }
}

// ==================== MAIN CLASS ====================
class InterfaceExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Basic Interface ==========");
        InterfaceAnimal dog = new InterfaceDog();
        InterfaceAnimal cat = new InterfaceCat();
        dog.sound();
        dog.eat();
        cat.sound();
        cat.eat();

        System.out.println("\n========== Example 2: Multiple Interfaces ==========");
        InterfaceDocument doc = new InterfaceDocument("Hello World");
        doc.print();
        doc.show();

        System.out.println("\n========== Example 3: Interface Constants ==========");
        InterfaceCalculator calc = new InterfaceCalculator();
        System.out.println("InterfaceCircle Area: " + calc.calculateCircleArea(5));
        calc.displayConstants();

        System.out.println("\n========== Example 4: Interface Extending Interface ==========");
        InterfaceCar car = new InterfaceCar();
        car.start();
        car.openDoor();
        car.stop();

        System.out.println("\n========== Example 5: Default Methods ==========");
        InterfacePayment creditCard = new InterfaceCreditCardPayment();
        InterfacePayment upi = new InterfaceUPIPayment();

        creditCard.processPayment(100.0);
        creditCard.printReceipt();
        creditCard.sendConfirmation();

        System.out.println();
        upi.processPayment(2000.0);
        upi.printReceipt(); // Uses default implementation
        upi.sendConfirmation();

        System.out.println("\n========== Example 6: Static Methods ==========");
        System.out.println("Static add: " + InterfaceMathOperations.add(5, 10));
        System.out.println("Static multiply: " + InterfaceMathOperations.multiply(5, 10));

        InterfaceAddition addition = new InterfaceAddition();
        System.out.println("Instance calculate: " + addition.calculate(5, 10));

        System.out.println("\n========== Example 7: Functional Interface ==========");
        // Using lambda expressions
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a + b);
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a * b);
        FunctionalInterfaceDemo.performOperation(5, 10, (a, b) -> a - b);

        System.out.println("\n========== Example 8: InterfaceShape Interface ==========");
        InterfaceShape circle = new InterfaceCircle(5);
        InterfaceShape rectangle = new InterfaceRectangle(10, 5);

        System.out.println("InterfaceCircle:");
        circle.display();

        System.out.println("\nRectangle:");
        rectangle.display();

        System.out.println("\n========== Example 9: Multiple Inheritance ==========");
        InterfaceDuck duck = new InterfaceDuck();
        duck.fly();
        duck.swim();
        duck.walk();

        System.out.println("\n========== Example 10: Database Operations ==========");
        InterfaceDatabaseOperations mysql = new InterfaceMySQLDatabase();
        InterfaceDatabaseOperations mongo = new InterfaceMongoDBDatabase();

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
        InterfaceStudent student = new InterfaceStudent("John Doe", 101);
        student.displayInfo();
    }
}
