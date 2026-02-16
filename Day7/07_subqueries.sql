-- ========================================
-- SESSION 5: SUBQUERIES
-- ========================================
-- Goal: Demystify subqueries
-- Time: 45 minutes

USE college;

-- ========================================
-- WHAT IS A SUBQUERY?
-- ========================================
-- A subquery is a "query inside another query"
-- It helps answer questions in steps

-- ========================================
-- BASIC SUBQUERIES
-- ========================================

-- 1. Find students who scored above 90
SELECT name
FROM students
WHERE student_id IN (
    SELECT student_id
    FROM marks
    WHERE score > 90
);

-- How it works:
-- Step 1: Inner query finds student_ids with score > 90
-- Step 2: Outer query gets names of those students

-- 2. Find students enrolled in 'Database Systems'
SELECT name
FROM students
WHERE student_id IN (
    SELECT student_id
    FROM enrollments
    WHERE course_id = (
        SELECT course_id
        FROM courses
        WHERE course_name = 'Database Systems'
    )
);

-- 3. Find courses with average score above 80
SELECT course_name
FROM courses
WHERE course_id IN (
    SELECT course_id
    FROM marks
    GROUP BY course_id
    HAVING AVG(score) > 80
);

-- ========================================
-- SUBQUERIES WITH COMPARISON OPERATORS
-- ========================================

-- 4. Find students who scored higher than average
SELECT s.name, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
WHERE m.score > (
    SELECT AVG(score)
    FROM marks
);

-- 5. Find the top scorer
SELECT s.name, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
WHERE m.score = (
    SELECT MAX(score)
    FROM marks
);

-- 6. Find students in the most popular department
SELECT name
FROM students
WHERE department = (
    SELECT department
    FROM students
    GROUP BY department
    ORDER BY COUNT(*) DESC
    LIMIT 1
);

-- ========================================
-- SUBQUERIES IN FROM CLAUSE
-- ========================================

-- 7. Get average score per student, then filter
SELECT *
FROM (
    SELECT s.name, AVG(m.score) AS avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.name
) AS student_averages
WHERE avg_score > 85;

-- ========================================
-- EXISTS - Check if subquery returns results
-- ========================================

-- 8. Find students who have enrolled in at least one course
SELECT name
FROM students s
WHERE EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

-- 9. Find students who have NOT enrolled in any course
SELECT name
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

-- ========================================
-- PRACTICAL EXAMPLES
-- ========================================

-- 10. Find students who scored above their department's average
SELECT s.name, s.department, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
WHERE m.score > (
    SELECT AVG(m2.score)
    FROM students s2
    JOIN marks m2 ON s2.student_id = m2.student_id
    WHERE s2.department = s.department
);

-- 11. Find courses that have more enrollments than average
SELECT c.course_name, COUNT(*) AS enrollment_count
FROM courses c
JOIN enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name
HAVING COUNT(*) > (
    SELECT AVG(enrollment_count)
    FROM (
        SELECT COUNT(*) AS enrollment_count
        FROM enrollments
        GROUP BY course_id
    ) AS avg_enrollments
);

-- 12. Find students who scored 100% in at least one course
SELECT DISTINCT s.name
FROM students s
WHERE s.student_id IN (
    SELECT student_id
    FROM marks
    WHERE score = 100
);

-- ========================================
-- PRACTICE QUESTIONS
-- ========================================
-- Try to write queries for these:

-- Q1: Find students who scored below average
-- Q2: Find courses with enrollment count above average
-- Q3: Find the lowest scorer's name and score
-- Q4: Find students in departments with more than 5 students
-- Q5: Find courses where no one scored below 70

-- ========================================
-- KEY CONCEPTS
-- ========================================
-- Subquery: Query inside another query
-- 
-- Types:
-- 1. IN: Check if value exists in subquery results
-- 2. Comparison (=, >, <): Compare with single value
-- 3. EXISTS: Check if subquery returns any rows
-- 4. FROM: Use subquery result as a table
--
-- When to use:
-- - When you need to filter based on aggregated data
-- - When the question has multiple steps
-- - When you want to compare with calculated values
--
-- Pro Tip: If subquery is complex, consider using CTE (next session!)
