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
public class Varargs {

    public void normalMethod(String arg1, int arg2, int[] arg3) {
    }

    public void toBeSpreaded(String arg1, int arg2, int arg3, int arg4) {
    }

    public void varargsMethod(String arg1, int... args) {
    }

    public void asVarargsCollector() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(Varargs.class, "normalMethod", MethodType.methodType(void.class, String.class, int.class, int[].class));
        mh = mh.asVarargsCollector(int[].class);
        mh.invoke(this, "Hello", 2, 3, 4, 5);
        System.out.println(mh.type());
    }

    public void asCollector() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(Varargs.class, "normalMethod", MethodType.methodType(void.class, String.class, int.class, int[].class));
        mh = mh.asCollector(int[].class, 2);
        mh.invoke(this, "Hello", 2, 3, 4);
        System.out.println(mh.type());
    }

    public void asSpreader() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(Varargs.class, "toBeSpreaded", MethodType.methodType(void.class, String.class, int.class, int.class, int.class));
        mh = mh.asSpreader(int[].class, 3);
        mh.invoke(this, "Hello", new int[]{3, 4, 5});
        System.out.println(mh.type());
    }

    public void asFixedArity() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(Varargs.class, "varargsMethod", MethodType.methodType(void.class, String.class, int[].class));
        mh = mh.asFixedArity();
        mh.invoke(this, "Hello", new int[]{2, 4});
        System.out.println(mh.type());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Varargs v = new Varargs();
        v.asVarargsCollector();
        v.asCollector();
        v.asSpreader();
        v.asFixedArity();
    }
}
