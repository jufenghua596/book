/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.instruction;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class ToUpperCase {
    public static CallSite bootstrap(Lookup lookup, String name, MethodType type, String value) throws Exception {
        System.out.println(name);
        MethodHandle mh = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class)).bindTo(value);
        return new ConstantCallSite(mh);
    }
}
