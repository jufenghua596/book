/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.framework;

/**
 *
 * @author chengfu
 */
public class DataAccessException extends BaseRuntimeException {

    /**
     * Creates a new instance of <code>DataAccessException</code> without detail message.
     */
    public DataAccessException() {
    }

    /**
     * Constructs an instance of <code>DataAccessException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataAccessException(String msg) {
        super(msg);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
    
}
