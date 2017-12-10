/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chengfu
 */
public class ReflectSetter {
    public static void invokeSetter(Object obj, String field, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, value.getClass());
        method.invoke(obj, value);
    }
    
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        try {
            ReflectSetter.invokeSetter(obj, "name", "Alex");
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectSetter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflectSetter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectSetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(obj.getName());
    }
    
    private static class MyObject {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
