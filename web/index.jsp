<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <!-- Header -->
    <div class="header">
        <h1>📚 Student Management System</h1>
        <p>Manage student information easily</p>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="card">

            <!-- Toolbar -->
            <div class="toolbar">
                <span class="card-title">All Students</span>
                <a href="add" class="btn btn-success">+ Add New Student</a>
            </div>

            <%
                // Get the student list from the servlet
                List<Student> studentList = (List<Student>) request.getAttribute("studentList");
            %>

            <% if (studentList != null && studentList.size() > 0) { %>

                <!-- Student Table -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Course</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Student s : studentList) { %>
                            <tr>
                                <td><%= s.getId() %></td>
                                <td><%= s.getName() %></td>
                                <td><%= s.getEmail() %></td>
                                <td><%= s.getCourse() %></td>
                                <td><%= s.getPhone() %></td>
                                <td class="action-links">
                                    <a href="update?id=<%= s.getId() %>" class="btn btn-warning">Edit</a>
                                    <a href="delete?id=<%= s.getId() %>" class="btn btn-danger"
                                       onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>

            <% } else { %>

                <!-- Empty State -->
                <div class="empty-state">
                    <p>No students found. Click "Add New Student" to get started!</p>
                </div>

            <% } %>

        </div>
    </div>

</body>
</html>
