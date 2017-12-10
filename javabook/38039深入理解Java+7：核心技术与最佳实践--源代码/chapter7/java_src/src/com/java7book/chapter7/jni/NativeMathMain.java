package com.java7book.chapter7.jni;

public class NativeMathMain {

	public static void main(String[] args) {
		NativeMath math = new NativeMath();
		System.out.println(math.sqrt(2.0));
		Rectangle rectangle = new Rectangle(300.5, 400.3);
		System.out.println(math.size(rectangle));
	}

}
