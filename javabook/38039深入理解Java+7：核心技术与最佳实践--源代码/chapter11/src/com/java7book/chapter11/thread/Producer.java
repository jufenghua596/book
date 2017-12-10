package com.java7book.chapter11.thread;

public class Producer {
    private final Object lock;
    public Producer(Object lock) {
        this.lock = lock;
    }
    public void produce() {
        synchronized (lock) {
            
        }
    }
}
