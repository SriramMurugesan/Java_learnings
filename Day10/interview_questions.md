# Interview Questions - Day 10: Servlets

## 1. What is the difference between `GenericServlet` and `HttpServlet`?
- **GenericServlet**: Protocol-independent. Can be used for any protocol (HTTP, FTP, SMTP). It implements `Servlet` interface.
- **HttpServlet**: Protocol-specific (HTTP only). It extends `GenericServlet` and adds support for HTTP methods like `doGet`, `doPost`, `doPut`, etc. **We almost always use HttpServlet.**

## 2. Explain the Servlet Life Cycle.
The life cycle is managed by the container:
1.  **Loading & Instantiation**: Class is loaded, instance created.
2.  **Initialization (`init`)**: Called once. Used for setup.
3.  **Service (`service`)**: Called for every request. Dispatches to `doGet`/`doPost`.
4.  **Destruction (`destroy`)**: Called once before cleanup.

## 3. Is `init()` called for every request?
**No.** It is called only **once** when the Servlet is first created.

## 4. Why is `service()` method not thread-safe?
The Servlet container allows concurrent access to the *same* Servlet instance by multiple threads (one per request). If you use instance variables to store request-specific data, one thread might overwrite another's data.
**Solution**: Use local variables within `doGet`/`doPost` and avoid instance variables for state.

## 5. What is the difference between `forward()` (RequestDispatcher) and `sendRedirect()`?
- **Forward**: H happens on the server. URL doesn't change. Request object is shared. Faster.
- **Redirect**: Happens on the client (browser). URL changes. New request is created. Slower.

## 6. How do you pass data from one Servlet to another?
- **Request Attributes**: `request.setAttribute("key", value)` (only works with Forward).
- **Session**: `request.getSession().setAttribute("key", value)` (works across multiple requests).
- **Context**: `getServletContext().setAttribute("key", value)` (global for the whole app).
- **URL Parameters**: `response.sendRedirect("next?key=value")`.

## 7. Can we define a constructor in a Servlet?
Yes, but the container uses the **no-argument constructor** to instantiate it. We rarely use constructors because `init()` is the preferred place for initialization logic provided by the Servlet API.
