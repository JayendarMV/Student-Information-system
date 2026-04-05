package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentDAO.deleteStudent(id);

        res.sendRedirect("view");
    }
}