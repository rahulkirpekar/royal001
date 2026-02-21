package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteMultipleStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String studentIdsStr[] = request.getParameterValues("studentIds");
		
		StudentDao dao = new StudentDao();
		int rowsAffected = 0;
		
		for (int i = 0; i < studentIdsStr.length; i++) 
		{
			rowsAffected = rowsAffected + dao.deleteStudentById(Integer.parseInt(studentIdsStr[i]));
			RequestDispatcher rd = null;
			
			if (studentIdsStr.length == rowsAffected) 
			{
				request.setAttribute("deleteSuccess", "<font color='green'>Student Records deleted.</font>");
			} else 
			{
				request.setAttribute("deleteDbError", "<font color='red'> Student record not deleted Due to Db error.</font>");
			}
			
			rd = request.getRequestDispatcher("ListStudentServlet");
			rd.forward(request, response);	
		}		
	}
}
