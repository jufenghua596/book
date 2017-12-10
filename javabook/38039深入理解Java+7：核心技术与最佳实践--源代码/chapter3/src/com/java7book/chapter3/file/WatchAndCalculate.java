/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 *
 * @author chengfu
 */
public class WatchAndCalculate {

    public void calculate() throws IOException, InterruptedException {
        WatchService service = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("").toAbsolutePath();
        path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
        while (true) {
            WatchKey key = service.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                Path createdPath = (Path) event.context();
                createdPath = path.resolve(createdPath);
                long size = Files.size(createdPath);
                System.out.println(createdPath + " ==> " + size);
            }
            key.reset();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        WatchAndCalculate wc = new WatchAndCalculate();
        wc.calculate();
    }
}
