package com.java7book.chapter11;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapUsage {
    public void useIterator() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(50, 0.75f, 2);
        
    }
    private static class ReadThread extends Thread {
        private final ConcurrentHashMap<Integer, Integer> map;
        public ReadThread(ConcurrentHashMap<Integer, Integer> map) {
            this.map = map;
        }
        public void run() {
            Iterator<Integer> iterator = map.keySet().iterator();
            int count = 0;
            while (iterator.hasNext()) {
                count++;
            }
            System.out.println(count);
        }
    }
}
