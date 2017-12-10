/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.interceptors;

/**
 *
 * @author chengfu
 */
public class SimpleClass {
    public void method1(int arg1, int arg2, String arg3) {
        System.out.println("INVOKE - method1");
    }
    
    public void method2(String arg1) { 
         System.out.println("INVOKE - method2");
    }
}
