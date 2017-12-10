/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.filechannel;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author chengfu
 */
public class FileMapping {
    
    public void mapFile() throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get("src.data"), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
            byte b = buffer.get(1024 * 1024);
            buffer.put(5 * 1024 * 1024, b);
            buffer.force();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileMapping fm = new FileMapping();
        fm.mapFile();
    }
}
