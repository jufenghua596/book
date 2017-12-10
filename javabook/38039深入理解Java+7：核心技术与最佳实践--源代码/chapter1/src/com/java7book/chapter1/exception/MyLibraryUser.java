/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception;

/**
 *
 * @author chengfu
 */
public class MyLibraryUser {
    public void use() {
        MyLibraryV1 myLibrary = new MyLibraryV1();
        try {
            myLibrary.powerfulMethod();
        } catch (MyLibraryExceptionV1 ex) {
            ex.printStackTrace();
        }
    }
}
