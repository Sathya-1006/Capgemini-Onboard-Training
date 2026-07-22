<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> Multiplication table</h2>

<%

out.println("<b>10 Table</b><br>");

for(int i=1;i<=10;i++){
	out.println(i+ " * 10 = "+ (i * 10) + "<br>");
	
}
%>

<a href = "second.jsp"> Second page </a>
</body>
</html>