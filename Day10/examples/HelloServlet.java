package com.example.day10;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet annotation maps this servlet to the URL "/hello"
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    // This method handles GET requests (e.g., typing URL in browser)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set the content type of the response to HTML
        response.setContentType("text/html");
                
        // Get the writer to modify response body
        PrintWriter out = response.getWriter();
        
        // Write HTML content
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<p>This is my first Servlet.</p>");
        out.println("</body></html>");
    }
}
