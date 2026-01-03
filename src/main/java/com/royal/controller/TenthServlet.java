package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TenthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		StudentBean s1 = (StudentBean)request.getAttribute("student1");
//		StudentBean s2 = (StudentBean)request.getAttribute("student2");
//		StudentBean s3 = (StudentBean)request.getAttribute("student3");
//		
//		System.out.println("TenthServlet : ");
//		System.out.println(s1.getRno()+" " + s1.getName()+" " +s1.getStd()+" " + s1.getMarks()); 
//		System.out.println(s2.getRno()+" " + s2.getName()+" " +s2.getStd()+" " + s2.getMarks()); 
//		System.out.println(s3.getRno()+" " + s3.getName()+" " +s3.getStd()+" " + s3.getMarks()); 

//		request scope			
//		StudentBean s1 = (StudentBean)request.getAttribute("student1");
//		StudentBean s2 = (StudentBean)request.getAttribute("student2");
//		StudentBean s3 = (StudentBean)request.getAttribute("student3");

		// getSession
//		HttpSession session = request.getSession();
		
////		session scope			
//		StudentBean s1 = (StudentBean)session.getAttribute("student1");
//		StudentBean s2 = (StudentBean)session.getAttribute("student2");
//		StudentBean s3 = (StudentBean)session.getAttribute("student3");
//
//		System.out.println("TenthServlet : ");
//		System.out.println(s1.getRno()+" " + s1.getName()+" " +s1.getStd()+" " + s1.getMarks()); 
//		System.out.println(s2.getRno()+" " + s2.getName()+" " +s2.getStd()+" " + s2.getMarks()); 
//		System.out.println(s3.getRno()+" " + s3.getName()+" " +s3.getStd()+" " + s3.getMarks()); 

		
		// getServletContext object
		ServletContext application = getServletContext();
		StudentBean s1 = (StudentBean)application.getAttribute("student1");
		StudentBean s2 = (StudentBean)application.getAttribute("student2");
		StudentBean s3 = (StudentBean)application.getAttribute("student3");
		
		
		System.out.println("TenthServlet : ");
		System.out.println(s1.getRno()+" " + s1.getName()+" " +s1.getStd()+" " + s1.getMarks()); 
		System.out.println(s2.getRno()+" " + s2.getName()+" " +s2.getStd()+" " + s2.getMarks()); 
		System.out.println(s3.getRno()+" " + s3.getName()+" " +s3.getStd()+" " + s3.getMarks()); 

		
	}

}
