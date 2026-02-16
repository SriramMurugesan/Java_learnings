-- ========================================
-- SESSION 2: SELECT + FILTERING
-- ========================================
-- Goal: Build confidence with basic queries
-- Time: 1 hour

USE college;

-- ========================================
-- BASIC SELECT
-- ========================================

-- 1. View all students
SELECT * FROM students;

-- 2. View only student names
SELECT name FROM students;

-- 3. View names and departments
SELECT name, department FROM students;

-- 4. View all courses
SELECT * FROM courses;

-- ========================================
-- FILTERING WITH WHERE
-- ========================================

-- 5. Find students in CSE department
SELECT * FROM students WHERE department = 'CSE';

-- 6. Find students in year 1
SELECT * FROM students WHERE year = 1;

-- 7. Find students scoring above 80
SELECT * FROM marks WHERE score > 80;

-- 8. Find students scoring exactly 85
SELECT * FROM marks WHERE score = 85;

-- 9. Find students scoring 70 or below
SELECT * FROM marks WHERE score <= 70;

-- ========================================
-- SORTING WITH ORDER BY
-- ========================================

-- 10. List students alphabetically by name
SELECT * FROM students ORDER BY name;

-- 11. List students by name in reverse order
SELECT * FROM students ORDER BY name DESC;

-- 12. List marks from highest to lowest
SELECT * FROM marks ORDER BY score DESC;

-- 13. List marks from lowest to highest
SELECT * FROM marks ORDER BY score ASC;

-- ========================================
-- COMBINING WHERE AND ORDER BY
-- ========================================

-- 14. CSE students sorted by name
SELECT * FROM students 
WHERE department = 'CSE' 
ORDER BY name;

-- 15. High scorers (above 85) sorted by score
SELECT * FROM marks 
WHERE score > 85 
ORDER BY score DESC;

-- 16. First year students sorted by department
SELECT * FROM students 
WHERE year = 1 
ORDER BY department, name;

-- ========================================
-- USING DISTINCT
-- ========================================

-- 17. List all unique departments
SELECT DISTINCT department FROM students;

-- 18. List all unique years
SELECT DISTINCT year FROM students;

-- ========================================
-- LIMITING RESULTS
-- ========================================

-- 19. Show top 5 scorers
SELECT * FROM marks 
ORDER BY score DESC 
LIMIT 5;

-- 20. Show bottom 3 scorers
SELECT * FROM marks 
ORDER BY score ASC 
LIMIT 3;

-- ========================================
-- PRACTICE QUESTIONS
-- ========================================
-- Try to write queries for these:

-- Q1: Find all ECE students
-- Q2: Find all students in year 3
-- Q3: Find all scores below 75
-- Q4: List all students sorted by year
-- Q5: Show top 10 scorers

-- ========================================
-- EXPLANATION
-- ========================================
-- SELECT: Choose which columns to display
-- FROM: Which table to get data from
-- WHERE: Filter rows based on conditions
-- ORDER BY: Sort results (ASC = ascending, DESC = descending)
-- LIMIT: Restrict number of results
-- DISTINCT: Remove duplicates
--
-- Operators:
-- = (equal), > (greater), < (less), >= (greater or equal), <= (less or equal)
-- != or <> (not equal)
