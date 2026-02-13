# Day 4 - OOP & Regular Expressions Exercises

## 🎯 Practice Problems

Complete these exercises to master OOP concepts and Regular Expressions in Java!

---

## Encapsulation Exercises

### Exercise 1: Student Management System
Create a `Student` class with private fields: name, rollNumber, marks (array of 5 subjects). Implement:
- Getters and setters with validation
- Method to calculate average marks
- Method to display student details

---

### Exercise 2: Bank Account
Create a `BankAccount` class with:
- Private fields: accountNumber, holderName, balance
- Methods: deposit(), withdraw(), displayBalance()
- Validation: balance cannot be negative, withdrawal amount should not exceed balance

---

### Exercise 3: Employee Salary Calculator
Create an `Employee` class with:
- Private fields: name, baseSalary, allowances, deductions
- Specific getters/setters with validation
- Method to calculate net salary
- Constructor overloading

---

## Inheritance Exercises

### Exercise 4: Vehicle Hierarchy
Create a vehicle hierarchy:
- Base class: `Vehicle` (brand, year, price)
- Derived classes: `Car`, `Bike`, `Truck`
- Each derived class should have specific attributes and methods
- Demonstrate method overriding

---

### Exercise 5: Shape Area Calculator
Create a shape hierarchy:
- Base class: `Shape` with abstract methods area() and perimeter()
- Derived classes: `Circle`, `Rectangle`, `Triangle`
- Calculate and display area and perimeter for each shape

---

### Exercise 6: Employee Management
Create an employee hierarchy:
- Base class: `Employee`
- Derived classes: `Manager`, `Developer`, `Designer`
- Each has different salary calculation logic
- Use constructor chaining

---

## Polymorphism Exercises

### Exercise 7: Calculator with Method Overloading
Create a `Calculator` class with overloaded methods:
- add(int, int)
- add(double, double)
- add(int, int, int)
- add(String, String) - for concatenation

---

### Exercise 8: Animal Sounds
Create an animal hierarchy demonstrating runtime polymorphism:
- Base class: `Animal` with sound() method
- Derived classes: `Dog`, `Cat`, `Cow`, `Lion`
- Create an array of animals and call sound() for each

---

### Exercise 9: Payment Processing
Create a payment system:
- Base class: `Payment` with processPayment() method
- Derived classes: `CreditCard`, `DebitCard`, `UPI`, `Cash`
- Demonstrate dynamic method dispatch

---

## Abstraction Exercises

### Exercise 10: Abstract Shape Class
Create an abstract `Shape` class:
- Abstract methods: draw(), area()
- Concrete method: displayInfo()
- Implement for Circle, Rectangle, Triangle

---

### Exercise 11: Database Connection
Create an abstract `Database` class:
- Abstract methods: connect(), disconnect(), executeQuery()
- Concrete method: logOperation()
- Implement for MySQL, MongoDB, PostgreSQL

---

### Exercise 12: Account Interest Calculator
Create an abstract `Account` class:
- Abstract method: calculateInterest()
- Concrete methods: deposit(), withdraw()
- Implement for Savings, Current, Fixed Deposit

---

## Interface Exercises

### Exercise 13: Multiple Interfaces
Create interfaces `Flyable`, `Swimmable`, `Walkable`
- Implement for classes: `Duck`, `Fish`, `Bird`, `Human`
- Demonstrate multiple inheritance

---

### Exercise 14: Drawable Interface
Create a `Drawable` interface:
- Methods: draw(), erase()
- Implement for: `Circle`, `Line`, `Rectangle`
- Add default method: displayInfo()

---

### Exercise 15: Comparable Interface
Create a `Student` class implementing `Comparable`:
- Compare students based on marks
- Sort an array of students

---

## Regular Expressions Exercises

### Exercise 16: Email Validator
Write a program to validate email addresses:
- Must have @ and .
- Domain should be 2-7 characters
- Test with various email formats

---

### Exercise 17: Password Strength Checker
Create a password validator:
- At least 8 characters
- Must contain uppercase, lowercase, digit, special character
- Display strength: Weak, Medium, Strong

---

### Exercise 18: Phone Number Formatter
Write a program to:
- Extract phone numbers from text
- Format them as (XXX) XXX-XXXX
- Validate Indian phone numbers (10 digits)

---

### Exercise 19: Text Analyzer
Create a text analyzer that:
- Counts words, sentences, paragraphs
- Extracts all numbers
- Finds all email addresses
- Removes special characters

---

### Exercise 20: URL Extractor
Write a program to:
- Extract all URLs from text
- Validate URL format
- Separate http and https URLs

---

## Combined OOP Exercises

### Exercise 21: Library Management System
Create a complete library system:
- Classes: Book, Member, Library
- Use encapsulation, inheritance, polymorphism
- Book types: EBook, PhysicalBook
- Member types: Student, Faculty

---

### Exercise 22: Online Shopping System
Create a shopping system:
- Classes: Product, Customer, Order
- Use interfaces: Payable, Shippable
- Abstract class: Payment
- Implement different payment methods

---

### Exercise 23: School Management System
Create a school system:
- Classes: Person, Student, Teacher, Staff
- Use inheritance hierarchy
- Interfaces: Teachable, Learnable
- Calculate fees, salaries, grades

---

### Exercise 24: Banking Application
Create a complete banking app:
- Abstract class: Account
- Derived classes: Savings, Current, Fixed
- Interfaces: Transferable, Printable
- Use regex for account number validation

---

### Exercise 25: E-Commerce Platform
Create an e-commerce platform:
- Product hierarchy (Electronics, Clothing, Books)
- User types (Customer, Seller, Admin)
- Payment interfaces
- Use regex for input validation

---

## Challenge Exercises

### Exercise 26: Design Pattern Implementation
Implement the following design patterns:
- Singleton pattern for Database connection
- Factory pattern for creating different shapes
- Observer pattern for notification system

---

### Exercise 27: Generic Class
Create a generic `Box<T>` class:
- Can store any type of object
- Methods: add(), remove(), display()
- Demonstrate with different data types

---

### Exercise 28: Exception Handling with OOP
Create a banking system with custom exceptions:
- InsufficientBalanceException
- InvalidAccountException
- Use try-catch blocks appropriately

---

### Exercise 29: File Processing with Regex
Create a program to:
- Read a text file
- Extract all emails, phone numbers, URLs
- Validate and categorize them
- Write results to another file

---

### Exercise 30: Complete Application
Build a complete Student Management System:
- Use all OOP concepts
- Implement CRUD operations
- Input validation using regex
- Multiple user roles (Admin, Teacher, Student)

---

## 💡 Tips for Solving

1. **Start Simple**: Begin with basic problems and gradually move to advanced ones
2. **Plan First**: Design your class hierarchy before coding
3. **Test Thoroughly**: Test with various inputs and edge cases
4. **Follow Best Practices**: Use proper naming, encapsulation, and documentation
5. **Reuse Code**: Use inheritance and interfaces to avoid code duplication

---

## 🎯 Practice Strategy

### Week 1: Encapsulation & Inheritance
- Complete exercises 1-6
- Focus on proper encapsulation
- Practice inheritance hierarchies

### Week 2: Polymorphism & Abstraction
- Complete exercises 7-12
- Master method overloading and overriding
- Understand abstract classes

### Week 3: Interfaces & Regex
- Complete exercises 13-20
- Learn interface implementation
- Practice regex patterns

### Week 4: Combined & Challenge
- Complete exercises 21-30
- Build complete applications
- Review all concepts

---

**Remember:** Practice is the key to mastering OOP and Regular Expressions! 🚀
