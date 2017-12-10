/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.stream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author chengfu
 */
public class ReusableInputStream extends BufferedInputStream {
    private boolean readAttempted = false;
    
    public ReusableInputStream(InputStream input) {
        super(input);
    }

    public synchronized int read() throws IOException {
        return super.read();
    }

    public synchronized int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    public int read(byte[] b) throws IOException {
        return super.read(b);
    }
    
    
    
}
