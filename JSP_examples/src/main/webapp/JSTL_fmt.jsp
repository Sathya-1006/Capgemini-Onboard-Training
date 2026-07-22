<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
<title>Formatting Tags Example</title>
</head>
<body>

<c:set var="salary" value="45890.567"/>
<c:set var="today" value="<%= new java.util.Date() %>"/>

Salary : ${salary}<br><br>

Currency :
<fmt:formatNumber value="${salary}" type="currency"/>

<br><br>

Number (2 decimal places) :
<fmt:formatNumber value="${salary}" maxFractionDigits="2"/>

<br><br>

Today's Date :
<fmt:formatDate value="${today}" pattern="dd-MM-yyyy"/>

</body>
</html>