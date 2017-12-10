package com.java7book.chapter11.sync;

import java.util.concurrent.Exchanger;

public class SendAndReceiver {
    private final Exchanger<StringBuilder> exchanger = new Exchanger<StringBuilder>();
    private class Sender implements Runnable {
        public void run() {
            try {
                StringBuilder content = new StringBuilder("Hello");
                content = exchanger.exchange(content);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private class Receiver implements Runnable {
        public void run() {
            try {
                StringBuilder content = new StringBuilder("World");
                content = exchanger.exchange(content);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void exchange() {
        new Thread(new Sender()).start();
        new Thread(new Receiver()).start();
    }
    
    public static void main(String[] args) {
        SendAndReceiver prog = new SendAndReceiver();
        prog.exchange();
    }
}
