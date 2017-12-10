package com.java7book.chapter10;

public class RunFinalize {
    
    protected void finalize() throws Throwable {
        System.out.println("运行finalize方法。");
        super.finalize();
    }

    public static void main(String[] args) throws InterruptedException {
        RunFinalize runFinalize = new RunFinalize();
        runFinalize = null;
        
        for (int i = 0; i < 10; i++) {
            System.gc();
            Thread.sleep(100);
        }
    }
}
