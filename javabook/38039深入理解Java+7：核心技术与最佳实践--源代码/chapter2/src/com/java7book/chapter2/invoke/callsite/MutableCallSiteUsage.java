/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.callsite;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;

/**
 *
 * @author chengfu
 */
public class MutableCallSiteUsage {
    
    public void useMutableCallSite() throws Throwable {
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MutableCallSite callSite = new MutableCallSite(type);
        MethodHandle invoker = callSite.dynamicInvoker();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhMax = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhMin = lookup.findStatic(Math.class, "min", type);
        callSite.setTarget(mhMax);
        int result = (int) invoker.invoke(3, 5); //值为5
        callSite.setTarget(mhMin);
        result = (int) invoker.invoke(3, 5); //值为3
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        MutableCallSiteUsage mcsu = new MutableCallSiteUsage();
        mcsu.useMutableCallSite();
    }
}
