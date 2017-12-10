/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class MultiCatchType {
    public void testCatchType() {
        try {
            throwException();
        }
        catch (ExceptionASub1 | ExceptionASub2 e) {
            e.methodInExceptionA();
        }
    }
    
    public void throwException() throws ExceptionASub1, ExceptionASub2 {
        
    }
}
