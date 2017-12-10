/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.buffer;

import java.nio.CharBuffer;

/**
 *
 * @author chengfu
 */
public class CharBufferUsage {
    
    public void useCharBuffer() {
        CharBuffer buffer = CharBuffer.allocate(32);
        buffer.put("Hello World");
        System.out.println(buffer.position());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CharBufferUsage cbu = new CharBufferUsage();
        cbu.useCharBuffer();
    }
}
