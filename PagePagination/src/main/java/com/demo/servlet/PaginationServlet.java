package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.demo.dao.StudentDAO;
import com.demo.entity.Student;

@WebServlet("/PaginationPage")
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page =1;
		int pageSize = 5;
		
		
		String p = request.getParameter("page");
		if(p != null) {
			page = Integer.parseInt(p);
			
		}
		StudentDAO dao = new StudentDAO();
		List<Student> lists = dao.getStudents(page, pageSize);
		long totalRecords = dao.getTotalStudent();
		int totalPages = (int) Math.ceil((double) totalRecords/pageSize);
		
		request.setAttribute("students", lists);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);
		
		request.getRequestDispatcher("student.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
