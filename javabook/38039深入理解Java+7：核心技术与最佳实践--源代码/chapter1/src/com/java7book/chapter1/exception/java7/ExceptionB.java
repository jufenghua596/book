/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionB extends BaseException {

    /**
     * Creates a new instance of <code>ExceptionB</code> without detail message.
     */
    public ExceptionB() {
    }

    /**
     * Constructs an instance of <code>ExceptionB</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExceptionB(String msg) {
        super(msg);
    }
    
}
