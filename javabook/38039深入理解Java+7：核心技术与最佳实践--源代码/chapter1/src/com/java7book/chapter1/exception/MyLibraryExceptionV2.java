/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception;

/**
 *
 * @author chengfu
 */
public class MyLibraryExceptionV2 extends Exception {

    /**
     * Creates a new instance of <code>MyLibraryExceptionV2</code> without detail message.
     */
    public MyLibraryExceptionV2() {
    }

    /**
     * Constructs an instance of <code>MyLibraryExceptionV2</code> with the specified detail message.
     * @param msg the detail message.
     */
    public MyLibraryExceptionV2(String msg) {
        super(msg);
    }
}
