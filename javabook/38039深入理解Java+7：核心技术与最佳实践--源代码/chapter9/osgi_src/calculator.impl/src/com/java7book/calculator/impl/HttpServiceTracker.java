package com.java7book.calculator.impl;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class HttpServiceTracker extends ServiceTracker {
	public HttpServiceTracker(BundleContext context) {
		super(context, HttpService.class.getName(), null);
	}

	@Override
	public Object addingService(ServiceReference reference) {
		final HttpService httpService = (HttpService) context
				.getService(reference);
		final HttpContext httpContext = httpService.createDefaultHttpContext();
		try {
			httpService.registerServlet("/calculator",
					new CalculatorServlet(), null,
					httpContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpService;
	}

	public void removedService(ServiceReference reference, Object service) {
		HttpService httpService = (HttpService) service;
		httpService.unregister("/calculator");
		httpService.unregister("/"); //$NON-NLS-1$
		super.removedService(reference, service);
	}
}
