/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author chengfu
 */
public class MultipleInterfacesProxy {

    public void proxyMultipleInterfaces() throws Throwable {
        List<String> receiverObj = new ArrayList<String>();
        ClassLoader cl = MultipleInterfacesProxy.class.getClassLoader();
        LoggingInvocationHandler handler = new LoggingInvocationHandler(receiverObj);
        Class<?> proxyClass = Proxy.getProxyClass(cl, new Class<?>[]{List.class, Set.class});
        Object proxy = proxyClass.getConstructor(new Class[]{InvocationHandler.class}).
                newInstance(new Object[]{handler});
        List list = (List) proxy;
        list.add("Hello");
        Set set = (Set) proxy;
        set.add("World");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        MultipleInterfacesProxy proxy = new MultipleInterfacesProxy();
        proxy.proxyMultipleInterfaces();
    }
}
