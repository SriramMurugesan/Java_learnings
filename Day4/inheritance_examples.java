// ==================== INHERITANCE EXAMPLES ====================

// Example 1: Single Inheritance
class InheritanceAnimal {
    String name;
    int age;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class InheritanceDog extends InheritanceAnimal {
    String breed;

    void bark() {
        System.out.println(name + " is barking");
    }

    void wagTail() {
        System.out.println(name + " is wagging tail");
    }
}

// Example 2: Multilevel Inheritance
class InheritanceLivingBeing {
    void breathe() {
        System.out.println("Breathing...");
    }
}

class InheritanceMammal extends InheritanceLivingBeing {
    void giveBirth() {
        System.out.println("Giving birth to young ones");
    }
}

class InheritanceHuman extends InheritanceMammal {
    void speak() {
        System.out.println("Speaking...");
    }
}

// Example 3: Hierarchical Inheritance
class InheritanceVehicle {
    String brand;
    int year;

    void start() {
        System.out.println(brand + " is starting");
    }

    void stop() {
        System.out.println(brand + " is stopping");
    }
}

class InheritanceCar extends InheritanceVehicle {
    int doors;

    void openTrunk() {
        System.out.println("Opening trunk");
    }
}

class Bike extends InheritanceVehicle {
    boolean hasCarrier;

    void kickStart() {
        System.out.println("Kick starting bike");
    }
}

class Truck extends InheritanceVehicle {
    double loadCapacity;

    void loadCargo() {
        System.out.println("Loading cargo");
    }
}

// Example 4: Method Overriding
class InheritanceShape {
    void draw() {
        System.out.println("Drawing a shape");
    }

    double area() {
        return 0.0;
    }
}

class InheritanceCircle extends InheritanceShape {
    double radius;

    InheritanceCircle(double radius) {
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

class InheritanceRectangle extends InheritanceShape {
    double length;
    double width;

    InheritanceRectangle(double length, double width) {
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
class InheritanceParent {
    int x = 10;

    InheritanceParent() {
        System.out.println("InheritanceParent constructor");
    }

    InheritanceParent(String message) {
        System.out.println("InheritanceParent: " + message);
    }

    void display() {
        System.out.println("InheritanceParent display method");
    }
}

class InheritanceChild extends InheritanceParent {
    int x = 20;

    InheritanceChild() {
        super(); // Call parent's no-arg constructor
        System.out.println("InheritanceChild constructor");
    }

    InheritanceChild(String message) {
        super(message); // Call parent's parameterized constructor
        System.out.println("InheritanceChild: " + message);
    }

    @Override
    void display() {
        System.out.println("InheritanceChild x: " + x);
        System.out.println("InheritanceParent x: " + super.x);
        super.display(); // Call parent's display method
        System.out.println("InheritanceChild display method");
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
        super(); // Implicit call to GrandParent()
        System.out.println("ParentClass constructor");
    }
}

class ChildClass extends ParentClass {
    ChildClass() {
        super(); // Implicit call to ParentClass()
        System.out.println("ChildClass constructor");
    }
}

// Example 7: Real-World Example - InheritanceEmployee Hierarchy
class InheritanceEmployee {
    String name;
    int id;
    double baseSalary;

    InheritanceEmployee(String name, int id, double baseSalary) {
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

class InheritanceManager extends InheritanceEmployee {
    double bonus;

    InheritanceManager(String name, int id, double baseSalary, double bonus) {
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

class InheritanceDeveloper extends InheritanceEmployee {
    String programmingLanguage;

    InheritanceDeveloper(String name, int id, double baseSalary, String programmingLanguage) {
        super(name, id, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }

    void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage);
    }
}

// Example 8: Access Modifiers in Inheritance
class BaseClass {
    private int privateVar = 10; // Not inherited
    int defaultVar = 20; // Inherited (same package)
    protected int protectedVar = 30; // Inherited
    public int publicVar = 40; // Inherited

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
        // System.out.println(privateVar); // ❌ Error! Cannot access
        System.out.println(defaultVar); // ✅ OK (same package)
        System.out.println(protectedVar); // ✅ OK
        System.out.println(publicVar); // ✅ OK

        // privateMethod(); // ❌ Error! Cannot access
        protectedMethod(); // ✅ OK
        publicMethod(); // ✅ OK
    }
}

// Example 9: Method Hiding (Static Methods)
class ParentStatic {
    static void display() {
        System.out.println("InheritanceParent static method");
    }
}

class ChildStatic extends ParentStatic {
    static void display() {
        System.out.println("InheritanceChild static method");
    }
}

// Example 10: Real-World Example - Bank Account System
class InheritanceBankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    InheritanceBankAccount(String accountNumber, String holderName, double balance) {
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

class InheritanceSavingsAccount extends InheritanceBankAccount {
    double interestRate;

    InheritanceSavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

class InheritanceCurrentAccount extends InheritanceBankAccount {
    double overdraftLimit;

    InheritanceCurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
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
class InheritanceExamples {
    public static void main(String[] args) {
        System.out.println("========== Example 1: Single Inheritance ==========");
        InheritanceDog dog = new InheritanceDog();
        dog.name = "Buddy";
        dog.age = 3;
        dog.breed = "Golden Retriever";
        dog.eat();
        dog.bark();
        dog.wagTail();

        System.out.println("\n========== Example 2: Multilevel Inheritance ==========");
        InheritanceHuman human = new InheritanceHuman();
        human.breathe();
        human.giveBirth();
        human.speak();

        System.out.println("\n========== Example 3: Hierarchical Inheritance ==========");
        InheritanceCar car = new InheritanceCar();
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
        InheritanceShape shape1 = new InheritanceCircle(5);
        InheritanceShape shape2 = new InheritanceRectangle(10, 5);

        shape1.draw();
        System.out.println("InheritanceCircle Area: " + shape1.area());

        shape2.draw();
        System.out.println("InheritanceRectangle Area: " + shape2.area());

        System.out.println("\n========== Example 5: Using super keyword ==========");
        InheritanceChild child1 = new InheritanceChild();
        System.out.println();
        InheritanceChild child2 = new InheritanceChild("Hello");
        System.out.println();
        child2.display();

        System.out.println("\n========== Example 6: Constructor Chaining ==========");
        ChildClass childClass = new ChildClass();

        System.out.println("\n========== Example 7: InheritanceEmployee Hierarchy ==========");
        InheritanceManager manager = new InheritanceManager("Alice", 101, 5000, 2000);
        manager.displayInfo();
        manager.conductMeeting();

        System.out.println();
        InheritanceDeveloper developer = new InheritanceDeveloper("Bob", 102, 4000, "Java");
        developer.displayInfo();
        developer.writeCode();

        System.out.println("\n========== Example 8: Access Modifiers ==========");
        DerivedClass derived = new DerivedClass();
        derived.testAccess();

        System.out.println("\n========== Example 9: Method Hiding ==========");
        ParentStatic.display();
        ChildStatic.display();
        ParentStatic obj = new ChildStatic();
        obj.display(); // Calls InheritanceParent's static method (method hiding!)

        System.out.println("\n========== Example 10: Bank Account System ==========");
        InheritanceSavingsAccount savings = new InheritanceSavingsAccount("SA001", "John", 10000, 4);
        savings.displayBalance();
        savings.deposit(2000);
        savings.addInterest();
        savings.displayBalance();

        System.out.println();
        InheritanceCurrentAccount current = new InheritanceCurrentAccount("CA001", "Jane", 5000, 2000);
        current.displayBalance();
        current.withdraw(6000); // Uses overdraft
        current.displayBalance();
    }
}
