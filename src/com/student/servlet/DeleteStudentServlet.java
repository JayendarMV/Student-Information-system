package com.student.servlet;

import com.student.dao.StudentDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Servlet to handle deleting a student
public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get student ID from URL
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete from database
        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(id);

        // Redirect back to student list
        response.sendRedirect("students");
    }
}
