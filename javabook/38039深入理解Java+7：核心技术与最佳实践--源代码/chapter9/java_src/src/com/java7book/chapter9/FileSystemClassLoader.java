package com.java7book.chapter9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemClassLoader extends ClassLoader {
    private Path path;
    
    public FileSystemClassLoader(Path path) {
        this.path = path;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = getClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }
    
    private byte[] getClassData(String className) throws IOException {
        Path classFilePath = classNameToPath(className);
        return Files.readAllBytes(classFilePath);
    }
    
    private Path classNameToPath(String className) {
        return path.resolve(className.replace('.', File.separatorChar) + ".class");
    } 
}
