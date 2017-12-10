package com.java7book.chapter7.jni;

public class NativeMath {
	static {
        System.loadLibrary("NativeMath");
    }
	
	public native double sqrt(double value);
	
	public native double size(Rectangle rectangle);
}
