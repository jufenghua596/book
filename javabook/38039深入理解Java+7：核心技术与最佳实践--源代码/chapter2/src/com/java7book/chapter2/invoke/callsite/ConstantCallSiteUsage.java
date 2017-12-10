/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.callsite;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class ConstantCallSiteUsage {
    
    public void useConstantCallSite() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type);
        ConstantCallSite callSite = new ConstantCallSite(mh);
        MethodHandle invoker = callSite.dynamicInvoker();
        String result = (String) invoker.invoke("Hello", 2, 3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        ConstantCallSiteUsage ccsu = new ConstantCallSiteUsage();
        ccsu.useConstantCallSite();
    }
}
