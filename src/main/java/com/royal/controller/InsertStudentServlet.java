package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// MIME
		response.setContentType("text/html");
		
		String  fullname    =request.getParameter("fullname");
		String  age    		=request.getParameter("age");
		String  course    	=request.getParameter("course");
		String  gender    	=request.getParameter("gender");
		
		String  hobbies[]   =request.getParameterValues("hobby");
		
		String  dob    		=request.getParameter("dob");
		String  email    	=request.getParameter("email");
		String  mobile    	=request.getParameter("mobile");
		String  address     =request.getParameter("address");
		
		PrintWriter out = 	response.getWriter();
		out.print("InsertStudentServlet : <br>");
		out.print("<b>  fullname      </b> : " + fullname+"<br>");
		out.print("<b>  age    	      </b> : " + age    +"<br>"	);
		out.print("<b>  course        </b> : " + course  +"<br>");
		out.print("<b>  gender        </b> : " + gender  +"<br>");
		
		out.print("<b>  hobby         </b> : ");
		
		for(int i = 0 ; i < hobbies.length;i++) 
		{
			if(i < (hobbies.length-1)) 
			{
				out.print(hobbies[i]+",");
			}else 
			{
				out.print(hobbies[i]+".");
			}
		}
		out.print("<br>");
		out.print("<b>  dob    	      </b> : " + dob    +"<br>"	);
		out.print("<b>  email         </b> : " + email   +"<br>");
		out.print("<b>  mobile        </b> : " + mobile  +"<br>");
		out.print("<b>  address       </b> : " + address +"<br>");
		
		
	}
}
