package com.java7book.calculator.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class WebAppLoaderServlet
 */
@WebServlet("/webapploader")
public final class WebAppLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebAppLoaderServlet() {
        super();
    }
    
    

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext context = config.getServletContext();
		context.setAttribute("cl", getWebAppClassLoader());
	}



	public static ClassLoader getWebAppClassLoader() {
    	return WebAppLoaderServlet.class.getClassLoader();
    }
}
