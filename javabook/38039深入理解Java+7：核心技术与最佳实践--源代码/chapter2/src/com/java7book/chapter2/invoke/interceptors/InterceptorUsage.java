/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.interceptors;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class InterceptorUsage {

    public static void normalMethod(String arg1, String arg2) {
        System.out.println(arg1 + " == " + arg2);
    }

    public static void useInterceptor() throws Throwable {
        LoggingInterceptor interceptor = new LoggingInterceptor();
        MethodHandle target = getTargetMethod();
        target = target.asSpreader(Object[].class, target.type().parameterCount());
        target = target.asVarargsCollector(Object[].class);
        MethodHandle before = interceptor.getLoggingHandle();
        MethodHandle mhNew = Interceptors.before(target, before);
        mhNew = mhNew.asVarargsCollector(Object[].class);
        mhNew.invoke("a", "b");
    }

    public static MethodHandle getTargetMethod() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, String.class, String.class);
        try {
            return lookup.findStatic(InterceptorUsage.class, "normalMethod", type);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        InterceptorUsage iu = new InterceptorUsage();
        iu.useInterceptor();
    }
}
