package com.java7book.calculator.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ClassLoaderListener
 *
 */
@WebListener
public class ClassLoaderListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ClassLoaderListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        System.out.println(event.getServletContext());
        System.out.println(this.getClass().getClassLoader());
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        System.out.println(Thread.currentThread());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
    }
	
}
