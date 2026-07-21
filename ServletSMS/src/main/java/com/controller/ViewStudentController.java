package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.Student;
import com.model.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "viewStudent", urlPatterns = { "/viewStudent" })
public class ViewStudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Student> students = dao.getAllStudents();

        request.setAttribute("students", students);

        request.getRequestDispatcher("viewStudent.jsp")
               .forward(request, response);

    }

}