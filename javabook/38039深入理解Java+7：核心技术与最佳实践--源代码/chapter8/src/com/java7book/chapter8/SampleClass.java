package com.java7book.chapter8;

public class SampleClass {
	private String name;
	
	private short size = 56;
	
	public String getName() {
		return name;
	}
	
	public <T> T echo(T input) {
		return input;
	}
}
