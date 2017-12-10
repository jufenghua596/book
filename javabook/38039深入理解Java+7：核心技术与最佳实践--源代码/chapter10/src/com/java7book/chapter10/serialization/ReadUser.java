package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadUser {
    public User readUser() throws IOException, ClassNotFoundException {
        Path path = Paths.get("user.bin");
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path))) {
            User user = (User) input.readObject();
            return user;
        }
    }
   
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ReadUser readUser = new ReadUser();
        User user = readUser.readUser();
        System.out.println(user.getEmail());
    }
}
