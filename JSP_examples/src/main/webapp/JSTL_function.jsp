
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function</title>
</head>
<body>

<c:set var="email" value="sathya1006@gmail.com"/>

Email: ${email} <br><br>

<c:if test="${fn:contains(email, '@gmail.com')}">
    This is a Gmail account.
</c:if>

<c:if test="${!fn:contains(email, '@gmail.com')}">
    This is not a Gmail account.
</c:if>

</body>
</html>