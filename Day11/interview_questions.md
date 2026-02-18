# Interview Questions - Day 11: HTML & Servlet Connection

## 1. What is the function of the `action` attribute in an HTML Form?
The `action` attribute specifies the **URL** (or destination) where the form data should be sent when the user clicks submit. This URL must match the mappings defined in your Servlet (e.g., via `@WebServlet`).

## 2. What happens if I don't provide a `method` attribute in `<form>`?
The default method is **GET**. The form data will be appended to the URL as query parameters.

## 3. Why is `name` attribute important in input tags?
The `name` attribute is the **key** used by the server to identify the data.
- HTML: `<input name="foobar">`
- Java: `request.getParameter("foobar")`
If "name" is missing, the Servlet cannot retrieve that field's value.

## 4. Can a Servlet handle both GET and POST requests?
Yes. You can override both `doGet()` and `doPost()`. Often, developers act smart and call `doGet()` from inside `doPost()` (or vice-versa) to handle both methods with the same logic.

## 5. What is the difference between `Parameter` and `Attribute`?
- **Parameter** (`request.getParameter()`): String data sent from the **Client** (HTML form, URL query string). Read-only for the Servlet.
- **Attribute** (`request.getAttribute()`): Objects set by the **Server** (Servlet) to pass data to another internal resource (like a JSP). Can be any Java Object.

## 6. What format is data sent in a POST request?
It is sent in the **body** of the HTTP request, not in the URL. This allows for sending large amounts of data (like files) and is more secure for sensitive info (like passwords).
