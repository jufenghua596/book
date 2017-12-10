package com.java7book.chapter13.jca;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class MessageDigestUsage {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("Hello World".getBytes());
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        byte[] result = mac.doFinal("Hello World".getBytes());
    }
}
