# Servlet JDBC Integration

Connecting a Servlet to a Database allows us to build dynamic, data-driven applications (like our Banking App!).

## How it works

1.  **Load the Driver**: `Class.forName("com.mysql.cj.jdbc.Driver");`
2.  **Establish Connection**: `DriverManager.getConnection(url, user, pass);`
3.  **Create Statement**: `PreparedStatement` or `Statement`
4.  **Execute Query**: `executeQuery()` for reading, `executeUpdate()` for creating/updating.
5.  **Process Result**: Iterate through `ResultSet`.
6.  **Close Resources**: **Essential** to avoid memory leaks.

## Where to write JDBC code?

- **Separate DAO (Data Access Object) Class**: Best Practice. Keep database logic separate from Servlet logic. The Servlet calls the DAO methods.
- **Inside `init()`**: For establishing a connection pool or single persistent connection (careful with concurrency!).
- **Inside `doGet()` / `doPost()`**: Simplest for learning, but creates a new connection for every request (slow).

## Example Flow (Login)

1.  **User** submits login form (HTML) -> POST request.
2.  **LoginServlet** (`doPost`) receives username/password.
3.  **LoginServlet** calls `UserDAO.validate(username, password)`.
4.  **UserDAO** executes `SELECT * FROM users WHERE ...` via JDBC.
5.  **UserDAO** returns `true` or `false`.
6.  **LoginServlet**:
    - If `true`: `response.sendRedirect("dashboard.jsp");`
    - If `false`: `request.getRequestDispatcher("login.jsp").forward(req, res);` (with error message).
