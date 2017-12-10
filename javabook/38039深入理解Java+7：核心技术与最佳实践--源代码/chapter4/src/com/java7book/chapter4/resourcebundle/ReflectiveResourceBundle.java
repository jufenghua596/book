/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 *
 * @author chengfu
 */
public class ReflectiveResourceBundle extends ResourceBundle {

    private Class clazz;

    public ReflectiveResourceBundle(Class clazz) {
        this.clazz = clazz;
    }

    public Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        try {
            Method method = clazz.getMethod(key);
            if (method == null) {
                return null;
            }
            return method.invoke(null);
        } catch (Exception ex) {
            return null;
        }
    }

    public Enumeration<String> getKeys() {
        Vector<String> result = new Vector<String>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            int mod = method.getModifiers();
            if (Modifier.isStatic(mod) && Modifier.isPublic(mod) && method.getParameterTypes().length == 0) {
                result.add(method.getName());
            }
        }
        return result.elements();
    }
}
