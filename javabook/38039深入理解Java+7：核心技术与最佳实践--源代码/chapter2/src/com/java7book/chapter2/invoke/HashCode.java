/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke;

/**
 *
 * @author chengfu
 */
public class HashCode {
    
    public void useHashCode() {
        String str = "Hello";
        Object obj = str;
        obj.hashCode();
        MyObject myObj = new MyObject();
        myObj.hashCode();
    }
    
    static class MyObject extends Object {
        
    }
}
