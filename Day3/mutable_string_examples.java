// Example 1: StringBuilder basic operations
class StringBuilderBasics {
    public static void main(String[] args) {
        // Creating StringBuilder
        StringBuilder sb = new StringBuilder();
        
        System.out.println("=== Initial State ===");
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());  // Default: 16
        
        // Append operations
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        
        System.out.println("\n=== After Appending ===");
        System.out.println("Content: " + sb.toString());
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}

// Example 2: StringBuilder with initial capacity
class StringBuilderCapacity {
    public static void main(String[] args) {
        // Different ways to create StringBuilder
        StringBuilder sb1 = new StringBuilder();  // Capacity: 16
        StringBuilder sb2 = new StringBuilder(50);  // Capacity: 50
        StringBuilder sb3 = new StringBuilder("Hello");  // Capacity: 16 + 5 = 21
        
        System.out.println("=== StringBuilder Capacities ===");
        System.out.println("sb1 (default): " + sb1.capacity());
        System.out.println("sb2 (50): " + sb2.capacity());
        System.out.println("sb3 (\"Hello\"): " + sb3.capacity());
        
        // Demonstrating capacity growth
        StringBuilder sb = new StringBuilder(5);
        System.out.println("\n=== Capacity Growth ===");
        System.out.println("Initial capacity: " + sb.capacity());
        
        sb.append("Hello World!");  // Exceeds capacity
        System.out.println("After exceeding: " + sb.capacity());  // (5 * 2) + 2 = 12
    }
}

// Example 3: StringBuilder methods
class StringBuilderMethods {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello World");
        
        System.out.println("=== Original ===");
        System.out.println(sb);
        
        // insert()
        System.out.println("\n=== insert() ===");
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb);
        
        // delete()
        System.out.println("\n=== delete() ===");
        sb.delete(6, 16);  // Remove "Beautiful "
        System.out.println("After delete: " + sb);
        
        // deleteCharAt()
        System.out.println("\n=== deleteCharAt() ===");
        sb.deleteCharAt(5);  // Remove space
        System.out.println("After deleteCharAt: " + sb);
        
        // reverse()
        System.out.println("\n=== reverse() ===");
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // reverse back
        sb.reverse();
        
        // replace()
        System.out.println("\n=== replace() ===");
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
    }
}

// Example 4: StringBuilder method chaining
class StringBuilderChaining {
    public static void main(String[] args) {
        // Without chaining
        System.out.println("=== Without Chaining ===");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Java");
        sb1.append(" ");
        sb1.append("is");
        sb1.append(" ");
        sb1.append("awesome");
        System.out.println(sb1);
        
        // With chaining (cleaner!)
        System.out.println("\n=== With Chaining ===");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Java").append(" ").append("is").append(" ").append("awesome");
        System.out.println(sb2);
        
        // Complex chaining
        System.out.println("\n=== Complex Chaining ===");
        String result = new StringBuilder()
            .append("Name: ")
            .append("Alice")
            .append(", Age: ")
            .append(25)
            .append(", City: ")
            .append("New York")
            .toString();
        System.out.println(result);
    }
}

// Example 5: StringBuilder vs String performance
class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 10000;
        
        // String concatenation (slow)
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s = s + i;
        }
        long stringTime = System.currentTimeMillis() - start;
        
        // StringBuilder (fast)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(i);
        }
        String result = sb.toString();
        long sbTime = System.currentTimeMillis() - start;
        
        System.out.println("=== Performance Test (" + iterations + " iterations) ===");
        System.out.println("String concatenation: " + stringTime + "ms");
        System.out.println("StringBuilder: " + sbTime + "ms");
        System.out.println("StringBuilder is " + (stringTime / Math.max(sbTime, 1)) + "x faster!");
    }
}

// Example 6: StringBuffer basic operations
class StringBufferBasics {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer();
        
        System.out.println("=== StringBuffer Operations ===");
        sbf.append("Hello");
        sbf.append(" ");
        sbf.append("World");
        
        System.out.println("Content: " + sbf);
        System.out.println("Length: " + sbf.length());
        System.out.println("Capacity: " + sbf.capacity());
        
        // Same methods as StringBuilder
        sbf.insert(6, "Beautiful ");
        System.out.println("After insert: " + sbf);
        
        sbf.reverse();
        System.out.println("After reverse: " + sbf);
    }
}

// Example 7: StringBuilder vs StringBuffer performance
class BuilderVsBuffer {
    public static void main(String[] args) {
        int iterations = 50000;
        
        // StringBuilder (not synchronized)
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(i);
        }
        long sbTime = System.currentTimeMillis() - start;
        
        // StringBuffer (synchronized)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(i);
        }
        long sbfTime = System.currentTimeMillis() - start;
        
        System.out.println("=== StringBuilder vs StringBuffer (" + iterations + " iterations) ===");
        System.out.println("StringBuilder: " + sbTime + "ms");
        System.out.println("StringBuffer: " + sbfTime + "ms");
        System.out.println("StringBuilder is faster by: " + (sbfTime - sbTime) + "ms");
    }
}

// Example 8: Practical use case - Building HTML
class HTMLBuilder {
    public static void main(String[] args) {
        StringBuilder html = new StringBuilder();
        
        html.append("<html>\n")
            .append("  <head>\n")
            .append("    <title>My Page</title>\n")
            .append("  </head>\n")
            .append("  <body>\n")
            .append("    <h1>Welcome</h1>\n")
            .append("    <p>This is a paragraph.</p>\n")
            .append("  </body>\n")
            .append("</html>");
        
        System.out.println("=== Generated HTML ===");
        System.out.println(html.toString());
    }
}

// Example 9: Practical use case - CSV builder
class CSVBuilder {
    public static void main(String[] args) {
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
            {"Alice", "25", "New York"},
            {"Bob", "30", "London"},
            {"Charlie", "35", "Paris"}
        };
        
        StringBuilder csv = new StringBuilder();
        
        // Add headers
        for (int i = 0; i < headers.length; i++) {
            csv.append(headers[i]);
            if (i < headers.length - 1) {
                csv.append(",");
            }
        }
        csv.append("\n");
        
        // Add data rows
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                csv.append(row[i]);
                if (i < row.length - 1) {
                    csv.append(",");
                }
            }
            csv.append("\n");
        }
        
        System.out.println("=== Generated CSV ===");
        System.out.println(csv.toString());
    }
}

// Example 10: Thread-safety demonstration
class ThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {
        // StringBuilder (not thread-safe)
        StringBuilder sb = new StringBuilder();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("=== StringBuilder (Not Thread-Safe) ===");
        System.out.println("Expected length: 2000");
        System.out.println("Actual length: " + sb.length());
        System.out.println("Result may be unpredictable!");
        
        // StringBuffer (thread-safe)
        StringBuffer sbf = new StringBuffer();
        
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sbf.append("A");
            }
        });
        
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sbf.append("B");
            }
        });
        
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        
        System.out.println("\n=== StringBuffer (Thread-Safe) ===");
        System.out.println("Expected length: 2000");
        System.out.println("Actual length: " + sbf.length());
        System.out.println("Result is always correct!");
    }
}
