package com.student.dao;

import com.student.model.Student;
import com.student.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object - handles all database operations for Student
public class StudentDAO {

    // 1. ADD a new student
    public boolean addStudent(Student student) {
        boolean result = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO students (name, email, course, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 2. GET all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 3. GET a single student by ID
    public Student getStudentById(int id) {
        Student student = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setPhone(rs.getString("phone"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // 4. UPDATE a student
    public boolean updateStudent(Student student) {
        boolean result = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE students SET name=?, email=?, course=?, phone=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 5. DELETE a student
    public boolean deleteStudent(int id) {
        boolean result = false;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
