package com.java7book.chapter1.stringinswitch;

public class Title {
    public String generate(String name, String gender) {
        String title = "";
        switch (gender) {
            case "男":
                title = name + " 先生";
                break;
            case "女":
                title = name + " 女士";
                break;
            default:
                title = name;
        }
        return title;
    }
}
