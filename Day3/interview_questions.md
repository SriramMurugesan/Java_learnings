# String-Based Interview Questions

## 📚 Common String Interview Problems

This document covers the most frequently asked string-related programming questions in technical interviews.

---

## 1️⃣ Reverse a String

### Problem:
Write a program to reverse a given string.

### Examples:
- Input: `"Hello"` → Output: `"olleH"`
- Input: `"Java"` → Output: `"avaJ"`

### Approaches:
1. Using StringBuilder's `reverse()` method
2. Using character array
3. Using recursion
4. Two-pointer technique

### Time Complexity: O(n)
### Space Complexity: O(n)

---

## 2️⃣ Check if String is Palindrome

### Problem:
Check if a given string reads the same forwards and backwards.

### Examples:
- Input: `"madam"` → Output: `true`
- Input: `"racecar"` → Output: `true`
- Input: `"hello"` → Output: `false`

### Approaches:
1. Reverse and compare
2. Two-pointer technique
3. Recursive approach

### Time Complexity: O(n)
### Space Complexity: O(1) for two-pointer, O(n) for reverse

---

## 3️⃣ Count Vowels and Consonants

### Problem:
Count the number of vowels and consonants in a string.

### Examples:
- Input: `"Hello World"` → Vowels: 3, Consonants: 7
- Input: `"Java Programming"` → Vowels: 5, Consonants: 11

### Approach:
- Iterate through each character
- Check if it's a vowel (a, e, i, o, u)
- Count accordingly

### Time Complexity: O(n)
### Space Complexity: O(1)

---

## 4️⃣ Remove Duplicate Characters

### Problem:
Remove all duplicate characters from a string, keeping only the first occurrence.

### Examples:
- Input: `"programming"` → Output: `"progamin"`
- Input: `"hello"` → Output: `"helo"`

### Approaches:
1. Using HashSet
2. Using boolean array (for ASCII)
3. Using StringBuilder with indexOf

### Time Complexity: O(n)
### Space Complexity: O(n)

---

## 5️⃣ Check if Two Strings are Anagrams

### Problem:
Check if two strings contain the same characters with the same frequencies.

### Examples:
- Input: `"listen"`, `"silent"` → Output: `true`
- Input: `"hello"`, `"world"` → Output: `false`

### Approaches:
1. Sort both strings and compare
2. Use character frequency array
3. Use HashMap for counting

### Time Complexity: O(n log n) for sorting, O(n) for counting
### Space Complexity: O(1) for array, O(n) for HashMap

---

## 6️⃣ Find First Non-Repeating Character

### Problem:
Find the first character that appears only once in a string.

### Examples:
- Input: `"programming"` → Output: `'p'`
- Input: `"aabbcc"` → Output: `null` (no non-repeating char)

### Approach:
- Use HashMap or array to count frequencies
- Find first character with frequency 1

### Time Complexity: O(n)
### Space Complexity: O(1) for limited character set

---

## 7️⃣ Count Occurrences of Each Character

### Problem:
Count how many times each character appears in a string.

### Examples:
- Input: `"hello"` → Output: `h:1, e:1, l:2, o:1`
- Input: `"programming"` → Output: `p:1, r:2, o:1, g:2, a:1, m:2, i:1, n:1`

### Approach:
- Use HashMap or array to store frequencies
- Iterate and count each character

### Time Complexity: O(n)
### Space Complexity: O(1) for limited character set

---

## 8️⃣ String Compression

### Problem:
Compress a string by replacing consecutive repeated characters with the character followed by count.

### Examples:
- Input: `"aaabbc"` → Output: `"a3b2c1"`
- Input: `"aabbccdd"` → Output: `"a2b2c2d2"`
- Input: `"abc"` → Output: `"a1b1c1"`

### Approach:
- Iterate through string
- Count consecutive characters
- Append character and count to result

### Time Complexity: O(n)
### Space Complexity: O(n)

---

## 9️⃣ Check if Strings are Rotations

### Problem:
Check if one string is a rotation of another.

### Examples:
- Input: `"waterbottle"`, `"erbottlewat"` → Output: `true`
- Input: `"hello"`, `"lohel"` → Output: `true`
- Input: `"hello"`, `"world"` → Output: `false`

### Approach:
- Check if s2 is a substring of s1 + s1
- Example: `"hello" + "hello"` = `"hellohello"` contains `"lohel"`

### Time Complexity: O(n)
### Space Complexity: O(n)

---

## 🔟 Longest Substring Without Repeating Characters

### Problem:
Find the length of the longest substring without repeating characters.

### Examples:
- Input: `"abcabcbb"` → Output: `3` (substring: `"abc"`)
- Input: `"bbbbb"` → Output: `1` (substring: `"b"`)
- Input: `"pwwkew"` → Output: `3` (substring: `"wke"`)

### Approach:
- Use sliding window technique
- Use HashSet to track characters in current window
- Expand window when no duplicates, shrink when duplicate found

### Time Complexity: O(n)
### Space Complexity: O(min(n, m)) where m is character set size

---

## 🎯 Additional Important Problems

### 11. Reverse Words in a String
- Input: `"Hello World"` → Output: `"World Hello"`

### 12. Check if String Contains Only Digits
- Input: `"12345"` → Output: `true`
- Input: `"123a45"` → Output: `false`

### 13. Remove All Whitespaces
- Input: `"Hello World"` → Output: `"HelloWorld"`

### 14. Convert String to Title Case
- Input: `"hello world"` → Output: `"Hello World"`

### 15. Find All Permutations of a String
- Input: `"abc"` → Output: `["abc", "acb", "bac", "bca", "cab", "cba"]`

---

## 💡 Tips for String Interview Questions

### 1. **Clarify Requirements**
- Case sensitivity?
- Special characters allowed?
- Empty string handling?
- Unicode or ASCII only?

### 2. **Common Techniques**
- **Two Pointers**: For palindrome, reverse
- **Sliding Window**: For substring problems
- **HashMap/HashSet**: For frequency counting, duplicates
- **StringBuilder**: For building strings efficiently
- **Character Array**: For in-place modifications

### 3. **Edge Cases to Consider**
- Empty string: `""`
- Single character: `"a"`
- All same characters: `"aaaa"`
- Special characters: `"!@#$"`
- Whitespaces: `"   "`
- Null input

### 4. **Optimization Tips**
- Use StringBuilder for concatenation
- Pre-allocate capacity if size is known
- Use character arrays for in-place operations
- Consider ASCII vs Unicode (128 vs 65536 characters)

---

## 📊 Complexity Quick Reference

| Problem | Time | Space |
|---------|------|-------|
| Reverse String | O(n) | O(n) |
| Palindrome Check | O(n) | O(1) |
| Count Vowels | O(n) | O(1) |
| Remove Duplicates | O(n) | O(n) |
| Anagram Check | O(n) | O(1) |
| First Non-Repeating | O(n) | O(1) |
| Character Count | O(n) | O(1) |
| String Compression | O(n) | O(n) |
| String Rotation | O(n) | O(n) |
| Longest Unique Substring | O(n) | O(min(n,m)) |

---

**Remember:** Practice these problems multiple times with different approaches to master string manipulation! 🚀
