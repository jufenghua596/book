/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.networkchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author chengfu
 */
public class BlockingSimpleServer {

    public void startSimpleServer() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress("localhost", 10800));
        while (true) {
            try (SocketChannel sc = channel.accept()) {
                sc.write(ByteBuffer.wrap("Hello".getBytes("UTF-8")));
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BlockingSimpleServer bss = new BlockingSimpleServer();
        bss.startSimpleServer();
    }
}
