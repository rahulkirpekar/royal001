package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// context object
		ServletContext context = getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		String lang4 = context.getInitParameter("lang4");
		String lang5 = context.getInitParameter("lang5");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>FourthServlet Object</b> : " + this+"<br>");
		out.print("<b>ServletContext Object</b> : " + context+"<br>");
		
		out.print("<b>lang1</b> : " + lang1+"<br>");
		out.print("<b>lang2</b> : " + lang2+"<br>");
		out.print("<b>lang3</b> : " + lang3+"<br>");
		out.print("<b>lang4</b> : " + lang4+"<br>");
		out.print("<b>lang5</b> : " + lang5+"<br>");
		
		
		
	}
}
