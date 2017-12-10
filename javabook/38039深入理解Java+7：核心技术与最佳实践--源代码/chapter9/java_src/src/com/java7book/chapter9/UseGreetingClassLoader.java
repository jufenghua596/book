package com.java7book.chapter9;

public class UseGreetingClassLoader {

    public static void main(String[] args) throws Exception {
        String message = "Hello";
        GreetingClassLoader gcl = new GreetingClassLoader(message);
        Class<?> clazz = gcl.loadClass("GreetingsSample");
        clazz.newInstance();
    }

}
