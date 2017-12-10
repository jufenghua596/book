package com.java7book.chapter9;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassIdentity {
    
    public void test() throws Exception {
        Path path = Paths.get("classData");
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(path);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(path);
        String className = "com.java7book.chapter9.Sample";
        Class<?> class1 = fscl1.loadClass(className);
        Object obj1 = class1.newInstance();
        Class<?> class2 = fscl2.loadClass(className);
        Object obj2 = class2.newInstance();
        Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
        setSampleMethod.invoke(obj1, obj2);
    }

    public static void main(String[] args) {
        ClassIdentity ci = new ClassIdentity();
        try {
            ci.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
