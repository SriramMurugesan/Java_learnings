package com.example.day10;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {

    // 1. Initialization: Called once when servlet is first loaded
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("--- init() method called: Servlet is being initialized ---");
        // Good place to open DB connections or read config files
    }

    // 2. Service: Called for every request (mapped to doGet/doPost)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        System.out.println("--- service() method called: Handling a request ---");
        // Calls doGet or doPost internally
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        System.out.println("--- doGet() method called ---");
        resp.getWriter().println("<h1>Check your server console for lifecycle logs!</h1>");
    }

    // 3. Destruction: Called once when servlet is stopped/undeployed
    @Override
    public void destroy() {
        System.out.println("--- destroy() method called: Servlet is being destroyed ---");
        // Good place to close DB connections
    }
}
