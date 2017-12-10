/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author chengfu
 */
public class WalkFileTree {
    
    public void cleanSVNInfo() throws IOException {
        Path path = Paths.get("C:", "chapter3");
        Files.walkFileTree(path, new SvnInfoCleanVisitor());
    }
    
    private static class SvnInfoCleanVisitor extends SimpleFileVisitor<Path> {
        
        private boolean cleanMark = false;
        
        private boolean isSvnFolder(Path dir) {
            return ".svn".equals(dir.getFileName().toString());
        }
        
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (isSvnFolder(dir)) {
               cleanMark = true;
           }
           return FileVisitResult.CONTINUE;
        }

        public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
            if (e == null && cleanMark) {
                 Files.delete(dir);
                 if (isSvnFolder(dir)) {
                     cleanMark = false;
                 }
             } 
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (cleanMark) {
                Files.setAttribute(file, "dos:readonly", false);
                Files.delete(file);
            }
            return FileVisitResult.CONTINUE;
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        WalkFileTree wft = new WalkFileTree();
        wft.cleanSVNInfo();
    }
}
