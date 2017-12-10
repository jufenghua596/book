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
public class UseBetterResourceBundle {
    
    public void load() {
        String baseName = "com.java7book.chapter4.resourcebundle.NewMessages";
        ResourceBundle bundle = ResourceBundleLoader.load(baseName, Locale.CHINA);
        System.out.println(bundle.getString("GREETING"));
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseBetterResourceBundle ubrb = new UseBetterResourceBundle();
        ubrb.load();
    }
}
