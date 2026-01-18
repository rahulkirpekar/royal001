package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		out.print("ListStudentServlet : Student record succssfully Inserted");
		
		StudentDao dao = new StudentDao();
		
		ArrayList<StudentBean> list = dao.getAllStudentRecords();
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("liststudent.jsp").forward(request, response);
		
	}
}
