package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NinthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		request scope			
//		StudentBean s1 = (StudentBean)request.getAttribute("student1");
//		StudentBean s2 = (StudentBean)request.getAttribute("student2");
//		StudentBean s3 = (StudentBean)request.getAttribute("student3");

		// getSession
//		HttpSession session = request.getSession();
		
//		session scope			
//		StudentBean s1 = (StudentBean)session.getAttribute("student1");
//		StudentBean s2 = (StudentBean)session.getAttribute("student2");
//		StudentBean s3 = (StudentBean)session.getAttribute("student3");

		// getServletContext object
		ServletContext context = getServletContext();
		StudentBean s1 = (StudentBean)context.getAttribute("student1");
		StudentBean s2 = (StudentBean)context.getAttribute("student2");
		StudentBean s3 = (StudentBean)context.getAttribute("student3");
		
		
		System.out.println("NinthServlet : ");
		System.out.println(s1.getRno()+" " + s1.getName()+" " +s1.getStd()+" " + s1.getMarks()); 
		System.out.println(s2.getRno()+" " + s2.getName()+" " +s2.getStd()+" " + s2.getMarks()); 
		System.out.println(s3.getRno()+" " + s3.getName()+" " +s3.getStd()+" " + s3.getMarks()); 

		context.removeAttribute("student3");
//		request.getRequestDispatcher("TenthServlet").forward(request, response);
	}
}

