-- ========================================
-- SESSION 3: JOINS (MOST IMPORTANT!)
-- ========================================
-- Goal: Understand how to combine data from multiple tables
-- Time: 1 hour

USE college;

-- ========================================
-- THE STORY: Why do we need JOINS?
-- ========================================
-- Data is split into different tables to avoid duplication.
-- JOIN combines them to get meaningful information.
--
-- Example: To know "Which course is Arun enrolled in?"
-- - Student name is in 'students' table
-- - Course name is in 'courses' table
-- - The link is in 'enrollments' table
-- We need to JOIN all three!

-- ========================================
-- INNER JOIN - Most Common
-- ========================================

-- 1. List students with their enrolled course names
SELECT s.name, c.course_name
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id;

-- Explanation:
-- s = alias for students table
-- e = alias for enrollments table
-- c = alias for courses table
-- ON = condition to match rows

-- 2. Show student name, course name, and score
SELECT s.name, c.course_name, m.score
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id
JOIN marks m ON s.student_id = m.student_id AND c.course_id = m.course_id;

-- 3. Show only CSE students with their courses
SELECT s.name, c.course_name
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id
WHERE s.department = 'CSE';

-- 4. Show students who scored above 85 with course names
SELECT s.name, c.course_name, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
JOIN courses c ON m.course_id = c.course_id
WHERE m.score > 85;

-- ========================================
-- LEFT JOIN - Include all from left table
-- ========================================

-- 5. Show ALL students, even if not enrolled in any course
SELECT s.name, c.course_name
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
LEFT JOIN courses c ON e.course_id = c.course_id;

-- Note: If a student has no enrollment, course_name will be NULL

-- 6. Find students who are NOT enrolled in any course
SELECT s.name
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
WHERE e.course_id IS NULL;

-- ========================================
-- RIGHT JOIN - Include all from right table
-- ========================================

-- 7. Show ALL courses, even if no student enrolled
SELECT c.course_name, s.name
FROM students s
RIGHT JOIN enrollments e ON s.student_id = e.student_id
RIGHT JOIN courses c ON e.course_id = c.course_id;

-- ========================================
-- PRACTICAL EXAMPLES
-- ========================================

-- 8. List all CSE courses with enrolled students
SELECT c.course_name, s.name
FROM courses c
JOIN enrollments e ON c.course_id = e.course_id
JOIN students s ON e.student_id = s.student_id
WHERE c.department = 'CSE'
ORDER BY c.course_name, s.name;

-- 9. Show student name, department, course, and score
SELECT s.name, s.department, c.course_name, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
JOIN courses c ON m.course_id = c.course_id
ORDER BY s.name;

-- 10. Find students enrolled in 'Database Systems'
SELECT s.name, s.department
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id
WHERE c.course_name = 'Database Systems';

-- ========================================
-- PRACTICE QUESTIONS
-- ========================================
-- Try to write queries for these:

-- Q1: List all ECE students with their courses
-- Q2: Show all students who scored above 90 with course names
-- Q3: Find all courses taken by student 'Priya'
-- Q4: List students enrolled in 'Circuit Theory'
-- Q5: Show all MECH students with their scores

-- ========================================
-- KEY CONCEPTS
-- ========================================
-- INNER JOIN: Only matching rows from both tables
-- LEFT JOIN: All rows from left table + matching from right
-- RIGHT JOIN: All rows from right table + matching from left
--
-- ON clause: Specifies how tables are related
-- Aliases (s, e, c): Make queries shorter and readable
--
-- Real World Use:
-- - E-commerce: Join customers with orders
-- - Banking: Join accounts with transactions
-- - Social Media: Join users with posts
