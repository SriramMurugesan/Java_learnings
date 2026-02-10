import java.util.Scanner;

// ========================================
// 1️⃣ METHOD WITH NO RETURN & NO PARAMETERS
// ========================================
class Example1 {
    void hello() {
        System.out.println("Hello");
    }
    void add(int a, int b) {
        System.out.println(a + b);
    }
    
    public static void main(String[] args) {
        Example1 obj = new Example1();
        obj.add(10,20);  // Output: Hello
    }
}

// ========================================
// 2️⃣ METHOD WITH PARAMETERS & NO RETURN
// ========================================
class Example2 {
    void add(int a, int b) {
        System.out.println(a + b);
    }
    
    public static void main(String[] args) {
        Example2 obj = new Example2();
        obj.add(10, 20);  // Output: 30
    }
}

// ========================================
// 3️⃣ METHOD WITH RETURN & NO PARAMETERS
// ========================================
class Example3 {
    int getNumber() {
        return 10;
    }
    
    public static void main(String[] args) {
        Example3 obj = new Example3();
        int result = obj.getNumber();
        System.out.println(result);  // Output: 10
    }
}

// ========================================
// 4️⃣ METHOD WITH RETURN & PARAMETERS
// ========================================
class Example4 {
    int add(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        Example4 obj = new Example4();
        int result = obj.add(10, 20);
        System.out.println(result);  // Output: 30
    }
}

// ========================================
// 🔥 STATIC vs INSTANCE METHODS (IMPORTANT)
// ========================================
class Example5 {
    
    // STATIC METHOD - No object needed
    static void staticMethod() {
        System.out.println("I am static");
    }
    
    // INSTANCE METHOD - Object required
    void instanceMethod() {
        System.out.println("I am instance");
    }
    
    public static void main(String[] args) {
        // Call static method directly
        staticMethod();
        
        // Call instance method using object
        Example5 obj = new Example5();
        obj.instanceMethod();
    }
}

// ========================================
// USER INPUT EXAMPLE
// ========================================
class Example6 {
    void greet(String name) {
        System.out.println("Hello " + name);
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scn.nextLine();
        
        Example6 obj = new Example6();
        obj.greet(name);
    }
}