package com.java7book.chapter11.thread;

public class ThreadJoin {
    public void useJoin() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        //执行其他操作
        System.out.println("START");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
    
    public static void main(String[] args) {
        ThreadJoin join = new ThreadJoin();
        join.useJoin();
    }
}
