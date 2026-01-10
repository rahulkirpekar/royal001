package com.royal.util;

public class StudentUtils 
{
	public static boolean isValidString(String value) 
	{
		if ((value!=null) && (value.trim().length() > 0)) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
