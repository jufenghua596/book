package com.java7book.chapter7.jni;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface User32Library extends Library {
	User32Library INSTANCE = (User32Library) Native.loadLibrary("user32", User32Library.class);
	
	int MessageBoxA(Pointer handle, String text, String caption, int type);
}
