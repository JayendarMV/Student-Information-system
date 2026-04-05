# Student Information Management System

A simple web application for managing student records using **Java Servlets**, **JDBC**, and **JSP**.

## Features
- **Add** new student records
- **View** all students in a table
- **Edit** existing student details
- **Delete** student records
- Clean UI with CSS styling

## Tech Stack
- Java Servlets (Backend)
- JDBC (Database connectivity)
- JSP (Frontend pages)
- MySQL (Database)
- HTML/CSS (UI)

## Project Structure
```
├── sql/database.sql                          ← Database setup script
├── src/com/student/
│   ├── model/Student.java                    ← Student data class
│   ├── dao/StudentDAO.java                   ← Database CRUD operations
│   ├── servlet/
│   │   ├── ListStudentServlet.java           ← View all students
│   │   ├── AddStudentServlet.java            ← Add new student
│   │   ├── UpdateStudentServlet.java         ← Edit student
│   │   └── DeleteStudentServlet.java         ← Delete student
│   └── util/DBConnection.java               ← DB connection helper
└── web/
    ├── WEB-INF/web.xml                       ← Servlet configuration
    ├── index.jsp                             ← Student list page
    ├── add-student.jsp                       ← Add student form
    ├── edit-student.jsp                      ← Edit student form
    └── css/style.css                         ← Styling
```

## How to Run

### Prerequisites
- Java JDK 8 or higher
- Apache Tomcat 9+
- MySQL Server
- MySQL Connector/J JAR file

### Step 1: Setup Database
Open MySQL and run:
```sql
source sql/database.sql;
```

### Step 2: Configure Database Connection
Edit `src/com/student/util/DBConnection.java` and update:
```java
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root";        // your MySQL username
private static final String PASSWORD = "root";    // your MySQL password
```

### Step 3: Deploy to Tomcat
1. Create a folder `StudentManagement` inside Tomcat's `webapps/` directory
2. Copy the contents of `web/` folder into `webapps/StudentManagement/`
3. Compile all Java files and place `.class` files in `webapps/StudentManagement/WEB-INF/classes/`
4. Place `mysql-connector-java.jar` in `webapps/StudentManagement/WEB-INF/lib/`

**Compile command:**
```
javac -cp "path/to/servlet-api.jar;path/to/mysql-connector-java.jar" -d web/WEB-INF/classes src/com/student/util/*.java src/com/student/model/*.java src/com/student/dao/*.java src/com/student/servlet/*.java
```

### Step 4: Open in Browser
```
http://localhost:8080/StudentManagement/students
```

## URL Mappings
| URL | Action |
|-----|--------|
| `/students` | View all students |
| `/add` | Add new student |
| `/update?id=1` | Edit student |
| `/delete?id=1` | Delete student |
