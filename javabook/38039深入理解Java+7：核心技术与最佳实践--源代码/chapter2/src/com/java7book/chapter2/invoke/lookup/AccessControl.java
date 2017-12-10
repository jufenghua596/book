package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;


public class AccessControl {
	private void privateMethod() {
		System.out.println("PRIVATE");
	}
	
	public MethodHandle accessControl() throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = lookup.findSpecial(AccessControl.class, "privateMethod", MethodType.methodType(void.class), AccessControl.class);
		mh = mh.bindTo(this);
		return mh;
	}
}
