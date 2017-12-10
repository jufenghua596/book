package com.java7book.chapter7.jni;

public class PerfTest {

	public static void runOnce() {
		System.out.println("RUN ... ");
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			runOnce();
		}
	}

}
