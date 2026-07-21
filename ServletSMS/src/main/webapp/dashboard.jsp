<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

HttpSession s = request.getSession(false);

if(s==null){

response.sendRedirect("login.html");
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

<a href="addStudent.html">Add Student</a>

<br><br>

<a href="viewStudent">View Students</a>

<br><br>

<a href="search.jsp">Search Student</a>

<br><br>

<a href="logout">Logout</a>

</div>

</body>

</html>