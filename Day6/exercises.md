# Day 6 - Threads & Java 8 Features Exercises

## Thread Basics

### Exercise 1: Create Simple Thread
Create a thread that prints numbers 1 to 10.

### Exercise 2: Multiple Threads
Create two threads - one prints even numbers, another prints odd numbers (1-10).

### Exercise 3: Thread with sleep()
Create a thread that prints "Hello" 5 times with 1 second delay between each print.

---

## Runnable Interface

### Exercise 4: Implement Runnable
Create a class implementing Runnable that prints your name 5 times.

### Exercise 5: Lambda Thread
Create a thread using lambda expression that prints "Lambda Thread" 3 times.

### Exercise 6: Shared Runnable
Create one Runnable object and use it with 3 different threads.

---

## Synchronization

### Exercise 7: Counter Problem
Create a Counter class with increment() method. Create 2 threads that increment counter 1000 times each. Show the race condition problem.

### Exercise 8: Synchronized Counter
Fix Exercise 7 using synchronized keyword.

### Exercise 9: Bank Account
Create a BankAccount class with withdraw() method. Use synchronization to prevent overdraft when multiple threads withdraw simultaneously.

---

## Producer-Consumer

### Exercise 10: Simple Producer-Consumer
Implement producer-consumer with single item buffer.

### Exercise 11: Queue Buffer
Implement producer-consumer with queue of capacity 5.

---

## Java 8 Features

### Exercise 12: Lambda Expressions
Create lambda expressions for:
- Adding two numbers
- Finding square of a number
- Checking if number is even

### Exercise 13: Optional Class
Create a method that returns Optional<String>. Handle both present and empty cases.

### Exercise 14: Stream with Lambda
Use stream and lambda to:
- Filter even numbers from a list
- Double all numbers in a list
- Find sum of all numbers

---

## Challenge Exercises

### Exercise 15: Thread States
Create a program that monitors and prints all states of a thread.

### Exercise 16: Deadlock
Create a simple deadlock scenario and explain how to avoid it.

### Exercise 17: Thread Pool
Research and implement a simple thread pool using ExecutorService.
