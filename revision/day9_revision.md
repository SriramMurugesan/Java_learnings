# Day 9 - JDBC Quick Revision

## 🎯 What is JDBC?
**JDBC (Java Database Connectivity)** - Java API to connect and interact with databases

**Package:** `java.sql`

---

## 📦 JDBC Components

| Component | Purpose | Key Methods |
|-----------|---------|-------------|
| **DriverManager** | Manage drivers, get connection | `getConnection()` |
| **Connection** | Database connection | `createStatement()`, `prepareStatement()`, `commit()`, `rollback()` |
| **Statement** | Execute SQL | `executeQuery()`, `executeUpdate()` |
| **PreparedStatement** | Parameterized SQL | `setString()`, `setInt()`, `executeQuery()` |
| **ResultSet** | Query results | `next()`, `getString()`, `getInt()` |

---

## 🚗 JDBC Driver Types

| Type | Name | Platform Independent | Speed | Usage |
|------|------|---------------------|-------|-------|
| Type 1 | JDBC-ODBC Bridge | ❌ | ⭐ | Deprecated |
| Type 2 | Native-API | ❌ | ⭐⭐ | Rarely used |
| Type 3 | Network Protocol | ✅ | ⭐⭐ | Enterprise |
| Type 4 | **Thin Driver** | ✅ | ⭐⭐⭐ | **Most Used** |

**Recommended:** Type 4 (Pure Java)

---

## 🔌 Connection Steps

```java
// 1. Load Driver (optional in JDBC 4.0+)
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. Get Connection
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mydb",
    "root",
    "password"
);

// 3. Use Connection
Statement stmt = con.createStatement();

// 4. Close Connection
con.close();
```

**URL Format:** `jdbc:database://hostname:port/database_name`

---

## 📝 Statement vs PreparedStatement

| Feature | Statement | PreparedStatement |
|---------|-----------|-------------------|
| SQL Injection | ❌ Vulnerable | ✅ **Safe** |
| Performance | Slower | **Faster** |
| Parameterization | ❌ No | ✅ **Yes** |
| Reusability | ❌ No | ✅ **Yes** |

**Always use PreparedStatement!**

```java
// Statement (Unsafe)
stmt.executeUpdate("INSERT INTO users VALUES ('" + name + "')");

// PreparedStatement (Safe)
PreparedStatement pstmt = con.prepareStatement("INSERT INTO users VALUES (?)");
pstmt.setString(1, name);
pstmt.executeUpdate();
```

---

## 🔍 Execute Methods

| Method | Used For | Returns |
|--------|----------|---------|
| `executeQuery()` | **SELECT** | ResultSet |
| `executeUpdate()` | **INSERT, UPDATE, DELETE** | int (rows affected) |
| `execute()` | Any SQL | boolean |

```java
// SELECT
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

// INSERT/UPDATE/DELETE
int rows = stmt.executeUpdate("DELETE FROM students WHERE id = 1");
```

---

## 📊 ResultSet Navigation

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

// Forward navigation
while (rs.next()) {
    String name = rs.getString("name");  // By column name
    int age = rs.getInt(2);              // By column index (starts from 1!)
}

// Scrollable ResultSet
rs.first();      // First row
rs.last();       // Last row
rs.absolute(3);  // 3rd row
rs.previous();   // Previous row
```

**ResultSet Types:**
- `TYPE_FORWARD_ONLY` (default)
- `TYPE_SCROLL_INSENSITIVE`
- `TYPE_SCROLL_SENSITIVE`

---

## 💾 Transaction Management

```java
connection.setAutoCommit(false);  // Start transaction

try {
    // Multiple operations
    stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
    stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");
    
    connection.commit();  // ✅ Success - Save changes
    
} catch (SQLException e) {
    connection.rollback();  // ❌ Error - Undo all changes
}
```

**ACID Properties:**
- **A**tomicity - All or nothing
- **C**onsistency - Valid state
- **I**solation - No interference
- **D**urability - Permanent changes

---

## 🎯 Savepoints

```java
connection.setAutoCommit(false);

stmt.executeUpdate("INSERT INTO students VALUES (1, 'John')");
Savepoint sp1 = connection.setSavepoint("SP1");

stmt.executeUpdate("INSERT INTO students VALUES (2, 'Alice')");
Savepoint sp2 = connection.setSavepoint("SP2");

// Error occurs
connection.rollback(sp2);  // Rollback to SP2
connection.commit();       // First 2 inserts saved
```

---

## 🔐 SQL Injection Prevention

**Malicious Input:** `John' OR '1'='1`

```java
// ❌ UNSAFE - Returns ALL users!
String sql = "SELECT * FROM users WHERE name = '" + input + "'";
// SQL: SELECT * FROM users WHERE name = 'John' OR '1'='1'

// ✅ SAFE - Treats input as literal string
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE name = ?");
pstmt.setString(1, input);
```

---

## 📦 Batch Processing

```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO students VALUES (?, ?)");

pstmt.setInt(1, 1);
pstmt.setString(2, "John");
pstmt.addBatch();

pstmt.setInt(1, 2);
pstmt.setString(2, "Alice");
pstmt.addBatch();

int[] results = pstmt.executeBatch();  // Execute all at once
```

---

## 🔧 PreparedStatement Setters

| Method | Data Type |
|--------|-----------|
| `setString(index, value)` | String |
| `setInt(index, value)` | Integer |
| `setDouble(index, value)` | Double |
| `setBoolean(index, value)` | Boolean |
| `setDate(index, value)` | Date |

**Note:** Index starts from 1, not 0!

---

## 📋 ResultSet Getters

| Method | Data Type |
|--------|-----------|
| `getString(column)` | String |
| `getInt(column)` | Integer |
| `getDouble(column)` | Double |
| `getBoolean(column)` | Boolean |
| `getDate(column)` | Date |

**Column:** Can be name (`"name"`) or index (`1`)

---

## 🎓 Transaction Isolation Levels

| Level | Dirty Read | Non-Repeatable Read | Phantom Read |
|-------|-----------|---------------------|--------------|
| READ_UNCOMMITTED | ✅ | ✅ | ✅ |
| READ_COMMITTED | ❌ | ✅ | ✅ |
| REPEATABLE_READ | ❌ | ❌ | ✅ |
| SERIALIZABLE | ❌ | ❌ | ❌ |

```java
connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
```

---

## ⚠️ Common Mistakes

❌ Forgetting to close resources → Memory leaks
❌ Using Statement instead of PreparedStatement → SQL injection
❌ Column index starting from 0 → Starts from 1!
❌ Not handling SQLException → Crashes
❌ Forgetting to commit transactions → Changes lost
❌ Not rolling back on errors → Inconsistent data

---

## ✅ Best Practices

1. **Always use PreparedStatement** (not Statement)
2. **Use try-with-resources** for auto-closing
3. **Handle exceptions** with try-catch
4. **Use transactions** for multiple operations
5. **Close resources** in finally block or try-with-resources
6. **Validate user input** before queries
7. **Use connection pooling** in production

---

## 📝 Quick Code Template

```java
String url = "jdbc:mysql://localhost:3306/mydb";

try (Connection con = DriverManager.getConnection(url, "root", "password");
     PreparedStatement pstmt = con.prepareStatement("SELECT * FROM students WHERE age > ?")) {
    
    pstmt.setInt(1, 18);
    ResultSet rs = pstmt.executeQuery();
    
    while (rs.next()) {
        System.out.println(rs.getString("name"));
    }
    
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

## 🎯 Key Takeaways

1. **JDBC** = Java + Database communication
2. **Type 4 Driver** = Most used (pure Java)
3. **PreparedStatement** = Always preferred (safe + fast)
4. **Transactions** = All or nothing (ACID)
5. **Close resources** = Prevent memory leaks
6. **SQL Injection** = Use PreparedStatement to prevent

---

## 📚 Interview Focus Areas

- Difference between Statement and PreparedStatement
- SQL injection prevention
- Transaction management (commit/rollback)
- JDBC workflow (6 steps)
- ResultSet navigation
- Driver types
- Execute methods (executeQuery vs executeUpdate)
