/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author chengfu
 */
public class ReflectMethodHandle {
    
    public void unreflect() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Constructor constructor = String.class.getConstructor(byte[].class);
        lookup.unreflectConstructor(constructor);
        Method method = String.class.getMethod("substring", int.class, int.class);
        lookup.unreflect(method);
        
        Method privateMethod = ReflectMethodHandle.class.getDeclaredMethod("privateMethod");
        lookup.unreflectSpecial(privateMethod, ReflectMethodHandle.class);
        
        Field field = ReflectMethodHandle.class.getField("name");
        lookup.unreflectGetter(field);
        lookup.unreflectSetter(field);
    }
    
    private void privateMethod() {}
    
    public String name;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        ReflectMethodHandle rmh = new ReflectMethodHandle();
        rmh.unreflect();
    }
}
