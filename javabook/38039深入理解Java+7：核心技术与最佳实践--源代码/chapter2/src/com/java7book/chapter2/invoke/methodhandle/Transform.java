/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class Transform {

    public void dropArguments() throws Throwable {
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhOld = lookup.findVirtual(String.class, "substring", type);
        String value = (String) mhOld.invoke("Hello", 2, 3);
        System.out.println(value);
        MethodHandle mhNew = MethodHandles.dropArguments(mhOld, 0, float.class, String.class);
        value = (String) mhNew.invoke(0.5f, "Ignore", "Hello", 2, 3);
        System.out.println(value);
    }

    public void insertArguments() throws Throwable {
        MethodType type = MethodType.methodType(String.class, String.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhOld = lookup.findVirtual(String.class, "concat", type);
        String value = (String) mhOld.invoke("Hello", "World");
        System.out.println(value);
        MethodHandle mhNew = MethodHandles.insertArguments(mhOld, 1, " --");
        value = (String) mhNew.invoke("Hello");
        System.out.println(value);
    }

    public void filterArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhGetLength = lookup.findVirtual(String.class, "length", MethodType.methodType(int.class));
        MethodHandle mhTarget = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhResult = MethodHandles.filterArguments(mhTarget, 0, mhGetLength, mhGetLength);
        int value = (int) mhResult.invoke("Hello", "New World");
        System.out.println(value);
    }
    
    public static int targetMethod(int arg1, int arg2, int arg3) {
        return arg1;
    }

    public void foldArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType typeCombiner = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhCombiner = lookup.findStatic(Math.class, "max", typeCombiner);
        MethodType typeTarget = MethodType.methodType(int.class, int.class, int.class, int.class);
        MethodHandle hmTarget = lookup.findStatic(Transform.class, "targetMethod", typeTarget);
        MethodHandle mhResult = MethodHandles.foldArguments(hmTarget, mhCombiner);
        int value = (int) mhResult.invoke(3, 4);
        System.out.println(value);
    }

    public void permuteArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhCompare = lookup.findStatic(Integer.class, "compare", type);
        int value = (int) mhCompare.invoke(3, 4); //输出-1
        MethodHandle mhNew = MethodHandles.permuteArguments(mhCompare, type, 1, 0);
        value = (int) mhNew.invoke(3, 4); //输出1
        MethodHandle mhDuplicateArgs = MethodHandles.permuteArguments(mhCompare, type, 1, 1);
        value = (int) mhDuplicateArgs.invoke(3, 4); //输出0
        System.out.println("PERMUTE " + value);
    }
    
    public int handleException(Exception e, String str) {
        System.out.println(e.getMessage());
        return 0;
    }

    public void catchExceptions() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType typeTarget = MethodType.methodType(int.class, String.class);
        MethodHandle mhParseInt = lookup.findStatic(Integer.class, "parseInt", typeTarget);
        MethodType typeHandler = MethodType.methodType(int.class, Exception.class, String.class);
        MethodHandle mhHandler = lookup.findVirtual(Transform.class, "handleException", typeHandler).bindTo(this);
        MethodHandle mh = MethodHandles.catchException(mhParseInt, NumberFormatException.class, mhHandler);
        mh.invoke("Hello");
    }
    
    public static boolean guardTest() {
        return Math.random() > 0.5;
    }

    public void guardWithTest() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhTest = lookup.findStatic(Transform.class, "guardTest", MethodType.methodType(boolean.class));
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhTarget = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhFallback = lookup.findStatic(Math.class, "min", type);
        MethodHandle mh = MethodHandles.guardWithTest(mhTest, mhTarget, mhFallback);
        int value = (int) mh.invoke(3, 5); //输出随机为3或5
    }

    public void filterReturnValue() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mhSubstring = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class));
        MethodHandle mhUpperCase = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class));
        MethodHandle mh = MethodHandles.filterReturnValue(mhSubstring, mhUpperCase);
        String str = (String) mh.invoke("Hello World", 5); //输出 WORLD
        System.out.println(str);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        Transform t = new Transform();
        t.dropArguments();
        t.insertArguments();
        t.filterArguments();
        t.foldArguments();
        t.permuteArguments();
        t.catchExceptions();
        t.guardWithTest();
        t.filterReturnValue();
    }
}
