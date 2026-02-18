# Day 9 - JDBC (Java Database Connectivity)

## Topics Covered

### Introduction
- [JDBC Introduction](jdbc_intro.md)
- [Types of JDBC Drivers](driver_types.md)

### Core Interfaces
- [Connection Interface](connection_examples.java) - Load driver and establish connection
- [Statement Interface](statement_examples.java) - Execute SQL queries
- [ResultSet Interface](resultset_examples.java) - Process query results
- [PreparedStatement Interface](preparedstatement_examples.java) - Parameterized queries

### Advanced Topics
- [Transaction Management](transaction_examples.java) - Commit and rollback

### Practice
- [Exercises](exercises.md)
- [Interview Questions](interview_questions.md)

## Quick Reference

| Interface | Purpose | Key Methods |
|-----------|---------|-------------|
| DriverManager | Establish connection | getConnection() |
| Connection | Database connection | createStatement(), prepareStatement(), commit(), rollback() |
| Statement | Execute SQL | executeQuery(), executeUpdate() |
| PreparedStatement | Parameterized SQL | setInt(), setString(), executeQuery() |
| ResultSet | Process results | next(), getInt(), getString() |

## JDBC Workflow

```
1. Load Driver          → Class.forName("com.mysql.cj.jdbc.Driver")
2. Get Connection       → DriverManager.getConnection(url, user, password)
3. Create Statement     → connection.createStatement() or prepareStatement()
4. Execute Query        → executeQuery() or executeUpdate()
5. Process Results      → resultSet.next(), resultSet.getString()
6. Close Resources      → Close ResultSet, Statement, Connection
```

## How to Run Examples

```bash
# Add MySQL/PostgreSQL JDBC driver to classpath
# Download from: https://dev.mysql.com/downloads/connector/j/

# Compile
javac -cp .:mysql-connector-java.jar filename.java

# Run
java -cp .:mysql-connector-java.jar filename
```

## Learning Path

1. Start with **JDBC Introduction**
2. Understand **Driver Types**
3. Learn **Connection** establishment
4. Master **Statement** interface
5. Understand **ResultSet** navigation
6. Learn **PreparedStatement** (SQL injection prevention)
7. Master **Transaction Management**
8. Practice with **Exercises**
9. Review **Interview Questions**
