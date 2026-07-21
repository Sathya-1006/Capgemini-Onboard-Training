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

@WebServlet(name = "searchStudent", urlPatterns = { "/searchStudent" })
public class SearchStudentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null){
            response.sendRedirect("login.html");
            return;
        }

        String name = request.getParameter("name");

        List<Student> students = dao.searchStudent(name);

        request.setAttribute("students", students);

        request.getRequestDispatcher("search.jsp")
               .forward(request, response);

    }

}