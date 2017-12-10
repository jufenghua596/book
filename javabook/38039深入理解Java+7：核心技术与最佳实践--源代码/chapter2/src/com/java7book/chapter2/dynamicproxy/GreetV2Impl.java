/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.dynamicproxy;

/**
 *
 * @author chengfu
 */
public class GreetV2Impl implements GreetV2 {

    @Override
    public String greet(String username) {
        return "<Greet V2>" +  username;
    }
    
}
