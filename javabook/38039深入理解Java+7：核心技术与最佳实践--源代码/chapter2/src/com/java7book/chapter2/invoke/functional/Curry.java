/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.functional;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class Curry {
    
    public static int add(int a, int b) {
        return a + b;
    }
    public static MethodHandle curry(MethodHandle handle, int value) {
        return MethodHandles.insertArguments(handle, 0, value);
    }
    
    public static int add5(int a) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhAdd = lookup.findStatic(Curry.class, "add", type);
        MethodHandle mh = curry(mhAdd, 5);
        return (int) mh.invoke(a);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        System.out.println(Curry.add5(10));
    }
}
