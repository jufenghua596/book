/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class Invoke {

    public void typeConvert() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class, int.class));
        mh = mh.asType(MethodType.methodType(String.class, String.class, Integer.class, Integer.class));
        mh = mh.asType(MethodType.methodType(Object.class, String.class, Integer.class, Integer.class));
        Object obj = mh.invokeWithArguments("Hello", 2, 3);
        System.out.println(obj);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Invoke invoke = new Invoke();
        try {
            invoke.typeConvert();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
