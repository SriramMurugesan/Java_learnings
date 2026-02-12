// Problem 1: Reverse a String
// Time Complexity: O(n), Space Complexity: O(n)

class ReverseString {
    // Approach 1: Using StringBuilder (Easiest)
    public static String reverseUsingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Approach 2: Using character array
    public static String reverseUsingCharArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    // Approach 3: Using recursion
    public static String reverseRecursive(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        String input = "Hello";
        
        System.out.println("=== Reverse a String ===");
        System.out.println("Input: " + input);
        System.out.println("Using StringBuilder: " + reverseUsingStringBuilder(input));
        System.out.println("Using Char Array: " + reverseUsingCharArray(input));
        System.out.println("Using Recursion: " + reverseRecursive(input));
    }
}

// Problem 2: Check if String is Palindrome
// Time Complexity: O(n), Space Complexity: O(1)

class PalindromeCheck {
    // Approach 1: Two-pointer technique (Most efficient)
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // Approach 2: Reverse and compare
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    public static void main(String[] args) {
        String[] testCases = {"madam", "racecar", "hello", "noon", "java"};
        
        System.out.println("=== Palindrome Check ===");
        for (String test : testCases) {
            System.out.println(test + " is palindrome: " + isPalindrome(test));
        }
    }
}

// Problem 3: Count Vowels and Consonants
// Time Complexity: O(n), Space Complexity: O(1)

class CountVowelsConsonants {
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        String[] testCases = {"Hello World", "Java Programming", "aeiou"};
        
        System.out.println("=== Count Vowels and Consonants ===");
        for (String test : testCases) {
            System.out.print(test + " -> ");
            countVowelsAndConsonants(test);
        }
    }
}

// Problem 4: Remove Duplicate Characters
// Time Complexity: O(n), Space Complexity: O(n)

class RemoveDuplicates {
    // Approach 1: Using StringBuilder with indexOf
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    // Approach 2: Using boolean array (for ASCII characters)
    public static String removeDuplicatesArray(String str) {
        boolean[] seen = new boolean[128];  // ASCII characters
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"programming", "hello", "aabbcc"};
        
        System.out.println("=== Remove Duplicates ===");
        for (String test : testCases) {
            System.out.println(test + " -> " + removeDuplicates(test));
        }
    }
}

// Problem 5: Check if Two Strings are Anagrams
// Time Complexity: O(n), Space Complexity: O(1)

class AnagramCheck {
    // Approach 1: Using character frequency array
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] count = new int[26];  // For lowercase a-z
        
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Approach 2: Using sorting
    public static boolean areAnagramsSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        return java.util.Arrays.equals(arr1, arr2);
    }
    
    public static void main(String[] args) {
        String[][] testCases = {
            {"listen", "silent"},
            {"hello", "world"},
            {"triangle", "integral"}
        };
        
        System.out.println("=== Anagram Check ===");
        for (String[] test : testCases) {
            System.out.println(test[0] + " & " + test[1] + " are anagrams: " + areAnagrams(test[0], test[1]));
        }
    }
}

// Problem 6: Find First Non-Repeating Character
// Time Complexity: O(n), Space Complexity: O(1)

class FirstNonRepeating {
    public static Character findFirstNonRepeating(String str) {
        int[] count = new int[128];  // ASCII characters
        
        // Count frequencies
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        
        // Find first character with count 1
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        
        return null;  // No non-repeating character
    }
    
    public static void main(String[] args) {
        String[] testCases = {"programming", "aabbcc", "hello", "java"};
        
        System.out.println("=== First Non-Repeating Character ===");
        for (String test : testCases) {
            Character result = findFirstNonRepeating(test);
            System.out.println(test + " -> " + (result != null ? result : "None"));
        }
    }
}

// Problem 7: Count Occurrences of Each Character
// Time Complexity: O(n), Space Complexity: O(1)

class CharacterCount {
    public static void countCharacters(String str) {
        int[] count = new int[128];  // ASCII characters
        
        // Count frequencies
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        
        // Print non-zero counts
        System.out.print(str + " -> ");
        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                System.out.print((char)i + ":" + count[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"hello", "programming", "aabbcc"};
        
        System.out.println("=== Character Count ===");
        for (String test : testCases) {
            countCharacters(test);
        }
    }
}

// Problem 8: String Compression
// Time Complexity: O(n), Space Complexity: O(n)

class StringCompression {
    public static String compress(String str) {
        if (str.isEmpty()) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        
        // Append last character and count
        result.append(str.charAt(str.length() - 1)).append(count);
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String[] testCases = {"aaabbc", "aabbccdd", "abc", "aaaa"};
        
        System.out.println("=== String Compression ===");
        for (String test : testCases) {
            System.out.println(test + " -> " + compress(test));
        }
    }
}

// Problem 9: Check if Strings are Rotations
// Time Complexity: O(n), Space Complexity: O(n)

class StringRotation {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Check if s2 is substring of s1 + s1
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }
    
    public static void main(String[] args) {
        String[][] testCases = {
            {"waterbottle", "erbottlewat"},
            {"hello", "lohel"},
            {"hello", "world"}
        };
        
        System.out.println("=== String Rotation Check ===");
        for (String[] test : testCases) {
            System.out.println(test[0] + " & " + test[1] + " are rotations: " + areRotations(test[0], test[1]));
        }
    }
}

// Problem 10: Longest Substring Without Repeating Characters
// Time Complexity: O(n), Space Complexity: O(min(n, m))

class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String str) {
        int[] lastIndex = new int[128];  // ASCII characters
        java.util.Arrays.fill(lastIndex, -1);
        
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            
            // If character was seen after start, move start
            if (lastIndex[ch] >= start) {
                start = lastIndex[ch] + 1;
            }
            
            lastIndex[ch] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "abcdef"};
        
        System.out.println("=== Longest Substring Without Repeating Characters ===");
        for (String test : testCases) {
            System.out.println(test + " -> " + lengthOfLongestSubstring(test));
        }
    }
}
