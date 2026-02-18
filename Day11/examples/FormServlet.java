package com.example.day11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/submitContact") maps this class to the URL "submitContact"
// The HTML form action="submitContact" MUST match this specific string.
@WebServlet("/submitContact")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Set the response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 2. Retrieve data from the request using the "name" attribute from HTML
        String name = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String message = request.getParameter("userMessage");

        // 3. Process the data (Here, we just display it back)
        out.println("<html>");
        out.println("<head><title>Submission Success</title></head>");
        out.println("<body>");
        out.println("<h2>Thank you, " + name + "!</h2>");
        out.println("<p>We have received your message.</p>");
        out.println("<ul>");
        out.println("<li><b>Email:</b> " + email + "</li>");
        out.println("<li><b>Message:</b> " + message + "</li>");
        out.println("</ul>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
