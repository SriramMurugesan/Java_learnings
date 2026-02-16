-- ========================================
-- SESSION 1: CREATE TABLES
-- ========================================
-- Goal: Create tables to organize data

-- Make sure you're using the college database
USE college;

-- ========================================
-- TABLE 1: STUDENTS
-- ========================================
-- Stores student information
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(30),
    year INT
);

-- ========================================
-- TABLE 2: COURSES
-- ========================================
-- Stores course information
CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50),
    department VARCHAR(30)
);

-- ========================================
-- TABLE 3: ENROLLMENTS
-- ========================================
-- Links students to courses (which student enrolled in which course)
CREATE TABLE enrollments (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id)
);

-- ========================================
-- TABLE 4: MARKS
-- ========================================
-- Stores marks for each student in each course
CREATE TABLE marks (
    student_id INT,
    course_id INT,
    score INT
);

-- ========================================
-- EXPLANATION
-- ========================================
-- PRIMARY KEY: Unique identifier for each row (like a student ID card)
-- INT: Integer number (whole number)
-- VARCHAR(50): Text with maximum 50 characters
-- 
-- Why separate tables?
-- - students: Basic student info
-- - courses: Course details
-- - enrollments: Which student takes which course
-- - marks: Scores for each student in each course
--
-- This is called "normalization" - avoiding duplicate data

-- ========================================
-- VERIFY
-- ========================================
-- Check if tables were created
SHOW TABLES;

-- See structure of students table
DESCRIBE students;
