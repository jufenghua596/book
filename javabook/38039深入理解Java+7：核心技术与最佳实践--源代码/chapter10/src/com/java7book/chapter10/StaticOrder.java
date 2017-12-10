package com.java7book.chapter10;

public class StaticOrder {
    public static int X = 20;
    
    public static int Y = 2 * X;
    
    static {
        X = 30;
    }
    
    public static void main(String[] args) {
        System.out.println(Y);
    }
}
