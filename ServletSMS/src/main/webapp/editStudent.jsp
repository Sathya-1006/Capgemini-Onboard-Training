<%@page import="com.model.Student"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

HttpSession session1=request.getSession(false);

if(session1==null){
    response.sendRedirect("login.html");
    return;
}

Student s=(Student)request.getAttribute("student");
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

<form action="updateStudent" method="post">

<input type="hidden"
name="studentId"
value="<%=s.getStudentId()%>">

Name

<input type="text"
name="name"
value="<%=s.getName()%>" required>

<br><br>

Email

<input type="email"
name="email"
value="<%=s.getEmail()%>" required>

<br><br>

Phone

<input type="text"
name="phone"
value="<%=s.getPhone()%>" required>

<br><br>

Course

<input type="text"
name="course"
value="<%=s.getCourse()%>" required>

<br><br>

Address

<textarea
name="address"
rows="4"
cols="30"><%=s.getAddress()%></textarea>

<br><br>

Date of Birth

<input
type="date"
name="dob"
value="<%=s.getDateOfBirth()%>"
required>

<br><br>

<input
type="submit"
value="Update Student">

</form>

<br>

<a href="viewStudent">Back</a>

</div>

</body>

</html>