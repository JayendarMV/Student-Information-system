package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

// Servlet to display all students (Home Page)
public class ListStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get all students from database
        StudentDAO dao = new StudentDAO();
        List<Student> studentList = dao.getAllStudents();

        // Set the list as a request attribute
        request.setAttribute("studentList", studentList);

        // Forward to JSP page to display
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}
