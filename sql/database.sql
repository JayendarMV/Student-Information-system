-- Step 1: Create the database
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

-- Step 2: Create the students table
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100),
    phone VARCHAR(15)
);

-- Step 3: Insert some sample data
INSERT INTO students (name, email, course, phone) VALUES
('Rahul Sharma', 'rahul@example.com', 'Computer Science', '9876543210'),
('Priya Patel', 'priya@example.com', 'Information Technology', '9876543211'),
('Amit Kumar', 'amit@example.com', 'Electronics', '9876543212');
