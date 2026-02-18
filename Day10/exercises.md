# Exercises - Day 10: Servlets

## 1. The Welcomer
Create a Servlet mapped to `/welcome`.
- If the user sends a GET request with a parameter `name` (e.g., `/welcome?name=Alice`), display "Welcome, Alice!".
- If the parameter is missing, display "Welcome, Guest!".

## 2. The Login System (Mock)
Create a `LoginServlet` mapped to `/login`.
- **GET request**: Display a simple HTML form with `username` and `password` fields and a submit button.
- **POST request**: Check if username is "admin" and password is "123".
    - If valid: Redirect to a "dashboard" (can be a simple success page or Google).
    - If invalid: Forward back to the login page (the GET request logic) with an error message in red.

## 3. The Lifecycle Logger
Create a Servlet that logs the current time to the console every time `init()`, `service()`, and `destroy()` are called.
- Observe when `init` is called (startup vs first request).
- Observe how `service` is called multiple times.
- Try to stop the server and see if `destroy()` is called.

## 4. JDBC Connect
Create a Servlet that connects to your existing database (from Day 9).
- Fetch the top 5 rows from any table and display them as an HTML List (`<ul>` / `<li>`) in the browser.
