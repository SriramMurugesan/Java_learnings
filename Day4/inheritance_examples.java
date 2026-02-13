// ==================== INHERITANCE EXAMPLES ====================

// Example 1: Single Inheritance
class Animal {
    String name;
    int age;
    
    void eat() {
        System.out.println(name + " is eating");
    }
    
    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    String breed;
    
    void bark() {
        System.out.println(name + " is barking");
    }
    
    void wagTail() {
        System.out.println(name + " is wagging tail");
    }
}

// Example 2: Multilevel Inheritance
class LivingBeing {
    void breathe() {
        System.out.println("Breathing...");
    }
}

class Mammal extends LivingBeing {
    void giveBirth() {
        System.out.println("Giving birth to young ones");
    }
}

class Human extends Mammal {
    void speak() {
        System.out.println("Speaking...");
    }
}

// Example 3: Hierarchical Inheritance
class Vehicle {
    String brand;
    int year;
    
    void start() {
        System.out.println(brand + " is starting");
    }
    
    void stop() {
        System.out.println(brand + " is stopping");
    }
}

class Car extends Vehicle {
    int doors;
    
    void openTrunk() {
        System.out.println("Opening trunk");
    }
}

class Bike extends Vehicle {
    boolean hasCarrier;
    
    void kickStart() {
        System.out.println("Kick starting bike");
    }
}

class Truck extends Vehicle {
    double loadCapacity;
    
    void loadCargo() {
        System.out.println("Loading cargo");
    }
}

// Example 4: Method Overriding
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

// Example 5: Using super keyword
class Parent {
    int x = 10;
    
    Parent() {
        System.out.println("Parent constructor");
    }
    
    Parent(String message) {
        System.out.println("Parent: " + message);
    }
    
    void display() {
        System.out.println("Parent display method");
    }
}

class Child extends Parent {
    int x = 20;
    
    Child() {
        super();  // Call parent's no-arg constructor
        System.out.println("Child constructor");
    }
    
    Child(String message) {
        super(message);  // Call parent's parameterized constructor
        System.out.println("Child: " + message);
    }
    
    @Override
    void display() {
        System.out.println("Child x: " + x);
        System.out.println("Parent x: " + super.x);
        super.display();  // Call parent's display method
        System.out.println("Child display method");
    }
}

// Example 6: Constructor Chaining in Inheritance
class GrandParent {
    GrandParent() {
        System.out.println("GrandParent constructor");
    }
}

class ParentClass extends GrandParent {
    ParentClass() {
        super();  // Implicit call to GrandParent()
        System.out.println("ParentClass constructor");
    }
}

class ChildClass extends ParentClass {
    ChildClass() {
        super();  // Implicit call to ParentClass()
        System.out.println("ChildClass constructor");
    }
}

// Example 7: Real-World Example - Employee Hierarchy
class Employee {
    String name;
    int id;
    double baseSalary;
    
    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    double calculateSalary() {
        return baseSalary;
    }
    
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
    
    void conductMeeting() {
        System.out.println(name + " is conducting a meeting");
    }
}

class Developer extends Employee {
    String programmingLanguage;
    
    Developer(String name, int id, double baseSalary, String programmingLanguage) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }
    
    void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage);
    }
}

// Example 8: Access Modifiers in Inheritance
class BaseClass {
    private int privateVar = 10;      // Not inherited
    int defaultVar = 20;              // Inherited (same package)
    protected int protectedVar = 30;  // Inherited
    public int publicVar = 40;        // Inherited
    
    private void privateMethod() {
        System.out.println("Private method");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
    
    public void publicMethod() {
        System.out.println("Public method");
    }
}

class DerivedClass extends BaseClass {
    void testAccess() {
        // System.out.println(privateVar);  // ❌ Error! Cannot access
        System.out.println(defaultVar);     // ✅ OK (same package)
        System.out.println(protectedVar);   // ✅ OK
        System.out.println(publicVar);      // ✅ OK
        
        // privateMethod();  // ❌ Error! Cannot access
        protectedMethod();   // ✅ OK
        publicMethod();      // ✅ OK
    }
}

// Example 9: Method Hiding (Static Methods)
class ParentStatic {
    static void display() {
        System.out.println("Parent static method");
    }
}

class ChildStatic extends ParentStatic {
    static void display() {
        System.out.println("Child static method");
    }
}

// Example 10: Real-World Example - Bank Account System
class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
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
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    
    void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;
    
    CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
    }
}

// ==================== MAIN CLASS ====================
public class InheritanceExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Single Inheritance ==========");
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.age = 3;
        dog.breed = "Golden Retriever";
        dog.eat();
        dog.bark();
        dog.wagTail();
        
        System.out.println("\n========== Example 2: Multilevel Inheritance ==========");
        Human human = new Human();
        human.breathe();
        human.giveBirth();
        human.speak();
        
        System.out.println("\n========== Example 3: Hierarchical Inheritance ==========");
        Car car = new Car();
        car.brand = "Toyota";
        car.doors = 4;
        car.start();
        car.openTrunk();
        
        Bike bike = new Bike();
        bike.brand = "Honda";
        bike.hasCarrier = true;
        bike.start();
        bike.kickStart();
        
        System.out.println("\n========== Example 4: Method Overriding ==========");
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(10, 5);
        
        shape1.draw();
        System.out.println("Circle Area: " + shape1.area());
        
        shape2.draw();
        System.out.println("Rectangle Area: " + shape2.area());
        
        System.out.println("\n========== Example 5: Using super keyword ==========");
        Child child1 = new Child();
        System.out.println();
        Child child2 = new Child("Hello");
        System.out.println();
        child2.display();
        
        System.out.println("\n========== Example 6: Constructor Chaining ==========");
        ChildClass childClass = new ChildClass();
        
        System.out.println("\n========== Example 7: Employee Hierarchy ==========");
        Manager manager = new Manager("Alice", 101, 5000, 2000);
        manager.displayInfo();
        manager.conductMeeting();
        
        System.out.println();
        Developer developer = new Developer("Bob", 102, 4000, "Java");
        developer.displayInfo();
        developer.writeCode();
        
        System.out.println("\n========== Example 8: Access Modifiers ==========");
        DerivedClass derived = new DerivedClass();
        derived.testAccess();
        
        System.out.println("\n========== Example 9: Method Hiding ==========");
        ParentStatic.display();
        ChildStatic.display();
        ParentStatic obj = new ChildStatic();
        obj.display();  // Calls Parent's static method (method hiding!)
        
        System.out.println("\n========== Example 10: Bank Account System ==========");
        SavingsAccount savings = new SavingsAccount("SA001", "John", 10000, 4);
        savings.displayBalance();
        savings.deposit(2000);
        savings.addInterest();
        savings.displayBalance();
        
        System.out.println();
        CurrentAccount current = new CurrentAccount("CA001", "Jane", 5000, 2000);
        current.displayBalance();
        current.withdraw(6000);  // Uses overdraft
        current.displayBalance();
    }
}
