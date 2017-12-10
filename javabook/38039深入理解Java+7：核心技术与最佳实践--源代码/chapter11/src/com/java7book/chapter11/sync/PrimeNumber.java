package com.java7book.chapter11.sync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PrimeNumber {
    private static final int TOTAL_COUNT = 5000;
    private static final int RANGE_LENGTH = 200;
    private static final int WORKER_NUMBER = 5;
    private static volatile boolean done = false;
    private static int rangeCount = 0;
    private static final List<Long> results = new ArrayList<Long>();
    private static final CyclicBarrier barrier = new CyclicBarrier(WORKER_NUMBER, new Runnable() {
        public void run() {
            if (results.size() >= TOTAL_COUNT) {
                done = true;
            }
        }
    });
    private static class PrimeFinder implements Runnable {
        public void run() {
            while (!done) {
                int range = getNextRange();
                long start = range * RANGE_LENGTH;
                long end = (range + 1) * RANGE_LENGTH;
                for (long i = start; i < end; i++) {
                    if (isPrime(i)) {
                        updateResult(i);
                    }
                }
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    done = true;
                }
            }
        }
    }
    private synchronized static void updateResult(long value) {
        results.add(value);
    }
    private synchronized static int getNextRange() {
        return rangeCount++;
    }
    private static boolean isPrime(long number) {
        if (number == 2) {
            return true;
        }
        if (number <= 1 || number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void calculate() {
        Thread thread1 = new Thread(new PrimeFinder());
        thread1.start();
        for (int i = 0; i < WORKER_NUMBER - 1; i++) {
            new Thread(new PrimeFinder()).start();
        }
        if (!done) {
            thread1.interrupt();
        }
        while (!done) {
            
        }
        System.out.println(results.size());
        System.out.println(Arrays.deepToString(results.toArray()));
    }
    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        pn.calculate();
    }
}
