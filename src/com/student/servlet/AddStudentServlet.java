package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Servlet to handle adding a new student
public class AddStudentServlet extends HttpServlet {

    // GET - show the add student form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("add-student.jsp");
        rd.forward(request, response);
    }

    // POST - save the new student to database
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String phone = request.getParameter("phone");

        // Create Student object
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setPhone(phone);

        // Save to database
        StudentDAO dao = new StudentDAO();
        boolean success = dao.addStudent(student);

        if (success) {
            // Redirect to student list
            response.sendRedirect("students");
        } else {
            // Show error
            request.setAttribute("error", "Failed to add student!");
            RequestDispatcher rd = request.getRequestDispatcher("add-student.jsp");
            rd.forward(request, response);
        }
    }
}
