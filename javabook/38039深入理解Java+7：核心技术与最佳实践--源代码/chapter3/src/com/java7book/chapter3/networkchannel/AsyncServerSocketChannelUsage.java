/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.networkchannel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

/**
 *
 * @author chengfu
 */
public class AsyncServerSocketChannelUsage {

    public void startAsyncSimpleServer() throws IOException {
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(10, Executors.defaultThreadFactory());
        final AsynchronousServerSocketChannel serverChannel =
                AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(10080));
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

            public void completed(AsynchronousSocketChannel clientChannel, Void attachement) {

                serverChannel.accept(null, this);

                try {
                    clientChannel.write(ByteBuffer.wrap("Hello".getBytes("UTF-8")));
                    clientChannel.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            public void failed(Throwable throwable, Void attachement) {
                throwable.printStackTrace();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        AsyncServerSocketChannelUsage usage = new AsyncServerSocketChannelUsage();
        usage.startAsyncSimpleServer();
    }
}
