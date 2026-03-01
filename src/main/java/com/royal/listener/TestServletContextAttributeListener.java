package com.royal.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

//Listener:-
//-----------
//	1. request---code--execute
//		ServletRequestListener
//
//	2. requestAttribute
//		ServletRequestAttributeListener
//
//	3. session
//		HttpSessionListener
//			sessionCreated()
//			sessionDestroyed()
//
//	4. session Attribute
//		HttpSessionAttributeListener
//		
//	5. Context
//		ServletContextListener
//
//	6. ContextAttribute
//		ContextAttributeListener

		
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
