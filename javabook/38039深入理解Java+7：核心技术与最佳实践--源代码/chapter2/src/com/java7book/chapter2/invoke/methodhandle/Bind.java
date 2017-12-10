/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 
 * @author chengfu
 */
public class Bind {

	public void bindTo() throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = lookup.findVirtual(String.class, "length",
				MethodType.methodType(int.class));
		int len = (int) mh.invoke("Hello");
		System.out.println(len);
		mh = mh.bindTo("Hello World");
		len = (int) mh.invoke();
		System.out.println(len);
		mh = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class, int.class));
		mh = mh.asType(mh.type().wrap());
		mh = mh.bindTo("Hello World").bindTo(3);
		System.out.println(mh.invoke(5));
	}

	public void multipleBindTo() throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = lookup.findVirtual(String.class, "indexOf",
				MethodType.methodType(int.class, String.class, int.class));
		mh = mh.bindTo("Hello").bindTo("l");
		System.out.println(mh.invoke(2));
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws Throwable {
		Bind bind = new Bind();
		bind.bindTo();
		bind.multipleBindTo();
	}
}
