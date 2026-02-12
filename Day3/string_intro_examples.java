// Example 1: Creating strings - Literal vs new keyword
class StringCreationExample {
    public static void main(String[] args) {
        // Using string literal (recommended)
        String s1 = "Hello";
        String s2 = "Hello";
        
        // Using new keyword
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        
        System.out.println("=== String Creation ===");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println("s4: " + s4);
        
        // Memory comparison
        System.out.println("\n=== Memory Comparison ===");
        System.out.println("s1 == s2: " + (s1 == s2));  // true (same pool reference)
        System.out.println("s3 == s4: " + (s3 == s4));  // false (different heap objects)
        System.out.println("s1 == s3: " + (s1 == s3));  // false (pool vs heap)
    }
}

// Example 2: String comparison - == vs equals()
class StringComparisonExample {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        
        System.out.println("=== Using == (compares references) ===");
        System.out.println("s1 == s2: " + (s1 == s2));  // true
        System.out.println("s1 == s3: " + (s1 == s3));  // false
        
        System.out.println("\n=== Using equals() (compares content) ===");
        System.out.println("s1.equals(s2): " + s1.equals(s2));  // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true
        
        System.out.println("\n=== Case-insensitive comparison ===");
        String s4 = "JAVA";
        System.out.println("s1.equals(s4): " + s1.equals(s4));  // false
        System.out.println("s1.equalsIgnoreCase(s4): " + s1.equalsIgnoreCase(s4));  // true
    }
}

// Example 3: Basic string methods
class BasicStringMethods {
    public static void main(String[] args) {
        String text = "Hello World";
        
        System.out.println("=== Basic Methods ===");
        System.out.println("Original: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Character at index 0: " + text.charAt(0));
        System.out.println("Character at index 6: " + text.charAt(6));
        
        System.out.println("\n=== Case Conversion ===");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        
        System.out.println("\n=== Substring ===");
        System.out.println("Substring(0, 5): " + text.substring(0, 5));
        System.out.println("Substring(6): " + text.substring(6));
        
        System.out.println("\n=== Contains/Search ===");
        System.out.println("Contains 'World': " + text.contains("World"));
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        System.out.println("Ends with 'World': " + text.endsWith("World"));
        System.out.println("Index of 'o': " + text.indexOf('o'));
        System.out.println("Last index of 'o': " + text.lastIndexOf('o'));
    }
}

// Example 4: String concatenation
class StringConcatenation {
    public static void main(String[] args) {
        String first = "Hello";
        String second = "World";
        
        System.out.println("=== Concatenation Methods ===");
        
        // Method 1: Using + operator
        String result1 = first + " " + second;
        System.out.println("Using +: " + result1);
        
        // Method 2: Using concat()
        String result2 = first.concat(" ").concat(second);
        System.out.println("Using concat(): " + result2);
        
        // Method 3: Using String.join()
        String result3 = String.join(" ", first, second);
        System.out.println("Using join(): " + result3);
        
        // Concatenating with numbers
        int age = 25;
        String message = "Age is: " + age;
        System.out.println("\nWith number: " + message);
    }
}

// Example 5: String replace and trim
class StringReplaceAndTrim {
    public static void main(String[] args) {
        String text = "  Java Programming  ";
        
        System.out.println("=== Trim ===");
        System.out.println("Original: '" + text + "'");
        System.out.println("Trimmed: '" + text.trim() + "'");
        
        System.out.println("\n=== Replace ===");
        String code = "Java is awesome";
        System.out.println("Original: " + code);
        System.out.println("Replace 'Java' with 'Python': " + code.replace("Java", "Python"));
        System.out.println("Replace 'a' with 'o': " + code.replace('a', 'o'));
        
        System.out.println("\n=== Replace First/All ===");
        String sentence = "cat cat cat";
        System.out.println("Original: " + sentence);
        System.out.println("Replace first 'cat': " + sentence.replaceFirst("cat", "dog"));
        System.out.println("Replace all 'cat': " + sentence.replaceAll("cat", "dog"));
    }
}

// Example 6: String split
class StringSplitExample {
    public static void main(String[] args) {
        String csv = "apple,banana,cherry,date";
        
        System.out.println("=== Split by comma ===");
        String[] fruits = csv.split(",");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(i + ": " + fruits[i]);
        }
        
        System.out.println("\n=== Split sentence by space ===");
        String sentence = "Java is a programming language";
        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        
        System.out.println("\n=== Split with limit ===");
        String text = "one:two:three:four";
        String[] parts = text.split(":", 2);  // Split into max 2 parts
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

// Example 7: String isEmpty and isBlank
class StringEmptyCheck {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "   ";
        String s3 = "Hello";
        String s4 = null;
        
        System.out.println("=== isEmpty() ===");
        System.out.println("Empty string isEmpty: " + s1.isEmpty());  // true
        System.out.println("Spaces isEmpty: " + s2.isEmpty());  // false
        System.out.println("'Hello' isEmpty: " + s3.isEmpty());  // false
        
        System.out.println("\n=== isBlank() (Java 11+) ===");
        System.out.println("Empty string isBlank: " + s1.isBlank());  // true
        System.out.println("Spaces isBlank: " + s2.isBlank());  // true
        System.out.println("'Hello' isBlank: " + s3.isBlank());  // false
        
        System.out.println("\n=== Null check ===");
        // System.out.println(s4.isEmpty());  // NullPointerException!
        if (s4 == null || s4.isEmpty()) {
            System.out.println("s4 is null or empty");
        }
    }
}

// Example 8: String formatting
class StringFormatExample {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 25;
        double salary = 50000.50;
        
        System.out.println("=== String.format() ===");
        String formatted = String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary);
        System.out.println(formatted);
        
        System.out.println("\n=== printf() ===");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Age: %d%n", age);
        System.out.printf("Salary: $%.2f%n", salary);
        
        System.out.println("\n=== Formatting numbers ===");
        System.out.printf("Integer: %d%n", 42);
        System.out.printf("Float: %.3f%n", 3.14159);
        System.out.printf("Padded: %05d%n", 42);  // 00042
    }
}
