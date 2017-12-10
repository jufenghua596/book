/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodtype;

import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodTypeFromMethodDescriptor {
    
    public void generateMethodTypesFromDescriptor() {
        ClassLoader cl = this.getClass().getClassLoader();
        String descriptor = "(Ljava/lang/String;)Ljava/lang/String;";
        MethodType mt1 = MethodType.fromMethodDescriptorString(descriptor, cl);
        System.out.println(mt1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MethodTypeFromMethodDescriptor().generateMethodTypesFromDescriptor();
    }
}
