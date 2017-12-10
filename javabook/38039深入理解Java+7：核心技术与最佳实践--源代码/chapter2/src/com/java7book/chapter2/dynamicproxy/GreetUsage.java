/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

/**
 *
 * @author chengfu
 */
public class GreetUsage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GreetV1 greetV1 = new GreetV1Impl();
        //System.out.println(greetV1.greet("Alex", "男"));
        GreetV2 greetV2 = GreetFactory.adaptGreet(greetV1);
        System.out.println(greetV2.greet("Alex"));
    }
}
