<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student - Student Management System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>📚 Student Management System</h1>
        <p>Add a new student record</p>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="card">
            <span class="card-title">Add New Student</span>

            <%-- Show error message if any --%>
            <% String error = (String) request.getAttribute("error"); %>
            <% if (error != null) { %>
                <div class="alert alert-danger"><%= error %></div>
            <% } %>

            <!-- Add Student Form -->
            <form action="add" method="post">

                <div class="form-group">
                    <label for="name">Student Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter student name" required>
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" placeholder="Enter email address" required>
                </div>

                <div class="form-group">
                    <label for="course">Course</label>
                    <input type="text" id="course" name="course" placeholder="Enter course name">
                </div>

                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" id="phone" name="phone" placeholder="Enter phone number">
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-success">Save Student</button>
                    <a href="students" class="btn btn-secondary">Cancel</a>
                </div>

            </form>
        </div>
    </div>

</body>
</html>
