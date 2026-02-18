# Exercises - Day 11: HTML5 & Connectivity

## 1. The Registration Form
Create an HTML file `register.html` with a form that has:
- Username (text)
- Password (password)
- Age (number)
- Gender (radio buttons: Male/Female)
- "Register" button

Create a Servlet `RegistrationServlet` mapped to `/processRegistration`.
- Display all the submitted data in a table format in the response.
- **Challenge**: If the age is less than 18, show a message "You are too young!" in red color.

## 2. The Calculator
Create `calc.html`:
- Two input fields for numbers.
- A dropdown (`<select>`) to choose operation: Add, Subtract, Multiply, Divide.
- A "Calculate" button.

Create `CalculatorServlet`:
- Retrieve the two numbers and the operation.
- Perform the calculation.
- Display the result (e.g., "Result: 10 + 20 = 30").

## 3. The Login Redirect
- Create `login.html` (Username, Password).
- Create `LoginServlet`.
- Hardcode a valid username/password (e.g., "admin"/"admin").
- If valid -> Redirect to a new file `welcome.html` (You need to create this simple HTML file).
- If invalid -> Display "Invalid Login" and a link to go back to `login.html`.
