package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;

public class AccessControlMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccessControl ac = new AccessControl();
		try {
			MethodHandle mh = ac.accessControl();
			mh.invoke();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

}
