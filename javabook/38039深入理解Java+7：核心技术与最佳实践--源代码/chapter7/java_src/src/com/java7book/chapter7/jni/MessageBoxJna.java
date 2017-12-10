package com.java7book.chapter7.jni;

public class MessageBoxJna {
	
	public int show(String text, String caption) {
		return User32Library.INSTANCE.MessageBoxA(null, text, caption, 0x40);
	}

	public static void main(String[] args) {
		MessageBoxJna mb = new MessageBoxJna();
		mb.show("Hello World", "JNI");
	}

}
