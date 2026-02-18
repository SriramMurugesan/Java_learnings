// Try-Catch Block Examples in Java

import java.util.Scanner;
import java.io.*;

// Example 1: Basic Try-Catch
class BasicTryCatch {
    public static void demonstrateBasic() {
        System.out.println("=== Basic Try-Catch Example ===");
        
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception handling\n");
    }
}

// Example 2: Multiple Catch Blocks
class MultipleCatchBlocks {
    public static void demonstrateMultipleCatch() {
        System.out.println("=== Multiple Catch Blocks ===");
        
        int choice = 1;
        
        try {
            if (choice == 1) {
                int result = 10 / 0; // ArithmeticException
            } else if (choice == 2) {
                String str = null;
                str.length(); // NullPointerException
            } else {
                int[] arr = {1, 2};
                System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null Reference Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
        
        System.out.println("Execution continues\n");
    }
}

// Example 3: Catch Block Order (Specific to General)
class CatchBlockOrder {
    public static void demonstrateCorrectOrder() {
        System.out.println("=== Correct Catch Block Order ===");
        
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // Specific exception first
            System.out.println("Number format error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Parent of NumberFormatException
            System.out.println("Illegal argument: " + e.getMessage());
        } catch (RuntimeException e) {
            // More general
            System.out.println("Runtime exception: " + e.getMessage());
        } catch (Exception e) {
            // Most general
            System.out.println("General exception: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 4: Finally Block
class FinallyBlockExample {
    public static void demonstrateFinally() {
        System.out.println("=== Finally Block Example ===");
        
        System.out.println("Case 1: Exception occurs");
        try {
            System.out.println("  Try block");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("  Catch block");
        } finally {
            System.out.println("  Finally block - Always executes");
        }
        
        System.out.println("\nCase 2: No exception");
        try {
            System.out.println("  Try block");
            int result = 10 / 2;
            System.out.println("  Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("  Catch block");
        } finally {
            System.out.println("  Finally block - Always executes");
        }
        
        System.out.println();
    }
}

// Example 5: Finally for Resource Cleanup
class FinallyResourceCleanup {
    public static void demonstrateResourceCleanup() {
        System.out.println("=== Finally for Resource Cleanup ===");
        
        BufferedReader reader = null;
        try {
            // Simulating file reading
            System.out.println("Opening resource...");
            reader = new BufferedReader(new StringReader("Sample data"));
            String line = reader.readLine();
            System.out.println("Data read: " + line);
            
            // Simulate an error
            // int x = 10 / 0;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            System.out.println("Cleaning up resources...");
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Resource closed successfully");
                } catch (IOException e) {
                    System.out.println("Error closing resource");
                }
            }
        }
        
        System.out.println();
    }
}

// Example 6: Try-With-Resources (Java 7+)
class TryWithResources {
    public static void demonstrateTryWithResources() {
        System.out.println("=== Try-With-Resources Example ===");
        
        // Resources automatically closed
        try (BufferedReader br = new BufferedReader(new StringReader("Line 1\nLine 2\nLine 3"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // BufferedReader automatically closed here
        
        System.out.println("Resources automatically closed\n");
    }
}

// Example 7: Multiple Resources in Try-With-Resources
class MultipleResources {
    public static void demonstrateMultipleResources() {
        System.out.println("=== Multiple Resources Example ===");
        
        try (
            StringReader sr = new StringReader("Sample text");
            BufferedReader br = new BufferedReader(sr)
        ) {
            String data = br.readLine();
            System.out.println("Data: " + data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Both resources automatically closed in reverse order
        
        System.out.println("All resources closed\n");
    }
}

// Example 8: Nested Try-Catch
class NestedTryCatch {
    public static void demonstrateNested() {
        System.out.println("=== Nested Try-Catch Example ===");
        
        try {
            System.out.println("Outer try block");
            
            try {
                System.out.println("Inner try block");
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
            
            // Another exception in outer try
            String str = null;
            str.length();
            
        } catch (NullPointerException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
        
        System.out.println("After nested try-catch\n");
    }
}

// Example 9: Multi-Catch (Java 7+)
class MultiCatch {
    public static void demonstrateMultiCatch() {
        System.out.println("=== Multi-Catch Example ===");
        
        int choice = 1;
        
        try {
            if (choice == 1) {
                int result = 10 / 0;
            } else {
                int[] arr = {1, 2};
                System.out.println(arr[5]);
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught multiple exception types: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 10: Getting Exception Information
class TryCatchExceptionInformation {
    public static void demonstrateExceptionInfo() {
        System.out.println("=== Exception Information Methods ===");
        
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1. getMessage(): " + e.getMessage());
            System.out.println("2. toString(): " + e.toString());
            System.out.println("3. getClass().getName(): " + e.getClass().getName());
            System.out.println("4. getClass().getSimpleName(): " + e.getClass().getSimpleName());
            
            System.out.println("\n5. printStackTrace():");
            e.printStackTrace();
            
            System.out.println("\n6. getStackTrace():");
            StackTraceElement[] trace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, trace.length); i++) {
                System.out.println("   " + trace[i]);
            }
        }
        
        System.out.println();
    }
}

// Example 11: Practical TryCatchCalculator Example
class TryCatchCalculator {
    public static void demonstrateCalculator() {
        System.out.println("=== Practical TryCatchCalculator Example ===");
        
        try {
            int a = 10;
            int b = 0;
            
            System.out.println("Calculating " + a + " / " + b);
            int result = divide(a, b);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please use a non-zero divisor");
        }
        
        System.out.println();
    }
    
    public static int divide(int a, int b) {
        return a / b; // May throw ArithmeticException
    }
}

// Example 12: Array Operations with Exception Handling
class ArrayOperations {
    public static void demonstrateArrayOperations() {
        System.out.println("=== Array Operations Example ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        try {
            System.out.println("Accessing valid index (2): " + numbers[2]);
            System.out.println("Accessing invalid index (10): " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index");
            System.out.println("Array length: " + numbers.length);
            System.out.println("Valid indices: 0 to " + (numbers.length - 1));
        }
        
        System.out.println();
    }
}

// Example 13: String Parsing with Exception Handling
class StringParsing {
    public static void demonstrateStringParsing() {
        System.out.println("=== String Parsing Example ===");
        
        String[] inputs = {"123", "456", "abc", "789"};
        
        for (String input : inputs) {
            try {
                int number = Integer.parseInt(input);
                System.out.println("Parsed: " + input + " → " + number);
            } catch (NumberFormatException e) {
                System.out.println("Cannot parse: " + input + " (not a valid number)");
            }
        }
        
        System.out.println();
    }
}

// Example 14: Finally with Return Statement
class FinallyWithReturn {
    public static int methodWithFinally() {
        try {
            System.out.println("  Try block");
            return 10;
        } catch (Exception e) {
            System.out.println("  Catch block");
            return 20;
        } finally {
            System.out.println("  Finally block executes before return");
            // Note: Don't return from finally, it overrides try/catch return
        }
    }
    
    public static void demonstrateFinallyWithReturn() {
        System.out.println("=== Finally with Return Statement ===");
        int result = methodWithFinally();
        System.out.println("  Returned value: " + result);
        System.out.println();
    }
}

// Example 15: Best Practices Demonstration
class BestPractices {
    public static void demonstrateBestPractices() {
        System.out.println("=== Best Practices ===");
        
        // Good: Specific exception handling
        System.out.println("1. Catch specific exceptions:");
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("   Specific: NumberFormatException caught");
        }
        
        // Good: Meaningful error messages
        System.out.println("\n2. Provide meaningful messages:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   User-friendly: Division by zero is not allowed");
        }
        
        // Good: Resource cleanup
        System.out.println("\n3. Clean up resources:");
        System.out.println("   Use try-with-resources or finally block");
        
        System.out.println();
    }
}

// Main class to run all examples
public class try_catch_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║      TRY-CATCH BLOCK EXAMPLES IN JAVA      ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all demonstrations
        BasicTryCatch.demonstrateBasic();
        MultipleCatchBlocks.demonstrateMultipleCatch();
        CatchBlockOrder.demonstrateCorrectOrder();
        FinallyBlockExample.demonstrateFinally();
        FinallyResourceCleanup.demonstrateResourceCleanup();
        TryWithResources.demonstrateTryWithResources();
        MultipleResources.demonstrateMultipleResources();
        NestedTryCatch.demonstrateNested();
        MultiCatch.demonstrateMultiCatch();
        TryCatchExceptionInformation.demonstrateExceptionInfo();
        TryCatchCalculator.demonstrateCalculator();
        ArrayOperations.demonstrateArrayOperations();
        StringParsing.demonstrateStringParsing();
        FinallyWithReturn.demonstrateFinallyWithReturn();
        BestPractices.demonstrateBestPractices();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
