<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student - Student Management System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>📚 Student Management System</h1>
        <p>Update student information</p>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="card">
            <span class="card-title">Edit Student</span>

            <%
                // Get the student object from servlet
                Student student = (Student) request.getAttribute("student");
            %>

            <!-- Edit Student Form -->
            <form action="update" method="post">

                <!-- Hidden field to pass student ID -->
                <input type="hidden" name="id" value="<%= student.getId() %>">

                <div class="form-group">
                    <label for="name">Student Name</label>
                    <input type="text" id="name" name="name" 
                           value="<%= student.getName() %>" required>
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" 
                           value="<%= student.getEmail() %>" required>
                </div>

                <div class="form-group">
                    <label for="course">Course</label>
                    <input type="text" id="course" name="course" 
                           value="<%= student.getCourse() %>">
                </div>

                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" id="phone" name="phone" 
                           value="<%= student.getPhone() %>">
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Update Student</button>
                    <a href="students" class="btn btn-secondary">Cancel</a>
                </div>

            </form>
        </div>
    </div>

</body>
</html>
