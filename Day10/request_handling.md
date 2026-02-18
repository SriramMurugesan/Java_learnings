# Request Handling

Servlets provide specific methods to handle different types of HTTP requests.

## 1. doGet() vs doPost()

The `service()` method dispatches requests to `doGet()` or `doPost()` based on the HTTP method.

| Feature | `doGet()` | `doPost()` |
| :--- | :--- | :--- |
| **HTTP Method** | GET | POST |
| **Data Visibility** | Parameters are visible in the **URL** (Query String). | Parameters are **hidden** in the Request Body. |
| **Data Length** | Limited (around 2048 chars, browser dependent). | Unlimited data length. |
| **Security** | Less secure (data visible). | More secure (data not visible). |
| **UseCase** | Retrieving data (Searching, Viewing). | Submitting data (Login, Registration, File Upload). |
| **Idempotency** | Idempotent (Safe to repeat). | Non-Idempotent (Repeating might cause duplicate actions). |

**Wait, what is Idempotent?**
Checking your bank balance 10 times gives the same result (Idempotent), but transferring money 10 times... well, you'll be broke (Non-Idempotent).

## 2. RequestDispatcher vs SendRedirect

Both are used to navigate from one resource to another (e.g., from a Servlet to a JSP or another Servlet), but they work very differently.

### RequestDispatcher (Forward)
- **Method**: `request.getRequestDispatcher("target").forward(req, res);`
- **Action**: Happens on the **Server Side**.
- **URL**: The URL in the browser **does NOT change**.
- **Request Object**: The **same request** object is passed to the destination.
- **Speed**: Faster (one request/response cycle).
- **Use Case**: Internal forwarding (e.g., Servlet processes data -> forwards to JSP for display).

### SendRedirect (Redirect)
- **Method**: `response.sendRedirect("target");`
- **Action**: Happens on the **Client Side** (Browser).
- **URL**: The URL in the browser **changes** to the new location.
- **Request Object**: A **new request** is created. Old request data is lost.
- **Speed**: Slower (two request/response cycles: 1. Request -> 2. Redirect Response 302 -> 3. New Request -> 4. Final Response).
- **Use Case**: Redirecting to an external site or after a successful POST (Post/Redirect/Get pattern) to prevent duplicate submissions.

---

### Comparison Summary

| Feature | `RequestDispatcher` (Forward) | `SendRedirect` (Redirect) |
| :--- | :--- | :--- |
| **Location** | Server Side | Client Side |
| **URL Change** | No | Yes |
| **Request Scope** | Preserved (Shared) | Create New (Lost) |
| **Performance** | Faster | Slower |
| **Can go outside?** | No (only internal resources) | Yes (can link to google.com) |
