<%@page import="com.demo.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<Student> lists = (List<Student>) request.getAttribute("students");
int currentPage = (int) request.getAttribute("currentPage");
int totalPages = (int) request.getAttribute("totalPages");
%>

<h2>Student Records</h2>



<table border ="1">
<tr><td>Roll</td><td>Name</td><td>Course</td><td>Marks</td></tr>

<%
for(Student s : lists){
%>

<tr><td><%= s.getRoll() %></td><td><%= s.getName() %></td>
<td><%= s.getCourse() %></td><td><%= s.getMarks() %></td>
 </tr>

<%
}
%>
 
</table>

<br>

<%
if(currentPage > 1){
	%>
<a href="PaginationPage?page=<%= currentPage - 1 %>">Previous</a>
	<%
}	
%> &nbsp; &nbsp;
<%
for(int i = 1; i <= totalPages; i++){
	%>
<a href="PaginationPage?page=<%= i %>"><%= i %></a>	&nbsp; &nbsp;
	<%
}
%>&nbsp; &nbsp;
<%
if(currentPage < totalPages){
	%>
<a href="PaginationPage?page = <%= currentPage + 1 %>">Next</a>
	<%
}
%>


</body>
</html>