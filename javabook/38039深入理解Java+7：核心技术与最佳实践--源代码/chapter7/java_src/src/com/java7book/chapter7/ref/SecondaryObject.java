package com.java7book.chapter7.ref;

public class SecondaryObject {

	private int count = 0;
	
	public int count() {
		System.out.println(count);
		return count++;
	}
}
