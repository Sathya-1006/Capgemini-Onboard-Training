package com.controller;

import java.io.IOException;

import com.model.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "deleteStudent", urlPatterns = { "/deleteStudent" })
public class DeleteStudentController extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));

        int result = dao.deleteStudent(id);

        if (result > 0) {

            response.sendRedirect("viewStudent");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Student Not Deleted!</h2>");
            response.getWriter().println("<br>");
            response.getWriter().println("<a href='viewStudent'>Back</a>");

        }

    }

}