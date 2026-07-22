<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>

<c:set var="number1" value="20"/>
<c:set var="number2" value="30"/>
<c:set var="number3" value="10"/>

<c:choose>

    <c:when test="${number1 < number2}">
        ${number1} is less than ${number2}
    </c:when>

    <c:when test="${number1 <= number3}">
        ${number1} is less than or equal to ${number3}
    </c:when>

    <c:otherwise>
        ${number1} is the largest number!
    </c:otherwise>

</c:choose>

<hr>

<c:set var="age" value="20"/>

Age : ${age}<br>

<c:if test="${age ge 18}">
    Eligible to vote
</c:if>

<c:if test="${age lt 18}">
    Not Eligible
</c:if>

</body>
</html>