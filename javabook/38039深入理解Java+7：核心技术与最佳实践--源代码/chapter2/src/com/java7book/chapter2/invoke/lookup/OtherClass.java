/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;

/**
 *
 * @author chengfu
 */
public class OtherClass {
    public void access() throws Throwable {
        MethodHandleLookup mhl = new MethodHandleLookup();
        MethodHandle mh = mhl.lookupSpecial();
        MHS p = new MHS();
        mh.invoke(p);
    }
    
    public static void main(String[] args) throws Throwable {
        OtherClass oc = new OtherClass();
        oc.access();
    }
    
    public static class MHS extends MethodHandleLookup {

        @Override
        protected void protectedMethod() {
           System.out.println("MHS");
        }
        
    }
}
