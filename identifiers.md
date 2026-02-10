# Java Identifiers - Rules

## 📌 What is an Identifier?

An **identifier** is a name given to a variable, method, class, interface, or package.

**Examples:**
- Variable name: `age`, `studentName`
- Method name: `calculateSum()`, `display()`
- Class name: `Student`, `Calculator`

---

## ✅ Rules for Identifiers

### 1️⃣ **Must Start With:**
- A letter (a-z, A-Z)
- Underscore (_)
- Dollar sign ($)

✅ Valid: `name`, `_value`, `$amount`  
❌ Invalid: `1name`, `@value`, `#number`

---

### 2️⃣ **Can Contain:**
- Letters (a-z, A-Z)
- Digits (0-9)
- Underscore (_)
- Dollar sign ($)

✅ Valid: `name1`, `student_age`, `total$`  
❌ Invalid: `student-name`, `total@amount`, `my name`

---

### 3️⃣ **Cannot Start With a Digit**

❌ Invalid: `1student`, `2name`, `9value`  
✅ Valid: `student1`, `name2`, `value9`

---

### 4️⃣ **Case Sensitive**

`name`, `Name`, and `NAME` are **three different identifiers**.

```
int age = 10;
int Age = 20;
int AGE = 30;
// All three are different variables
```

---

### 5️⃣ **No Reserved Keywords**

Cannot use Java keywords as identifiers.

❌ Invalid: `int`, `class`, `void`, `public`, `static`, `if`, `for`, `while`  
✅ Valid: `myInt`, `className`, `voidValue`

**Java Keywords (Reserved Words):**
```
abstract, assert, boolean, break, byte, case, catch, char, class,
const, continue, default, do, double, else, enum, extends, final,
finally, float, for, goto, if, implements, import, instanceof, int,
interface, long, native, new, package, private, protected, public,
return, short, static, strictfp, super, switch, synchronized, this,
throw, throws, transient, try, void, volatile, while
```

---

### 6️⃣ **No Special Characters**

Cannot use special characters like `@`, `#`, `%`, `&`, `-`, `+`, `*`, `/`, space, etc.

❌ Invalid: `student-name`, `total@amount`, `my name`, `value%`  
✅ Valid: `student_name`, `totalAmount`, `myName`, `value`

---

### 7️⃣ **No Length Limit**

Identifiers can be of any length, but keep them meaningful and readable.

✅ Valid: `a`, `studentName`, `calculateTotalSalaryOfEmployee`  
⚠️ Avoid: Very long names reduce readability

---

### 8️⃣ **Whitespace Not Allowed**

Cannot have spaces in identifier names.

❌ Invalid: `student name`, `total amount`, `my variable`  
✅ Valid: `studentName`, `totalAmount`, `myVariable`

---

## 📝 Summary of Rules

| Rule | Valid ✅ | Invalid ❌ |
|------|---------|-----------|
| Start with letter, _, $ | `name`, `_id`, `$price` | `1name`, `@id` |
| Can contain letters, digits, _, $ | `age1`, `total_sum` | `age-1`, `total@sum` |
| Cannot start with digit | `student1` | `1student` |
| Case sensitive | `name` ≠ `Name` | - |
| No keywords | `myClass` | `class` |
| No special chars | `student_name` | `student-name` |
| No spaces | `studentName` | `student name` |

---

## 💡 Best Practices (Naming Conventions)

### Variables & Methods
- Use **camelCase**: `studentName`, `calculateSum()`
- Start with lowercase letter

### Classes & Interfaces
- Use **PascalCase**: `Student`, `Calculator`
- Start with uppercase letter

### Constants
- Use **UPPER_CASE**: `MAX_VALUE`, `PI`, `DEFAULT_SIZE`
- All uppercase with underscores

---

## ✅ Valid Identifier Examples

```
age
studentName
_value
$amount
student1
total_sum
calculateSum
MyClass
MAX_VALUE
```

---

## ❌ Invalid Identifier Examples

```
1student          // Starts with digit
student-name      // Contains hyphen
total@amount      // Contains @
my name           // Contains space
class             // Reserved keyword
int               // Reserved keyword
for               // Reserved keyword
```

---

**Remember:** Choose meaningful and descriptive names for better code readability! 🚀
