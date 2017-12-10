/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class PreciseThrow {
    public void preciseThrow() throws ExceptionASub1, ExceptionASub2 {
        throw new ExceptionASub2Sub();
    }
}
