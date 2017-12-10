/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

/**
 *
 * @author chengfu
 */
public class MultiCatchSequence {
    public void testSequence() {
        try {
            Integer.parseInt("Hello");
        }
        catch (NumberFormatException | RuntimeException e) {
           
        }
    }
}
