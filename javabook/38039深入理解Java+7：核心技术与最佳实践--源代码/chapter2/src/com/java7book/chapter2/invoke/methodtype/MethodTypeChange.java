/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.methodtype;

import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodTypeChange {
    
    public void changeMethodType() {
        //(int,int)String
        MethodType mt = MethodType.methodType(String.class, int.class, int.class);
        //(int,int,float)String
        mt = mt.appendParameterTypes(float.class);
        //(int,double,long,int,float)String
        mt = mt.insertParameterTypes(1, double.class, long.class);
        //(int,double,int,float)String
        mt = mt.dropParameterTypes(2, 3);
        //(int,double,String,float)String
        mt = mt.changeParameterType(2, String.class);
        //(int,double,String,float)void
        mt = mt.changeReturnType(void.class);
        System.out.println(mt);
    }
    
    public void wrapAndGeneric() {
        //(int,double)Integer
        MethodType mt = MethodType.methodType(Integer.class, int.class, double.class);
        //(Integer,Double)Integer
        MethodType wrapped = mt.wrap();
        //(int,double)int
        MethodType unwrapped = mt.unwrap();
        //(Object,Object)Object
        MethodType generic = mt.generic();
        //(int,double)Object
        MethodType erased = mt.erase();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MethodTypeChange mtc = new MethodTypeChange();
        mtc.changeMethodType();
        mtc.wrapAndGeneric();
    }
}
