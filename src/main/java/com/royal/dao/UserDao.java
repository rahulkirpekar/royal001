package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.bean.UserBean;
import com.royal.util.DBConnection;

public class UserDao 
{
	public UserBean authenticateuser(String userName, String password) 
	{
		String isValidUser = "SELECT * FROM USER WHERE email='"+userName+"' AND password='"+password+"'";
		UserBean userBean = null;
		Connection conn = DBConnection.getConnection();
		Statement stmt =null;
		if (conn!=null) 
		{
			try 
			{
				stmt =conn.createStatement();
				
				ResultSet rs =  stmt.executeQuery(isValidUser);
				
				if (rs.next()) 
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String email= rs.getString(3);
					String password1 = rs.getString(4);
					
					userBean = new UserBean(id, name, email, password1);	
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("Db not connected : " + conn);
		}
		return userBean;
	}
}
