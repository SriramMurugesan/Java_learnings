# Servlet Environment Setup Guide

To run Servlets, you need two main things:
1.  **JDK (Java Development Kit)**: To compile Java code.
2.  **Servlet Container (Web Server)**: To run the servlets (e.g., Apache Tomcat).

---

## 1. Install Java (JDK)
Ensure you have **Java 8 or later** installed.

### 🪟 Windows
1.  Download JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [Adoptium](https://adoptium.net/).
2.  Run the installer (.exe).
3.  **Set Environment Variables**:
    - Search for "Edit the system environment variables".
    - Click **Environment Variables**.
    - Under **System Variables**, click **New**:
        - Variable name: `JAVA_HOME`
        - Variable value: `C:\Program Files\Java\jdk-17` (path to your JDK).
    - Find `Path` variable, click **Edit**, and add `%JAVA_HOME%\bin`.

### 🍎 macOS
1.  Download JDK from [Adoptium](https://adoptium.net/) (.pkg file) or use Homebrew:
    ```bash
    brew install openjdk
    ```
2.  **Verify**:
    ```bash
    java -version
    ```
    Usually, macOS handles paths automatically if installed via installer. If not, add this to `.zshrc`:
    ```bash
    export JAVA_HOME=$(/usr/libexec/java_home)
    ```

### 🐧 Linux (Ubuntu/Debian)
1.  Install via terminal:
    ```bash
    sudo apt update
    sudo apt install default-jdk
    ```
2.  **Verify**:
    ```bash
    java -version
    ```

---

## 2. Install Apache Tomcat (Servlet Container)
Tomcat is the server that will actually run your Servlet code.

### 🪟 Windows
1.  Download "Core" **ZIP** or **Service Installer** from [tomcat.apache.org](https://tomcat.apache.org/download-90.cgi) (Tomcat 9 or 10 is good).
2.  **If ZIP**: Extract to `C:\apache-tomcat-9.0.x`.
3.  **Set Environment Variable** (Optional but recommended):
    - Variable name: `CATALINA_HOME`
    - Variable value: `C:\apache-tomcat-9.0.x`
4.  **Start Server**:
    - Go to `bin` folder.
    - Double click `startup.bat`.
5.  Open Browser: `http://localhost:8080`.

### 🍎 macOS / 🐧 Linux
1.  Download "Core" **tar.gz** from [tomcat.apache.org](https://tomcat.apache.org/download-90.cgi).
2.  Extract it:
    ```bash
    tar -xzvf apache-tomcat-9.0.x.tar.gz
    sudo mv apache-tomcat-9.0.x /usr/local/tomcat
    ```
3.  **Make scripts executable**:
    ```bash
    cd /usr/local/tomcat/bin
    chmod +x *.sh
    ```
4.  **Start Server**:
    ```bash
    ./startup.sh
    ```
5.  Open Browser: `http://localhost:8080`.

---

## 3. Developing with VS Code (Manual Setup)

Since VS Code is just a text editor, it doesn't have built-in Tomcat integration like Eclipse/IntelliJ. You have two options:

### Option A: The "Manual Copy" Method (Good for understanding)
1.  Write your Java code in `src`.
2.  **Compile** your Servlet: You need the `servlet-api.jar` (found in `Tomcat/lib` folder) in your classpath.
    ```bash
    javac -cp .:/path/to/tomcat/lib/servlet-api.jar MyServlet.java
    ```
    *(Note: I have already downloaded a copy of `servlet-api.jar` into your project's `lib` folder to make compilation easier in VS Code).*
3.  **Deploy**:
    - Copy your compiled `.class` file to `Tomcat/webapps/ROOT/WEB-INF/classes/com/example/...`
    - Or create a WAR file.

### Option B: Maven Extension (Recommended for Real Projects)
1.  Install "Extension Pack for Java" in VS Code.
2.  Create a Maven Project.
3.  Add Tomcat server connector extension (e.g., "Community Server Connectors").
4.  Right-click project -> "Run on Server".

---

## Summary Checklist

| OS | Java Setup | Tomcat Setup | Start Command |
| :--- | :--- | :--- | :--- |
| **Windows** | Install exe, Set `JAVA_HOME` | Unzip, Set `CATALINA_HOME` | `bin\startup.bat` |
| **macOS** | Install pkg / `brew` | Unzip, `chmod +x` scripts | `bin/startup.sh` |
| **Linux** | `apt install default-jdk` | Unzip, `chmod +x` scripts | `bin/startup.sh` |
