/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chengfu
 */
public class LoggingInvocationHandler implements InvocationHandler {

    private static final Logger LOGGER = Logger.getLogger(LoggingInvocationHandler.class.getName());
    private Object receiverObject;

    public LoggingInvocationHandler(Object thisObject) {
        this.receiverObject = thisObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.log(Level.INFO, "调用方法 " + method + "；参数为 " + Arrays.deepToString(args));
        return method.invoke(receiverObject, args);
    }
}
