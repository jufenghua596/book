package com.java7book.securewebapp.login;

import javax.security.auth.callback.Callback;

public class RequestParameterCallback implements Callback {
	private final String parameter;
	private String value;
	
	public RequestParameterCallback(String parameter) {
		this.parameter = parameter;
	}
	
	public String getParameter() {
		return this.parameter;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
