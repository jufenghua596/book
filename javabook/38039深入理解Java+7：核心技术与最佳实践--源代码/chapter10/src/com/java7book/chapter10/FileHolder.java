package com.java7book.chapter10;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

//错误的finalize使用
public class FileHolder {
    private Path path;
    private InputStream inputStream;
    
    public FileHolder(Path path) {
        this.path = path;
    }
    
    public void open() throws IOException {
        this.inputStream = Files.newInputStream(path, StandardOpenOption.WRITE);
    }

    protected void finalize() throws Throwable {
        if (inputStream != null) {
            inputStream.close();
        }
        super.finalize();
    }
}
