package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EditStudentServlet extends HttpServlet
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
		
		int id = 	Integer.parseInt(request.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean = dao.getStudentById(id);
		
		request.setAttribute("sbean", sbean);
		
		RequestDispatcher rd = null;
		
		if(sbean==null) 
		{
			request.setAttribute("dbErr","<font color='red'>Database Connection Error.</font>");
			rd = request.getRequestDispatcher("ListStudentServlet");
		}else 
		{
			rd = request.getRequestDispatcher("editstudent.jsp");			
		}
		
		rd.forward(request, response);
	}
}
