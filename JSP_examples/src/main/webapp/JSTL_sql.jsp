<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>

<sql:setDataSource
    var="db"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/student"
    user="root"
    password="Sathya@123"/>

<sql:query var="students" dataSource="${db}">
    SELECT * FROM students;
</sql:query>

<h2>Student Details</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Course ID</th>
    </tr>

    <c:forEach var="row" items="${students.rows}">
        <tr>
            <td>${row.student_id}</td>
            <td>${row.student_name}</td>
            <td>${row.course_id}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>