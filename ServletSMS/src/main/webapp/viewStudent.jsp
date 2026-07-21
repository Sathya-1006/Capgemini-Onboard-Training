<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.model.Student"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

HttpSession session1 = request.getSession(false);

if(session1 == null){
    response.sendRedirect("login.html");
    return;
}

List<Student> students = (List<Student>)request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>View Students</title>

<link rel="stylesheet" href="style.css">

<style>

table{

width:100%;

border-collapse:collapse;

margin-top:20px;

}

table,th,td{

border:1px solid black;

}

th{

background:green;

color:white;

padding:10px;

}

td{

padding:10px;

text-align:center;

}

</style>

</head>

<body>

<div class="container" style="width:95%;">

<h2>Student Details</h2>

<table>

<tr>

<th>ID</th>

<th>Name</th>

<th>Email</th>

<th>Phone</th>

<th>Course</th>

<th>Address</th>

<th>Date of Birth</th>

<th>Edit</th>

<th>Delete</th>

</tr>

<%
if(students != null){

    for(Student s : students){
%>

<tr>

<td><%=s.getStudentId()%></td>

<td><%=s.getName()%></td>

<td><%=s.getEmail()%></td>

<td><%=s.getPhone()%></td>

<td><%=s.getCourse()%></td>

<td><%=s.getAddress()%></td>

<td><%=s.getDateOfBirth()%></td>

<td>
<a class="edit-btn"
href="editStudent?id=<%=s.getStudentId()%>">
Edit
</a>
</td>

<td>
<a class="delete-btn"
href="deleteStudent?id=<%=s.getStudentId()%>"
onclick="return confirm('Are you sure you want to delete this student?');">
Delete
</a>
</td>

</tr>

<%
    }
}
%>

</table>

<br><br>

<a href="dashboard">Back to Dashboard</a>

</div>

</body>
</html>