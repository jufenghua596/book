/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodtype;

import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodTypeGeneric {
    
    public void generateGenericMethodTypes() {
        MethodType mt1 = MethodType.genericMethodType(3);
        MethodType mt2 = MethodType.genericMethodType(2, true);
        
        System.out.println(mt1);
        System.out.println(mt2);
        System.out.println(mt1.parameterCount());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MethodTypeGeneric().generateGenericMethodTypes();
    }
}
