package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
	@Override
	public void init() throws ServletException 
	{
		System.out.println("=========SecondServlet---init()========="+ this);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		System.out.println("=========SecondServlet---service()========="+ this);
//		System.out.println("request : " + request);
//		System.out.println("response : " + response);

		ServletConfig config =	getServletConfig();
		
		String URLNAME = config.getInitParameter("URLNAME");
		String DRIVERCLASS = config.getInitParameter("DRIVERCLASS");
		String USERNAME = config.getInitParameter("USERNAME");
		String PASSWORD = config.getInitParameter("PASSWORD");
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>SecondServlet Object</b> : " + this+"<br>");
		out.print("<b>SecondServletConfig Object</b> : " + config+"<br>");
		
		out.print("<b>URLNAME</b> : " + URLNAME+"<br>");
		out.print("<b>DRIVERCLASS</b> : " + DRIVERCLASS+"<br>");
		out.print("<b>USERNAME</b> : " + USERNAME+"<br>");
		out.print("<b>PASSWORD</b> : " + PASSWORD+"<br>");
	}
	@Override
	public void destroy() 
	{
		System.out.println("=========SecondServlet---destroy()========="+ this);
	}
}
