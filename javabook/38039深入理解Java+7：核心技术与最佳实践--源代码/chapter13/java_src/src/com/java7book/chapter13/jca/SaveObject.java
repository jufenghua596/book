package com.java7book.chapter13.jca;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignedObject;

public class SaveObject {
    public void saveObject(Serializable obj, Path path) throws GeneralSecurityException, IOException {
        Signature signature = Signature.getInstance("SHA1withDSA");
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DSA");
        KeyPair keyPair = keyGenerator.generateKeyPair();
        SignedObject signedObj = new SignedObject(obj, keyPair.getPrivate(), signature);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(signedObj);
        }
    }
}
