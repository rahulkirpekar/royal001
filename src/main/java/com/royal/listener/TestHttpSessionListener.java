package com.royal.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class TestHttpSessionListener implements HttpSessionListener 
{
	@Override
	public void sessionCreated(HttpSessionEvent se) 
	{
		System.out.println("TestHttpSessionListener :  sessionCreated() ");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("TestHttpSessionListener :  sessionDestroyed() ");
	}
}
