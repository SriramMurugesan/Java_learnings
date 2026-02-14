// Error vs Exception Examples in Java

// Example 1: StackOverflowError - Infinite Recursion
class StackOverflowExample {
    public static void infiniteRecursion() {
        System.out.println("Calling infiniteRecursion...");
        infiniteRecursion(); // No base case - causes StackOverflowError
    }
    
    public static void demonstrateStackOverflow() {
        System.out.println("=== StackOverflowError Example ===");
        try {
            infiniteRecursion();
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError (Not recommended to catch!)");
            System.out.println("Error: " + e.getClass().getName());
        }
    }
}

// Example 2: OutOfMemoryError
class OutOfMemoryExample {
    public static void demonstrateOutOfMemory() {
        System.out.println("\n=== OutOfMemoryError Example ===");
        System.out.println("Attempting to create huge array...");
        try {
            // Try to allocate huge array
            int[] hugeArray = new int[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError (Not recommended to catch!)");
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Example 3: ArithmeticException
class ArithmeticExceptionExample {
    public static void demonstrateArithmeticException() {
        System.out.println("\n=== ArithmeticException Example ===");
        try {
            int result = 10 / 0; // Division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException (Good to catch!)");
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Example 4: NullPointerException
class NullPointerExceptionExample {
    public static void demonstrateNullPointerException() {
        System.out.println("\n=== NullPointerException Example ===");
        try {
            String str = null;
            System.out.println("String length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException (Good to catch!)");
            System.out.println("Exception: " + e.getClass().getName());
        }
    }
}

// Example 5: ArrayIndexOutOfBoundsException
class ArrayIndexExceptionExample {
    public static void demonstrateArrayIndexException() {
        System.out.println("\n=== ArrayIndexOutOfBoundsException Example ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Accessing index 5: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException (Good to catch!)");
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Example 6: NumberFormatException
class NumberFormatExceptionExample {
    public static void demonstrateNumberFormatException() {
        System.out.println("\n=== NumberFormatException Example ===");
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException (Good to catch!)");
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Example 7: ClassCastException
class ClassCastExceptionExample {
    public static void demonstrateClassCastException() {
        System.out.println("\n=== ClassCastException Example ===");
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj; // Invalid cast
            System.out.println("Number: " + num);
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException (Good to catch!)");
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

// Example 8: Comparing Error and Exception Handling
class ErrorVsExceptionComparison {
    public static void compareErrorAndException() {
        System.out.println("\n=== Error vs Exception Comparison ===");
        
        // Exception - Should be caught and handled
        System.out.println("\n1. Exception (Recoverable):");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Caught exception: " + e.getMessage());
            System.out.println("   Program continues normally...");
        }
        System.out.println("   After exception handling - still running!");
        
        // Error - Should NOT be caught (but we'll demonstrate)
        System.out.println("\n2. Error (Irrecoverable):");
        System.out.println("   Errors like StackOverflowError should terminate the program");
        System.out.println("   They indicate serious problems that cannot be recovered from");
    }
}

// Example 9: Checked vs Unchecked Exceptions
class CheckedVsUnchecked {
    public static void demonstrateCheckedVsUnchecked() {
        System.out.println("\n=== Checked vs Unchecked Exceptions ===");
        
        // Unchecked Exception - No need to declare or catch
        System.out.println("\n1. Unchecked Exception (RuntimeException):");
        try {
            String str = null;
            str.length(); // NullPointerException
        } catch (RuntimeException e) {
            System.out.println("   Caught unchecked exception: " + e.getClass().getSimpleName());
        }
        
        // Checked Exception would require try-catch or throws declaration
        System.out.println("\n2. Checked Exception (IOException, SQLException, etc.):");
        System.out.println("   Must be declared with 'throws' or caught with try-catch");
        System.out.println("   Example: FileReader, Database connections");
    }
}

// Example 10: Multiple Exception Types
class MultipleExceptionTypes {
    public static void demonstrateMultipleExceptions() {
        System.out.println("\n=== Multiple Exception Types ===");
        
        int choice = 1;
        
        try {
            switch (choice) {
                case 1:
                    int result = 10 / 0; // ArithmeticException
                    break;
                case 2:
                    String str = null;
                    str.length(); // NullPointerException
                    break;
                case 3:
                    int[] arr = {1, 2};
                    System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null reference error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        }
    }
}

// Main class to run all examples
public class error_vs_exception_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   ERROR VS EXCEPTION EXAMPLES IN JAVA      ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Run exception examples (safe to demonstrate)
        ArithmeticExceptionExample.demonstrateArithmeticException();
        NullPointerExceptionExample.demonstrateNullPointerException();
        ArrayIndexExceptionExample.demonstrateArrayIndexException();
        NumberFormatExceptionExample.demonstrateNumberFormatException();
        ClassCastExceptionExample.demonstrateClassCastException();
        
        // Comparison
        ErrorVsExceptionComparison.compareErrorAndException();
        CheckedVsUnchecked.demonstrateCheckedVsUnchecked();
        MultipleExceptionTypes.demonstrateMultipleExceptions();
        
        // Error examples (commented out as they can crash the program)
        System.out.println("\n=== Error Examples (Commented Out) ===");
        System.out.println("StackOverflowError and OutOfMemoryError examples are");
        System.out.println("commented out to prevent program termination.");
        System.out.println("Uncomment them to see how Errors behave.");
        
        // Uncomment to see StackOverflowError (will crash)
        // StackOverflowExample.demonstrateStackOverflow();
        
        // Uncomment to see OutOfMemoryError (will crash)
        // OutOfMemoryExample.demonstrateOutOfMemory();
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
