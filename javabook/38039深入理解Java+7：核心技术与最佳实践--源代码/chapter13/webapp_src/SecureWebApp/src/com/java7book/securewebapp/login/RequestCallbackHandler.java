package com.java7book.securewebapp.login;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.servlet.http.HttpServletRequest;

public class RequestCallbackHandler implements CallbackHandler {
	private final HttpServletRequest request;

	public RequestCallbackHandler(HttpServletRequest request) {
		this.request = request;
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			if (callback instanceof RequestParameterCallback) {
				RequestParameterCallback requestCallback = (RequestParameterCallback) callback;
				String parameter = requestCallback.getParameter();
				String value = request.getParameter(parameter);
				requestCallback.setValue(value);
			} else {
				throw new UnsupportedCallbackException(callback);
			}
		}
	}
}
