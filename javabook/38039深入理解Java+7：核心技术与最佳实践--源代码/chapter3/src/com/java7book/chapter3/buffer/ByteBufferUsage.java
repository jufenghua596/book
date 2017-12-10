/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 *
 * @author chengfu
 */
public class ByteBufferUsage {
    
    public void useByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte)1);
        buffer.put(new byte[3]);
        buffer.putChar('A');
        buffer.putFloat(0.0f);
        buffer.putLong(10, 100L);
        System.out.println(buffer.getChar(4));
        System.out.println(buffer.remaining());
    }
    
    public void byteOrder() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.getInt(0); //值为16777216
    }
    
    public void compact() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put(new byte[16]);
        buffer.flip();
        buffer.getInt();
        buffer.compact();
        int pos = buffer.position();
    }
    
    public void viewBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putInt(1);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(2);
        int value = buffer.getInt(); //值为2
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ByteBufferUsage bbu = new ByteBufferUsage();
        bbu.useByteBuffer();
        bbu.byteOrder();
        bbu.compact();
        bbu.viewBuffer();
    }
}
