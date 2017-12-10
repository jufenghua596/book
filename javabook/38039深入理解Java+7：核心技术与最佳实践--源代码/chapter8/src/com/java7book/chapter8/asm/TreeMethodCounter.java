package com.java7book.chapter8.asm;

import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

public class TreeMethodCounter {
    public int count(String className) throws IOException {
        ClassReader reader = new ClassReader(className);
        ClassNode cn = new ClassNode();
        reader.accept(cn, 0);
        return cn.methods != null ? cn.methods.size() : 0;
    }

    public static void main(String[] args) throws IOException {
        TreeMethodCounter counter = new TreeMethodCounter();
        int count = counter.count("java.lang.String");
        System.out.println(count);
    }

}
