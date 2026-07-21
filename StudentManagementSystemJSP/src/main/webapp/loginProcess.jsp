<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
String username=request.getParameter("username");
String password=request.getParameter("password");

if(username.equals("admin") && password.equals("123")){

    session.setAttribute("username", username);

    response.sendRedirect("dashboard.jsp");

}
else{

    response.sendRedirect("login.jsp");

}
%>