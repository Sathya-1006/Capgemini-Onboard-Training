<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>

<h2>Registration Successful</h2>

<p><strong>Employee ID:</strong> ${emp.id}</p>

<p>
    <strong>Employee Name:</strong> <b>${emp.name}</b> has been registered successfully.
</p>

<p><strong>Email:</strong> ${emp.email}</p>

<p><strong>Salary:</strong> ${emp.salary}</p>

<p><strong>Joining Date:</strong> ${emp.joiningDate}</p>

<p><strong>Gender:</strong> ${emp.gender}</p>

<p><strong>Department:</strong> ${emp.department}</p>

<p><strong>Skills:</strong> ${emp.skills}</p>

<p>
    <strong>Address:</strong><br>
    City: ${emp.address.city}<br>
    State: ${emp.address.state}<br>
    Pincode: ${emp.address.pincode}
</p>

</body>
</html>