package com.java7book.chapter9;

public class SimpleClassLoaderUsage {

    public void loadClass() throws Exception {
        ClassLoader current = getClass().getClassLoader();
        Class<?> clazz = current.loadClass("java.lang.String");
        Object str = clazz.newInstance();
        System.out.println(str.getClass()); //输出java.lang.String
    }
    
    public static void main(String[] args) throws Exception {
        SimpleClassLoaderUsage usage = new SimpleClassLoaderUsage();
        usage.loadClass();
    }

}
