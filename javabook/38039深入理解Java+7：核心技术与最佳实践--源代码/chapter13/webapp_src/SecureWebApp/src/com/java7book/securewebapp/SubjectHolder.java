package com.java7book.securewebapp;

import javax.security.auth.Subject;

public class SubjectHolder {
	private static ThreadLocal<Subject> holder = new ThreadLocal<Subject>();
	
	public static Subject get() {
		return holder.get();
	}
	
	public static void set(Subject subject) {
		holder.set(subject);
	}
}
