# Introduction to Servlets

## 1. Introduction to Servlets
A **Servlet** is a Java class that runs on a web server and responds to HTTP requests.

- **Purpose**: It extends the capabilities of a server (like Apache Tomcat).
- **Function**: It receives a request from a client (browser), processes it (e.g., talks to a database), and sends a response (HTML, JSON, etc.) back to the client.
- **Key Feature**: Unlike CGI (Common Gateway Interface), where each request started a new process, Servlets are efficient because they use **threads** (one thread per request).

## 2. Web Application Architecture
A Web Application follows the **Client-Server Architecture**.

### The Flow:
1.  **Client (Browser)**: User types a URL or clicks a button. The browser sends an **HTTP Request**.
2.  **Server (Web Server/App Server)**: Receives the request.
3.  **Servlet Container (Web Container)**:
    - Identifies which Servlet should handle the request (based on URL mapping).
    - Creates a thread for the request.
    - Calls the Servlet's methods (`service()`, `doGet()`, `doPost()`).
4.  **Database (Optional)**: If data is needed, the Servlet connects to the Database using JDBC.
5.  **Servlet**: Generates dynamic content (HTML).
6.  **Response**: The server sends the **HTTP Response** back to the client.

\[Browser] -> [Request] -> [Web Server + Container] -> [Servlet] -> [Database]
                                           |             ^
                                           |             |
                                           v             |
                                      [Response] <-------+

## 3. Server Architecture
A Server is software that serves content.

- **Web Server**: Handles static content (HTML, CSS, Images). Examples: Apache HTTP Server, Nginx.
- **Application Server**: Handles dynamic content and business logic (Servlets, JSPs, EJBs). Examples: JBoss, WebLogic, GlassFish.
- **Servlet Container (Web Container)**: A part of the web server that interacts with Java Servlets. It manages the lifecycle of servlets. The most popular one is **Apache Tomcat**.

**Tomcat** acts as both a Web Server (for development) and a Servlet Container.
