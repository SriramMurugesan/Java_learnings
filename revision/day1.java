// Day 1 Revision: Java Basics

public class day1 {
    public static void main(String[] args) {
        
        // 1. Data Types
        System.out.println("=== DATA TYPES ===");
        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 10000L;
        float f = 10.5f;
        double d = 20.5;
        char c = 'A';
        boolean bool = true;
        
        System.out.println("byte: " + b);
        System.out.println("int: " + i);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);
        
        // 2. Type Casting
        System.out.println("\n=== TYPE CASTING ===");
        int num1 = 100;
        double num2 = num1;
        System.out.println("Widening: int " + num1 + " to double " + num2);
        
        double num3 = 99.99;
        int num4 = (int) num3;
        System.out.println("Narrowing: double " + num3 + " to int " + num4);
        
        // 3. Operators
        System.out.println("\n=== OPERATORS ===");
        int a = 10, b1 = 5;
        System.out.println("Addition: " + a + " + " + b1 + " = " + (a + b1));
        System.out.println("Subtraction: " + a + " - " + b1 + " = " + (a - b1));
        System.out.println("Multiplication: " + a + " * " + b1 + " = " + (a * b1));
        System.out.println("Division: " + a + " / " + b1 + " = " + (a / b1));
        System.out.println("Modulus: " + a + " % " + b1 + " = " + (a % b1));
        
        // 4. Methods
        System.out.println("\n=== METHODS ===");
        greet();
        int sum = add(10, 20);
        System.out.println("Sum: " + sum);
    }
    
    static void greet() {
        System.out.println("Hello from method!");
    }
    
    static int add(int x, int y) {
        return x + y;
    }
}
