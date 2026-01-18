package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EightServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Data Ready
//		StudentBean s1 = new StudentBean(1, "Rahul", 12, 100);
//		StudentBean s2 = new StudentBean(2, "Ankur", 10, 100);
//		StudentBean s3 = new StudentBean(3, "Sagar", 11, 100);
		
		// request scope
//		request.setAttribute("student1", s1);
//		request.setAttribute("student2", s2);
//		request.setAttribute("student3", s3);
		
//				// get session
//		HttpSession session = request.getSession();
//		
//		// session data store
//		session.setAttribute("student1", s1);
//		session.setAttribute("student2", s2);
//		session.setAttribute("student3", s3);
//		
		
		// get ServletContext objet
//		ServletContext context = getServletContext();
//		context.setAttribute("student1", s1);
//		context.setAttribute("student2", s2);
//		context.setAttribute("student3", s3);
		
		
//		request.getRequestDispatcher("NinthServlet").forward(request, response);
		
		
	}
}
