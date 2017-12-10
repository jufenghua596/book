/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4;

/**
 *
 * @author chengfu
 */
public class UseCharacter {
    
    public void useCharacter() {
        String str = "你好";
        int codePoint = Character.codePointAt(str, 0); //值为20320
        Character.isBmpCodePoint(codePoint); //值为true
        int smpCodePoint = 0x12367;
        Character.isSupplementaryCodePoint(smpCodePoint); //值为true
        Character.charCount(smpCodePoint); //值为2
        char high = Character.highSurrogate(smpCodePoint);
        char low = Character.lowSurrogate(smpCodePoint);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseCharacter uc = new UseCharacter();
        uc.useCharacter();
    }
}
