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
public class ArrayUsage {
    
    public int sum(int v1, int v2) {
        return v1 + v2;
    }
    
    public int multipy(int v1, int v2) {
        return v1 * v2;
    }
    
    public void testAllUsage() throws Throwable {
        MethodType typeReduce = MethodType.methodType(int.class, int.class, int.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhSum= lookup.findVirtual(ArrayUsage.class, "sum", typeReduce).bindTo(this);
        Object[] testArray = {1, 2, 3, 4, 5};
        Object result = Array.reduce(testArray, 0, mhSum);
        System.out.println(result);
        MethodHandle mhMultipy = lookup.findVirtual(ArrayUsage.class, "multipy", typeReduce).bindTo(this);
        result = Array.reduce(testArray, 1, mhMultipy);
        System.out.println(result);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        ArrayUsage au = new ArrayUsage();
        au.testAllUsage();
    }
}
