package com.java7book.securewebapp.filter;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.java7book.securewebapp.SubjectHolder;

/**
 * Servlet Filter implementation class AuthCheckFilter
 */
@WebFilter("/protected/*")
public class AuthCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Subject subject = (Subject) req.getSession(true).getAttribute("subject");
		if (subject == null) {
			req.getRequestDispatcher("/login").forward(req, response);
			return;
		}
		SubjectHolder.set(subject);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
