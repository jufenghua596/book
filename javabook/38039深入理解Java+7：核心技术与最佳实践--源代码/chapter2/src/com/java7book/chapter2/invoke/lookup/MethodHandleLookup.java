/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class MethodHandleLookup extends MethodHandleLookupParent {

    public void lookupMethod() throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        //构造方法
        lookup.findConstructor(String.class, MethodType.methodType(void.class, byte[].class));
        //String.substring
        lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class, int.class));
        //String.format
        lookup.findStatic(String.class, "format", MethodType.methodType(String.class, String.class, Object[].class));
    }
    
    public void lookupFieldAccessor() throws NoSuchFieldException, IllegalAccessException{
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        lookup.findGetter(Sample.class, "name", String.class);
        lookup.findSetter(Sample.class, "name", String.class);
        lookup.findStaticGetter(Sample.class, "value", int.class);
        MethodHandle mh = lookup.findStaticSetter(Sample.class, "value", int.class);
        System.out.println(mh.type());
    }
    
    
    public MethodHandle lookupSpecial() throws NoSuchMethodException, IllegalAccessException, Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findSpecial(MethodHandleLookup.class, "protectedMethod", MethodType.methodType(void.class), MethodHandleLookup.class);
        System.out.println(mh.type());
        mh.invoke(this);
        return mh;
    }
    
    public void lookupSpecialNoDispatch() throws Throwable {
    	MethodHandles.Lookup lookup = MethodHandles.lookup();
    	MethodHandle mh = lookup.findSpecial(Object.class, "toString", MethodType.methodType(String.class), Object.class);
    	Object result = mh.invoke(this);
    	System.out.println(result);
    }
    
    private void privateMethod() {
        System.out.println("PRIVATE");
    }
    
    protected void protectedMethod() {
        System.out.println("OVERRIDE");
    }
    
    public static class MHHH extends MethodHandleLookup {
        
    }
    
    public String toString() {
    	return this.getClass().toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MethodHandleLookup lookup = new MethodHandleLookup();
        try {
            lookup.lookupMethod();
            lookup.lookupFieldAccessor();
            lookup.lookupSpecial();
            lookup.lookupSpecialNoDispatch();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
