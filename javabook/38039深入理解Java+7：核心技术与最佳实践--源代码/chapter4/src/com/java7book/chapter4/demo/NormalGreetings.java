package com.java7book.chapter4.demo;

import java.util.Date;

public class NormalGreetings {
    public String greet(String name) {
        return "Hello, " + name + ". Today is " + new Date().toString() + ".";
    }
}
