package com.java7book.chapter11.sync;

import java.util.Random;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleResourceManager {
    private final InnerSynchronizer synchronizer;
    private static class InnerSynchronizer extends AbstractQueuedSynchronizer {
        InnerSynchronizer(int numOfResources) {
            setState(numOfResources);
        }
        protected int tryAcquireShared(int acquires) {
            for (;;) {
                int available = getState();
                int remaining = available - acquires;
                if (remaining < 0 ||
                    compareAndSetState(available, remaining)) {
                    return remaining;
                }
            }
        }
        protected boolean tryReleaseShared(int releases) {
            for (;;) {
                int available = getState();
                int next = available + releases;
                if (compareAndSetState(available, next)) {
                    return true;
                }
            }
        }  
    }
    
    public SimpleResourceManager(int numOfResources) {
        synchronizer = new InnerSynchronizer(numOfResources);
    }
    public void acquire() throws InterruptedException {
        synchronizer.acquireSharedInterruptibly(1);
    }
    public void release() {
        synchronizer.releaseShared(1);
    }
    
    public static void main(String[] args) {
        final SimpleResourceManager manager = new SimpleResourceManager(2);
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    try {
                        manager.acquire();
                        String name = Thread.currentThread().getName();
                        System.out.println(name + " ACQUIRE");
                        Random random = new Random();
                        Thread.sleep(random.nextInt(5000));
                        manager.release();
                        System.out.println(name + " RELEASE");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(300 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
