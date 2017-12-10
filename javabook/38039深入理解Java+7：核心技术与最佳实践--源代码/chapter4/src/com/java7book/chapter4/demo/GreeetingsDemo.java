package com.java7book.chapter4.demo;

public class GreeetingsDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        NormalGreetings ng = new NormalGreetings();
        System.out.println(ng.greet("Alex"));
        I18nGreetings ig = new I18nGreetings();
        System.out.println(ig.greet("Alex"));
    }

}
