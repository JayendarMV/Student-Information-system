package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<String[]> list = StudentDAO.getAllStudents();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>View Students</title>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; }");
        out.println(".card { border: none; border-radius: 15px; box-shadow: 0 10px 30px rgba(0,0,0,0.3); }");
        out.println(".btn-custom { background: linear-gradient(45deg, #FF6B6B, #4ECDC4); border: none; border-radius: 25px; padding: 12px 30px; font-weight: bold; transition: transform 0.2s; }");
        out.println(".btn-custom:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }");
        out.println(".table { background: white; border-radius: 10px; overflow: hidden; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container mt-5'>");
        out.println("<div class='card p-4 shadow'>");

        out.println("<h2 class='text-center mb-4 text-primary'>Student List</h2>");
        out.println("<div class='text-center mb-3'>");
        out.println("<a href='addStudent.html' class='btn btn-custom'>Add Student</a>");
        out.println("<a href='index.html' class='btn btn-secondary ms-2'>Home</a>");
        out.println("</div>");

        out.println("<table class='table table-bordered table-striped'>");

        out.println("<thead class='table-dark'>");
        out.println("<tr>");
        out.println("<th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Edit</th><th>Delete</th>");
        out.println("</tr>");
        out.println("</thead><tbody>");

        for (String[] s : list) {
            out.println("<tr>");

            for (String val : s) {
                out.println("<td>" + val + "</td>");
            }

            out.println("<td><a class='btn btn-warning btn-sm' href='edit?id=" + s[0] + "'>Edit</a></td>");
            out.println("<td><a class='btn btn-danger btn-sm' href='delete?id=" + s[0] + "'>Delete</a></td>");

            out.println("</tr>");
        }

        out.println("</tbody></table>");
        out.println("</div></div>");

        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</body></html>");
    }
}