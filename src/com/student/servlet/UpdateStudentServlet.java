package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Servlet to handle updating an existing student
public class UpdateStudentServlet extends HttpServlet {

    // GET - show the edit form with existing data
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get student ID from URL parameter
        int id = Integer.parseInt(request.getParameter("id"));

        // Fetch student from database
        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentById(id);

        // Set student as request attribute
        request.setAttribute("student", student);

        // Forward to edit form
        RequestDispatcher rd = request.getRequestDispatcher("edit-student.jsp");
        rd.forward(request, response);
    }

    // POST - update the student in database
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String phone = request.getParameter("phone");

        // Create Student object with updated data
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setPhone(phone);

        // Update in database
        StudentDAO dao = new StudentDAO();
        dao.updateStudent(student);

        // Redirect to student list
        response.sendRedirect("students");
    }
}
