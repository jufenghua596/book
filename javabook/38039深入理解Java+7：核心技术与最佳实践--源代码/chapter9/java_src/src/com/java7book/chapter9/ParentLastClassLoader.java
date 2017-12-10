package com.java7book.chapter9;

public class ParentLastClassLoader extends ClassLoader {
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        }
        clazz = findClass(name);
        if (clazz != null) {
            return clazz;
        }
        ClassLoader parent = getParent();
        if (parent != null) {
            return parent.loadClass(name);
        }
        else {
            return super.loadClass(name, resolve);
        }
    }
}
