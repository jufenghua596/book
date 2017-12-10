/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author chengfu
 */
public class ReflectiveResourceBundleUsage {

    public void useReflectiveResourceBundle() {
        String baseName = "com.java7book.chapter4.resourcebundle.ReflectiveMessages";
        ReflectiveResourceBundleControl control = new ReflectiveResourceBundleControl();
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.CHINA, control);
        Object value = bundle.getObject("greet");
        System.out.println(value);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReflectiveResourceBundleUsage rrbu = new ReflectiveResourceBundleUsage();
        rrbu.useReflectiveResourceBundle();
    }
}
