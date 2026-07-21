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

@WebServlet(name="updateStudent", urlPatterns={"/updateStudent"})
public class UpdateStudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAO dao = new StudentDAO();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null) {
            response.sendRedirect("login.html");
            return;
        }

        int id = Integer.parseInt(request.getParameter("studentId"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String address = request.getParameter("address");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        Student student = new Student(id, name, email, phone, course, address, dob);

        int result = dao.updateStudent(student);

        if(result > 0) {

            response.sendRedirect("viewStudent");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Update Failed!</h2>");
            response.getWriter().println("<a href='viewStudent'>Back</a>");

        }

    }

}