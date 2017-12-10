package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewUserTest {

    public void test() throws IOException, ClassNotFoundException {
        Path path = Paths.get("new_user.bin");
        NewUser3 user = new NewUser3(30);
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path))) {
            output.writeObject(user);
        }
        /*try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path))) {
            NewUser result = (NewUser) input.readObject();
            System.out.println(result.getAge());
        }*/
    }
    
    public static void main(String[] args) {
        

    }

}
