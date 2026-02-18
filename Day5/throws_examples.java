// Throws Declaration Examples in Java

import java.io.*;

// Example 1: Basic Throws Declaration
class BasicThrows {
    // Method declares it might throw IOException
    public static void readFile() throws IOException {
        System.out.println("=== Basic Throws Example ===");
        FileReader fr = new FileReader("nonexistent.txt");
        fr.close();
    }
    
    public static void demonstrateBasicThrows() {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 2: Multiple Exceptions in Throws
class MultipleThrows {
    public static void processData(String filename, String data) 
            throws IOException, NumberFormatException {
        System.out.println("Processing data from: " + filename);
        
        // May throw IOException
        FileWriter fw = new FileWriter(filename);
        
        // May throw NumberFormatException
        int number = Integer.parseInt(data);
        
        fw.write("Number: " + number);
        fw.close();
    }
    
    public static void demonstrateMultipleThrows() {
        System.out.println("=== Multiple Throws Example ===");
        try {
            processData("output.txt", "123");
            System.out.println("Data processed successfully");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 3: Exception Propagation
class ThrowsExceptionPropagation {
    // Level 3: Throws exception
    public static void methodC() throws IOException {
        System.out.println("  methodC: Throwing IOException");
        throw new IOException("Error in methodC");
    }
    
    // Level 2: Propagates exception
    public static void methodB() throws IOException {
        System.out.println("  methodB: Calling methodC");
        methodC(); // Exception propagates from methodC
    }
    
    // Level 1: Propagates exception
    public static void methodA() throws IOException {
        System.out.println("  methodA: Calling methodB");
        methodB(); // Exception propagates from methodB
    }
    
    public static void demonstratePropagation() {
        System.out.println("=== Exception Propagation Example ===");
        System.out.println("Call chain: methodA → methodB → methodC");
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("  main: Caught exception - " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 4: Two Options - Handle or Propagate
class HandleOrPropagate {
    // Option 1: Handle with try-catch
    public static void option1HandleException() {
        System.out.println("=== Option 1: Handle Exception ===");
        try {
            FileReader fr = new FileReader("test.txt");
            fr.close();
        } catch (IOException e) {
            System.out.println("Handled here: " + e.getMessage());
        }
        System.out.println();
    }
    
    // Option 2: Propagate with throws
    public static void option2PropagateException() throws IOException {
        System.out.println("=== Option 2: Propagate Exception ===");
        FileReader fr = new FileReader("test.txt");
        fr.close();
        // Exception propagated to caller
    }
    
    public static void demonstrateOptions() {
        option1HandleException();
        
        try {
            option2PropagateException();
        } catch (IOException e) {
            System.out.println("Handled by caller: " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 5: Checked vs Unchecked with Throws
class CheckedVsUncheckedThrows {
    // Checked exception - MUST declare throws or use try-catch
    public static void checkedExample() throws IOException {
        System.out.println("Checked exception - must declare");
        throw new IOException("Checked exception");
    }
    
    // Unchecked exception - throws declaration is OPTIONAL
    public static void uncheckedExample() {
        System.out.println("Unchecked exception - throws optional");
        throw new RuntimeException("Unchecked exception");
    }
    
    // Can also declare unchecked exceptions (optional)
    public static void uncheckedWithThrows() throws RuntimeException {
        System.out.println("Unchecked with throws declaration");
        throw new RuntimeException("Unchecked exception");
    }
    
    public static void demonstrateCheckedVsUnchecked() {
        System.out.println("=== Checked vs Unchecked Throws ===");
        
        try {
            checkedExample();
        } catch (IOException e) {
            System.out.println("Caught checked: " + e.getMessage());
        }
        
        try {
            uncheckedExample();
        } catch (RuntimeException e) {
            System.out.println("Caught unchecked: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 6: Throws in Constructors
class ThrowsDatabaseConnection {
    private String connectionString;
    
    // Constructor throws exception
    public ThrowsDatabaseConnection(String url) throws IOException {
        if (url == null || url.isEmpty()) {
            throw new IOException("Invalid connection URL");
        }
        this.connectionString = url;
        System.out.println("Connected to: " + url);
    }
}

class ConstructorThrows {
    public static void demonstrateConstructorThrows() {
        System.out.println("=== Constructor Throws Example ===");
        
        try {
            ThrowsDatabaseConnection db = new ThrowsDatabaseConnection("jdbc:mysql://localhost");
            System.out.println("Connection successful");
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        
        try {
            ThrowsDatabaseConnection db = new ThrowsDatabaseConnection("");
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 7: Method Overriding with Throws
class ThrowsParent {
    public void method() throws IOException {
        System.out.println("ThrowsParent method");
    }
}

class ThrowsChild1 extends ThrowsParent {
    // Valid: Same exception
    @Override
    public void method() throws IOException {
        System.out.println("ThrowsChild1: Same exception");
    }
}

class ThrowsChild2 extends ThrowsParent {
    // Valid: Subclass exception
    @Override
    public void method() throws FileNotFoundException {
        System.out.println("ThrowsChild2: Subclass exception (FileNotFoundException)");
    }
}

class ThrowsChild3 extends ThrowsParent {
    // Valid: No exception
    @Override
    public void method() {
        System.out.println("ThrowsChild3: No exception");
    }
}

class OverridingThrows {
    public static void demonstrateOverriding() {
        System.out.println("=== Method Overriding with Throws ===");
        
        try {
            ThrowsParent p1 = new ThrowsChild1();
            p1.method();
            
            ThrowsParent p2 = new ThrowsChild2();
            p2.method();
            
            ThrowsParent p3 = new ThrowsChild3();
            p3.method();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 8: Practical File Operations
class FileOperations {
    public static String readFileContent(String filename) throws IOException {
        System.out.println("Reading file: " + filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        
        reader.close();
        return content.toString();
    }
    
    public static void demonstrateFileOperations() {
        System.out.println("=== File Operations Example ===");
        
        try {
            String content = readFileContent("sample.txt");
            System.out.println("File content: " + content);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 9: Service Layer Pattern
class UserService {
    // Service method throws to controller
    public String getUserData(int userId) throws IOException {
        System.out.println("Fetching user data for ID: " + userId);
        
        if (userId < 0) {
            throw new IOException("Invalid user ID");
        }
        
        return "User data for ID: " + userId;
    }
}

class UserController {
    private UserService userService = new UserService();
    
    // Controller handles exceptions
    public void displayUser(int userId) {
        System.out.println("=== Service Layer Pattern ===");
        try {
            String userData = userService.getUserData(userId);
            System.out.println("Success: " + userData);
        } catch (IOException e) {
            System.out.println("Error loading user: " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 10: Chained Method Calls with Throws
class ChainedMethods {
    public static void step1() throws IOException {
        System.out.println("  Step 1: Starting process");
        step2();
    }
    
    public static void step2() throws IOException {
        System.out.println("  Step 2: Processing data");
        step3();
    }
    
    public static void step3() throws IOException {
        System.out.println("  Step 3: Finalizing");
        throw new IOException("Error in step 3");
    }
    
    public static void demonstrateChainedMethods() {
        System.out.println("=== Chained Method Calls ===");
        try {
            step1();
        } catch (IOException e) {
            System.out.println("  Error caught: " + e.getMessage());
        }
        System.out.println();
    }
}

// Example 11: Utility Class with Throws
class FileUtils {
    public static boolean fileExists(String filename) throws IOException {
        if (filename == null) {
            throw new IOException("Filename cannot be null");
        }
        File file = new File(filename);
        return file.exists();
    }
    
    public static long getFileSize(String filename) throws IOException {
        if (!fileExists(filename)) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        File file = new File(filename);
        return file.length();
    }
}

class UtilityThrows {
    public static void demonstrateUtilityThrows() {
        System.out.println("=== Utility Class Throws Example ===");
        
        try {
            boolean exists = FileUtils.fileExists("test.txt");
            System.out.println("File exists: " + exists);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
}

// Example 12: Throws vs Try-Catch Comparison
class ThrowsVsTryCatch {
    // Using throws - delegates to caller
    public static int divideWithThrows(int a, int b) throws ArithmeticException {
        return a / b;
    }
    
    // Using try-catch - handles internally
    public static int divideWithTryCatch(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("  Handled internally: " + e.getMessage());
            return 0; // Default value
        }
    }
    
    public static void demonstrateComparison() {
        System.out.println("=== Throws vs Try-Catch Comparison ===");
        
        System.out.println("1. With throws (caller handles):");
        try {
            int result = divideWithThrows(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("  Caller handles: " + e.getMessage());
        }
        
        System.out.println("\n2. With try-catch (method handles):");
        int result = divideWithTryCatch(10, 0);
        System.out.println("  Result: " + result);
        
        System.out.println();
    }
}

// Main class to run all examples
public class throws_examples {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     THROWS DECLARATION EXAMPLES IN JAVA    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // Run all demonstrations
        BasicThrows.demonstrateBasicThrows();
        MultipleThrows.demonstrateMultipleThrows();
        ThrowsExceptionPropagation.demonstratePropagation();
        HandleOrPropagate.demonstrateOptions();
        CheckedVsUncheckedThrows.demonstrateCheckedVsUnchecked();
        ConstructorThrows.demonstrateConstructorThrows();
        OverridingThrows.demonstrateOverriding();
        FileOperations.demonstrateFileOperations();
        
        UserController controller = new UserController();
        controller.displayUser(123);
        controller.displayUser(-1);
        
        ChainedMethods.demonstrateChainedMethods();
        UtilityThrows.demonstrateUtilityThrows();
        ThrowsVsTryCatch.demonstrateComparison();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         ALL EXAMPLES COMPLETED             ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
