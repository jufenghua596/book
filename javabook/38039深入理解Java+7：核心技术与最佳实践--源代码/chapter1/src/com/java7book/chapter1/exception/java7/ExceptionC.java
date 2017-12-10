/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionC extends Exception {

    /**
     * Creates a new instance of <code>ExceptionC</code> without detail message.
     */
    public ExceptionC() {
    }

    /**
     * Constructs an instance of <code>ExceptionC</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExceptionC(String msg) {
        super(msg);
    }
}
