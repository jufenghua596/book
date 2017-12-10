/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.networkchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author chengfu
 */
public class LoadWebPageUseSocket {

    public void loadWebPageUseSocket() throws IOException {
        try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                SocketChannel sc = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80))) {
            String request = "GET / HTTP/1.1\r\n\r\nHost: www.baidu.com\r\n\r\n";
            ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
            sc.write(header);
            destChannel.transferFrom(sc, 0, Integer.MAX_VALUE);
        }
    }
    
    public void loadWebPageUseNonBlockingSocket() throws IOException, InterruptedException {
        try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                SocketChannel sc = SocketChannel.open()) {
            sc.configureBlocking(false);
            boolean connected = sc.connect(new InetSocketAddress("www.baidu.com", 80));
            if (!connected) {
                Thread.sleep(2000);
            }
            while (!sc.finishConnect()) {
                
            }
            System.out.println(sc.isConnected());
            String request = "GET / HTTP/1.1\r\n\r\n";
            ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
            sc.write(header);
            destChannel.transferFrom(sc, 0, Integer.MAX_VALUE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        LoadWebPageUseSocket lp = new LoadWebPageUseSocket();
        //lp.loadWebPageUseSocket();
        lp.loadWebPageUseNonBlockingSocket();
    }
}
