#!/bin/bash
# Compile FormServlet.java with the servlet-api.jar in the classpath
# This requires running from the directory where FormServlet.java is located (Day11/examples)

javac -cp ".:../../lib/servlet-api.jar" FormServlet.java
echo "Compilation complete. FormServlet.class created."
