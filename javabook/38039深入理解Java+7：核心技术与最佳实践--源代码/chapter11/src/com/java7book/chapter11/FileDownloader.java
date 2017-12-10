package com.java7book.chapter11;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FileDownloader {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    public boolean download(final URL url, final Path path) {
        Future<Path> future = executor.submit(new Callable<Path>() {
            public Path call() {
                try {
                    InputStream is = url.openStream();
                    Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
                    return path;
                } catch (IOException e) {
                    return null;
                }
            }
        });
        try {
            return future.get() != null ? true : false;
        } catch (InterruptedException | ExecutionException e) {
            return false;
        }
    }
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                executor.awaitTermination(1, TimeUnit.MINUTES);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args) throws MalformedURLException {
        FileDownloader downloader = new FileDownloader();
        downloader.download(new URL("http://www.baidu.com"), Paths.get("baidu.txt"));
        downloader.download(new URL("http://www.sina.com.cn"), Paths.get("sina.txt"));
        downloader.close();
    }
}
