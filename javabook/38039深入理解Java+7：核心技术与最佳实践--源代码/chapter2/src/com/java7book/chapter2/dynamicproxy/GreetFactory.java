/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 *
 * @author chengfu
 */
public class GreetFactory {

    public static GreetV2 adaptGreet(GreetV1 greet) {
        GreetAdapter adapter = new GreetAdapter(greet);
        ClassLoader cl = greet.getClass().getClassLoader();
        return (GreetV2) Proxy.newProxyInstance(cl, new Class<?>[]{GreetV2.class}, adapter);
    }
}
