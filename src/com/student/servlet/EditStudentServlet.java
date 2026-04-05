package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.ResultSet;

public class EditStudentServlet extends HttpServlet {

    // 👉 Show Edit Form (GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ResultSet rs = StudentDAO.getStudentById(id);
        String name = "", email = "", course = "";
        try {
            if (rs.next()) {
                name = rs.getString("name");
                email = rs.getString("email");
                course = rs.getString("course");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Edit Student</title>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; }");
        out.println(".card { border: none; border-radius: 15px; box-shadow: 0 10px 30px rgba(0,0,0,0.3); }");
        out.println(".btn-custom { background: linear-gradient(45deg, #FF6B6B, #4ECDC4); border: none; border-radius: 25px; padding: 12px 30px; font-weight: bold; transition: transform 0.2s; }");
        out.println(".btn-custom:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }");
        out.println(".form-control { border-radius: 10px; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container mt-5'>");
        out.println("<div class='row justify-content-center'>");
        out.println("<div class='col-md-6'>");
        out.println("<div class='card p-4 shadow'>");

        out.println("<h2 class='text-center mb-4 text-primary'>Edit Student</h2>");

        out.println("<form action='edit' method='post'>");

        out.println("<input type='hidden' name='id' value='" + id + "'>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Name</label>");
        out.println("<input type='text' name='name' class='form-control' value='" + name + "' required>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Email</label>");
        out.println("<input type='email' name='email' class='form-control' value='" + email + "' required>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label class='form-label'>Course</label>");
        out.println("<input type='text' name='course' class='form-control' value='" + course + "' required>");
        out.println("</div>");

        out.println("<button class='btn btn-custom w-100'>Update Student</button>");
        out.println("</form>");

        out.println("<div class='text-center mt-3'>");
        out.println("<a href='view' class='text-decoration-none'>Back to List</a>");
        out.println("</div>");

        out.println("</div></div></div></div>");

        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</body></html>");
    }

    // 👉 Update Data (POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        StudentDAO.updateStudent(id, name, email, course);

        res.sendRedirect("view");
    }
}