package com.java7book.chapter11;

public class WrongUser {
    private final String name;
    public WrongUser(String name) {
        UserHolder.user = this;
        this.name = name;
    }
}
