# Servlet Architecture

## 1. High-Level Architecture
The Servlet architecture relies on a **Container** (like Apache Tomcat) to manage the execution of Servlets.

```mermaid
graph LR
    User[Browser/Client] -- HTTP Request --> Server[Web Server]
    Server -- Forward --> Container[Servlet Container (Tomcat)]
    Container -- Create Thread --> Thread[Worker Thread]
    Thread -- Call service() --> Servlet[Your Java Servlet]
    Servlet -- SQL --> DB[(Database)]
    Servlet -- HTML --> Thread
    Thread -- HTTP Response --> User
```

### Components:
1.  **Client**: The browser sending the request.
2.  **Web Server**: Accepts the connection (e.g., connects on port 8080).
3.  **Servlet Container (Web Container)**: The "engine" that runs inside the web server. It manages:
    *   **Life Cycle**: Creating and destroying Servlet instances.
    *   **Mapping**: knowing that `/hello` goes to `HelloServlet.java`.
    *   **Multithreading**: Creates a new thread for every request.

---

## 2. The Internal Hierarchy (Code Architecture)
Servlets follow a specific inheritance hierarchy.

**Class Diagram:**
`Servlet` (Interface)  
   ↑  
`GenericServlet` (Abstract Class)  
   ↑  
`HttpServlet` (Abstract Class - **We use this**)  
   ↑  
`YourServlet` (Your Class)

### 1. `Servlet` Interface
The root interface. Defines lifecycle methods: `init()`, `service()`, `destroy()`.

### 2. `GenericServlet`
Implements `Servlet`. Makes writing servlets easier but is protocol-independent (not just HTTP).

### 3. `HttpServlet`
Extends `GenericServlet`. Adds HTTP-specific methods like `doGet()`, `doPost()`, `doPut()`, etc.
*   **Key Feature**: It implements `service()` to automatically route requests to `doGet` or `doPost` based on the request type.

---

## 3. Execution Flow & Threading Model (The "How it Works")

Unlike normal Java programs that have a `main()` method, Servlets are controlled by the Container.

**Step-by-Step Execution:**

1.  **Initialization**: When the server starts (or on first request), the Container creates **ONE instance** of your Servlet.
    *   Calls `init()`.
2.  **Request Handling**:
    *   User sends a request.
    *   Container creates a new **Thread**.
    *   Container creates two objects:
        *   `HttpServletRequest`: Contains data (form inputs, URL parameters).
        *   `HttpServletResponse`: Empty object for you to fill with HTML.
    *   Container calls `service(request, response)`.
3.  **Routing**:
    *   `service()` checks the HTTP method (GET or POST).
    *   If GET -> calls `doGet()`.
    *   If POST -> calls `doPost()`.
4.  **Destruction**: When server stops, calls `destroy()`.

**Visualizing the Code Flow:**

```java
// 1. Container manages the class (YourServlet extends HttpServlet)
@WebServlet("/architecture-demo")
public class ArchitectureServlet extends HttpServlet {

    // 2. Container creates ONE instance. init() runs once.
    public void init() {
        System.out.println("Servlet Initialized (Memory Allocated)");
    }

    // 3. User sends GET request -> Container creates Thread -> Calls service() -> Calls doGet()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // request object: fetching data from the container
        String userIp = request.getRemoteAddr(); 
        
        // response object: sending data back to container -> client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Servlet Architecture Demo</h1>");
        out.println("<p>Your IP: " + userIp + "</p>");
        out.println("<p>This request is handled by a dedicated thread!</p>");
        out.println("</body></html>");
    }
    // 4. Thread dies, but Servlet instance remains in memory for next user.
}
```

---

## 4. Key Takeaways for Interviews

1.  **Single Instance, Multiple Threads**: The Servlet is **NOT** recreated for every user. One object handles all users using different threads.
    *   *Warning*: Do not use instance variables (global variables) to store user data (e.g., `String username;` at class level), because other users will overwrite it! Use local variables inside `doGet/doPost`.
2.  **Request/Response Objects**: These are created fresh for every single request.
3.  **Container Control**: You never write `new Servlet()`. The Tomcat container does it.
