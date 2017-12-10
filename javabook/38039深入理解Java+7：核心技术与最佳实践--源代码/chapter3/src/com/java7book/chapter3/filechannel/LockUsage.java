/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.filechannel;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author chengfu
 */
public class LockUsage {
    
    public void updateWithLock() throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get("settings.config"), StandardOpenOption.READ, StandardOpenOption.WRITE); 
                FileLock lock = channel.lock()) {
           //更新文件内容
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        LockUsage lu = new LockUsage();
        lu.updateWithLock();
    }
}
