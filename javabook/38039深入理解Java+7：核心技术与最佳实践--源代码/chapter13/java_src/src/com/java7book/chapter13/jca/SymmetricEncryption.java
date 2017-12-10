package com.java7book.chapter13.jca;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricEncryption { 
    public void encrypt() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        SecretKey key = generator.generateKey();
        Files.write(Paths.get("key.data"), key.getEncoded());
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String text = "Hello World";
        byte[] encrypted = cipher.doFinal(text.getBytes());
        Files.write(Paths.get("encrypted.bin"), encrypted);
    }
    
    public void decrypt() throws Exception {
        byte[] keyData = Files.readAllBytes(Paths.get("key.data"));
        SecretKeySpec keySpec = new SecretKeySpec(keyData, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] data = Files.readAllBytes(Paths.get("encrypted.bin"));
        byte[] result = cipher.doFinal(data);
        System.out.println(new String(result));
    }

    public static void main(String[] args) throws Exception {
        SymmetricEncryption se = new SymmetricEncryption();
        se.encrypt();
        se.decrypt();
    }

}
