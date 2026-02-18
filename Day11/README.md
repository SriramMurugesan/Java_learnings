# Day 11: HTML5 & Backend Connection

Welcome to Day 11! Today we bridge the gap between Frontend (HTML) and Backend (Java Servlets).

## 📚 Topics Covered
1.  **HTML5 Basics**
    - Important Tags for Static Pages.
    - Forms and Input elements.
2.  **Connecting Frontend to Backend**
    - How an HTML Form talks to a Java Servlet.
    - The role of the `action` attribute and `name` attributes.

## 📂 File Structure
- `html5_tags.md`: Cheat sheet of essential HTML5 tags.
- `html_to_servlet_setup.md`: **Crucial Guide** on setting up the connection.
- `examples/index.html`: A sample frontend page.
- `examples/FormServlet.java`: The backend servlet that handles the "Contact Us" form submission.

## 🚀 Key Concept: The Connection
The magic happens in the `<form>` tag:
```html
<form action="submitForm" method="post">
```
And in the Servlet:
```java
@WebServlet("/submitForm")
```
The **action** must match the **URL Mapping**!
