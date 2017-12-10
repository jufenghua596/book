package com.java7book.chapter7.ref;

public class ReferencedObject {
	private String name;
	
	private String email;
	
	private SecondaryObject secondaryObject = new SecondaryObject();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SecondaryObject getSecondaryObject() {
		return secondaryObject;
	}
}
