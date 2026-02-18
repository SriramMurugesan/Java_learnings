# Servlet Life Cycle

The Servlet Life Cycle is managed by the **Servlet Container** (e.g., Tomcat). A Servlet goes through three main phases:

1.  **Creation**: The container loads the Servlet class and creates an instance.
2.  **Initialization**: The container calls the `init()` method.
3.  **Service (Request Handling)**: For every request, the container calls the `service()` method.
4.  **Destruction**: When the container shuts down or the Servlet is removed, `destroy()` is called.

## 1. init() Method (Initialization)
- **Signature**: `void init(ServletConfig config)`
- **When Called**: Only **once**, when the Servlet is first loaded.
- **Purpose**: To perform one-time initialization tasks (e.g., connecting to a database, reading configuration parameters).
- **Thread Safety**: It is single-threaded (called by the container before any requests are served).

**Why do we need init()?**
Think of `init()` like a constructor but specifically for Servlets. Instead of initializing resources every time a request comes in (which is slow), we do it once during startup.

## 2. service() Method (Request Processing)
- **Signature**: `void service(ServletRequest req, ServletResponse res)`
- **When Called**: Every time a client sends a request.
- **Purpose**: To handle the request. This method checks the HTTP method (GET, POST, etc.) and forwards the request to the appropriate method (`doGet`, `doPost`).
- **Thread Safety**: **NOT Thread Safe**. Each request runs in its own thread. If multiple users access the Servlet simultaneously, multiple threads will execute `service()` concurrently on the same Servlet instance.

**Why do we need service()?**
It acts as the traffic controller. It decides *how* to handle the request based on the type (GET, POST, PUT, DELETE). Usually, you don't override `service()` directly unless you want to handle all request types in a generic way. Instead, you override `doGet()` or `doPost()`.

## 3. destroy() Method (Shutdown)
- **Signature**: `void destroy()`
- **When Called**: Only **once**, when the Servlet is being taken out of service (e.g., server shutdown or undeployment).
- **Purpose**: To clean up resources initialized in `init()` (e.g., closing database connections, stopping background threads).

**Why do we need destroy()?**
To ensure resources are released properly and avoid memory leaks. It's the "cleanup crew".

---

## Summary Table

| Method | Called | Purpose | Thread Safety |
| :--- | :--- | :--- | :--- |
| `init()` | Once | Initialization (DB connection, config) | Single-threaded |
| `service()` | Many times (per request) | Dispatch request to doGet/doPost | Multi-threaded (careful!) |
| `destroy()` | Once | Cleanup resources | Single-threaded |
