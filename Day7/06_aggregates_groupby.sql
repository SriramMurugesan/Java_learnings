-- ========================================
-- SESSION 4: AGGREGATE FUNCTIONS + GROUP BY
-- ========================================
-- Goal: Learn to summarize and analyze data
-- Time: 1 hour

USE college;

-- ========================================
-- AGGREGATE FUNCTIONS
-- ========================================

-- 1. COUNT - How many students?
SELECT COUNT(*) AS total_students FROM students;

-- 2. COUNT - How many enrollments?
SELECT COUNT(*) AS total_enrollments FROM enrollments;

-- 3. AVG - Average score across all marks
SELECT AVG(score) AS average_score FROM marks;

-- 4. MAX - Highest score
SELECT MAX(score) AS highest_score FROM marks;

-- 5. MIN - Lowest score
SELECT MIN(score) AS lowest_score FROM marks;

-- 6. SUM - Total of all scores
SELECT SUM(score) AS total_score FROM marks;

-- ========================================
-- GROUP BY - Grouping Data
-- ========================================

-- 7. Count students in each department
SELECT department, COUNT(*) AS student_count
FROM students
GROUP BY department;

-- 8. Count students in each year
SELECT year, COUNT(*) AS student_count
FROM students
GROUP BY year
ORDER BY year;

-- 9. Average score per course
SELECT course_id, AVG(score) AS avg_score
FROM marks
GROUP BY course_id;

-- 10. Average score per course with course names
SELECT c.course_name, AVG(m.score) AS avg_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name
ORDER BY avg_score DESC;

-- ========================================
-- ADVANCED GROUP BY
-- ========================================

-- 11. Highest score in each course
SELECT c.course_name, MAX(m.score) AS highest_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name;

-- 12. Lowest score in each course
SELECT c.course_name, MIN(m.score) AS lowest_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name;

-- 13. Count enrollments per course
SELECT c.course_name, COUNT(*) AS enrollment_count
FROM enrollments e
JOIN courses c ON e.course_id = c.course_id
GROUP BY c.course_name
ORDER BY enrollment_count DESC;

-- 14. Average score per student
SELECT s.name, AVG(m.score) AS avg_score
FROM students s
JOIN marks m ON s.student_id = m.student_id
GROUP BY s.name
ORDER BY avg_score DESC;

-- ========================================
-- HAVING - Filtering Groups
-- ========================================

-- 15. Courses with average score above 80
SELECT c.course_name, AVG(m.score) AS avg_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name
HAVING AVG(m.score) > 80;

-- 16. Students with average score above 85
SELECT s.name, AVG(m.score) AS avg_score
FROM students s
JOIN marks m ON s.student_id = m.student_id
GROUP BY s.name
HAVING AVG(m.score) > 85;

-- 17. Departments with more than 3 students
SELECT department, COUNT(*) AS student_count
FROM students
GROUP BY department
HAVING COUNT(*) > 3;

-- ========================================
-- REAL-WORLD QUESTIONS
-- ========================================

-- 18. Which course has the highest average score?
SELECT c.course_name, AVG(m.score) AS avg_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name
ORDER BY avg_score DESC
LIMIT 1;

-- 19. Which department has the most students?
SELECT department, COUNT(*) AS student_count
FROM students
GROUP BY department
ORDER BY student_count DESC
LIMIT 1;

-- 20. Show course-wise statistics (count, avg, max, min)
SELECT 
    c.course_name,
    COUNT(*) AS student_count,
    AVG(m.score) AS avg_score,
    MAX(m.score) AS max_score,
    MIN(m.score) AS min_score
FROM marks m
JOIN courses c ON m.course_id = c.course_id
GROUP BY c.course_name;

-- ========================================
-- PRACTICE QUESTIONS
-- ========================================
-- Try to write queries for these:

-- Q1: Find average score for each department
-- Q2: Count how many courses each student is enrolled in
-- Q3: Find courses where minimum score is below 70
-- Q4: List departments with average student year > 2
-- Q5: Find students who are enrolled in more than 1 course

-- ========================================
-- KEY CONCEPTS
-- ========================================
-- COUNT(*): Counts rows
-- AVG(): Calculates average
-- SUM(): Adds all values
-- MAX(): Finds maximum value
-- MIN(): Finds minimum value
--
-- GROUP BY: Groups rows with same values
-- HAVING: Filters groups (like WHERE but for groups)
--
-- Difference between WHERE and HAVING:
-- WHERE: Filters rows BEFORE grouping
-- HAVING: Filters groups AFTER grouping
--
-- Example:
-- WHERE score > 80 → Filter individual scores
-- HAVING AVG(score) > 80 → Filter groups by average
