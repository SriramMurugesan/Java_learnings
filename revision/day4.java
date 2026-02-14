// Day 4 Revision: OOP Concepts

// 1. ENCAPSULATION
class Person {
    private String name;
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

// 2. INHERITANCE - Single
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// 3. INHERITANCE - Multilevel
class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}

class SportsCar extends Car {
    void turbo() {
        System.out.println("Turbo activated");
    }
}

// 4. INHERITANCE - Hierarchical
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing rectangle");
    }
}

// 5. POLYMORPHISM - Method Overloading (Compile-time)
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

// 6. POLYMORPHISM - Method Overriding (Runtime)
class Parent {
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child display");
    }
}

// 7. ABSTRACTION - Abstract Class
abstract class Bank {
    abstract void getRateOfInterest();
    
    void welcome() {
        System.out.println("Welcome to Bank");
    }
}

class SBI extends Bank {
    void getRateOfInterest() {
        System.out.println("SBI Rate: 7%");
    }
}

class HDFC extends Bank {
    void getRateOfInterest() {
        System.out.println("HDFC Rate: 8%");
    }
}

// 8. INTERFACE
interface Printable {
    void print();
}

interface Showable {
    void show();
}

class Document implements Printable, Showable {
    public void print() {
        System.out.println("Printing document");
    }
    
    public void show() {
        System.out.println("Showing document");
    }
}

public class day4 {
    public static void main(String[] args) {
        
        // 1. Encapsulation
        System.out.println("=== ENCAPSULATION ===");
        Person p = new Person();
        p.setName("John");
        p.setAge(25);
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        
        // 2. Inheritance - Single
        System.out.println("\n=== SINGLE INHERITANCE ===");
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        
        // 3. Inheritance - Multilevel
        System.out.println("\n=== MULTILEVEL INHERITANCE ===");
        SportsCar sc = new SportsCar();
        sc.start();
        sc.drive();
        sc.turbo();
        
        // 4. Inheritance - Hierarchical
        System.out.println("\n=== HIERARCHICAL INHERITANCE ===");
        Circle circle = new Circle();
        circle.draw();
        circle.drawCircle();
        
        Rectangle rect = new Rectangle();
        rect.draw();
        rect.drawRectangle();
        
        // 5. Polymorphism - Overloading
        System.out.println("\n=== METHOD OVERLOADING ===");
        Calculator calc = new Calculator();
        System.out.println("add(5, 10): " + calc.add(5, 10));
        System.out.println("add(5, 10, 15): " + calc.add(5, 10, 15));
        System.out.println("add(5.5, 10.5): " + calc.add(5.5, 10.5));
        
        // 6. Polymorphism - Overriding
        System.out.println("\n=== METHOD OVERRIDING ===");
        Parent parent = new Parent();
        parent.display();
        
        Child child = new Child();
        child.display();
        
        Parent ref = new Child();
        ref.display();
        
        // 7. Abstraction
        System.out.println("\n=== ABSTRACTION ===");
        Bank sbi = new SBI();
        sbi.welcome();
        sbi.getRateOfInterest();
        
        Bank hdfc = new HDFC();
        hdfc.welcome();
        hdfc.getRateOfInterest();
        
        // 8. Interface
        System.out.println("\n=== INTERFACE ===");
        Document doc = new Document();
        doc.print();
        doc.show();
    }
}
