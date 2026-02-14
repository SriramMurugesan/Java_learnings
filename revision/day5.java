// Day 5 Revision: Exception Handling

class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

public class day5 {
    public static void main(String[] args) {
        
        // 1. Try-Catch
        System.out.println("=== TRY-CATCH ===");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
        
        // 2. Multiple Catch
        System.out.println("\n=== MULTIPLE CATCH ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index");
        } catch (Exception e) {
            System.out.println("Error: General exception");
        }
        
        // 3. Finally Block
        System.out.println("\n=== FINALLY BLOCK ===");
        try {
            System.out.println("Try block");
            int x = 10 / 2;
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block - Always executes");
        }
        
        // 4. Throw Keyword
        System.out.println("\n=== THROW KEYWORD ===");
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // 5. Throws Declaration
        System.out.println("\n=== THROWS DECLARATION ===");
        try {
            validateAge(25);
            validateAge(200);
        } catch (AgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // 6. Custom Exception
        System.out.println("\n=== CUSTOM EXCEPTION ===");
        try {
            processData("abc");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
        }
        
        // 7. Exception Hierarchy
        System.out.println("\n=== EXCEPTION HIERARCHY ===");
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer exception");
        }
        
        // 8. Nested Try-Catch
        System.out.println("\n=== NESTED TRY-CATCH ===");
        try {
            System.out.println("Outer try");
            try {
                System.out.println("Inner try");
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Outer catch");
        }
        
        System.out.println("\nProgram continues...");
    }
    
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Valid age: " + age);
    }
    
    static void validateAge(int age) throws AgeException {
        if (age < 0 || age > 150) {
            throw new AgeException("Invalid age: " + age);
        }
        System.out.println("Valid age: " + age);
    }
    
    static void processData(String data) {
        int number = Integer.parseInt(data);
        System.out.println("Number: " + number);
    }
}
