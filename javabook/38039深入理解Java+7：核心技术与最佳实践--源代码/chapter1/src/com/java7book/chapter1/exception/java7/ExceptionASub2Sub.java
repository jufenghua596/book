/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionASub2Sub extends ExceptionASub2 {

    /**
     * Creates a new instance of <code>ExceptionASub2Sub</code> without detail message.
     */
    public ExceptionASub2Sub() {
    }

    /**
     * Constructs an instance of <code>ExceptionASub2Sub</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExceptionASub2Sub(String msg) {
        super(msg);
    }
}
