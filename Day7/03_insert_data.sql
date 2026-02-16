-- ========================================
-- SESSION 1: INSERT DATA
-- ========================================
-- Goal: Add realistic data to practice with

USE college;

-- ========================================
-- INSERT 20 STUDENTS
-- ========================================
-- Adding diverse students from different departments and years
INSERT INTO students VALUES
(1, 'Arun', 'CSE', 1),
(2, 'Priya', 'CSE', 2),
(3, 'Rahul', 'ECE', 1),
(4, 'Sneha', 'ECE', 3),
(5, 'Karthik', 'MECH', 2),
(6, 'Divya', 'CSE', 3),
(7, 'Ravi', 'EEE', 1),
(8, 'Meena', 'EEE', 2),
(9, 'Vikram', 'CIVIL', 4),
(10, 'Anitha', 'CSE', 1),
(11, 'Suresh', 'MECH', 3),
(12, 'Lakshmi', 'ECE', 2),
(13, 'Harish', 'CSE', 4),
(14, 'Nisha', 'CIVIL', 1),
(15, 'Praveen', 'EEE', 3),
(16, 'Keerthi', 'MECH', 4),
(17, 'Ajay', 'CSE', 2),
(18, 'Pooja', 'ECE', 4),
(19, 'Manoj', 'CIVIL', 2),
(20, 'Deepa', 'CSE', 3);

-- ========================================
-- INSERT COURSES
-- ========================================
-- Adding 6 courses across different departments
INSERT INTO courses VALUES
(101, 'Database Systems', 'CSE'),
(102, 'Data Structures', 'CSE'),
(103, 'Digital Electronics', 'ECE'),
(104, 'Thermodynamics', 'MECH'),
(105, 'Circuit Theory', 'EEE'),
(106, 'Structural Engineering', 'CIVIL');

-- ========================================
-- INSERT ENROLLMENTS
-- ========================================
-- Links students to courses they enrolled in
-- Note: Some students take multiple courses, some take one
INSERT INTO enrollments VALUES
(1,101),(1,102),
(2,101),(2,102),
(3,103),
(4,103),
(5,104),
(6,101),(6,102),
(7,105),
(8,105),
(9,106),
(10,101),
(11,104),
(12,103),
(13,101),(13,102),
(14,106),
(15,105),
(16,104),
(17,102),
(18,103),
(19,106),
(20,101);

-- ========================================
-- INSERT MARKS
-- ========================================
-- Scores for each student in their enrolled courses
INSERT INTO marks VALUES
(1,101,85),(1,102,78),
(2,101,92),(2,102,88),
(3,103,75),
(4,103,81),
(5,104,69),
(6,101,95),(6,102,90),
(7,105,72),
(8,105,84),
(9,106,77),
(10,101,66),
(11,104,73),
(12,103,89),
(13,101,91),(13,102,87),
(14,106,80),
(15,105,79),
(16,104,68),
(17,102,93),
(18,103,82),
(19,106,70),
(20,101,88);

-- ========================================
-- EXPLANATION
-- ========================================
-- INSERT INTO table_name VALUES (value1, value2, ...);
-- Values must match the column order in the table
-- 
-- Notice:
-- - 20 students across 5 departments (CSE, ECE, MECH, EEE, CIVIL)
-- - 6 courses (each department has at least one course)
-- - Some students enrolled in multiple courses
-- - Marks only exist for enrolled courses

-- ========================================
-- VERIFY DATA
-- ========================================
-- Count students
SELECT COUNT(*) AS total_students FROM students;

-- Count courses
SELECT COUNT(*) AS total_courses FROM courses;

-- Count enrollments
SELECT COUNT(*) AS total_enrollments FROM enrollments;

-- Count marks entries
SELECT COUNT(*) AS total_marks FROM marks;

-- Quick preview of each table
SELECT * FROM students LIMIT 5;
SELECT * FROM courses;
SELECT * FROM enrollments LIMIT 5;
SELECT * FROM marks LIMIT 5;
