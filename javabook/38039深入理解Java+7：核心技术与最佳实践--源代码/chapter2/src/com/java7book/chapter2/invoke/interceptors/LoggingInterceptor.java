/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.interceptors;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/**
 *
 * @author chengfu
 */
public class LoggingInterceptor {
    public MethodHandle getLoggingHandle() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object[].class);
        try {
            return lookup.findVirtual(LoggingInterceptor.class, "log", type).bindTo(this);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private void log(Object... args) {
        System.out.println("LOG");
        System.out.println(Arrays.deepToString(args));
    }
}
