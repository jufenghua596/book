package com.java7book.chapter9;

public class NoParentClassLoader extends ClassLoader {
    public NoParentClassLoader() {
        super(null);
    }
    
    public void testLoad() throws ClassNotFoundException {
        Class<?> clazz = loadClass("com.java7book.chapter9.ToLoad");
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        NoParentClassLoader loader = new NoParentClassLoader();
        System.out.println(NoParentClassLoader.class.getClassLoader());
        loader.testLoad();
    }
}
