/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * @author chengfu
 */
public class StreamReuse {

    private InputStream input;

    public StreamReuse(InputStream input) {
        if (!input.markSupported()) {
            this.input = new BufferedInputStream(input);
        } else {
            this.input = input;
        }
    }

    public InputStream getInputStream() {
        input.mark(Integer.MAX_VALUE);
        return input;
    }

    public void markUsed() throws IOException {
        input.reset();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("C:\\my.txt");
        StreamReuse sr = new StreamReuse(input);
        InputStream reusable = sr.getInputStream();
        useStream(reusable);
        sr.markUsed();
        reusable = sr.getInputStream();
        useStream(reusable);
    }

    public static void useStream(InputStream input) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ReadableByteChannel channel = Channels.newChannel(input);
        int count = 0;
        try {
            count = channel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
