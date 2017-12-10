/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

/**
 *
 * @author chengfu
 */
public class GreetException extends Exception {

    /**
     * Creates a new instance of <code>GreetException</code> without detail message.
     */
    public GreetException() {
    }

    /**
     * Constructs an instance of <code>GreetException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public GreetException(String msg) {
        super(msg);
    }
}
