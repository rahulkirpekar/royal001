package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<StudentBean> getAllStudentRecords() 
	{
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		
		String selectQuery = "SELECT * from student";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sbean = null;
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rs = stmt.executeQuery(selectQuery);
				
				while(rs.next()) 
				{
					int id = rs.getInt(1);
					String fullname= rs.getString(2);
					int age = rs.getInt(3);
					String course= rs.getString(4);
					String gender= rs.getString(5);
					String hobbiesStr= rs.getString(6);
					String dob= rs.getString(7);
					String email = rs.getString(8);
					String mobile = rs.getString(9);
					String address = rs.getString(10);
					
					String hobbies[] = hobbiesStr.split(",");
					
					for (int i = 0; i < hobbies.length; i++) 
					{
						System.out.println("hobbies["+ i +"] : " +hobbies[i]);
					}
					sbean = new StudentBean(id, fullname, age, course, gender, hobbies, dob, email, mobile, address);
					list.add(sbean);
				}
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("StudentDao--getAllStudentRecords() Db not Connecteed");
		}
		
		return list;
	}
	public static void main(String[] args) 
	{
		StudentDao dao = new StudentDao();
		
		ArrayList<StudentBean> list = dao.getAllStudentRecords();
		System.out.println("list.size() : " + list.size());
		
		for (int i = 0; i < list.size(); i++) 
		{
			StudentBean s = list.get(i);
			System.out.println(s.getId()+" " + s.getFullname()+" " );
		}
	}
	
}
