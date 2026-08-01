<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Employee Registration Form</h2>
<form:form action="saveEmployee" modelAttribute="employee" method="post">
Employee ID <form:input path="id"/> <br><br>
Emplyoee Name <form:input path="name"/> <br><br>
Email <form:input path="email"/> <br><br>
Gender <br>
        Male <form:radiobutton path="gender" value="Male"/> <br><br>
       Female <form:radiobutton path="gender" value="Female"/> 
<br><br>
Department <form:select path="department">
           <form:option value="">select Any</form:option>
           <form:option value="IT">IT</form:option>
           <form:option value="HR">HR</form:option>
           <form:option value="Sales">Sales</form:option>
           <form:option value="Admin">Admin</form:option>
</form:select>
<br><br>
Salary <form:input path="salary"/> <br><br>
Joining Date <form:input path="joiningDate"/> <br><br>
Skills <br>
       Java <form:checkbox path="skills" value="Java"/>
       Spring <form:checkbox path="skills" value="Spring"/>
       Hibernate <form:checkbox path="skills" value="Hibernate"/>
       React <form:checkbox path="skills" value="React"/>
       Angular <form:checkbox path="skills" value="SAngular"/> <br><br>
Address <br>
        City <form:input path="address.city"/>
        State <form:input path="address.state"/>
        Pin Code <form:input path="address.pincode"/> <br><br>
<input type="Submit" value="Register"/>



</form:form>

</body>
</html>