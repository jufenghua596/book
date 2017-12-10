package com.java7book.chapter8.asm;

public class CreatedObjectAfter {
    public static int instanceCount = 0;
    public CreatedObjectAfter() {
        instanceCount++;
    }
}
