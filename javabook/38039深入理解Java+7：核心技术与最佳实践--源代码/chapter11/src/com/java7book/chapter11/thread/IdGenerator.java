package com.java7book.chapter11.thread;

public class IdGenerator {
    private int value = 0;
    public int getNext() {
        return value++;
    }
}
