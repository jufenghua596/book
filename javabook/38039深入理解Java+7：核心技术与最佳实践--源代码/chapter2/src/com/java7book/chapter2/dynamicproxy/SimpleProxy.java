/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengfu
 */
public class SimpleProxy {

    public static <T> T makeProxy(Class<T> intf, final T object) {
        LoggingInvocationHandler handler = new LoggingInvocationHandler(object);
        ClassLoader cl = object.getClass().getClassLoader();
        return (T) Proxy.newProxyInstance(cl, new Class<?>[]{intf}, handler);
    }

    public static Object proxyAll(final Object object) {
        LoggingInvocationHandler handler = new LoggingInvocationHandler(object);
        ClassLoader cl = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return Proxy.newProxyInstance(cl, interfaces, handler);
    }

    public static void useProxy() {
        String str = "Hello World";
        LoggingInvocationHandler handler = new LoggingInvocationHandler(str);
        ClassLoader cl = SimpleProxy.class.getClassLoader();
        Comparable obj = (Comparable) Proxy.newProxyInstance(cl, new Class[]{Comparable.class}, handler);
        obj.compareTo("Good");
    }

    public static void useGenericProxy() {
        String str = "Hello World";
        Comparable proxy = makeProxy(Comparable.class, str);
        proxy.compareTo("Good");
        List<String> list = new ArrayList<String>();
        list = makeProxy(List.class, list);
        list.add("Hello");
    }

    public static void useAllProxy() {
        String str = "Hello World";
        CharSequence cs = (CharSequence) proxyAll(str);
        cs.length();
        cs.charAt(0);
        cs.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        useProxy();
        useGenericProxy();
        useAllProxy();
    }
}
