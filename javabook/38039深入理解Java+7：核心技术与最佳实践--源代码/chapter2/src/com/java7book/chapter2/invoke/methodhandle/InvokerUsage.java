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
public class InvokerUsage {

    public void invoker() throws Throwable {
        MethodType typeInvoker = MethodType.methodType(String.class, Object.class, int.class, int.class);
        MethodHandle invoker = MethodHandles.invoker(typeInvoker);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType typeFind = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh1 = lookup.findVirtual(String.class, "substring", typeFind);
        MethodHandle mh2 = lookup.findVirtual(InvokerUsage.class, "testMethod", typeFind);
        String result = (String) invoker.invoke(mh1, "Hello", 2, 3);
        System.out.println(result);
        result = (String) invoker.invoke(mh2, this, 2, 3);
        System.out.println(result);
    }

    public void exactInvoker() throws Throwable {
        MethodType typeInvoker = MethodType.methodType(String.class, String.class, int.class, int.class);
        MethodHandle invoker = MethodHandles.exactInvoker(typeInvoker);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhUpperCase = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class));
        invoker = MethodHandles.filterReturnValue(invoker, mhUpperCase);
        MethodType typeFind = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh1 = lookup.findVirtual(String.class, "substring", typeFind);
        String result = (String) invoker.invoke(mh1, "Hello", 1, 4);
        System.out.println(result);
    }

    public String testMethod(int arg1, int arg2) {
        return "Hello";
    }

    public static void spreadMethod(int arg1, Object... arg2) {
    }

    public void spreadInvoker() throws Throwable {
        MethodType typeInvoker = MethodType.methodType(void.class, int.class, String.class, int.class);
        MethodHandle invoker = MethodHandles.spreadInvoker(typeInvoker, 1);
        System.out.println(invoker.type());
        MethodType typeFind = MethodType.methodType(void.class, int.class, Object[].class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh1 = lookup.findStatic(InvokerUsage.class, "spreadMethod", typeFind);
        invoker.invoke(mh1, 2, new Object[]{"H", 1});
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        InvokerUsage invoker = new InvokerUsage();
        invoker.invoker();
        invoker.exactInvoker();
        invoker.spreadInvoker();
    }
}
