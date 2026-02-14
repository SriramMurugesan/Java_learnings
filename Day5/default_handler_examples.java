// Default Exception Handler Examples in Java

// Example 1: Basic Uncaught Exception
class BasicUncaughtException {
    public static void demonstrateBasicUncaught() {
        System.out.println("=== Basic Uncaught Exception ===");
        System.out.println("Before exception");
        // This will be caught and demonstrated in main
        int result = 10 / 0;
        System.out.println("After exception"); // This line never executes
    }
}

// Example 2: Stack Trace Demonstration
class StackTraceDemo {
    public static void methodA() {
        System.out.println("methodA called");
        methodB();
    }
    
    public static void methodB() {
        System.out.println("methodB called");
        methodC();
    }
    
    public static void methodC() {
        System.out.println("methodC called");
        // Exception occurs here
        int[] arr = {1, 2, 3};
        System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
    }
    
    public static void demonstrateStackTrace() {
        System.out.println("\n=== Stack Trace Demonstration ===");
        System.out.println("Calling methodA...");
        try {
            methodA();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nException caught!");
            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println("Exception message: " + e.getMessage());
            System.out.println("\nStack trace (read bottom to top):");
            e.printStackTrace();
        }
    }
}

// Example 3: Multiple Method Calls
class MultipleMethodCalls {
    public static void level1() {
        System.out.println("Level 1 method");
        level2();
    }
    
    public static void level2() {
        System.out.println("Level 2 method");
        level3();
    }
    
    public static void level3() {
        System.out.println("Level 3 method");
        level4();
    }
    
    public static void level4() {
        System.out.println("Level 4 method - Exception occurs here");
        String str = null;
        str.length(); // NullPointerException
    }
    
    public static void demonstrateMultipleLevels() {
        System.out.println("\n=== Multiple Method Calls ===");
        try {
            level1();
        } catch (NullPointerException e) {
            System.out.println("\nCaught NullPointerException");
            System.out.println("Call chain: level1 → level2 → level3 → level4");
            System.out.println("\nStack trace shows the path:");
            e.printStackTrace();
        }
    }
}

// Example 4: Exception Information Methods
class ExceptionInformation {
    public static void demonstrateExceptionInfo() {
        System.out.println("\n=== Exception Information Methods ===");
        try {
            int result = 100 / 0;
        } catch (ArithmeticException e) {
            System.out.println("1. getMessage(): " + e.getMessage());
            System.out.println("2. toString(): " + e.toString());
            System.out.println("3. getClass().getName(): " + e.getClass().getName());
            System.out.println("4. getClass().getSimpleName(): " + e.getClass().getSimpleName());
            System.out.println("\n5. printStackTrace():");
            e.printStackTrace();
            
            System.out.println("\n6. getStackTrace() - Array of stack elements:");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length && i < 3; i++) {
                System.out.println("   [" + i + "] " + stackTrace[i]);
            }
        }
    }
}

// Example 5: Program Termination Behavior
class ProgramTermination {
    public static void demonstrateTerminationWithCatch() {
        System.out.println("\n=== With Exception Handling ===");
        System.out.println("Start of program");
        
        try {
            System.out.println("Before exception");
            int result = 10 / 0;
            System.out.println("After exception"); // Not executed
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("End of program - Program continues!");
    }
    
    public static void demonstrateTerminationWithoutCatch() {
        System.out.println("\n=== Without Exception Handling (Simulated) ===");
        System.out.println("Start of program");
        System.out.println("Before exception");
        System.out.println("Exception occurs here: ArithmeticException: / by zero");
        System.out.println("Default handler prints stack trace");
        System.out.println("Program terminates abnormally");
        System.out.println("Lines after exception are NOT executed");
    }
}

// Example 6: Different Exception Types
class DifferentExceptionTypes {
    public static void demonstrateDifferentTypes() {
        System.out.println("\n=== Different Exception Types ===");
        
        // Type 1: ArithmeticException
        System.out.println("\n1. ArithmeticException:");
        try {
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Type: " + e.getClass().getSimpleName());
        }
        
        // Type 2: NullPointerException
        System.out.println("\n2. NullPointerException:");
        try {
            String str = null;
            str.charAt(0);
        } catch (NullPointerException e) {
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Type: " + e.getClass().getSimpleName());
        }
        
        // Type 3: ArrayIndexOutOfBoundsException
        System.out.println("\n3. ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Type: " + e.getClass().getSimpleName());
        }
        
        // Type 4: NumberFormatException
        System.out.println("\n4. NumberFormatException:");
        try {
            int num = Integer.parseInt("xyz");
        } catch (NumberFormatException e) {
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Type: " + e.getClass().getSimpleName());
        }
    }
}

// Example 7: Reading Stack Trace
class ReadingStackTrace {
    public static void outerMethod() {
        middleMethod();
    }
    
    public static void middleMethod() {
        innerMethod();
    }
    
    public static void innerMethod() {
        // Exception occurs here at line 162
        throw new RuntimeException("Custom error message");
    }
    
    public static void demonstrateReadingStackTrace() {
        System.out.println("\n=== Reading Stack Trace ===");
        System.out.println("Understanding the stack trace:");
        
        try {
            outerMethod();
        } catch (RuntimeException e) {
            System.out.println("\nException: " + e.getMessage());
            System.out.println("\nHow to read the stack trace:");
            System.out.println("1. Read from BOTTOM to TOP");
            System.out.println("2. Bottom = where execution started (main)");
            System.out.println("3. Top = where exception occurred");
            System.out.println("4. Each line shows: method name and line number");
            System.out.println("\nActual stack trace:");
            e.printStackTrace();
        }
    }
}

// Example 8: Exception Propagation
class ExceptionPropagation {
    public static void method1() {
        method2();
    }
    
    public static void method2() {
        method3();
    }
    
    public static void method3() {
        // Exception starts here
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[5]);
    }
    
    public static void demonstratePropagation() {
        System.out.println("\n=== Exception Propagation ===");
        System.out.println("Exception propagates up the call stack:");
        System.out.println("method3 → method2 → method1 → main");
        
        try {
            method1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nException caught in main method");
            System.out.println("It propagated through all methods");
            System.out.println("\nStack trace shows the propagation path:");
            e.printStackTrace();
        }
    }
}

// Example 9: Default Handler Output Format
class DefaultHandlerFormat {
    public static void demonstrateDefaultFormat() {
        System.out.println("\n=== Default Handler Output Format ===");
        System.out.println("Format: Exception in thread \"thread-name\" ExceptionType: message");
        System.out.println("        at ClassName.methodName(FileName.java:LineNumber)");
        System.out.println("        at ClassName.methodName(FileName.java:LineNumber)");
        System.out.println("        ...");
        
        try {
            throw new IllegalArgumentException("Sample error message");
        } catch (IllegalArgumentException e) {
            System.out.println("\nActual output:");
            e.printStackTrace();
        }
    }
}

// Example 10: Comparing Handled vs Unhandled
class HandledVsUnhandled {
    public static void demonstrateComparison() {
        System.out.println("\n=== Handled vs Unhandled Comparison ===");
        
        System.out.println("\n1. HANDLED Exception:");
        System.out.println("   - Try-catch block catches the exception");
        System.out.println("   - Custom error message shown");
        System.out.println("   - Program continues execution");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("   - Caught: " + e.getMessage());
        }
        System.out.println("   - Program still running!");
        
        System.out.println("\n2. UNHANDLED Exception (what would happen):");
        System.out.println("   - No try-catch block");
        System.out.println("   - Default handler activates");
        System.out.println("   - Stack trace printed to console");
        System.out.println("   - Program terminates abnormally");
        System.out.println("   - Remaining code not executed");
    }
}

// Main class to run all examples
public class default_handler_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   DEFAULT EXCEPTION HANDLER EXAMPLES       ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Run all demonstrations
        StackTraceDemo.demonstrateStackTrace();
        MultipleMethodCalls.demonstrateMultipleLevels();
        ExceptionInformation.demonstrateExceptionInfo();
        ProgramTermination.demonstrateTerminationWithCatch();
        ProgramTermination.demonstrateTerminationWithoutCatch();
        DifferentExceptionTypes.demonstrateDifferentTypes();
        ReadingStackTrace.demonstrateReadingStackTrace();
        ExceptionPropagation.demonstratePropagation();
        DefaultHandlerFormat.demonstrateDefaultFormat();
        HandledVsUnhandled.demonstrateComparison();
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
