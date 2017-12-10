/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodtype;

import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodTypeByType {
    public void generateMethodTypes() {
        //String.length()
        MethodType mt1 = MethodType.methodType(int.class);
        //String.concat(String str)
        MethodType mt2 = MethodType.methodType(String.class, String.class);
        //String.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        MethodType mt3 = MethodType.methodType(void.class, int.class, int.class, char[].class, int.class);
        //String.startsWith(String prefix)
        MethodType mt4 = MethodType.methodType(boolean.class, mt2);
        
        System.out.println(mt1);
        System.out.println(mt2);
        System.out.println(mt3);
        System.out.println(mt4);
    }
    
    public static void main(String[] args) {
        new MethodTypeByType().generateMethodTypes();
    }
}
