package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("123")) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            response.sendRedirect("dashboard");

        }

        else {

            response.getWriter().println("<h2>Invalid Username or Password</h2>");
            response.getWriter().println("<a href='login.html'>Try Again</a>");

        }

    }

}