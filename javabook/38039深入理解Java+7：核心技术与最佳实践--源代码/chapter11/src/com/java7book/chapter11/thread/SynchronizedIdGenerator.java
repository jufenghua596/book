package com.java7book.chapter11.thread;

public class SynchronizedIdGenerator {
    private int value = 0;
    public synchronized int getNext() {
        return value++;
    }
    public int getNextV2() {
        synchronized(this) {
            return value++;
        }
    }
}
