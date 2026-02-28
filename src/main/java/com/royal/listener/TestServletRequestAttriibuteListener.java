package com.royal.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class TestServletRequestAttriibuteListener implements ServletRequestAttributeListener 
{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttriibuteListener---attributeAdded()");
	}
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttriibuteListener---attributeReplaced()");
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) 
	{
		System.out.println("TestServletRequestAttriibuteListener---attributeRemoved()");
	}
}
