/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MMMMM extends MethodHandleLookup {
    public void test() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findSpecial(MethodHandleLookup.class, "protectedMethod", MethodType.methodType(void.class), MMMMM.class);
        mh.invoke(this);
    }

    @Override
    protected void protectedMethod() {
        System.out.println("M");
    }
    
    public static void main(String[] args) {
        MMMMM m = new MMMMM();
        try {
            m.test();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
