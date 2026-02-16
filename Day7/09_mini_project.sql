-- ========================================
-- SESSION 7: MINI PROJECT TASKS
-- ========================================
-- Goal: Make students feel like experts!

USE college;

-- ========================================
-- INSTRUCTIONS
-- ========================================
-- Try to solve these problems on your own first
-- Solutions are provided below
-- Use any technique: JOIN, subquery, CTE, GROUP BY, etc.

-- ========================================
-- PROBLEM 1: List students with course names
-- ========================================
-- Show: student name, course name
-- Sort by: student name

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
SELECT s.name AS student_name, c.course_name
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
JOIN courses c ON e.course_id = c.course_id
ORDER BY s.name;

-- ========================================
-- PROBLEM 2: Find top scorer
-- ========================================
-- Show: student name, course name, score
-- Find: The highest score in the database

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
SELECT s.name, c.course_name, m.score
FROM students s
JOIN marks m ON s.student_id = m.student_id
JOIN courses c ON m.course_id = c.course_id
WHERE m.score = (SELECT MAX(score) FROM marks);

-- ========================================
-- PROBLEM 3: Average marks per course
-- ========================================
-- Show: course name, average score
-- Sort by: average score (highest first)

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
SELECT c.course_name, AVG(m.score) AS average_score
FROM courses c
JOIN marks m ON c.course_id = m.course_id
GROUP BY c.course_name
ORDER BY average_score DESC;

-- ========================================
-- PROBLEM 4: Students not enrolled in any course
-- ========================================
-- Show: student name, department
-- Find: Students with no enrollments

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION (Method 1 - LEFT JOIN):
SELECT s.name, s.department
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
WHERE e.course_id IS NULL;

-- OFFICIAL SOLUTION (Method 2 - NOT EXISTS):
SELECT s.name, s.department
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

-- ========================================
-- PROBLEM 5: Course with highest average
-- ========================================
-- Show: course name, average score
-- Find: The course with the best average score

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION (Method 1 - LIMIT):
SELECT c.course_name, AVG(m.score) AS avg_score
FROM courses c
JOIN marks m ON c.course_id = m.course_id
GROUP BY c.course_name
ORDER BY avg_score DESC
LIMIT 1;

-- OFFICIAL SOLUTION (Method 2 - Subquery):
SELECT c.course_name, AVG(m.score) AS avg_score
FROM courses c
JOIN marks m ON c.course_id = m.course_id
GROUP BY c.course_name
HAVING AVG(m.score) = (
    SELECT MAX(avg_score)
    FROM (
        SELECT AVG(score) AS avg_score
        FROM marks
        GROUP BY course_id
    ) AS course_averages
);

-- ========================================
-- BONUS CHALLENGES
-- ========================================

-- CHALLENGE 6: Department-wise performance
-- Show: department, number of students, average score
-- Sort by: average score (highest first)

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
SELECT 
    s.department,
    COUNT(DISTINCT s.student_id) AS student_count,
    ROUND(AVG(m.score), 2) AS avg_score
FROM students s
JOIN marks m ON s.student_id = m.student_id
GROUP BY s.department
ORDER BY avg_score DESC;

-- ========================================
-- CHALLENGE 7: Students taking multiple courses
-- ========================================
-- Show: student name, number of courses
-- Find: Students enrolled in more than 1 course

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
SELECT s.name, COUNT(e.course_id) AS course_count
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
GROUP BY s.name
HAVING COUNT(e.course_id) > 1
ORDER BY course_count DESC;

-- ========================================
-- CHALLENGE 8: Top 3 students per course
-- ========================================
-- Show: course name, student name, score
-- Find: Top 3 scorers in each course

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION (Using CTE and Window Function):
WITH ranked_scores AS (
    SELECT 
        c.course_name,
        s.name,
        m.score,
        ROW_NUMBER() OVER (PARTITION BY c.course_id ORDER BY m.score DESC) AS rank_num
    FROM marks m
    JOIN students s ON m.student_id = s.student_id
    JOIN courses c ON m.course_id = c.course_id
)
SELECT course_name, name, score
FROM ranked_scores
WHERE rank_num <= 3
ORDER BY course_name, rank_num;

-- ========================================
-- CHALLENGE 9: Students above department average
-- ========================================
-- Show: student name, department, their average, department average
-- Find: Students performing above their department's average

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
WITH dept_avg AS (
    SELECT s.department, AVG(m.score) AS dept_avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.department
),
student_avg AS (
    SELECT s.student_id, s.name, s.department, AVG(m.score) AS student_avg_score
    FROM students s
    JOIN marks m ON s.student_id = m.student_id
    GROUP BY s.student_id, s.name, s.department
)
SELECT 
    sa.name,
    sa.department,
    ROUND(sa.student_avg_score, 2) AS student_avg,
    ROUND(da.dept_avg_score, 2) AS dept_avg
FROM student_avg sa
JOIN dept_avg da ON sa.department = da.department
WHERE sa.student_avg_score > da.dept_avg_score
ORDER BY sa.department, sa.student_avg_score DESC;

-- ========================================
-- CHALLENGE 10: Complete Student Report Card
-- ========================================
-- Show: student name, department, all courses with scores, average, grade
-- Create a comprehensive report

-- YOUR SOLUTION HERE:


-- OFFICIAL SOLUTION:
WITH student_details AS (
    SELECT 
        s.student_id,
        s.name,
        s.department,
        s.year,
        GROUP_CONCAT(CONCAT(c.course_name, ': ', m.score) SEPARATOR ', ') AS courses_scores,
        AVG(m.score) AS avg_score,
        COUNT(m.course_id) AS total_courses
    FROM students s
    LEFT JOIN marks m ON s.student_id = m.student_id
    LEFT JOIN courses c ON m.course_id = c.course_id
    GROUP BY s.student_id, s.name, s.department, s.year
)
SELECT 
    name,
    department,
    year,
    total_courses,
    courses_scores,
    ROUND(avg_score, 2) AS average_score,
    CASE
        WHEN avg_score >= 90 THEN 'A+ (Excellent)'
        WHEN avg_score >= 80 THEN 'A (Very Good)'
        WHEN avg_score >= 70 THEN 'B (Good)'
        WHEN avg_score >= 60 THEN 'C (Average)'
        ELSE 'D (Needs Improvement)'
    END AS grade
FROM student_details
ORDER BY avg_score DESC;

-- ========================================
-- CONGRATULATIONS!
-- ========================================
-- If you solved these problems, you now understand:
-- ✅ JOINs (combining tables)
-- ✅ GROUP BY (summarizing data)
-- ✅ Subqueries (nested queries)
-- ✅ CTEs (readable complex queries)
-- ✅ Aggregate functions (COUNT, AVG, MAX, MIN)
-- ✅ Window functions (ROW_NUMBER, PARTITION BY)
--
-- You are now ready to work with SQL in real projects!
--
-- Next Steps:
-- 1. Practice these queries with different datasets
-- 2. Learn about indexes and query optimization
-- 3. Explore stored procedures and triggers
-- 4. Study database design and normalization
--
-- Keep practicing! 🚀
