package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationUtils {
    public static void write(Object obj, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path))) {
            output.writeObject(obj);
        }
    }
    
    public static Object read(String filePath) throws IOException, ClassNotFoundException {
        Path path = Paths.get(filePath);
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path))) {
            return input.readObject();
        }
    }
}
