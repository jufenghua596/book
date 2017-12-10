package com.java7book.chapter13.access;

import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GuardedObject;

public class UseGuard {
    
    public GuardedObject readFile(Path path) throws IOException {
        FilePermission permission = new FilePermission(path.toString(), "read");
        byte[] data = Files.readAllBytes(path);
        GuardedObject guardedObj = new GuardedObject(data, permission);
        return guardedObj;
    }
    
    public void useFile(Path path) throws IOException {
        GuardedObject guardedObj = readFile(path);
        byte[] data = (byte[]) guardedObj.getObject();
        System.out.println(data.length);
    }

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("myapp.conf");
        UseGuard guard = new UseGuard();
        guard.useFile(path);
    }

}
