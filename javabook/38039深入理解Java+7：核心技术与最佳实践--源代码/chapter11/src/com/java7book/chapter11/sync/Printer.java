package com.java7book.chapter11.sync;

public class Printer {
    private String name;
    public Printer(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println(name + " ==> " + "Print...");
    }
}
