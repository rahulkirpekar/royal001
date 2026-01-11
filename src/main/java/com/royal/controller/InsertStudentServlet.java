package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.util.StudentUtils;

import jakarta.servlet.RequestDispatcher;
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
		
		boolean flag = false;
		
		StudentBean sbean = new StudentBean();
		
		String  fullname    =request.getParameter("fullname");
		
		if(StudentUtils.isValidString(fullname)) 
		{
			sbean.setFullname(fullname);
		}else 
		{
			request.setAttribute("fullnameErr","<font color='red'>Please enter valid FullName.</font>");
			flag = true;
		}
		
		String  age = request.getParameter("age");
		
		if(StudentUtils.isValidString(age)) 
		{
			sbean.setAge(Integer.parseInt(age));
		}else 
		{
			request.setAttribute("ageErr","<font color='red'>Please enter valid Age.</font>");
			flag = true;
		}

		String  course = request.getParameter("course");

		if(StudentUtils.isValidString(course)) 
		{
			sbean.setCourse(course);
		}else 
		{
			request.setAttribute("courseErr","<font color='red'>Please enter valid Course.</font>");
			flag = true;
		}
		
		
		String  gender    	=request.getParameter("gender");
		if(StudentUtils.isValidString(gender)) 
		{
			sbean.setGender(gender);
		}else 
		{
			request.setAttribute("genderErr","<font color='red'>Please enter valid Gender.</font>");
			flag = true;
		}
		
		String  hobbies[]   =request.getParameterValues("hobby");

		if(hobbies!=null) 
		{
			sbean.setHobbies(hobbies);
			
			String hobbiesStr = null;
			for(int i = 0 ; i < hobbies.length;i++) 
			{
				if(i < (hobbies.length-1)) 
				{
					hobbiesStr = hobbiesStr + hobbies[i]+ ",";
				}else 
				{
					hobbiesStr = hobbiesStr + hobbies[i]+ ".";
				}
			}
			System.out.println("hobbiesStr : " + hobbiesStr);
			
		}else 
		{
			request.setAttribute("hobbiesErr","<font color='red'>Please enter valid Hobbies.</font>");
			flag = true;
		}
		
		String  dob    		=request.getParameter("dob");
		if(StudentUtils.isValidString(dob)) 
		{
			sbean.setDob(dob);
		}else 
		{
			request.setAttribute("dobErr","<font color='red'>Please enter valid DOB.</font>");
			flag = true;
		}

		String  email    	=request.getParameter("email");
		if(StudentUtils.isValidString(email)) 
		{
			sbean.setEmail(email);
		}else 
		{
			request.setAttribute("emailErr","<font color='red'>Please enter valid Email.</font>");
			flag = true;
		}
		String  mobile    	=request.getParameter("mobile");
		if(StudentUtils.isValidString(mobile)) 
		{
			sbean.setMobile(mobile);
		}else 
		{
			request.setAttribute("mobileErr","<font color='red'>Please enter valid Mobile.</font>");
			flag = true;
		}
		String  address     =request.getParameter("address");
		if(StudentUtils.isValidString(address)) 
		{
			sbean.setAddress(address);
		}else 
		{
			request.setAttribute("addressErr","<font color='red'>Please enter valid Address.</font>");
			flag = true;
		}
		
		request.setAttribute("sbean", sbean);
		
		RequestDispatcher rd = null;
		
		if (flag) 
		{
			rd = request.getRequestDispatcher("studentregi.jsp");
		} else 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
		}
		rd.forward(request, response);
	}
}
