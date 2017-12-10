package com.java7book.chapter11.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockIdGenerator {
    private final ReentrantLock lock = new ReentrantLock();
    private int value = 0;
    public int getNext() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }
}
