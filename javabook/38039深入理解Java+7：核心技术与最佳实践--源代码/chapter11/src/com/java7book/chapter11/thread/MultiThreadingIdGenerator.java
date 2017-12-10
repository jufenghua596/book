package com.java7book.chapter11.thread;

public class MultiThreadingIdGenerator {

    public static void main(String[] args) {
        IdGenerator counter = new IdGenerator();
        for (int i = 0; i < 10; i++) {
            new IdGeneratorThread(counter).start();
        }
    }

    private static class IdGeneratorThread extends Thread {
        private IdGenerator counter;
        public IdGeneratorThread(IdGenerator counter) {
            this.counter = counter;
        }
        public void run() {
            System.out.println(this.getName() + " => " + counter.getNext());
        }
    }
}
