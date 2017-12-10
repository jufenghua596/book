package com.java7book.chapter13.jca;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignature {
    private Signature signature;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] data = "Hello World".getBytes();
    
    public DigitalSignature() {
        init();
    }
    
    private void init() {
        try {
            signature = Signature.getInstance("SHA1withDSA");
            KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DSA");
            KeyPair keyPair = keyGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        }
        catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
    
    public byte[] sign() throws GeneralSecurityException {
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }
    
    public boolean verify(byte[] signatureData) throws GeneralSecurityException {
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signatureData);
    }
    
    public void testSignature() throws GeneralSecurityException {
        boolean result = verify(sign());
        System.out.println(result);
    }
    
    public static void main(String[] args) throws GeneralSecurityException {
        DigitalSignature ds = new DigitalSignature();
        ds.testSignature();
    }
}
