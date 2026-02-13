# Regular Expressions in Java

## 📚 What are Regular Expressions?

**Regular Expressions (Regex)** are **patterns** used to **search, match, and manipulate** text. They provide a powerful way to work with strings.

Think of regex as a **search filter** 🔍 - you define a pattern, and it finds all matching text!

### Real-World Analogy:
- **Phone Directory Search** 📞: Search for all numbers starting with "555"
- **Email Filter** 📧: Find all emails ending with "@gmail.com"
- **Password Validator** 🔒: Check if password has uppercase, lowercase, and numbers

---

## 🎯 Why Use Regular Expressions?

1. **Pattern Matching** - Find specific patterns in text
2. **Validation** - Validate emails, phone numbers, passwords
3. **Search and Replace** - Find and replace text patterns
4. **Data Extraction** - Extract specific information from text
5. **Text Processing** - Parse and process complex text data

---

## 🔑 Java Regex Classes

Java provides two main classes for regex:

### 1️⃣ `Pattern` Class
- Compiles regex pattern
- Used to create `Matcher` objects

### 2️⃣ `Matcher` Class
- Performs matching operations
- Provides methods to find, match, and replace

---

## 📝 Basic Syntax

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Create pattern
Pattern pattern = Pattern.compile("regex_pattern");

// Create matcher
Matcher matcher = pattern.matcher("text_to_search");

// Check if pattern matches
boolean found = matcher.find();
```

---

## 🎨 Simple Example

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RegexExample {
    public static void main(String[] args) {
        // Pattern to find "Java"
        Pattern pattern = Pattern.compile("Java");
        
        // Text to search
        Matcher matcher = pattern.matcher("I love Java programming");
        
        // Find pattern
        if (matcher.find()) {
            System.out.println("Pattern found!");
        } else {
            System.out.println("Pattern not found!");
        }
    }
}
```

---

## 🔤 Common Regex Patterns

### Character Classes

| Pattern | Description | Example |
|---------|-------------|---------|
| `.` | Any single character | `a.c` matches "abc", "a1c", "a@c" |
| `\d` | Any digit (0-9) | `\d\d` matches "12", "99" |
| `\D` | Any non-digit | `\D` matches "a", "@", " " |
| `\w` | Word character (a-z, A-Z, 0-9, _) | `\w+` matches "hello", "test123" |
| `\W` | Non-word character | `\W` matches "@", " ", "!" |
| `\s` | Whitespace (space, tab, newline) | `\s` matches " ", "\t", "\n" |
| `\S` | Non-whitespace | `\S` matches "a", "1", "@" |
| `[abc]` | Any character in brackets | `[abc]` matches "a", "b", or "c" |
| `[^abc]` | Any character NOT in brackets | `[^abc]` matches "d", "1", "@" |
| `[a-z]` | Any lowercase letter | `[a-z]` matches "a" to "z" |
| `[A-Z]` | Any uppercase letter | `[A-Z]` matches "A" to "Z" |
| `[0-9]` | Any digit | `[0-9]` matches "0" to "9" |

---

### Quantifiers

| Pattern | Description | Example |
|---------|-------------|---------|
| `*` | 0 or more times | `a*` matches "", "a", "aa", "aaa" |
| `+` | 1 or more times | `a+` matches "a", "aa", "aaa" |
| `?` | 0 or 1 time | `a?` matches "", "a" |
| `{n}` | Exactly n times | `a{3}` matches "aaa" |
| `{n,}` | n or more times | `a{2,}` matches "aa", "aaa", "aaaa" |
| `{n,m}` | Between n and m times | `a{2,4}` matches "aa", "aaa", "aaaa" |

---

### Anchors

| Pattern | Description | Example |
|---------|-------------|---------|
| `^` | Start of line | `^Hello` matches "Hello world" |
| `$` | End of line | `world$` matches "Hello world" |
| `\b` | Word boundary | `\bcat\b` matches "cat" but not "catch" |
| `\B` | Non-word boundary | `\Bcat` matches "catch" but not "cat" |

---

### Special Characters

| Pattern | Description |
|---------|-------------|
| `\` | Escape special character |
| `\|` | OR operator |
| `()` | Grouping |
| `[]` | Character class |

---

## 🛠️ Common Regex Methods

### 1️⃣ `matches()` - Check if entire string matches pattern

```java
String text = "12345";
boolean result = text.matches("\\d+");  // true (all digits)

String text2 = "abc123";
boolean result2 = text2.matches("\\d+");  // false (contains letters)
```

---

### 2️⃣ `find()` - Find pattern anywhere in string

```java
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher("abc123def456");

while (matcher.find()) {
    System.out.println("Found: " + matcher.group());
}
// Output:
// Found: 123
// Found: 456
```

---

### 3️⃣ `replaceAll()` - Replace all occurrences

```java
String text = "Hello123World456";
String result = text.replaceAll("\\d+", "X");
System.out.println(result);  // HelloXWorldX
```

---

### 4️⃣ `split()` - Split string by pattern

```java
String text = "apple,banana,orange";
String[] fruits = text.split(",");
// fruits = ["apple", "banana", "orange"]

String text2 = "one1two2three3";
String[] parts = text2.split("\\d");
// parts = ["one", "two", "three", ""]
```

---

## 🎨 Practical Examples

### Example 1: Email Validation

```java
import java.util.regex.Pattern;

class EmailValidator {
    public static void main(String[] args) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        String email1 = "user@example.com";
        String email2 = "invalid.email";
        
        System.out.println(email1 + " is valid: " + email1.matches(emailRegex));  // true
        System.out.println(email2 + " is valid: " + email2.matches(emailRegex));  // false
    }
}
```

---

### Example 2: Phone Number Validation

```java
class PhoneValidator {
    public static void main(String[] args) {
        // Pattern: (123) 456-7890 or 123-456-7890
        String phoneRegex = "^(\\(\\d{3}\\)|\\d{3})[- ]?\\d{3}[- ]?\\d{4}$";
        
        String phone1 = "(123) 456-7890";
        String phone2 = "123-456-7890";
        String phone3 = "12345";
        
        System.out.println(phone1 + " is valid: " + phone1.matches(phoneRegex));  // true
        System.out.println(phone2 + " is valid: " + phone2.matches(phoneRegex));  // true
        System.out.println(phone3 + " is valid: " + phone3.matches(phoneRegex));  // false
    }
}
```

---

### Example 3: Password Validation

```java
class PasswordValidator {
    public static void main(String[] args) {
        // At least 8 characters, 1 uppercase, 1 lowercase, 1 digit
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        
        String pwd1 = "Password123";
        String pwd2 = "weak";
        
        System.out.println(pwd1 + " is valid: " + pwd1.matches(passwordRegex));  // true
        System.out.println(pwd2 + " is valid: " + pwd2.matches(passwordRegex));  // false
    }
}
```

---

### Example 4: Extract All Numbers

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class ExtractNumbers {
    public static void main(String[] args) {
        String text = "I have 3 apples, 5 bananas, and 10 oranges";
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Numbers found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        // Output:
        // 3
        // 5
        // 10
    }
}
```

---

### Example 5: Remove Special Characters

```java
class RemoveSpecialChars {
    public static void main(String[] args) {
        String text = "Hello@World#123!";
        
        // Keep only letters and digits
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "");
        
        System.out.println("Original: " + text);      // Hello@World#123!
        System.out.println("Cleaned: " + cleaned);    // HelloWorld123
    }
}
```

---

### Example 6: Find All Words

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class FindWords {
    public static void main(String[] args) {
        String text = "Java is awesome! I love Java programming.";
        
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Words found:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        // Output: Java, is, awesome, I, love, Java, programming
    }
}
```

---

## 📊 String Methods with Regex

### 1️⃣ `matches(String regex)`
```java
String text = "12345";
boolean result = text.matches("\\d+");  // true
```

### 2️⃣ `replaceAll(String regex, String replacement)`
```java
String text = "Hello123World456";
String result = text.replaceAll("\\d+", "X");  // HelloXWorldX
```

### 3️⃣ `replaceFirst(String regex, String replacement)`
```java
String text = "Hello123World456";
String result = text.replaceFirst("\\d+", "X");  // HelloXWorld456
```

### 4️⃣ `split(String regex)`
```java
String text = "apple,banana,orange";
String[] parts = text.split(",");  // ["apple", "banana", "orange"]
```

---

## 🎯 Common Regex Patterns

### Email Pattern
```java
String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
```

### Phone Number (US)
```java
String phoneRegex = "^\\d{3}-\\d{3}-\\d{4}$";  // 123-456-7890
```

### URL Pattern
```java
String urlRegex = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(/.*)?$";
```

### Date (DD/MM/YYYY)
```java
String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";  // 25/12/2023
```

### Username (alphanumeric, 3-16 characters)
```java
String usernameRegex = "^[a-zA-Z0-9]{3,16}$";
```

### IP Address
```java
String ipRegex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
```

---

## ⚠️ Important Notes

### 1️⃣ Escape Backslashes in Java

In Java strings, backslash `\` must be escaped as `\\`.

```java
// Regex: \d (digit)
// Java: "\\d"

// Regex: \w+ (one or more word characters)
// Java: "\\w+"
```

---

### 2️⃣ Case Sensitivity

By default, regex is case-sensitive. Use flags for case-insensitive matching:

```java
Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher("I love JAVA");
System.out.println(matcher.find());  // true
```

---

### 3️⃣ Greedy vs Lazy Quantifiers

```java
// Greedy (default): matches as much as possible
String text = "<div>Hello</div><div>World</div>";
String result = text.replaceAll("<.*>", "X");
// Result: X (matches entire string!)

// Lazy: matches as little as possible
String result2 = text.replaceAll("<.*?>", "X");
// Result: XXHelloXXWorldX (matches each tag separately)
```

---

## 💡 Best Practices

### ✅ DO:
```java
// 1. Use raw strings or escape properly
String regex = "\\d+";  // Correct

// 2. Compile pattern once for reuse
Pattern pattern = Pattern.compile("\\d+");
Matcher m1 = pattern.matcher(text1);
Matcher m2 = pattern.matcher(text2);

// 3. Use meaningful variable names
String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

// 4. Test regex patterns thoroughly
```

### ❌ DON'T:
```java
// 1. Don't forget to escape backslashes
String regex = "\d+";  // ❌ Wrong! Use "\\d+"

// 2. Don't compile pattern repeatedly in loops
for (String text : texts) {
    Pattern.compile("\\d+").matcher(text);  // ❌ Inefficient!
}

// 3. Don't make regex too complex
String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
// Better: Break into smaller validations
```

---

## 🎯 Summary

1. **Regular Expressions** = Patterns for text matching and manipulation
2. **Pattern Class** = Compiles regex patterns
3. **Matcher Class** = Performs matching operations
4. **Common Patterns:**
   - `\\d` = digit
   - `\\w` = word character
   - `\\s` = whitespace
   - `.` = any character
5. **Quantifiers:** `*`, `+`, `?`, `{n}`, `{n,m}`
6. **Anchors:** `^` (start), `$` (end), `\\b` (word boundary)
7. **Methods:** `matches()`, `find()`, `replaceAll()`, `split()`
8. **Use Cases:** Email validation, phone validation, data extraction

---

**Remember:** Regex is powerful but can be complex - start simple and build up! 🔍
