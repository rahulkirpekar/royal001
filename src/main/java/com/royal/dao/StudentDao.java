package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	
	
	public ArrayList<StudentBean> getStudentByLimit(int start ,int end) 
	{
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		
		String selectQueryByLimit = "SELECT * FROM student ORDER BY id LIMIT "+start+" , "+end+"";
		
		System.out.println("selectQueryByLimit : " + selectQueryByLimit);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sbean = null;
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rs = stmt.executeQuery(selectQueryByLimit);
				
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
			System.out.println("StudentDao--getStudentByLimit() Db not Connecteed");
		}
		
		return list;
	}
	public int getTotalRecords() {

	    String sql = "SELECT COUNT(*) FROM student";

	    Statement st;
		try 
		{
			st = DBConnection.getConnection().createStatement();
		
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) 
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    return 0;
	}

	public int deleteStudentById(int id) 
	{
		String deleteQuery = "DELETE FROM Student WHERE id="+id;
		System.out.println("deleteQuery : "  +deleteQuery);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt=  null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				stmt =  conn.createStatement();
				rowsAffected = stmt.executeUpdate(deleteQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao--deleteStudentById()--Db not connected");
		}
		return rowsAffected;
	}

	public StudentBean getStudentById(int id) 
	{
		String selectQuery = "SELECT * from student WHERE id="+id;
		
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
				
				rs.next(); 
				int id1 = rs.getInt(1);
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
				sbean = new StudentBean(id1, fullname, age, course, gender, hobbies, dob, email, mobile, address);
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("StudentDao--getStudentById() Db not Connecteed");
		}
		return sbean;
	}

	public int updateStudent(StudentBean sbean, int id) 
	{
		String updateQuery = "UPDATE student SET fullname=?,age=?,course=?,gender=?,hobbies=?,date_of_birth=?,email=?,mobile=?,address=? WHERE id=?";
		System.out.println("updateQuery : " + updateQuery);
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt=  null;
		int rowsAffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt =  conn.prepareStatement(updateQuery);
				
				pstmt.setString(1, sbean.getFullname());
				pstmt.setInt(2, sbean.getAge());
				pstmt.setString(3, sbean.getCourse());
				pstmt.setString(4, sbean.getGender());
				pstmt.setString(5, sbean.getHobbiesStr());
				pstmt.setString(6, sbean.getDob());
				pstmt.setString(7, sbean.getEmail());
				pstmt.setString(8, sbean.getMobile());
				pstmt.setString(9, sbean.getAddress());
				
				pstmt.setInt(10, id);
				
				rowsAffected = pstmt.executeUpdate();
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
