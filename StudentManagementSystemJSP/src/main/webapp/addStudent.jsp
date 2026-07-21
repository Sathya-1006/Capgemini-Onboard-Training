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

<title>Add Student</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">

<h2>Add Student</h2>

<form action="addStudentProcess.jsp" method="post">

<label>Name</label>

<input type="text" name="name" required>

<label>Email</label>

<input type="email" name="email" required>

<label>Phone</label>

<input type="text" name="phone" required>

<label>Course</label>

<input type="text" name="course" required>

<label>Address</label>

<textarea name="address" rows="4" required></textarea>

<label>Date of Birth</label>

<input type="date" name="dob" required>

<input type="submit" value="Add Student">

</form>

<br>

<a href="dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>