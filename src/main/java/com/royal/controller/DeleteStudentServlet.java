package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteStudentServlet extends HttpServlet
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.deleteStudentById(id);
		
		RequestDispatcher rd = null;
		
		if (rowsAffected > 0) 
		{
			request.setAttribute("deleteSuccess", "<font color='green'>Student Record deleted.</font>");
		} else 
		{
			request.setAttribute("deleteDbError", "<font color='red'> Student record not deleted Due to Db error.</font>");
		}
		rd = request.getRequestDispatcher("ListStudentServlet");
		rd.forward(request, response);
	}
}
