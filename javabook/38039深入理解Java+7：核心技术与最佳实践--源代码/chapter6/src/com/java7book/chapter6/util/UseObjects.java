package com.java7book.chapter6.util;

import java.util.Comparator;
import java.util.Objects;

public class UseObjects {
	
	private static class ReverseComparator implements Comparator<Long> {
		public int compare(Long num1, Long num2) {
			return num2.compareTo(num1);
		}
	}
	
	public void compare() {
		int value1 = Objects.compare(1L, 2L, new ReverseComparator());
		System.out.println(value1);
	}
	
	public void equals() {
		boolean value1 = Objects.equals(new Object(), new Object());
		Object[] array1 = new Object[] {"Hello", 1, 1.0};
		Object[] array2 = new Object[] {"Hello", 1, 1.5};
		boolean value2 = Objects.deepEquals(array1, array2);
		System.out.println(value1);
		System.out.println(value2);
	}
	
	public void hash() {
		int hashCode1 = Objects.hashCode("Hello");
		int hashCode2 = Objects.hash("Hello", "World");
		int hashCode3 = Objects.hash("Hello");
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		System.out.println(hashCode3);
	}
	
	public void useToString() {
		String str1 = Objects.toString("Hello");
		String str2 = Objects.toString(null, "ø’∂‘œÛ");
		System.out.println(str1);
		System.out.println(str2);
	}

	public static void main(String[] args) {
		UseObjects uo = new UseObjects();
		uo.compare();
		uo.equals();
		uo.hash();
		uo.useToString();
	}
}
