package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		HttpSession session =	request.getSession(false);
		
		if(session == null) 
		{
			request.setAttribute("logoutErr", "<font color='red'>Invalid User,Login First</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
//		PrintWriter out= response.getWriter();
//		out.print("ListStudentServlet : Student record succssfully Inserted");
//		StudentDao dao = new StudentDao();
//		ArrayList<StudentBean> list = dao.getAllStudentRecords();
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("liststudent.jsp").forward(request, response);

		int page = 1;
		
		int recordsPerPage = 10;
		
		String pageStr = request.getParameter("page");
				
		if(pageStr != null) 
		{
			page = Integer.parseInt(pageStr);
		}
		
		int offset = (page - 1) * recordsPerPage;
		
		StudentDao dao = new StudentDao();
		
		ArrayList<StudentBean> list = dao.getStudentByLimit(offset, recordsPerPage);
		
		// get total records count
	    int totalRecords = dao.getTotalRecords();

	    // fetch paginated data
//	    ArrayList<StudentBean> list = dao.getStudentByLimit((page-1)*recordsPerPage, recordsPerPage);

	    int totalPages = (int)Math.ceil((double)totalRecords / recordsPerPage);

	    request.setAttribute("list", list);
	    request.setAttribute("currentPage", page);
	    request.setAttribute("totalPages", totalPages);

	    request.getRequestDispatcher("liststudent.jsp").forward(request,response);
	}
}
