/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author chengfu
 */
public class FilterCharacters {

    public String filter(String str) throws CharacterCodingException {
        Charset charset = StandardCharsets.ISO_8859_1;
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();
        encoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
        CharBuffer buffer = CharBuffer.wrap(str);
        ByteBuffer byteBuffer = encoder.encode(buffer);
        CharBuffer result = decoder.decode(byteBuffer);
        return result.toString();
    }
    
    public void useFilter() throws CharacterCodingException {
        String result = filter("你好，123世界！"); //值为123
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CharacterCodingException {
        FilterCharacters fc = new FilterCharacters();
        fc.useFilter();
    }
}
