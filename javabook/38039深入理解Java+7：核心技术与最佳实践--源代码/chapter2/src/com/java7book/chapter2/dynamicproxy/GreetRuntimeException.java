/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

/**
 *
 * @author chengfu
 */
public class GreetRuntimeException extends RuntimeException {

    /**
     * Creates a new instance of <code>GreetRuntimeException</code> without detail message.
     */
    public GreetRuntimeException() {
    }

    /**
     * Constructs an instance of <code>GreetRuntimeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public GreetRuntimeException(String msg) {
        super(msg);
    }

    public GreetRuntimeException(Throwable cause) {
        super(cause);
    }

    public GreetRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
