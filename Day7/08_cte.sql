-- ========================================
-- SESSION 6: COMMON TABLE EXPRESSIONS (CTE)
-- ========================================
-- Goal: Simplify complex queries
-- Time: 45 minutes

USE college;

-- ========================================
-- WHAT IS A CTE?
-- ========================================
-- CTE = "Common Table Expression"
-- Think of it as a "temporary named result"
-- It makes complex queries easier to read and write
--
-- Syntax:
-- WITH cte_name AS (
--     SELECT ...
-- )
-- SELECT * FROM cte_name;

-- ========================================
-- BASIC CTE EXAMPLES
-- ========================================

-- 1. Find students with average score above 80
WITH student_averages AS (
    SELECT s.student_id, s.name, AVG(m.score) AS avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.student_id, s.name
)
SELECT name, avg_score
FROM student_averages
WHERE avg_score > 80
ORDER BY avg_score DESC;

-- 2. Find courses with average score above 80
WITH course_averages AS (
    SELECT c.course_id, c.course_name, AVG(m.score) AS avg_score
    FROM courses c
    JOIN marks m ON c.course_id = m.course_id
    GROUP BY c.course_id, c.course_name
)
SELECT course_name, avg_score
FROM course_averages
WHERE avg_score > 80;

-- ========================================
-- MULTIPLE CTEs
-- ========================================

-- 3. Compare student averages with course averages
WITH student_avg AS (
    SELECT student_id, AVG(score) AS avg_score
    FROM marks
    GROUP BY student_id
),
course_avg AS (
    SELECT course_id, AVG(score) AS avg_score
    FROM marks
    GROUP BY course_id
)
SELECT 
    s.name,
    sa.avg_score AS student_avg,
    c.course_name,
    ca.avg_score AS course_avg
FROM student_avg sa
JOIN students s ON sa.student_id = s.student_id
JOIN marks m ON s.student_id = m.student_id
JOIN course_avg ca ON m.course_id = ca.course_id
JOIN courses c ON ca.course_id = c.course_id;

-- ========================================
-- CTE VS SUBQUERY - Same Result, Better Readability
-- ========================================

-- 4a. Using Subquery (harder to read)
SELECT *
FROM (
    SELECT s.name, AVG(m.score) AS avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.name
) AS student_averages
WHERE avg_score > 85;

-- 4b. Using CTE (easier to read)
WITH student_averages AS (
    SELECT s.name, AVG(m.score) AS avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.name
)
SELECT *
FROM student_averages
WHERE avg_score > 85;

-- ========================================
-- PRACTICAL EXAMPLES
-- ========================================

-- 5. Find top performers (above department average)
WITH dept_avg AS (
    SELECT s.department, AVG(m.score) AS avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.department
)
SELECT s.name, s.department, m.score, da.avg_score AS dept_avg
FROM students s
JOIN marks m ON s.student_id = m.student_id
JOIN dept_avg da ON s.department = da.department
WHERE m.score > da.avg_score
ORDER BY s.department, m.score DESC;

-- 6. Rank courses by popularity and performance
WITH course_stats AS (
    SELECT 
        c.course_name,
        COUNT(e.student_id) AS enrollment_count,
        AVG(m.score) AS avg_score
    FROM courses c
    LEFT JOIN enrollments e ON c.course_id = e.course_id
    LEFT JOIN marks m ON c.course_id = m.course_id
    GROUP BY c.course_name
)
SELECT 
    course_name,
    enrollment_count,
    ROUND(avg_score, 2) AS avg_score
FROM course_stats
ORDER BY enrollment_count DESC, avg_score DESC;

-- 7. Find students performing below their course average
WITH course_avg AS (
    SELECT course_id, AVG(score) AS avg_score
    FROM marks
    GROUP BY course_id
)
SELECT s.name, c.course_name, m.score, ca.avg_score
FROM students s
JOIN marks m ON s.student_id = m.student_id
JOIN courses c ON m.course_id = c.course_id
JOIN course_avg ca ON c.course_id = ca.course_id
WHERE m.score < ca.avg_score
ORDER BY c.course_name, m.score;

-- ========================================
-- ADVANCED: RECURSIVE CTE (Bonus)
-- ========================================

-- 8. Generate a sequence of numbers 1 to 10
WITH RECURSIVE numbers AS (
    SELECT 1 AS n
    UNION ALL
    SELECT n + 1
    FROM numbers
    WHERE n < 10
)
SELECT * FROM numbers;

-- ========================================
-- REAL-WORLD USE CASES
-- ========================================

-- 9. Student Performance Report
WITH student_stats AS (
    SELECT 
        s.student_id,
        s.name,
        s.department,
        COUNT(m.course_id) AS courses_taken,
        AVG(m.score) AS avg_score,
        MAX(m.score) AS best_score,
        MIN(m.score) AS worst_score
    FROM students s
    LEFT JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.student_id, s.name, s.department
)
SELECT 
    name,
    department,
    courses_taken,
    ROUND(avg_score, 2) AS avg_score,
    best_score,
    worst_score,
    CASE
        WHEN avg_score >= 90 THEN 'Excellent'
        WHEN avg_score >= 80 THEN 'Good'
        WHEN avg_score >= 70 THEN 'Average'
        ELSE 'Needs Improvement'
    END AS performance_grade
FROM student_stats
ORDER BY avg_score DESC;

-- ========================================
-- PRACTICE QUESTIONS
-- ========================================
-- Try to write queries using CTE:

-- Q1: Find departments with average score above 80
-- Q2: List students who scored above overall average in all their courses
-- Q3: Find courses where all students scored above 70
-- Q4: Create a report showing course-wise top scorer
-- Q5: Find students who are in top 25% by average score

-- ========================================
-- KEY CONCEPTS
-- ========================================
-- CTE Benefits:
-- 1. Makes queries easier to read
-- 2. Can be referenced multiple times
-- 3. Better than subqueries for complex logic
-- 4. Can be recursive (advanced)
--
-- Syntax:
-- WITH cte_name AS (query)
-- SELECT * FROM cte_name;
--
-- Multiple CTEs:
-- WITH cte1 AS (...),
--      cte2 AS (...)
-- SELECT ...
--
-- When to use CTE:
-- - Complex queries with multiple steps
-- - When you need to reference same subquery multiple times
-- - When you want to make code more readable
-- - For recursive operations (hierarchical data)
