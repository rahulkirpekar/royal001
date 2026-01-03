package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = 	response.getWriter();
		
		out.print("<h1>LoginServlet---service()</h1>");
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		out.print("<b>UserName : </b>" + userName+"<br>");
		out.print("<b>Password : </b>" + password+"<br>");
		
	}
}
