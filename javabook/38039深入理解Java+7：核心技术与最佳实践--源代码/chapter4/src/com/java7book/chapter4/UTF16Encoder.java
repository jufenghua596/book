/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4;

/**
 *
 * @author chengfu
 */
public class UTF16Encoder {

    public char[] encode(int codePoint) {
        if ((codePoint >= 0 && codePoint <= 0xD7FF)
                || (codePoint >= 0xE000 && codePoint <= 0xFFFF)) {
            return new char[]{(char) codePoint};
        } else {
            codePoint = codePoint - 0x10000;
            int high = (codePoint >> 10) + 0xD800;
            int low = (codePoint & 0x3FF) + 0xDC00;
            return new char[]{(char) high, (char) low};
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UTF16Encoder encoder = new UTF16Encoder();
        System.out.println(encoder.encode(0x007A));
        System.out.println(encoder.encode(0x6C34));
        char[] result = encoder.encode(0x1F701);
        System.out.println(new String(result).length());
    }
}
