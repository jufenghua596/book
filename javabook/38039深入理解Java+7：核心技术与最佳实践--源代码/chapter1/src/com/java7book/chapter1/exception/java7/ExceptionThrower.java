/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionThrower {
    public void manyExceptions() throws ExceptionA, ExceptionB, ExceptionC {
        throw new ExceptionA();
    }
}
