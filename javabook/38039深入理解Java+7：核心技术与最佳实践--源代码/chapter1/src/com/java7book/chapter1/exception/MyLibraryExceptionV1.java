/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception;

/**
 *
 * @author chengfu
 */
public class MyLibraryExceptionV1 extends Exception {

    /**
     * Creates a new instance of <code>MyLibraryException</code> without detail message.
     */
    public MyLibraryExceptionV1() {
    }

    /**
     * Constructs an instance of <code>MyLibraryException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public MyLibraryExceptionV1(String msg) {
        super(msg);
    }
}
