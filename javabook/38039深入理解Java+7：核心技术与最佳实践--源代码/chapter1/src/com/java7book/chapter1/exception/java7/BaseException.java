/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class BaseException extends Exception {

    /**
     * Creates a new instance of <code>BaseException</code> without detail message.
     */
    public BaseException() {
    }

    /**
     * Constructs an instance of <code>BaseException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BaseException(String msg) {
        super(msg);
    }
}
