/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author chengfu
 */
public class FileAttributes {
    
    public boolean checkUpdatesRequired(Path path, int intervalInMillis) throws IOException {
        FileTime lastModifiedTime = (FileTime) Files.getAttribute(path, "lastModifiedTime");
        long now = System.currentTimeMillis();
        return now - lastModifiedTime.toMillis() > intervalInMillis;
    }
    
    public void useFileAttributeView() throws IOException {
        Path path = Paths.get("content.txt");
        DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
        if (view != null) {
            DosFileAttributes attrs = view.readAttributes();
            System.out.println(attrs.isReadOnly());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileAttributes fa = new FileAttributes();
        boolean result = fa.checkUpdatesRequired(Paths.get("content.txt"), 500);
        System.out.println(result);
        fa.useFileAttributeView();
    }
}
