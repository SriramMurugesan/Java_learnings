# Setup Guide: Connecting HTML to Servlets

This is the bridge between the Frontend (HTML) and the Backend (Java).

## 1. The Concept
1.  User enters data in an **HTML Form**.
2.  User clicks "Submit".
3.  Browser packs the data and sends an **HTTP Request** to the URL specified in the form's `action`.
4.  Server receives the request and looks for a **Servlet** mapped to that URL.
5.  Servlet processes the data and sends back a response.

## 2. The HTML Side (`index.html`)
You need a `<form>` tag with two important attributes:
- **action**: The URL of the Servlet (e.g., `"register"`).
- **method**: The HTTP method (`"GET"` or `"POST"`).

You also need `name` attributes for every input field. The Servlet uses these names to grab the values.

```html
<form action="register" method="post">
    Username: <input type="text" name="txtUser"> <br>
    Password: <input type="password" name="txtPass"> <br>
    <input type="submit" value="Register">
</form>
```

## 3. The Servlet Side (`RegisterServlet.java`)
You need to map the Servlet to the URL used in the HTML `action`.

**Using Annotation (Modern Way):**
```java
@WebServlet("/register") 
public class RegisterServlet extends HttpServlet { ... }
```
*Note: The slash `/` is required in the annotation, but usually not in the HTML action if relative pathing is used.*

## 4. Retrieving Data in Servlet
Inside `doPost()` (since method="post"), use `request.getParameter("name_attribute")`.

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    // "txtUser" connects to name="txtUser" in HTML
    String u = request.getParameter("txtUser"); 
    String p = request.getParameter("txtPass");
    
    // Process data...
}
```

## 5. Common Mistakes
1.  **Mismatching Action and URL Pattern**: `action="reg"` but `@WebServlet("/register")`. They must match!
2.  **Missing Name Attribute**: If `<input>` has no `name`, the Servlet cannot read it.
3.  **Method Mismatch**: Form sends `POST` but Servlet only has `doGet()`. result: **405 Method Not Allowed**.
4.  **Directory Structure**: The HTML file usually goes in `src/main/webapp` (Standard Maven) or `WebContent`. The Java file goes in `src/main/java`.
