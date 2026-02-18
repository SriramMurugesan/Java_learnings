# Day 10: Introduction to Servlets

Welcome to Day 10! Today we dive into **Servlets**, the foundation of Java Web Development.

## 📚 Topics Covered
1.  **Introduction to Servlets**
    - What are Servlets?
    - Web Application Architecture
    - Server Architecture
2.  **Servlet Life Cycle**
    - `init()`, `service()`, `destroy()`
3.  **Request Handling**
    - `doGet` vs `doPost`
    - `RequestDispatcher` vs `SendRedirect`
4.  **Database Integration**
    - Connecting Servlets to JDBC

## 📂 File Structure
- `servlet_setup_guide.md`: **Installation Instructions** for Windows, Mac, and Linux.
- `servlet_intro.md`: Theory on Servlets and Architecture.
- `servlet_lifecycle.md`: Explanation of the Life Cycle methods.
- `request_handling.md`: Deep dive into handling HTTP requests.
- `jdbc_integration.md`: How to connect a Servlet to a Database.
- `examples/`: Simple Java files demonstrating the concepts.

## 🚀 Getting Started
Servlets run inside a **Servlet Container** (like Apache Tomcat). You cannot run them as standalone Java applications (no `public static void main`).

To run these examples, you would typically:
1.  Set up a project with a structure (e.g., Maven or standard Web App structure).
2.  Compile the classes with the Servlet API in the classpath.
3.  Deploy them to a server like Tomcat.

For learning purposes, focus on understanding the **methods** and the **flow of execution**.
