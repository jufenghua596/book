package com.java7book.securewebapp.servlet;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java7book.securewebapp.login.RequestCallbackHandler;
import com.java7book.securewebapp.login.SecureConfiguration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Path rootPath = Paths.get(request.getServletContext().getRealPath("/"));
		SecureConfiguration config = new SecureConfiguration(rootPath);
		RequestCallbackHandler callbackHandler = new RequestCallbackHandler(request);
		try {
			LoginContext loginContext = new LoginContext("SecureWebApp", null, callbackHandler, config);
			loginContext.login();
			Subject subject = loginContext.getSubject();
			request.getSession(true).setAttribute("subject", subject);
		} catch (LoginException e) {
			throw new ServletException(e);
		}
	}

}
