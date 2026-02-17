-- Day 7 Revision: SQL Basics

-- 1. CREATE DATABASE
CREATE DATABASE school_db;
USE school_db;

-- 2. CREATE TABLE
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT,
    grade VARCHAR(10),
    city VARCHAR(50)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    credits INT
);

CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- 3. INSERT DATA
INSERT INTO students (name, age, grade, city) VALUES
('John Doe', 20, 'A', 'New York'),
('Jane Smith', 22, 'B', 'Los Angeles'),
('Bob Johnson', 21, 'A', 'Chicago'),
('Alice Williams', 23, 'C', 'New York'),
('Charlie Brown', 20, 'B', 'Boston');

INSERT INTO courses (course_name, credits) VALUES
('Java Programming', 4),
('Database Systems', 3),
('Web Development', 3),
('Data Structures', 4);

INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2024-01-15'),
(1, 2, '2024-01-15'),
(2, 1, '2024-01-16'),
(2, 3, '2024-01-16'),
(3, 2, '2024-01-17'),
(3, 4, '2024-01-17');

-- 4. SELECT QUERIES
-- Basic SELECT
SELECT * FROM students;
SELECT name, age FROM students;

-- WHERE clause
SELECT * FROM students WHERE age > 20;
SELECT * FROM students WHERE city = 'New York';

-- ORDER BY
SELECT * FROM students ORDER BY age DESC;
SELECT * FROM students ORDER BY name ASC;

-- LIMIT
SELECT * FROM students LIMIT 3;

-- 5. UPDATE
UPDATE students SET age = 24 WHERE name = 'John Doe';
UPDATE students SET grade = 'A' WHERE age > 21;

-- 6. DELETE
DELETE FROM students WHERE age < 18;
DELETE FROM students WHERE city = 'Boston';

-- 7. AGGREGATE FUNCTIONS
SELECT COUNT(*) FROM students;
SELECT AVG(age) FROM students;
SELECT MAX(age) FROM students;
SELECT MIN(age) FROM students;
SELECT SUM(credits) FROM courses;

-- 8. GROUP BY
SELECT city, COUNT(*) as student_count FROM students GROUP BY city;
SELECT grade, AVG(age) as avg_age FROM students GROUP BY grade;

-- 9. HAVING
SELECT city, COUNT(*) as count FROM students GROUP BY city HAVING count > 1;
SELECT grade, AVG(age) FROM students GROUP BY grade HAVING AVG(age) > 20;

-- 10. JOINS
-- INNER JOIN
SELECT s.name, c.course_name 
FROM students s
INNER JOIN enrollments e ON s.id = e.student_id
INNER JOIN courses c ON e.course_id = c.course_id;

-- LEFT JOIN
SELECT s.name, c.course_name 
FROM students s
LEFT JOIN enrollments e ON s.id = e.student_id
LEFT JOIN courses c ON e.course_id = c.course_id;

-- 11. SUBQUERIES
SELECT name FROM students WHERE age > (SELECT AVG(age) FROM students);
SELECT * FROM students WHERE id IN (SELECT student_id FROM enrollments);

-- 12. DISTINCT
SELECT DISTINCT city FROM students;
SELECT DISTINCT grade FROM students;

-- 13. LIKE
SELECT * FROM students WHERE name LIKE 'J%';
SELECT * FROM students WHERE city LIKE '%York%';

-- 14. BETWEEN
SELECT * FROM students WHERE age BETWEEN 20 AND 22;

-- 15. IN
SELECT * FROM students WHERE city IN ('New York', 'Chicago');

-- 16. ALTER TABLE
ALTER TABLE students ADD email VARCHAR(100);
ALTER TABLE students DROP COLUMN email;
ALTER TABLE students MODIFY COLUMN age INT NOT NULL;

-- 17. DROP TABLE
DROP TABLE IF EXISTS temp_table;

-- 18. TRUNCATE
TRUNCATE TABLE enrollments;

-- 19. CREATE INDEX
CREATE INDEX idx_student_name ON students(name);
CREATE INDEX idx_student_city ON students(city);

-- 20. VIEWS
CREATE VIEW student_courses AS
SELECT s.name, c.course_name, e.enrollment_date
FROM students s
JOIN enrollments e ON s.id = e.student_id
JOIN courses c ON e.course_id = c.course_id;

SELECT * FROM student_courses;
