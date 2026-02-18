# Day 9 - JDBC Interview Questions

## Basic Questions

### 1. What is JDBC?
**Answer:** JDBC (Java Database Connectivity) is a Java API that allows Java programs to interact with databases. It provides classes and interfaces to connect to databases, execute SQL queries, and process results.

**Key Points:**
- Part of `java.sql` package
- Database independent
- Standard API for all databases

---

### 2. What are the main components of JDBC?
**Answer:** 
1. **DriverManager** - Manages database drivers
2. **Connection** - Represents database connection
3. **Statement** - Executes SQL queries
4. **ResultSet** - Holds query results
5. **PreparedStatement** - Parameterized queries
6. **CallableStatement** - Stored procedures

---

### 3. What are the types of JDBC drivers?
**Answer:**

| Type | Name | Platform Independent | Performance |
|------|------|---------------------|-------------|
| Type 1 | JDBC-ODBC Bridge | ❌ No | Slow |
| Type 2 | Native-API Driver | ❌ No | Medium |
| Type 3 | Network Protocol | ✅ Yes | Medium |
| Type 4 | Thin Driver | ✅ Yes | **Fast** |

**Most Used:** Type 4 (Pure Java Driver)

---

### 4. What are the steps to connect to a database using JDBC?
**Answer:**
```java
// Step 1: Load Driver
Class.forName("com.mysql.cj.jdbc.Driver");

// Step 2: Get Connection
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

---

### 5. What is the difference between Statement and PreparedStatement?
**Answer:**

| Feature | Statement | PreparedStatement |
|---------|-----------|-------------------|
| SQL Injection | ❌ Vulnerable | ✅ Safe |
| Performance | Slower | Faster (pre-compiled) |
| Parameterization | ❌ No | ✅ Yes |
| Reusability | ❌ No | ✅ Yes |
| Usage | Simple queries | **Recommended** |

**Example:**
```java
// Statement (Unsafe)
Statement stmt = con.createStatement();
stmt.executeUpdate("INSERT INTO students VALUES ('" + name + "')");

// PreparedStatement (Safe)
PreparedStatement pstmt = con.prepareStatement("INSERT INTO students VALUES (?)");
pstmt.setString(1, name);
pstmt.executeUpdate();
```

---

### 6. What is SQL Injection and how does PreparedStatement prevent it?
**Answer:** 

**SQL Injection:** A security vulnerability where malicious SQL code is inserted into input fields.

**Example Attack:**
```java
String input = "John' OR '1'='1";
// Unsafe: SELECT * FROM users WHERE name = 'John' OR '1'='1'
// This returns ALL users!
```

**Prevention with PreparedStatement:**
```java
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE name = ?");
pstmt.setString(1, "John' OR '1'='1");
// Treats entire input as a string literal - safe!
```

---

### 7. What is the difference between executeQuery(), executeUpdate(), and execute()?
**Answer:**

| Method | Used For | Returns |
|--------|----------|---------|
| `executeQuery()` | SELECT | ResultSet |
| `executeUpdate()` | INSERT, UPDATE, DELETE | int (rows affected) |
| `execute()` | Any SQL | boolean |

**Examples:**
```java
// executeQuery - SELECT
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

// executeUpdate - INSERT/UPDATE/DELETE
int rows = stmt.executeUpdate("DELETE FROM students WHERE id = 1");

// execute - Any SQL
boolean hasResultSet = stmt.execute("SELECT * FROM students");
```

---

### 8. What is a ResultSet and how do you navigate it?
**Answer:** ResultSet is an object that holds data returned from a database query.

**Navigation Methods:**
- `next()` - Move to next row
- `previous()` - Move to previous row
- `first()` - Move to first row
- `last()` - Move to last row
- `absolute(n)` - Move to nth row

**Example:**
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM students");
while(rs.next()) {
    String name = rs.getString("name");
    int age = rs.getInt("age");
}
```

---

### 9. What are the types of ResultSet?
**Answer:**

1. **TYPE_FORWARD_ONLY** (default)
   - Can only move forward using `next()`
   
2. **TYPE_SCROLL_INSENSITIVE**
   - Can scroll forward and backward
   - Does not reflect database changes
   
3. **TYPE_SCROLL_SENSITIVE**
   - Can scroll forward and backward
   - Reflects database changes

**Example:**
```java
Statement stmt = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);
```

---

### 10. What is a transaction in JDBC?
**Answer:** A transaction is a group of SQL operations that are executed as a single unit. Either all operations succeed (commit) or all fail (rollback).

**ACID Properties:**
- **Atomicity** - All or nothing
- **Consistency** - Valid state always
- **Isolation** - Concurrent transactions don't interfere
- **Durability** - Committed changes are permanent

**Example:**
```java
connection.setAutoCommit(false); // Start transaction
try {
    // Multiple operations
    stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
    stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");
    connection.commit(); // Success
} catch (SQLException e) {
    connection.rollback(); // Failure
}
```

---

## Intermediate Questions

### 11. What is the difference between commit() and rollback()?
**Answer:**

| Method | Purpose | When to Use |
|--------|---------|-------------|
| `commit()` | Save changes permanently | All operations successful |
| `rollback()` | Undo all changes | Any operation fails |

**Example:**
```java
connection.setAutoCommit(false);
try {
    // Operations
    connection.commit(); // Save
} catch (SQLException e) {
    connection.rollback(); // Undo
}
```

---

### 12. What is a Savepoint?
**Answer:** A savepoint is a point within a transaction to which you can rollback without rolling back the entire transaction.

**Example:**
```java
connection.setAutoCommit(false);
stmt.executeUpdate("INSERT INTO students VALUES (1, 'John')");
Savepoint sp1 = connection.setSavepoint("Savepoint1");
stmt.executeUpdate("INSERT INTO students VALUES (2, 'Alice')");
// Error occurs
connection.rollback(sp1); // Only rollback to savepoint
connection.commit(); // First insert is saved
```

---

### 13. What is batch processing in JDBC?
**Answer:** Batch processing allows executing multiple SQL statements together, improving performance.

**Example:**
```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO students VALUES (?, ?)");
pstmt.setInt(1, 1);
pstmt.setString(2, "John");
pstmt.addBatch();

pstmt.setInt(1, 2);
pstmt.setString(2, "Alice");
pstmt.addBatch();

int[] results = pstmt.executeBatch(); // Execute all at once
```

---

### 14. What is the difference between getInt(1) and getInt("id")?
**Answer:**

| Method | Parameter | Example |
|--------|-----------|---------|
| `getInt(1)` | Column index (starts from 1) | `rs.getInt(1)` |
| `getInt("id")` | Column name | `rs.getInt("id")` |

**Recommendation:** Use column name for better readability.

---

### 15. What is ResultSetMetaData?
**Answer:** ResultSetMetaData provides information about the ResultSet structure (column names, types, sizes).

**Example:**
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM students");
ResultSetMetaData metaData = rs.getMetaData();

int columnCount = metaData.getColumnCount();
for (int i = 1; i <= columnCount; i++) {
    System.out.println(metaData.getColumnName(i));
    System.out.println(metaData.getColumnTypeName(i));
}
```

---

### 16. How do you handle NULL values in ResultSet?
**Answer:** Use `wasNull()` method after retrieving a value.

**Example:**
```java
int age = rs.getInt("age");
if (rs.wasNull()) {
    System.out.println("Age is NULL");
} else {
    System.out.println("Age: " + age);
}
```

---

### 17. What is the difference between JDBC and ODBC?
**Answer:**

| Feature | JDBC | ODBC |
|---------|------|------|
| Language | Java | C/C++ |
| Platform | Platform independent | Platform dependent |
| Driver | Pure Java drivers available | Requires native libraries |
| Performance | Better for Java apps | Better for C/C++ apps |

---

### 18. What is Connection Pooling?
**Answer:** Connection pooling is a technique to reuse database connections instead of creating new ones for each request.

**Benefits:**
- Improved performance
- Reduced resource usage
- Faster response time

**Libraries:** HikariCP, Apache DBCP, C3P0

---

### 19. What are the transaction isolation levels?
**Answer:**

| Level | Dirty Read | Non-Repeatable Read | Phantom Read |
|-------|-----------|---------------------|--------------|
| READ_UNCOMMITTED | ✅ Yes | ✅ Yes | ✅ Yes |
| READ_COMMITTED | ❌ No | ✅ Yes | ✅ Yes |
| REPEATABLE_READ | ❌ No | ❌ No | ✅ Yes |
| SERIALIZABLE | ❌ No | ❌ No | ❌ No |

**Example:**
```java
connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
```

---

### 20. What is CallableStatement?
**Answer:** CallableStatement is used to execute stored procedures in the database.

**Example:**
```java
CallableStatement cstmt = con.prepareCall("{call getStudentById(?)}");
cstmt.setInt(1, 101);
ResultSet rs = cstmt.executeQuery();
```

---

## Advanced Questions

### 21. How do you retrieve auto-generated keys after an INSERT?
**Answer:**
```java
PreparedStatement pstmt = con.prepareStatement(
    "INSERT INTO students (name, age) VALUES (?, ?)",
    Statement.RETURN_GENERATED_KEYS
);
pstmt.setString(1, "John");
pstmt.setInt(2, 20);
pstmt.executeUpdate();

ResultSet rs = pstmt.getGeneratedKeys();
if (rs.next()) {
    int id = rs.getInt(1);
    System.out.println("Generated ID: " + id);
}
```

---

### 22. What is the difference between close() and isClosed()?
**Answer:**

| Method | Purpose |
|--------|---------|
| `close()` | Closes the connection |
| `isClosed()` | Checks if connection is closed |

**Example:**
```java
if (!connection.isClosed()) {
    connection.close();
}
```

---

### 23. What happens if you don't close JDBC resources?
**Answer:**
- **Memory leaks** - Resources not released
- **Connection pool exhaustion** - No connections available
- **Database locks** - Tables remain locked
- **Performance degradation** - System slowdown

**Solution:** Always use try-with-resources or close in finally block.

---

### 24. Can you execute multiple SQL statements in a single execute() call?
**Answer:** No, each execute() call executes one SQL statement. Use batch processing for multiple statements.

---

### 25. What is the purpose of DriverManager?
**Answer:** DriverManager manages JDBC drivers and establishes database connections.

**Key Methods:**
- `getConnection(url, user, password)` - Get connection
- `registerDriver(driver)` - Register driver
- `deregisterDriver(driver)` - Deregister driver

---

## Practical Scenario Questions

### 26. How would you implement a bank transfer using JDBC?
**Answer:**
```java
connection.setAutoCommit(false);
try {
    // Debit from Account A
    pstmt1.executeUpdate("UPDATE accounts SET balance = balance - 1000 WHERE id = 1");
    
    // Credit to Account B
    pstmt2.executeUpdate("UPDATE accounts SET balance = balance + 1000 WHERE id = 2");
    
    connection.commit(); // Both successful
} catch (SQLException e) {
    connection.rollback(); // Undo both
}
```

---

### 27. How do you prevent SQL injection in user login?
**Answer:**
```java
// UNSAFE
String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

// SAFE
String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password);
```

---

### 28. How would you implement pagination in JDBC?
**Answer:**
```java
// MySQL
String sql = "SELECT * FROM students LIMIT ? OFFSET ?";
pstmt.setInt(1, pageSize);
pstmt.setInt(2, (pageNumber - 1) * pageSize);

// Oracle
String sql = "SELECT * FROM (SELECT ROWNUM rnum, a.* FROM students a WHERE ROWNUM <= ?) WHERE rnum > ?";
```

---

## Tips for Interview Success

1. **Understand the basics** - Know all JDBC components
2. **Practice coding** - Write actual JDBC programs
3. **Know PreparedStatement** - Most important interface
4. **Understand transactions** - ACID properties
5. **Security awareness** - SQL injection prevention
6. **Resource management** - Always close connections
7. **Real-world scenarios** - Bank transfers, login systems
