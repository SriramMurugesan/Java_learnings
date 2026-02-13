// ==================== REGULAR EXPRESSIONS EXAMPLES ====================

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExamples {
    
    // Example 1: Basic Pattern Matching
    static void basicPatternMatching() {
        System.out.println("========== Example 1: Basic Pattern Matching ==========");
        
        String text = "I love Java programming";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(text);
        
        if (matcher.find()) {
            System.out.println("Pattern 'Java' found in text!");
        } else {
            System.out.println("Pattern not found!");
        }
    }
    
    // Example 2: Email Validation
    static void emailValidation() {
        System.out.println("\n========== Example 2: Email Validation ==========");
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        String[] emails = {
            "user@example.com",
            "john.doe@company.co.in",
            "invalid.email",
            "test@domain",
            "user123@test.com"
        };
        
        for (String email : emails) {
            boolean isValid = email.matches(emailRegex);
            System.out.println(email + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // Example 3: Phone Number Validation
    static void phoneValidation() {
        System.out.println("\n========== Example 3: Phone Number Validation ==========");
        
        // Pattern: (123) 456-7890 or 123-456-7890 or 1234567890
        String phoneRegex = "^(\\(\\d{3}\\)|\\d{3})[- ]?\\d{3}[- ]?\\d{4}$";
        
        String[] phones = {
            "(123) 456-7890",
            "123-456-7890",
            "1234567890",
            "12345",
            "123-45-6789"
        };
        
        for (String phone : phones) {
            boolean isValid = phone.matches(phoneRegex);
            System.out.println(phone + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // Example 4: Password Validation
    static void passwordValidation() {
        System.out.println("\n========== Example 4: Password Validation ==========");
        
        // At least 8 characters, 1 uppercase, 1 lowercase, 1 digit
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        
        String[] passwords = {
            "Password123",
            "weak",
            "NoDigits",
            "nouppercas3",
            "NOLOWERCASE1",
            "ValidPass1"
        };
        
        for (String password : passwords) {
            boolean isValid = password.matches(passwordRegex);
            System.out.println(password + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // Example 5: Extract All Numbers
    static void extractNumbers() {
        System.out.println("\n========== Example 5: Extract All Numbers ==========");
        
        String text = "I have 3 apples, 5 bananas, and 10 oranges. Total: 18 fruits.";
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Numbers found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    // Example 6: Extract All Words
    static void extractWords() {
        System.out.println("\n========== Example 6: Extract All Words ==========");
        
        String text = "Java is awesome! I love Java programming.";
        
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Words found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    // Example 7: Replace All Digits
    static void replaceDigits() {
        System.out.println("\n========== Example 7: Replace All Digits ==========");
        
        String text = "My phone is 123-456-7890 and my ID is 98765";
        System.out.println("Original: " + text);
        
        String result = text.replaceAll("\\d", "X");
        System.out.println("After replacing digits: " + result);
    }
    
    // Example 8: Remove Special Characters
    static void removeSpecialCharacters() {
        System.out.println("\n========== Example 8: Remove Special Characters ==========");
        
        String text = "Hello@World#123! How are you?";
        System.out.println("Original: " + text);
        
        // Keep only letters, digits, and spaces
        String cleaned = text.replaceAll("[^a-zA-Z0-9 ]", "");
        System.out.println("Cleaned: " + cleaned);
    }
    
    // Example 9: Split String by Pattern
    static void splitByPattern() {
        System.out.println("\n========== Example 9: Split String by Pattern ==========");
        
        String text = "apple,banana;orange:grape|mango";
        System.out.println("Original: " + text);
        
        // Split by comma, semicolon, colon, or pipe
        String[] fruits = text.split("[,;:|]");
        
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
    }
    
    // Example 10: Find and Replace First Occurrence
    static void replaceFirst() {
        System.out.println("\n========== Example 10: Replace First Occurrence ==========");
        
        String text = "Hello123World456";
        System.out.println("Original: " + text);
        
        String result = text.replaceFirst("\\d+", "X");
        System.out.println("After replacing first number: " + result);
    }
    
    // Example 11: Case-Insensitive Matching
    static void caseInsensitiveMatching() {
        System.out.println("\n========== Example 11: Case-Insensitive Matching ==========");
        
        String text = "I love JAVA and java programming";
        
        Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Found 'java' at index: " + matcher.start());
        }
        System.out.println("Total occurrences: " + count);
    }
    
    // Example 12: URL Validation
    static void urlValidation() {
        System.out.println("\n========== Example 12: URL Validation ==========");
        
        String urlRegex = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(/.*)?$";
        
        String[] urls = {
            "https://www.example.com",
            "http://example.com",
            "www.example.com",
            "example.com",
            "invalid url",
            "https://example.com/path/to/page"
        };
        
        for (String url : urls) {
            boolean isValid = url.matches(urlRegex);
            System.out.println(url + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // Example 13: Date Validation (DD/MM/YYYY)
    static void dateValidation() {
        System.out.println("\n========== Example 13: Date Validation (DD/MM/YYYY) ==========");
        
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        
        String[] dates = {
            "25/12/2023",
            "01/01/2024",
            "32/13/2023",  // Invalid but matches pattern
            "2023-12-25",
            "25-12-2023"
        };
        
        for (String date : dates) {
            boolean matches = date.matches(dateRegex);
            System.out.println(date + " matches pattern: " + matches);
        }
    }
    
    // Example 14: Username Validation
    static void usernameValidation() {
        System.out.println("\n========== Example 14: Username Validation ==========");
        
        // Alphanumeric, 3-16 characters
        String usernameRegex = "^[a-zA-Z0-9]{3,16}$";
        
        String[] usernames = {
            "john123",
            "ab",  // Too short
            "user_name",  // Contains underscore
            "validuser",
            "ThisIsATooLongUsername"
        };
        
        for (String username : usernames) {
            boolean isValid = username.matches(usernameRegex);
            System.out.println(username + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // Example 15: Extract Email Addresses from Text
    static void extractEmails() {
        System.out.println("\n========== Example 15: Extract Email Addresses ==========");
        
        String text = "Contact us at support@example.com or sales@company.co.in for more info.";
        
        String emailRegex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Emails found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    // Example 16: Count Vowels and Consonants
    static void countVowelsConsonants() {
        System.out.println("\n========== Example 16: Count Vowels and Consonants ==========");
        
        String text = "Hello World";
        
        int vowels = text.replaceAll("[^aeiouAEIOU]", "").length();
        int consonants = text.replaceAll("[^a-zA-Z]", "").length() - vowels;
        
        System.out.println("Text: " + text);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    // Example 17: Remove Extra Spaces
    static void removeExtraSpaces() {
        System.out.println("\n========== Example 17: Remove Extra Spaces ==========");
        
        String text = "Hello    World   Java    Programming";
        System.out.println("Original: '" + text + "'");
        
        String result = text.replaceAll("\\s+", " ").trim();
        System.out.println("Cleaned: '" + result + "'");
    }
    
    // Example 18: IP Address Validation
    static void ipValidation() {
        System.out.println("\n========== Example 18: IP Address Validation ==========");
        
        String ipRegex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
        
        String[] ips = {
            "192.168.1.1",
            "10.0.0.1",
            "256.256.256.256",  // Invalid but matches pattern
            "192.168.1",
            "192.168.1.1.1"
        };
        
        for (String ip : ips) {
            boolean matches = ip.matches(ipRegex);
            System.out.println(ip + " matches pattern: " + matches);
        }
    }
    
    // Example 19: Extract Hashtags
    static void extractHashtags() {
        System.out.println("\n========== Example 19: Extract Hashtags ==========");
        
        String text = "Learning #Java and #Programming is fun! #Code #Developer";
        
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Hashtags found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    
    // Example 20: Validate Hexadecimal Color Code
    static void hexColorValidation() {
        System.out.println("\n========== Example 20: Hexadecimal Color Code Validation ==========");
        
        String hexRegex = "^#[0-9A-Fa-f]{6}$";
        
        String[] colors = {
            "#FF5733",
            "#000000",
            "#FFFFFF",
            "#GGG123",  // Invalid
            "FF5733",   // Missing #
            "#FFF"      // Too short
        };
        
        for (String color : colors) {
            boolean isValid = color.matches(hexRegex);
            System.out.println(color + " is " + (isValid ? "VALID" : "INVALID"));
        }
    }
    
    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {
        basicPatternMatching();
        emailValidation();
        phoneValidation();
        passwordValidation();
        extractNumbers();
        extractWords();
        replaceDigits();
        removeSpecialCharacters();
        splitByPattern();
        replaceFirst();
        caseInsensitiveMatching();
        urlValidation();
        dateValidation();
        usernameValidation();
        extractEmails();
        countVowelsConsonants();
        removeExtraSpaces();
        ipValidation();
        extractHashtags();
        hexColorValidation();
    }
}
