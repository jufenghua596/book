/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.interceptors;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/**
 *
 * @author chengfu
 */
public class LoggingBootstrap {
    public static CallSite bootstrap(Lookup lookup, String name, MethodType type, Object[] params) throws Exception {
        System.out.println("CAlled");
        MethodHandle mh = lookup.findStatic(LoggingBootstrap.class, "log", MethodType.methodType(void.class, Object[].class)).bindTo(params);
        return new ConstantCallSite(mh);
    }
    
    public static void log(Object[] args) {
        System.out.println("LOG => " + Arrays.deepToString(args));
    }
}
