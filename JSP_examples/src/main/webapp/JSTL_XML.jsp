<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="x" uri="jakarta.tags.xml" %>

<html>
<head>
<title>XML Tags Example</title>
</head>
<body>

<x:parse var="doc">
<employees>
    <employee>
        <id>101</id>
        <name>Sathya</name>
        <department>IT</department>
    </employee>
</employees>
</x:parse>

Employee ID :
<x:out select="$doc/employees/employee/id"/>

<br>

Employee Name :
<x:out select="$doc/employees/employee/name"/>

<br>

Department :
<x:out select="$doc/employees/employee/department"/>

</body>
</html>