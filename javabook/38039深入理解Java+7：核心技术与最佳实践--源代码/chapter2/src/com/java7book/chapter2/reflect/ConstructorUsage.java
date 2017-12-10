/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chengfu
 */
public class ConstructorUsage {
	
	private String outerValue;

    public void useNestedClassConstructor() throws Exception {
        Constructor<StaticNestedClass> sncc = StaticNestedClass.class.getDeclaredConstructor(String.class);
        sncc.newInstance("Alex");
        Constructor<NestedClass> ncc = NestedClass.class.getDeclaredConstructor(ConstructorUsage.class, int.class);
        NestedClass ic = ncc.newInstance(this, 3);
    }

    public void useVarargsConstructor() throws Exception {
        Constructor<VarargsConstructor> constructor = VarargsConstructor.class.getDeclaredConstructor(String.class, String[].class);
        constructor.newInstance("", (Object) (new String[]{"A", "B", "C"}));
    }


    static class StaticNestedClass {
        public StaticNestedClass(String name) {
        }
    }

    class NestedClass {
        public NestedClass(int count) {
        	outerValue = "";
        }
    }

    public static void main(String[] args) {
        ConstructorUsage cu = new ConstructorUsage();
        try {
            cu.useNestedClassConstructor();
            cu.useVarargsConstructor();
        } catch (Exception ex) {
            Logger.getLogger(ConstructorUsage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
