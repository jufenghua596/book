/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author chengfu
 */
public class ArrayUsage {
    public void useArray() {
        String[] names = (String[]) Array.newInstance(String.class, 10);
        names[0] = "Hello";
        Array.set(names, 1, "World");
        String str = (String) Array.get(names, 0);
        int[][][] matrix1 = (int[][][]) Array.newInstance(int.class, 3, 3, 3);
        matrix1[0][0][0] = 1;
        int[][][] matrix2 = (int[][][]) Array.newInstance(int[].class, 3, 4);
        matrix2[0][0] = new int[10];
        matrix2[0][1] = new int[3];
        matrix2[0][0][1] = 1;
    }
    
    public static void main(String[] args) {
        ArrayUsage au = new ArrayUsage();
        au.useArray();
    }
}
