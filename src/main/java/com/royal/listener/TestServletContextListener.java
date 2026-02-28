package com.royal.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

public class TestServletContextListener implements ServletContextListener 
{
	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("TestServletContextListener :  contextInitialized() ");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		System.out.println("TestServletContextListener :  contextDestroyed() ");
	}
	
}
