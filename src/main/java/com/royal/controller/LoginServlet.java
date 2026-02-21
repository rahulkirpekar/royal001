package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;
import com.royal.util.StudentUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = 	response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		RequestDispatcher rd= null;
		if(StudentUtils.isValidString(userName) && StudentUtils.isValidString(password)) 
		{
			UserDao dao = new UserDao();
			UserBean userBean =	dao.authenticateuser(userName,password);

			if(userBean !=null) 
			{
				// create session
				HttpSession session = request.getSession();
				session.setAttribute("userBean", userBean);
				rd= request.getRequestDispatcher("studentregi.jsp");
			}else 
			{
				request.setAttribute("InvalidUser", "<font color='red'>Invalid UserName and Password</font>");
				rd= request.getRequestDispatcher("login.jsp");
			}
		}else 
		{
			request.setAttribute("InvalidUser", "<font color='red'>Invalid UserName and Password</font>");
			rd= request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}
}
