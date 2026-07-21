<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("username")==null){

    response.sendRedirect("login.jsp");
    return;

}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Dashboard</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">

<h2>Welcome Admin</h2>

<br>

<a href="addStudent.jsp">Add Student</a>

<br><br>

<a href="viewStudent.jsp">View Students</a>

<br><br>

<a href="search.jsp">Search Student</a>

<br><br>

<a href="logout.jsp">Logout</a>

</div>

</body>
</html>