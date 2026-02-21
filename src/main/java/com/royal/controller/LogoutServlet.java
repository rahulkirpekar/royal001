package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		RequestDispatcher rd= null;
		if (session!=null) 
		{
			UserBean userBean = (UserBean)session.getAttribute("userBean");
			if(userBean == null) 
			{
				request.setAttribute("logoutErr", "<font color='red'>Invalid User,Login First</font>");
				rd= request.getRequestDispatcher("login.jsp");
				
			}else 
			{
				request.setAttribute("logoutSuccess", "<font color='green'>Logout Succssfully</font>");
				rd= request.getRequestDispatcher("login.jsp");
			}
			// session delete
			session.invalidate();
		} else 
		{
			request.setAttribute("logoutErr", "<font color='red'>Invalid User,Login First</font>");
			rd= request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}
}
