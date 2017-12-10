package com.java7book.chapter11.sync;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.io.IOUtils;

public class PageSizeSorter {
    private static final ConcurrentHashMap<String, Integer> sizeMap = new ConcurrentHashMap<>();
    private static class GetSizeWorker implements Runnable {
        private final String urlString;
        private final CountDownLatch signal;
        public GetSizeWorker(String urlString, CountDownLatch signal) {
            this.urlString = urlString;
            this.signal = signal;
        }
        public void run() {
            try {
                InputStream is = new URL(urlString).openStream();
                int size = IOUtils.toByteArray(is).length;
                sizeMap.put(urlString, size);
            } catch (IOException e) {
                sizeMap.put(urlString, -1);
            } finally {
                signal.countDown();
            }
        }
    }
    private void sort() {
        List<Entry<String, Integer>> list = new ArrayList<>(sizeMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
        System.out.println(Arrays.deepToString(list.toArray()));
    }
    public void sortPageSize(Collection<String> urls) throws InterruptedException {
        CountDownLatch sortSignal = new CountDownLatch(urls.size());
        for (String url : urls) {
            new Thread(new GetSizeWorker(url, sortSignal)).start();
        }
        sortSignal.await();
        sort();
    }
    
    public static void main(String[] args) throws InterruptedException {
        PageSizeSorter pso = new PageSizeSorter();
        List<String> urls = Arrays.asList(new String[] {
            "http://www.baidu.com",
            "http://www.sina.com.cn",
            "http://www.163.com"    
        });
        pso.sortPageSize(urls);
    }
}
