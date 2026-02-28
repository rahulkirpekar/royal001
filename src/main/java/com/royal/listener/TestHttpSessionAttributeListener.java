package com.royal.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class TestHttpSessionAttributeListener implements HttpSessionAttributeListener 
{
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) 
	{
		System.out.println("TestHttpSessionAttributeListener---attributeAdded()");
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) 
	{
		System.out.println("TestHttpSessionAttributeListener---attributeReplaced()");
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) 
	{
		System.out.println("TestHttpSessionAttributeListener---attributeRemoved()");
	}
}
