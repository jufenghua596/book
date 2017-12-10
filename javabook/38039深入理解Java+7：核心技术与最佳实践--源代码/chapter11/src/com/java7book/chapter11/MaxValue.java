package com.java7book.chapter11;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaxValue {
    private static final int RANGE_LENGTH = 2000;
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    private static class MaxValueTask extends RecursiveTask<Long> {
        private final long[] array;
        private final int start;
        private final int end;
        MaxValueTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        protected Long compute() {
            long max = Long.MIN_VALUE;
            if (end - start <= RANGE_LENGTH) {
                for (int i = start; i < end; i++) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
            }
            else {
                int mid = (start + end) / 2; 
                MaxValueTask lowTask = new MaxValueTask(array, start, mid);
                MaxValueTask highTask = new MaxValueTask(array, mid, end);
                lowTask.fork();
                highTask.fork();
                max = Math.max(max, lowTask.join());
                max = Math.max(max, highTask.join());
            }
            return max;
        }
    }
    public void calculate(long[] array) {
        MaxValueTask task = new MaxValueTask(array, 0, array.length);
        Long result = forkJoinPool.invoke(task);
        System.out.println(result);
    }
    public void calculateNormal(long[] array) {
        long max = Long.MIN_VALUE;
        for (int i = 0, n = array.length; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        Random random = new Random();
        int size = Integer.MAX_VALUE / 256;
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextLong();
        }
        MaxValue mv = new MaxValue();
        long startTime = System.currentTimeMillis();
        mv.calculate(array);
        long midTime = System.currentTimeMillis();
        System.out.println(midTime - startTime);
        mv.calculateNormal(array);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - midTime);
    }
}
