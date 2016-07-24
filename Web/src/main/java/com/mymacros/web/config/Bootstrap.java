package com.mymacros.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Tomas on 23/07/2016.
 */
public class Bootstrap implements WebApplicationInitializer
{
     @Override
     public void onStartup(ServletContext container) throws ServletException
     {
          container.getServletRegistration("default")
                  .addMapping("/resource/*");

          AnnotationConfigWebApplicationContext rootContext =
                  new AnnotationConfigWebApplicationContext();

          rootContext.register(RootContextConfig.class);
          container.addListener(new ContextLoaderListener(rootContext));

          AnnotationConfigWebApplicationContext servletContext =
                  new AnnotationConfigWebApplicationContext();
          servletContext.register(ServletContextConfig.class);
          ServletRegistration.Dynamic dispatcher = container.addServlet(
                  "springDispatcher", new DispatcherServlet(servletContext)
          );
          dispatcher.setLoadOnStartup(1);
          dispatcher.setMultipartConfig(new MultipartConfigElement(
                  null, 20_971_520L, 41_943_040L, 512_000
          ));
          dispatcher.addMapping("/");

     }
}
