package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class WriteNewUser {
    public void write(NewUser user) throws IOException {
        Path path = Paths.get("new_user.bin");
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path))) {
            output.writeObject(user);
        }
    }
    
    public static void main(String[] args) throws IOException {
        WriteNewUser writeUser = new WriteNewUser();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 10);
        NewUser user = new NewUser(calendar.getTime());
        writeUser.write(user);
    }
}
