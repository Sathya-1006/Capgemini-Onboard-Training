<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.model.Student"%>
<%@ page import="com.model.StudentDAO"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("username")==null){
    response.sendRedirect("login.jsp");
    return;
}

int id = Integer.parseInt(request.getParameter("id"));

StudentDAO dao = new StudentDAO();

Student s = dao.getStudentById(id);
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Edit Student</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">

<h2>Update Student</h2>

<form action="updateStudent.jsp" method="post">

<input type="hidden"
name="studentId"
value="<%=s.getStudentId()%>">

<label>Name</label>

<input
type="text"
name="name"
value="<%=s.getName()%>"
required>

<label>Email</label>

<input
type="email"
name="email"
value="<%=s.getEmail()%>"
required>

<label>Phone</label>

<input
type="text"
name="phone"
value="<%=s.getPhone()%>"
required>

<label>Course</label>

<input
type="text"
name="course"
value="<%=s.getCourse()%>"
required>

<label>Address</label>

<textarea
name="address"
rows="4"><%=s.getAddress()%></textarea>

<label>Date of Birth</label>

<input
type="date"
name="dob"
value="<%=s.getDateOfBirth()%>"
required>

<input
type="submit"
value="Update Student">

</form>

<br>

<a href="viewStudent.jsp">Back</a>

</div>

</body>
</html>