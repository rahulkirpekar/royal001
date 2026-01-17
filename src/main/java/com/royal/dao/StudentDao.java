package com.royal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao 
{
	public int insertStudent(StudentBean sbean) 
	{
		String hobbiesStr = "";
		String hobbies[] = sbean.getHobbies();
		for(int i = 0 ; i < hobbies.length;i++) 
		{
			if(i < (hobbies.length-1)) 
			{
				hobbiesStr = hobbiesStr + hobbies[i]+ ",";
			}else 
			{
				hobbiesStr = hobbiesStr + hobbies[i];
			}
		}
		System.out.println("hobbiesStr : " + hobbiesStr);
		
		String insertQuery = "INSERT INTO student (fullname,age,course,gender,hobbies,date_of_birth,email,mobile,address) VALUES('"+sbean.getFullname()+"',"+sbean.getAge()+",'"+sbean.getCourse()+"','"+sbean.getGender()+"','"+hobbiesStr+"','"+sbean.getDob()+"','"+sbean.getEmail()+"','"+sbean.getMobile()+"','"+sbean.getAddress()+"')  ";
		System.out.println("insertQuery : " + insertQuery);
		Connection conn = DBConnection.getConnection();
		Statement stmt=  null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt =  conn.createStatement();
				rowsAffected = stmt.executeUpdate(insertQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao--insertStudent()--Db not connected");
		}
		return rowsAffected;
	}
}
