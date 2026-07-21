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

String name=request.getParameter("name");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String course=request.getParameter("course");
String address=request.getParameter("address");
LocalDate dob=LocalDate.parse(request.getParameter("dob"));

Student student=new Student(name,email,phone,course,address,dob);

StudentDAO dao=new StudentDAO();

int result=dao.addStudent(student);

if(result>0){

    response.sendRedirect("viewStudent.jsp");

}
else{

    out.println("<h2>Student Not Added!</h2>");
    out.println("<br>");
    out.println("<a href='addStudent.jsp'>Try Again</a>");

}
%>