package com.java7book.chapter4.demo;

import java.util.Date;

public class I18nGreetings {
    public String greet(String name) {
        return Messages.get("GREETINGS", name, new Date());
    }
}
