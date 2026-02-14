// Exception Hierarchy Examples in Java

// Example 1: Throwable Class Methods
class ThrowableClassMethods {
    public static void demonstrateThrowableMethods() {
        System.out.println("=== Throwable Class Methods ===");
        
        try {
            int result = 10 / 0;
        } catch (Throwable t) {
            System.out.println("1. getMessage(): " + t.getMessage());
            System.out.println("2. toString(): " + t.toString());
            System.out.println("3. getClass().getName(): " + t.getClass().getName());
            System.out.println("4. getLocalizedMessage(): " + t.getLocalizedMessage());
            System.out.println("\n5. printStackTrace():");
            t.printStackTrace();
        }
        
        System.out.println();
    }
}

// Example 2: Error Hierarchy
class ErrorHierarchy {
    public static void demonstrateStackOverflowError() {
        System.out.println("=== StackOverflowError (Commented) ===");
        System.out.println("Infinite recursion causes StackOverflowError");
        System.out.println("This is an Error, not an Exception");
        // Uncomment to see actual error (will crash program)
        // recursiveMethod();
    }
    
    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }
}

// Example 3: Exception Hierarchy Levels
class ExceptionHierarchyLevels {
    public static void demonstrateHierarchy() {
        System.out.println("=== Exception Hierarchy Levels ===");
        
        // Level 1: Specific exception
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException (most specific)");
            System.out.println("Type: " + e.getClass().getSimpleName());
        }
        
        // Level 2: Parent exception
        try {
            throw new IllegalArgumentException("Test");
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught IllegalArgumentException (parent of NumberFormatException)");
            System.out.println("Type: " + e.getClass().getSimpleName());
        }
        
        // Level 3: RuntimeException
        try {
            throw new RuntimeException("Test");
        } catch (RuntimeException e) {
            System.out.println("\nCaught RuntimeException (grandparent)");
            System.out.println("Type: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
}

// Example 4: Checked Exceptions
class CheckedExceptions {
    public static void demonstrateCheckedExceptions() {
        System.out.println("=== Checked Exceptions ===");
        
        // IOException
        System.out.println("1. IOException (Checked):");
        try {
            throw new java.io.IOException("IO operation failed");
        } catch (java.io.IOException e) {
            System.out.println("   Message: " + e.getMessage());
        }
        
        // FileNotFoundException (subclass of IOException)
        System.out.println("\n2. FileNotFoundException (Checked, subclass of IOException):");
        try {
            throw new java.io.FileNotFoundException("File not found");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("   Message: " + e.getMessage());
        }
        
        // SQLException
        System.out.println("\n3. SQLException (Checked):");
        try {
            throw new java.sql.SQLException("Database error");
        } catch (java.sql.SQLException e) {
            System.out.println("   Message: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 5: Unchecked Exceptions (RuntimeException)
class UncheckedExceptions {
    public static void demonstrateUncheckedExceptions() {
        System.out.println("=== Unchecked Exceptions (RuntimeException) ===");
        
        // NullPointerException
        System.out.println("1. NullPointerException:");
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // ArithmeticException
        System.out.println("\n2. ArithmeticException:");
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // ArrayIndexOutOfBoundsException
        System.out.println("\n3. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // ClassCastException
        System.out.println("\n4. ClassCastException:");
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // IllegalArgumentException
        System.out.println("\n5. IllegalArgumentException:");
        try {
            throw new IllegalArgumentException("Invalid argument");
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        // NumberFormatException (subclass of IllegalArgumentException)
        System.out.println("\n6. NumberFormatException:");
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
            System.out.println("   Parent: " + e.getClass().getSuperclass().getSimpleName());
        }
        
        System.out.println();
    }
}

// Example 6: Catching Parent Exception
class CatchingParentException {
    public static void demonstrateCatchingParent() {
        System.out.println("=== Catching Parent Exception ===");
        
        // Parent catches child
        System.out.println("1. RuntimeException catches NullPointerException:");
        try {
            String str = null;
            str.length();
        } catch (RuntimeException e) {
            System.out.println("   Caught by parent: " + e.getClass().getSimpleName());
        }
        
        // IllegalArgumentException catches NumberFormatException
        System.out.println("\n2. IllegalArgumentException catches NumberFormatException:");
        try {
            Integer.parseInt("xyz");
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught by parent: " + e.getClass().getSimpleName());
        }
        
        // Exception catches all
        System.out.println("\n3. Exception catches all exception types:");
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            System.out.println("   Caught by Exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
}

// Example 7: Specific to General Catch Order
class SpecificToGeneralOrder {
    public static void demonstrateCatchOrder() {
        System.out.println("=== Specific to General Catch Order ===");
        
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Level 1 (Most Specific): NumberFormatException");
        } catch (IllegalArgumentException e) {
            System.out.println("Level 2: IllegalArgumentException");
        } catch (RuntimeException e) {
            System.out.println("Level 3: RuntimeException");
        } catch (Exception e) {
            System.out.println("Level 4 (Most General): Exception");
        }
        
        System.out.println();
    }
}

// Example 8: IndexOutOfBoundsException Family
class IndexOutOfBoundsFamily {
    public static void demonstrateIndexFamily() {
        System.out.println("=== IndexOutOfBoundsException Family ===");
        
        // ArrayIndexOutOfBoundsException
        System.out.println("1. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Type: " + e.getClass().getSimpleName());
            System.out.println("   Parent: " + e.getClass().getSuperclass().getSimpleName());
        }
        
        // StringIndexOutOfBoundsException
        System.out.println("\n2. StringIndexOutOfBoundsException:");
        try {
            String str = "Hello";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("   Type: " + e.getClass().getSimpleName());
            System.out.println("   Parent: " + e.getClass().getSuperclass().getSimpleName());
        }
        
        // Catching parent IndexOutOfBoundsException
        System.out.println("\n3. Parent IndexOutOfBoundsException catches both:");
        try {
            int[] arr = {1, 2};
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   Caught: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
}

// Example 9: Checked vs Unchecked Demonstration
class CheckedVsUncheckedDemo {
    // Checked exception - must declare or handle
    public static void checkedMethod() throws java.io.IOException {
        throw new java.io.IOException("Checked exception");
    }
    
    // Unchecked exception - optional to declare
    public static void uncheckedMethod() {
        throw new RuntimeException("Unchecked exception");
    }
    
    public static void demonstrateCheckedVsUnchecked() {
        System.out.println("=== Checked vs Unchecked Demonstration ===");
        
        System.out.println("1. Checked Exception (must handle):");
        try {
            checkedMethod();
        } catch (java.io.IOException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println("\n2. Unchecked Exception (optional to handle):");
        try {
            uncheckedMethod();
        } catch (RuntimeException e) {
            System.out.println("   Caught: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 10: Exception Inheritance Chain
class ExceptionInheritanceChain {
    public static void demonstrateInheritanceChain() {
        System.out.println("=== Exception Inheritance Chain ===");
        
        try {
            throw new NumberFormatException("Invalid number");
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            
            Class<?> current = e.getClass();
            System.out.println("\nInheritance chain:");
            int level = 1;
            while (current != null && !current.equals(Object.class)) {
                System.out.println("  Level " + level + ": " + current.getSimpleName());
                current = current.getSuperclass();
                level++;
            }
        }
        
        System.out.println();
    }
}

// Example 11: Multiple Exception Types
class MultipleExceptionTypes {
    public static void demonstrateMultipleTypes() {
        System.out.println("=== Multiple Exception Types ===");
        
        Exception[] exceptions = {
            new NullPointerException("Null reference"),
            new ArithmeticException("Division by zero"),
            new ArrayIndexOutOfBoundsException("Invalid index"),
            new NumberFormatException("Invalid number"),
            new IllegalStateException("Invalid state")
        };
        
        for (Exception e : exceptions) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
            System.out.println("  Message: " + e.getMessage());
            System.out.println("  Parent: " + e.getClass().getSuperclass().getSimpleName());
            System.out.println();
        }
    }
}

// Example 12: Catching Multiple Levels
class CatchingMultipleLevels {
    public static void testException(int type) throws Exception {
        switch (type) {
            case 1:
                throw new NumberFormatException("Number format error");
            case 2:
                throw new IllegalArgumentException("Illegal argument");
            case 3:
                throw new RuntimeException("Runtime error");
            case 4:
                throw new Exception("General exception");
            default:
                System.out.println("No exception");
        }
    }
    
    public static void demonstrateMultipleLevels() {
        System.out.println("=== Catching Multiple Levels ===");
        
        for (int i = 1; i <= 4; i++) {
            try {
                System.out.print("Test " + i + ": ");
                testException(i);
            } catch (NumberFormatException e) {
                System.out.println("Caught NumberFormatException");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught IllegalArgumentException");
            } catch (RuntimeException e) {
                System.out.println("Caught RuntimeException");
            } catch (Exception e) {
                System.out.println("Caught Exception");
            }
        }
        
        System.out.println();
    }
}

// Example 13: Exception Hierarchy Tree
class ExceptionHierarchyTree {
    public static void demonstrateHierarchyTree() {
        System.out.println("=== Exception Hierarchy Tree ===");
        System.out.println("Throwable");
        System.out.println("├── Error (Unchecked)");
        System.out.println("│   ├── VirtualMachineError");
        System.out.println("│   │   ├── StackOverflowError");
        System.out.println("│   │   └── OutOfMemoryError");
        System.out.println("│   └── AssertionError");
        System.out.println("│");
        System.out.println("└── Exception");
        System.out.println("    ├── IOException (Checked)");
        System.out.println("    │   ├── FileNotFoundException");
        System.out.println("    │   └── EOFException");
        System.out.println("    ├── SQLException (Checked)");
        System.out.println("    └── RuntimeException (Unchecked)");
        System.out.println("        ├── NullPointerException");
        System.out.println("        ├── ArithmeticException");
        System.out.println("        ├── ArrayIndexOutOfBoundsException");
        System.out.println("        ├── ClassCastException");
        System.out.println("        └── IllegalArgumentException");
        System.out.println("            └── NumberFormatException");
        System.out.println();
    }
}

// Example 14: Practical Hierarchy Usage
class PracticalHierarchyUsage {
    public static void processData(String data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }
        try {
            int number = Integer.parseInt(data);
            System.out.println("Processed number: " + number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + data);
        }
    }
    
    public static void demonstratePracticalUsage() {
        System.out.println("=== Practical Hierarchy Usage ===");
        
        String[] inputs = {"123", "", null, "abc"};
        
        for (String input : inputs) {
            try {
                System.out.print("Input: " + input + " → ");
                processData(input);
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println();
    }
}

// Main class to run all examples
public class exception_hierarchy_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║    EXCEPTION HIERARCHY EXAMPLES IN JAVA    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all demonstrations
        ThrowableClassMethods.demonstrateThrowableMethods();
        ErrorHierarchy.demonstrateStackOverflowError();
        ExceptionHierarchyLevels.demonstrateHierarchy();
        CheckedExceptions.demonstrateCheckedExceptions();
        UncheckedExceptions.demonstrateUncheckedExceptions();
        CatchingParentException.demonstrateCatchingParent();
        SpecificToGeneralOrder.demonstrateCatchOrder();
        IndexOutOfBoundsFamily.demonstrateIndexFamily();
        CheckedVsUncheckedDemo.demonstrateCheckedVsUnchecked();
        ExceptionInheritanceChain.demonstrateInheritanceChain();
        MultipleExceptionTypes.demonstrateMultipleTypes();
        CatchingMultipleLevels.demonstrateMultipleLevels();
        ExceptionHierarchyTree.demonstrateHierarchyTree();
        PracticalHierarchyUsage.demonstratePracticalUsage();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
