package com.example.day10;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handleRequest")
public class RequestHandlingServlet extends HttpServlet {

    // Helper method to simulate checking if a user is valid
    private boolean isValidUser(String username) {
        return "admin".equals(username);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // This handles "http://localhost:8080/myapp/handleRequest?action=search&q=java"

        String action = request.getParameter("action");

        if ("redirect".equals(action)) {
            // SEND REDIRECT: Redirects browser to Google (Client-side redirect)
            // Useful for external links
            response.sendRedirect("https://www.google.com");

        } else {
            // REQUEST DISPATCHER: Forwards request to another internal resource
            // (Server-side forward)
            // Useful for internal navigation like MVC
            request.setAttribute("message", "Forwarding to internal page...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/internalPage.jsp");

            // Note: Since we don't have the JSP, this will fail at runtime if run.
            // dispatcher.forward(request, response);

            response.getWriter().println("Recieved GET request with action: " + action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // This handles form submissions

        String username = request.getParameter("username");

        if (isValidUser(username)) {
            // Successful login -> Redirect to dashboard
            // Why Redirect? To prevent re-submission if user refreshes the page (PRG
            // Pattern)
            response.sendRedirect("dashboard.jsp");
        } else {
            // Failed login -> Forward back to login page with error
            // Why Forward? To keep the data and show error on same page
            request.setAttribute("error", "Invalid Credentials");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
