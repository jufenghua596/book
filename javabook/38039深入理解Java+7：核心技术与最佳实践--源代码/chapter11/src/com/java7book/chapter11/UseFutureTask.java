package com.java7book.chapter11;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UseFutureTask {
    
    public void useFutureTask() throws Exception {
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            public String call() throws Exception {
               Thread.sleep(3000);
               return "Hello World";
            }
        });
        task.run();
        String result = task.get();
        System.out.println(result);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UseFutureTask uft = new UseFutureTask();
        try {
            uft.useFutureTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
