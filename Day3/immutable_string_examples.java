// Example 1: Demonstrating String immutability
class StringImmutabilityDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;  // Both point to same object
        
        System.out.println("=== Before modification ===");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s1 == s2: " + (s1 == s2));  // true
        
        // "Modify" s1
        s1 = s1 + " World";  // Creates NEW object
        
        System.out.println("\n=== After 'modification' ===");
        System.out.println("s1: " + s1);  // "Hello World"
        System.out.println("s2: " + s2);  // "Hello" (unchanged!)
        System.out.println("s1 == s2: " + (s1 == s2));  // false (different objects)
    }
}

// Example 2: String Pool demonstration
class StringPoolDemo {
    public static void main(String[] args) {
        // String literals go to pool
        String s1 = "Java";
        String s2 = "Java";
        String s3 = "Java";
        
        // new keyword creates heap objects
        String s4 = new String("Java");
        String s5 = new String("Java");
        
        System.out.println("=== String Pool ===");
        System.out.println("s1 == s2: " + (s1 == s2));  // true (same pool object)
        System.out.println("s2 == s3: " + (s2 == s3));  // true (same pool object)
        
        System.out.println("\n=== Heap Objects ===");
        System.out.println("s4 == s5: " + (s4 == s5));  // false (different heap objects)
        
        System.out.println("\n=== Pool vs Heap ===");
        System.out.println("s1 == s4: " + (s1 == s4));  // false (pool vs heap)
        
        System.out.println("\n=== Content Comparison ===");
        System.out.println("s1.equals(s4): " + s1.equals(s4));  // true (same content)
    }
}

// Example 3: String intern() method
class StringInternDemo {
    public static void main(String[] args) {
        String s1 = new String("Hello");  // Heap
        String s2 = "Hello";  // Pool
        String s3 = s1.intern();  // Returns pool reference
        
        System.out.println("=== Before intern() ===");
        System.out.println("s1 == s2: " + (s1 == s2));  // false
        
        System.out.println("\n=== After intern() ===");
        System.out.println("s3 == s2: " + (s3 == s2));  // true (both from pool)
        System.out.println("s1 == s3: " + (s1 == s3));  // false (heap vs pool)
        
        // Practical use of intern()
        String[] words = new String[1000];
        for (int i = 0; i < 1000; i++) {
            words[i] = new String("duplicate").intern();  // Saves memory
        }
        System.out.println("\nAll 1000 strings point to same object in pool!");
    }
}

// Example 4: String methods create new objects
class StringMethodsDemo {
    public static void main(String[] args) {
        String original = "Hello World";
        
        System.out.println("=== Original String ===");
        System.out.println("Original: " + original);
        
        // All these create NEW strings
        String upper = original.toUpperCase();
        String lower = original.toLowerCase();
        String replaced = original.replace('o', 'a');
        String substring = original.substring(0, 5);
        String trimmed = "  Hello  ".trim();
        
        System.out.println("\n=== New Strings Created ===");
        System.out.println("toUpperCase(): " + upper);
        System.out.println("toLowerCase(): " + lower);
        System.out.println("replace(): " + replaced);
        System.out.println("substring(): " + substring);
        System.out.println("trim(): " + trimmed);
        
        System.out.println("\n=== Original Unchanged ===");
        System.out.println("Original: " + original);  // Still "Hello World"
    }
}

// Example 5: Performance impact of immutability
class StringConcatenationPerformance {
    public static void main(String[] args) {
        int iterations = 5000;
        
        // Bad: String concatenation in loop
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result = result + i;  // Creates new object each time!
        }
        long stringTime = System.currentTimeMillis() - start;
        
        System.out.println("=== Performance Test (" + iterations + " iterations) ===");
        System.out.println("String concatenation: " + stringTime + "ms");
        System.out.println("Objects created: ~" + iterations);
        
        // Note: We'll compare with StringBuilder in next file
    }
}

// Example 6: Common String methods
class StringMethodsExample {
    public static void main(String[] args) {
        String text = "Java Programming";
        
        System.out.println("=== substring() ===");
        System.out.println("Original: " + text);
        System.out.println("substring(0, 4): " + text.substring(0, 4));  // "Java"
        System.out.println("substring(5): " + text.substring(5));  // "Programming"
        
        System.out.println("\n=== replace() ===");
        System.out.println("replace('a', 'o'): " + text.replace('a', 'o'));
        System.out.println("replace('Java', 'Python'): " + text.replace("Java", "Python"));
        
        System.out.println("\n=== toUpperCase/toLowerCase ===");
        System.out.println("toUpperCase(): " + text.toUpperCase());
        System.out.println("toLowerCase(): " + text.toLowerCase());
        
        System.out.println("\n=== trim() ===");
        String padded = "   Hello   ";
        System.out.println("Before trim: '" + padded + "'");
        System.out.println("After trim: '" + padded.trim() + "'");
        
        System.out.println("\n=== split() ===");
        String sentence = "Java is awesome";
        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println("- " + word);
        }
    }
}

// Example 7: String concatenation creates multiple objects
class StringConcatenationObjects {
    public static void main(String[] args) {
        System.out.println("=== Concatenation Creates New Objects ===");
        
        String s1 = "Hello";
        System.out.println("s1 = \"Hello\"");
        
        String s2 = s1 + " World";
        System.out.println("s2 = s1 + \" World\"  // Creates new object");
        
        String s3 = s2 + "!";
        System.out.println("s3 = s2 + \"!\"  // Creates another new object");
        
        System.out.println("\nFinal values:");
        System.out.println("s1: " + s1);  // "Hello"
        System.out.println("s2: " + s2);  // "Hello World"
        System.out.println("s3: " + s3);  // "Hello World!"
        
        System.out.println("\nTotal objects created: 3");
        System.out.println("- \"Hello\"");
        System.out.println("- \"Hello World\"");
        System.out.println("- \"Hello World!\"");
    }
}

// Example 8: Why immutability is good - Thread safety
class StringThreadSafety {
    private static String sharedString = "Initial Value";
    
    public static void main(String[] args) {
        System.out.println("=== String Thread Safety Demo ===");
        System.out.println("Initial: " + sharedString);
        
        // Thread 1
        Thread t1 = new Thread(() -> {
            sharedString = sharedString + " - Thread1";
            System.out.println("Thread 1: " + sharedString);
        });
        
        // Thread 2
        Thread t2 = new Thread(() -> {
            sharedString = sharedString + " - Thread2";
            System.out.println("Thread 2: " + sharedString);
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final: " + sharedString);
        System.out.println("\nNote: Each thread creates its own new String object");
        System.out.println("Original strings are never modified (immutable)");
    }
}

// Example 9: String comparison edge cases
class StringComparisonEdgeCases {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = "Hel" + "lo";  // Compile-time concatenation
        String s5 = "Hel";
        String s6 = s5 + "lo";  // Runtime concatenation
        
        System.out.println("=== Compile-time vs Runtime ===");
        System.out.println("s1 == s2: " + (s1 == s2));  // true (both literals)
        System.out.println("s1 == s3: " + (s1 == s3));  // false (literal vs new)
        System.out.println("s1 == s4: " + (s1 == s4));  // true (compile-time concat)
        System.out.println("s1 == s6: " + (s1 == s6));  // false (runtime concat)
        
        System.out.println("\n=== Content Comparison (Always use equals!) ===");
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true
        System.out.println("s1.equals(s6): " + s1.equals(s6));  // true
    }
}

// Example 10: Memory visualization
class StringMemoryVisualization {
    public static void main(String[] args) {
        System.out.println("=== String Memory Allocation ===\n");
        
        String s1 = "Java";
        System.out.println("String s1 = \"Java\";  // Created in String Pool");
        
        String s2 = "Java";
        System.out.println("String s2 = \"Java\";  // Reuses from Pool (same object as s1)");
        
        String s3 = new String("Java");
        System.out.println("String s3 = new String(\"Java\");  // New object in Heap");
        
        System.out.println("\n=== Memory Layout ===");
        System.out.println("String Pool: [\"Java\"] <-- s1, s2");
        System.out.println("Heap: [\"Java\"] <-- s3");
        
        System.out.println("\n=== Reference Comparison ===");
        System.out.println("s1 == s2: " + (s1 == s2) + " (same pool reference)");
        System.out.println("s1 == s3: " + (s1 == s3) + " (pool vs heap)");
        
        System.out.println("\n=== Memory Saved ===");
        System.out.println("Without String Pool: 3 objects");
        System.out.println("With String Pool: 2 objects (33% savings!)");
    }
}
