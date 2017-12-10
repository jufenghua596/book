/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author chengfu
 */
public class AsyncFileChannelUsage {

    public void asyncWrite() throws IOException, ExecutionException, InterruptedException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("large.bin"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024 * 1024);
        Future<Integer> result = channel.write(buffer, 0);
        //其它操作
        Integer len = result.get();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        AsyncFileChannelUsage afcu = new AsyncFileChannelUsage();
        afcu.asyncWrite();
    }
}
