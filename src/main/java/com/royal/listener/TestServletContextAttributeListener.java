package com.royal.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;


public class TestServletContextAttributeListener implements ServletContextAttributeListener 
{
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener---attributeAdded()");
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener---attributeReplaced()");
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener---attributeRemoved()");
	}
}
