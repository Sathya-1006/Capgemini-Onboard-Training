package com.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.model.Student;
import com.model.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String address = request.getParameter("address");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        Student student = new Student(name, email, phone, course, address, dob);

        StudentDAO dao = new StudentDAO();

        int result = dao.addStudent(student);

        if (result > 0) {
            response.getWriter().println("<h2>Student Added Successfully!</h2>");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href='dashboard'>Go to Dashboard</a>");
        } else {
            response.getWriter().println("<h2>Failed to Add Student!</h2>");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href='addStudent.html'>Try Again</a>");
        }

    }

}