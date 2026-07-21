<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.time.LocalDate"%>
<%@ page import="com.model.Student"%>
<%@ page import="com.model.StudentDAO"%>

<%
if(session.getAttribute("username")==null){
    response.sendRedirect("login.jsp");
    return;
}

int id = Integer.parseInt(request.getParameter("studentId"));

String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String course = request.getParameter("course");
String address = request.getParameter("address");
LocalDate dob = LocalDate.parse(request.getParameter("dob"));

Student student = new Student(id,name,email,phone,course,address,dob);

StudentDAO dao = new StudentDAO();

int result = dao.updateStudent(student);

if(result > 0){

    response.sendRedirect("viewStudent.jsp");

}
else{

    out.println("<h2>Update Failed!</h2>");
    out.println("<a href='viewStudent.jsp'>Back</a>");

}
%>