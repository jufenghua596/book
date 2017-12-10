/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

import java.lang.IllegalArgumentException;

/**
 *
 * @author chengfu
 */
public class PreciseThrowUse3 {

    public void test() throws ExceptionA {
        PreciseThrow pt = new PreciseThrow();
        try {
            pt.preciseThrow();
        } catch (ExceptionASub1 e) {
        } catch (NumberFormatException | IllegalArgumentException e) {
        
        }
    }

    public static void main(String[] args) {
        try {
            new PreciseThrowUse3().test();
        } catch (ExceptionA ex) {
           System.out.println(ex.getClass());
        }
    }
}
