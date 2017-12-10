package com.java7book.chapter9;

import java.nio.file.Paths;

public class UseFileSystemClassLoader {

    public static void main(String[] args) {
        FileSystemClassLoader fscl = new FileSystemClassLoader(Paths.get("..", "chapter8", "bin"));
        try {
            Class<?> clazz = fscl.loadClass("com.java7book.chapter8.SampleClass");
            System.out.println(clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
