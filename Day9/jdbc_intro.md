# Introduction to JDBC

## What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API that allows Java programs to interact with databases.

### Simple Analogy
Think of JDBC as a **translator** between your Java program and a database:
- Your Java code speaks "Java language"
- Database speaks "SQL language"
- JDBC translates between them

## Why Use JDBC?

1. **Database Independence** - Write once, connect to any database (MySQL, PostgreSQL, Oracle)
2. **Standard API** - Same code structure for all databases
3. **Easy Integration** - Connect Java applications to databases easily

## JDBC Architecture

```
Java Application
      ↓
  JDBC API (java.sql package)
      ↓
  JDBC Driver Manager
      ↓
  JDBC Driver (MySQL/PostgreSQL/Oracle)
      ↓
  Database (MySQL/PostgreSQL/Oracle)
```

## JDBC Components

### 1. DriverManager
- Manages database drivers
- Establishes connection to database

### 2. Connection
- Represents a connection to the database
- Used to create statements

### 3. Statement
- Executes SQL queries
- Three types: Statement, PreparedStatement, CallableStatement

### 4. ResultSet
- Holds data returned from database
- Navigate through results row by row

## JDBC Package

All JDBC classes are in the `java.sql` package:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
```

## Basic JDBC Steps

```java
// Step 1: Load Driver
Class.forName("com.mysql.cj.jdbc.Driver");

// Step 2: Establish Connection
Connection con = DriverManager.getConnection(url, username, password);

// Step 3: Create Statement
Statement stmt = con.createStatement();

// Step 4: Execute Query
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

// Step 5: Process Results
while(rs.next()) {
    System.out.println(rs.getString("name"));
}

// Step 6: Close Resources
rs.close();
stmt.close();
con.close();
```

## Real-World Use Cases

1. **Banking Applications** - Store account details, transactions
2. **E-commerce** - Manage products, orders, customers
3. **Student Management** - Store student records, grades
4. **Social Media** - Store user profiles, posts, comments

## Key Points to Remember

- JDBC is an **API** (set of interfaces and classes)
- It provides **database independence**
- Always **close resources** (Connection, Statement, ResultSet)
- Use **try-catch** blocks for exception handling
- **PreparedStatement** is preferred over Statement (security + performance)
