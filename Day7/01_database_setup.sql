-- ========================================
-- SESSION 1: DATABASE SETUP
-- ========================================
-- Goal: Create a database to store college information

-- Step 1: Create a new database called 'college'
CREATE DATABASE college;

-- Step 2: Switch to using the college database
USE college;

-- ========================================
-- EXPLANATION
-- ========================================
-- CREATE DATABASE: Creates a new database (like creating a new folder)
-- USE: Tells MySQL which database to work with (like opening a folder)

-- ========================================
-- VERIFY
-- ========================================
-- Check if database was created
SHOW DATABASES;

-- Check which database you're currently using
SELECT DATABASE();
