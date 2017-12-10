package com.java7book.chapter9;

public class ClassForNameMain {
    
    public void classForNameVsLoader() throws ClassNotFoundException {
        String className = "com.java7book.chapter9.ClassForNameTest";
        Class<?> clazz1 = Class.forName(className);
        ClassLoader loader = this.getClass().getClassLoader();
        Class<?> clazz2 = loader.loadClass(className);
    }

    
    public static void main(String[] args) {
        ClassForNameMain main = new ClassForNameMain();
        try {
            main.classForNameVsLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
