package com.java7book.securewebapp.servlet;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java7book.securewebapp.service.EmployeeService;
import com.java7book.securewebapp.service.EmployeeServiceFactory;

/**
 * Servlet implementation class EmployeeInfoServlet
 */
@WebServlet("/protected/employeeinfo")
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject subject = (Subject) request.getSession(true).getAttribute("subject");
		if (subject == null) {
			throw new ServletException("");
		}
		EmployeeService service = EmployeeServiceFactory.getEmployeeService();
		String employeeId = request.getParameter("id");
		service.read(employeeId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
