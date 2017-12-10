package com.java7book.securewebapp;

import java.io.Serializable;
import java.security.Principal;

public class RolePrincipal implements Principal, Serializable {
	
	private String role;
	
	public RolePrincipal(String role) {
		this.role = role;
	}

	@Override
	public String getName() {
		return role;
	}

}
