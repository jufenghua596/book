/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.framework;

/**
 *
 * @author chengfu
 */
public class ClassB {
    public void b() {
        ClassC c = new ClassC();
        c.read("my.txt");
    }
}
