package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteUser {
    public void write(User user) throws IOException {
        Path path = Paths.get("user.bin");
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path))) {
            output.writeObject(user);
        }
    }
    
    public static void main(String[] args) throws IOException {
        WriteUser writeUser = new WriteUser();
        User user = new User("Alex", "alex@example.org");
        writeUser.write(user);
    }
}
