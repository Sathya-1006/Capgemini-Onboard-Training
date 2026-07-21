<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.model.StudentDAO"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("username")==null){
    response.sendRedirect("login.jsp");
    return;
}

int id = Integer.parseInt(request.getParameter("id"));

StudentDAO dao = new StudentDAO();

int result = dao.deleteStudent(id);

if(result > 0){

    response.sendRedirect("viewStudent.jsp");

}
else{

    out.println("<h2>Student Not Deleted!</h2>");
    out.println("<br>");
    out.println("<a href='viewStudent.jsp'>Back</a>");

}
%>