📘 Student Information Management System

A web-based Student Information Management System developed using Java Servlets and JDBC, which allows users to perform CRUD (Create, Read, Update, Delete) operations on student records.

🚀 Features
➕ Add new student details
📄 View all students
✏️ Edit existing student information
❌ Delete student records
🎨 Simple UI using Bootstrap
🛠️ Technologies Used
Frontend: HTML, CSS, Bootstrap
Backend: Java Servlets
Database: MySQL
Connectivity: JDBC
Server: Apache Tomcat
IDE/Editor: VS Code / Cursor
⚙️ Project Structure
StudentManagement/
│
├── addStudent.html
├── editStudent.jsp
├── viewStudents.jsp
│
├── WEB-INF/
│   ├── web.xml
│   ├── classes/
│   └── lib/
│       └── mysql-connector-j.jar
🗄️ Database Setup
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);


▶️ How to Run the Project
1. Prerequisites
Java JDK installed
Apache Tomcat installed
MySQL installed
2. Steps
Clone the repository:
git clone https://github.com/yourusername/StudentManagement.git
Place the project folder inside:
Tomcat/webapps/
Make sure:
.class files are inside WEB-INF/classes
MySQL connector .jar is inside WEB-INF/lib
Start Tomcat server:
startup.bat

🔄 How It Works
User → Browser → Tomcat → Servlet → JDBC → MySQL Database → Response
User submits data through browser
Request is sent to Tomcat server
Servlet processes the request
JDBC connects to MySQL database
Data is stored/retrieved
Response is sent back to browser

🔑 Key Concepts
Java Servlets (doGet, doPost)
JDBC (Connection, PreparedStatement, ResultSet)
HTTP methods (GET, POST)
MVC architecture (basic)
Web deployment using Tomcat
