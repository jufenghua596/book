package com.java7book.chapter6.lang;

public class NumberCache {

	public void stringIntern() {
		boolean value1 = "Hello" == "Hello";
		boolean value2 = (new String("Hello") == "Hello");
		boolean value3 = (new String("Hello").intern() == "Hello");
		System.out.println(value3);
	}
	
	public void numberCache() {
		boolean value1 = Integer.valueOf(3) == Integer.valueOf(3);
		boolean value2 = Integer.valueOf(129) == Integer.valueOf(129);
		System.out.println(value1);
		System.out.println(value2);
	}

	public static void main(String[] args) {
		NumberCache nc = new NumberCache();
		nc.stringIntern();
		nc.numberCache();
	}

}
