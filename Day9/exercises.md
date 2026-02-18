# Day 9 - JDBC Exercises

## Exercise 1: Basic Connection
**Difficulty:** Easy

Create a Java program that:
1. Loads the MySQL JDBC driver
2. Establishes a connection to a database named `school_db`
3. Prints "Connection successful!" if connected
4. Closes the connection properly

---

## Exercise 2: Create Table
**Difficulty:** Easy

Write a program to create a table named `books` with the following structure:
- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `title` (VARCHAR(100))
- `author` (VARCHAR(50))
- `price` (DOUBLE)
- `quantity` (INT)

---

## Exercise 3: Insert Records
**Difficulty:** Easy

Create a program that inserts 5 book records into the `books` table using Statement interface.

Sample data:
- "Java Programming", "John Smith", 45.99, 10
- "Python Basics", "Alice Johnson", 39.99, 15
- "Web Development", "Bob Williams", 55.00, 8

---

## Exercise 4: Display All Records
**Difficulty:** Easy

Write a program to:
1. Retrieve all records from the `books` table
2. Display them in a formatted table:
   ```
   ID | Title | Author | Price | Quantity
   ---|-------|--------|-------|----------
   ```

---

## Exercise 5: Search by Author
**Difficulty:** Medium

Create a program that:
1. Accepts an author name from user input
2. Uses PreparedStatement to search for books by that author
3. Displays all matching books

---

## Exercise 6: Update Book Price
**Difficulty:** Medium

Write a program to:
1. Accept a book ID and new price from user
2. Update the book price using PreparedStatement
3. Display "Price updated successfully" message

---

## Exercise 7: Delete Book
**Difficulty:** Medium

Create a program that:
1. Accepts a book ID from user
2. Deletes the book from the database using PreparedStatement
3. Displays the number of rows affected

---

## Exercise 8: SQL Injection Prevention
**Difficulty:** Medium

Create two programs:
1. **Unsafe Version:** Uses Statement with string concatenation
2. **Safe Version:** Uses PreparedStatement

Test both with input: `' OR '1'='1`

Show how PreparedStatement prevents SQL injection.

---

## Exercise 9: Batch Insert
**Difficulty:** Medium

Write a program that:
1. Reads 10 book records from an array
2. Uses PreparedStatement batch processing to insert all records
3. Displays total execution time

---

## Exercise 10: Transaction - Book Purchase
**Difficulty:** Hard

Create a program that simulates a book purchase:
1. Decrease book quantity by 1
2. Insert a record in `purchases` table
3. Use transaction management (commit if both succeed, rollback if any fails)

---

## Exercise 11: Scrollable ResultSet
**Difficulty:** Medium

Write a program that:
1. Creates a scrollable ResultSet
2. Displays first book
3. Displays last book
4. Displays 3rd book
5. Navigates backward and displays all books in reverse order

---

## Exercise 12: ResultSet Metadata
**Difficulty:** Medium

Create a program that:
1. Executes a SELECT query on `books` table
2. Uses ResultSetMetaData to display:
   - Number of columns
   - Column names
   - Column types
   - Column sizes

---

## Exercise 13: Connection Utility Class
**Difficulty:** Medium

Create a utility class `DBUtil` with:
1. `getConnection()` method - returns Connection
2. `closeConnection(Connection)` method - closes connection
3. `closeStatement(Statement)` method - closes statement
4. `closeResultSet(ResultSet)` method - closes resultset

Use this utility in a sample program.

---

## Exercise 14: Complete CRUD Application
**Difficulty:** Hard

Create a complete Book Management System with menu:
```
1. Add Book
2. View All Books
3. Search Book by ID
4. Update Book Price
5. Delete Book
6. Exit
```

Use PreparedStatement for all operations.

---

## Exercise 15: Transaction with Savepoints
**Difficulty:** Hard

Create a program that:
1. Inserts 3 books
2. Creates a savepoint after each insert
3. Simulates an error on 3rd insert
4. Rolls back to savepoint 2
5. Commits the first 2 inserts

---

## Bonus Exercise: Library Management System
**Difficulty:** Expert

Create a complete library management system with:

**Tables:**
- `books` (id, title, author, isbn, total_copies, available_copies)
- `members` (id, name, email, phone)
- `transactions` (id, book_id, member_id, issue_date, return_date, status)

**Features:**
1. Add/Update/Delete Books
2. Add/Update/Delete Members
3. Issue Book (decrease available_copies, create transaction)
4. Return Book (increase available_copies, update transaction)
5. View all issued books
6. View member history

**Requirements:**
- Use PreparedStatement for all queries
- Use transactions for issue/return operations
- Proper exception handling
- Menu-driven interface

---

## Tips for Solving Exercises

1. **Always close resources** - Use try-with-resources
2. **Use PreparedStatement** - Prevents SQL injection
3. **Handle exceptions** - Use try-catch blocks
4. **Test with sample data** - Create test cases
5. **Print meaningful messages** - Help debug issues
6. **Follow naming conventions** - Use camelCase for variables

---

## Common Mistakes to Avoid

❌ Forgetting to close connections
❌ Using Statement instead of PreparedStatement
❌ Not handling SQLException
❌ Column index starting from 0 (it starts from 1!)
❌ Forgetting to commit transactions
❌ Not rolling back on errors
