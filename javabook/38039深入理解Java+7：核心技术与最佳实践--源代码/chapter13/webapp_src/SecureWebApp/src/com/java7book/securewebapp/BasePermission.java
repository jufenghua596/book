package com.java7book.securewebapp;

import java.security.BasicPermission;

public class BasePermission extends BasicPermission {

	public BasePermission(String name) {
		super(name);
	}

	public BasePermission(String name, String actions) {
		super(name, actions);
	}
	
}
