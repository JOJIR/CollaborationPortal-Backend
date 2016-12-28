package com.niit.backend.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("runs!!!");
		return new Class[]{WebAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	//DispatcherServlet - receives all the request (any URL)
	@Override
	protected String[] getServletMappings() 
	{
		System.out.println("works okay!!!");
		return new String[]{"/"};
	}
}
