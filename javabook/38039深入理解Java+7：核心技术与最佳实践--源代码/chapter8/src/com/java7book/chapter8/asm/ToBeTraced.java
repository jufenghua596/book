package com.java7book.chapter8.asm;

import java.io.IOException;
import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.TraceClassVisitor;

public class ToBeTraced {

    public void method1() {
    }
    
    public void method2() {
    }
    
    public void method3() {
    }
    
    public static void main(String[] args) throws IOException {
        ToBeTraced traced = new ToBeTraced();
        traced.method1();
        RetransformClassesAgent.enableTrace();
        //traced.dumpByteCode();
        traced.method2();
        RetransformClassesAgent.disableTrace();
        traced.method3();
        //traced.dumpByteCode();
    }

    public void dumpByteCode() throws IOException {
        System.out.println(" === START === ");
        ClassReader reader = new ClassReader("com.java7book.chapter8.asm.ToBeTraced");
        PrintWriter pw = new PrintWriter(System.out);
        TraceClassVisitor cv = new TraceClassVisitor(pw);
        reader.accept(cv, 0);
        System.out.println(" === END === ");
    }
}
