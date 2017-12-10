package com.java7book.chapter13.access;

public class UseProperty {
    public static void main(String[] args) {
        System.out.println(GetSystemProperty.getWithPrivilege("user.dir"));
    }
}
