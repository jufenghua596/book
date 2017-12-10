/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke;

/**
 *
 * @author chengfu
 */
public class Test {
    public static void test(String str) {
        System.out.println("string");
    }
    
    public static void test(Object obj) {
        System.out.println("object");
    }
    
    public static void main(String[] args) {
        test(12);
    }
}
