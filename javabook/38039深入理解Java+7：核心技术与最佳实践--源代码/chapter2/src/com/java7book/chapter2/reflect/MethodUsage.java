/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.reflect;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chengfu
 */
public class MethodUsage {
    public void useMethod() throws Exception {
        MethodContainer mc = new MethodContainer();
        Method publicMethod = MethodContainer.class.getDeclaredMethod("publicMethod");
        publicMethod.invoke(mc);
        Method privateMethod = MethodContainer.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(mc);
    }
    
    public static void main(String[] args) {
        MethodUsage mu = new MethodUsage();
        try {
            mu.useMethod();
        } catch (Exception ex) {
            Logger.getLogger(MethodUsage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
