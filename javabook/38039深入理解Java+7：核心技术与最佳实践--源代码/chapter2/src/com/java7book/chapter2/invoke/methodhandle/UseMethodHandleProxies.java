package com.java7book.chapter2.invoke.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class UseMethodHandleProxies {
	
	public void doSomething() {
		System.out.println("WORK");
	}
	
	public void useMethodHandleProxy() throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = lookup.findVirtual(UseMethodHandleProxies.class, "doSomething", MethodType.methodType(void.class));
		mh = mh.bindTo(this);
		Runnable runnable = MethodHandleProxies.asInterfaceInstance(Runnable.class, mh);
		new Thread(runnable).start();
	}

	public static void main(String[] args) {
		UseMethodHandleProxies umhp = new UseMethodHandleProxies();
		try {
			umhp.useMethodHandleProxy();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
