/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.java7;

import java.math.BigDecimal;

/**
 *
 * @author chengfu
 */
public class ExceptionJava7Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            throw new InsufficientBalanceException(new BigDecimal("3.25"), new BigDecimal("1.13"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ExceptionHandler eh = new ExceptionHandler();
        eh.handle();
    }
}
