package com.java7book.chapter12;

public class StaticField <T>  {
    public static int count = 0;
    public StaticField() {
        count++;
    }
    public static void main(String[] args) {
        new StaticField<String>();
        new StaticField<Integer>();
        System.out.println(StaticField.count); //输出为2
    }
}
