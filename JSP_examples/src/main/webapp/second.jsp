
<%@ page import ="com.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action tags</title>
</head>
<body>
<% Student st = new Student(101,"Sathya"); %>
<%--  <p>Hi <%= st.getName() %> Roll = <%= st.getRoll() %>  </p>--%>


<%-- Using ACTION tags --%>
<jsp:useBean id="obj" class ="com.model.Student"/>


<jsp:setProperty property = "name" name ="obj" value="Sathya"/>
<jsp:getProperty property="name" name="obj"/>
<jsp:setProperty property = "roll" name ="obj" value="102"/>
<jsp:getProperty property="roll" name="obj"/>



</body>
</html>