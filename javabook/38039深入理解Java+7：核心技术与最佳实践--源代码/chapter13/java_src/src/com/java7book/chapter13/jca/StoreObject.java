package com.java7book.chapter13.jca;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class StoreObject {
    public void storeSafely(Serializable obj, Cipher cipher, Path path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(Files.newOutputStream(path), cipher))) {
            oos.writeObject(obj);
        }
    }
    
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        StoreObject so = new StoreObject();
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        SecretKey key = generator.generateKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        so.storeSafely("Hello World", cipher, Paths.get("saved.obj"));
    }
}
