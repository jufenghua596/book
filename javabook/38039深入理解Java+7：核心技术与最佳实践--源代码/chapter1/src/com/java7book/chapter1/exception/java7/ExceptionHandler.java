/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class ExceptionHandler {
    public void handle() {
        ExceptionThrower thrower = new ExceptionThrower();
        try {
            thrower.manyExceptions();
        } catch (ExceptionA | ExceptionB ab) {
            System.out.println(ab.getClass());
        } catch (ExceptionC c) {
        }
    }
}
