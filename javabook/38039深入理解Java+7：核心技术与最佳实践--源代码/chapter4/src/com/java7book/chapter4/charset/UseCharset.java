/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author chengfu
 */
public class UseCharset {
    
    public void testCharset() {
        String str = "你好";
        byte[] code = str.getBytes(Charset.forName("GB18030"));
        System.out.println(Hex.encodeHex(code));
        System.out.println(Hex.encodeHex(str.getBytes(StandardCharsets.UTF_16BE)));
    }
    
    private byte[] char2byte(char c) {
        return new byte[] { (byte)( c >> 8), (byte)( c & 0xFF) };
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UseCharset uc = new UseCharset();
       uc.testCharset();
    }
}
