package com.java7book.chapter7.jni;

public class MessageBox {
	static {
        System.loadLibrary("MessageBox");
    }

	public native int show(String text, String caption);
	
	
	public static void main(String[] args) {
		MessageBox mb = new MessageBox();
		mb.show("Hello World", "JNI");
	}

}
