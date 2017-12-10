/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 *
 * @author chengfu
 */
public class Other {
    
    public void arrayHandles() throws Throwable {
        int[] array = new int[] {1, 2, 3, 4, 5};
        MethodHandle setter = MethodHandles.arrayElementSetter(int[].class);
        setter.invoke(array, 3, 6);
        MethodHandle getter = MethodHandles.arrayElementGetter(int[].class);
        int value = (int) getter.invoke(array, 3); //值为6
        System.out.println(value);
    }
    
    public void identity() throws Throwable {
        MethodHandle mh = MethodHandles.identity(String.class);
        String value = (String) mh.invoke("Hello"); //值为"Hello"
        System.out.println(value);
    }
    
    public void constant() throws Throwable {
        MethodHandle mh = MethodHandles.constant(String.class, "Hello");
         String value = (String) mh.invoke();
        System.out.println(value);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Other other = new Other();
        other.arrayHandles();
        other.identity();
        other.constant();
    }
}
