package com.java7book.chapter11.thread;

public class ThreadLocalIdGeneratorMain {

    public static void main(String[] args) {
        ThreadLocalIdGeneratorMain main = new ThreadLocalIdGeneratorMain();
        main.startTest();
    }
    
    public void startTest() {
        for (int i = 0; i < 10; i++) {
            new Thread(new IdDisplay()).start();
        }
    }

    private static class IdDisplay implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ==> " + ThreadLocalIdGenerator.getNext());
            System.out.println(Thread.currentThread().getName() + " ==> " + ThreadLocalIdGenerator.getNext());
        }
    }
}
