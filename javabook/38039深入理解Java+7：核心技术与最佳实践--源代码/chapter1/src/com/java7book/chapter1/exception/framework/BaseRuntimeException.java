/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.framework;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengfu
 */
public class BaseRuntimeException extends RuntimeException {
    
    private List<Throwable> exceptions = new ArrayList<Throwable>();

    /**
     * Creates a new instance of <code>BaseRuntimeException</code> without detail message.
     */
    public BaseRuntimeException() {
    }

    /**
     * Constructs an instance of <code>BaseRuntimeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BaseRuntimeException(String msg) {
        super(msg);
    }
    
    public void addException(Throwable exception) {
        if (exception != null) {
            exceptions.add(exception);
        }
    }
    
    public boolean isThrownRequired() {
        return exceptions.size() > 0;
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
