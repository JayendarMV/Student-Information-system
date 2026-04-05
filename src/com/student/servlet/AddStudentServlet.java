package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        StudentDAO.addStudent(name, email, course);

        res.sendRedirect("view");
    }
}