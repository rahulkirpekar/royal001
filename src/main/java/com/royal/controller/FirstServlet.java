package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	public void init() throws ServletException 
	{
		System.out.println("=========FirstServlet---init()========="+ this);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SET MIME
		response.setContentType("text/html");
		
//		System.out.println("=========FirstServlet---service()========="+ this);
//		System.out.println("request : " + request);
//		System.out.println("response : " + response);
		
		ServletConfig config =	getServletConfig();
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>FirstServlet Object</b> : " + this+"<br>");
		out.print("<b>FirstServletConfig Object</b> : " + config +"<br>");
		
		Enumeration<String> e =  config.getInitParameterNames();
		
		while(e.hasMoreElements()) 
		{
			String paramName = e.nextElement();
			
			String paramValue = config.getInitParameter(paramName);
		
			out.print("<b>"+paramName+"</b> : " + paramValue+"<br>");
		}
		
		
//		String URLNAME = config.getInitParameter("URLNAME");
//		String DRIVERCLASS = config.getInitParameter("DRIVERCLASS");
//		String USERNAME = config.getInitParameter("USERNAME");
//		String PASSWORD = config.getInitParameter("PASSWORD");
		
//		out.print("<b>DRIVERCLASS</b> : " + DRIVERCLASS+"<br>");
//		out.print("<b>USERNAME</b> : " + USERNAME+"<br>");
//		out.print("<b>PASSWORD</b> : " + PASSWORD+"<br>");
	}
	@Override
	public void destroy() 
	{
		System.out.println("=========FirstServlet---destroy()========="+ this);
	}
}
