// Day 3 Revision: Strings

public class day3 {
    public static void main(String[] args) {
        
        // 1. String Creation
        System.out.println("=== STRING CREATION ===");
        String str1 = "Hello";
        String str2 = new String("World");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        
        // 2. String Immutability
        System.out.println("\n=== STRING IMMUTABILITY ===");
        String original = "Java";
        String modified = original.concat(" Programming");
        System.out.println("Original: " + original);
        System.out.println("Modified: " + modified);
        
        // 3. String Methods
        System.out.println("\n=== STRING METHODS ===");
        String text = "Hello World";
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Substring: " + text.substring(0, 5));
        System.out.println("Contains 'World': " + text.contains("World"));
        System.out.println("Replace: " + text.replace("World", "Java"));
        
        // 4. String Comparison
        System.out.println("\n=== STRING COMPARISON ===");
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        
        // 5. StringBuilder (Mutable)
        System.out.println("\n=== STRINGBUILDER ===");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("After append: " + sb);
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // 6. String Operations
        System.out.println("\n=== STRING OPERATIONS ===");
        String sentence = "Java is easy";
        String[] words = sentence.split(" ");
        System.out.println("Split words:");
        for (String word : words) {
            System.out.println("  " + word);
        }
        
        System.out.println("Starts with 'Java': " + sentence.startsWith("Java"));
        System.out.println("Ends with 'easy': " + sentence.endsWith("easy"));
        System.out.println("Index of 'is': " + sentence.indexOf("is"));
    }
}
