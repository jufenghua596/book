/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodHandleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Object x, y;
        String s;
        int i;
        MethodType mt;
        MethodHandle mh;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        mt = MethodType.methodType(String.class, char.class, char.class);
        mh = lookup.findVirtual(String.class, "replace", mt);
        s = (String) mh.invokeExact("daddy", 'd', 'n');
        System.out.println(s);
        
        ConstantCallSite ccs = new ConstantCallSite(mh);
        MethodHandle di = ccs.dynamicInvoker();
        s = (String) di.invokeExact("daddy", 'd', 'n');
        System.out.println(s);
    }
}
