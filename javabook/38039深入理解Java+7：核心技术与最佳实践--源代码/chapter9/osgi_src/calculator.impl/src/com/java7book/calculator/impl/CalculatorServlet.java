package com.java7book.calculator.impl;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java7book.calculator.servlet.CustomBridgeServlet;


public class CalculatorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Thread currentThread = Thread.currentThread();
		ClassLoader oldContextLoader = currentThread.getContextClassLoader();
		ClassLoader webappLoader = (ClassLoader) req.getAttribute("WebappClassLoader");
		currentThread.setContextClassLoader(webappLoader);
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("rb");
        currentThread.setContextClassLoader(oldContextLoader);
        if (engine == null) {
        	resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	return;
        }
        String expr = req.getParameter("expr");
        try {
			Object result = engine.eval(expr);
			resp.getWriter().write(result.toString());
		} catch (ScriptException e) {
			throw new ServletException(e);
		}
	}
}
