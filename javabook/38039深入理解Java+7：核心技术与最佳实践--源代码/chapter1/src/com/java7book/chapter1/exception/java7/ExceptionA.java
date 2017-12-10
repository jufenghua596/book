/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionA extends BaseException {

    /**
     * Creates a new instance of <code>ExceptionA</code> without detail message.
     */
    public ExceptionA() {
    }

    /**
     * Constructs an instance of <code>ExceptionA</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExceptionA(String msg) {
        super(msg);
    }
    
    protected void methodInExceptionA() {
        
    }
}
