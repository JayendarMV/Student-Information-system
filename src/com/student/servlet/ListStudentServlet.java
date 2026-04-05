package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet to display all students (Home Page)
public class ListStudentServlet extends HttpServlet {

    @Override
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
