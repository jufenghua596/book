package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadNewUser {
    public NewUser readUser() throws IOException, ClassNotFoundException {
        Path path = Paths.get("new_user.bin");
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path))) {
            NewUser user = (NewUser) input.readObject();
            return user;
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ReadNewUser readUser = new ReadNewUser();
        NewUser user = readUser.readUser();
        System.out.println(user.getAge());
    }
}
