package com.MyWepOne.Initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.MyWepOne.config.Appconfig;
import com.MyWepOne.config.WebConfig;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MWebAppInitializer implements WebApplicationInitializer
{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Appconfig.class);
		// TODO Auto-generated method stub
        rootContext.refresh();
        //context Lodaer list
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));

        webContext.register(WebConfig.class);
        // DispatcherServlet 생성 및 등록
      
        if (dispatcher != null) {
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
        } else {
            throw new ServletException("Failed to register DispatcherServlet.");
        }
	}



}
