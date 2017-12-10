package com.java7book.calculator.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.equinox.servletbridge.BridgeServlet;

public class CustomBridgeServlet extends BridgeServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("WebappClassLoader", this.getClass().getClassLoader());
		super.service(req, resp);
	}
}
