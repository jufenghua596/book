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
public class UseResourceBundle {
    
    public void useResourceBundle() {
        String baseName = "com.java7book.chapter4.resourcebundle.Messages";
        ResourceBundle bundleEn = ResourceBundle.getBundle(baseName, Locale.US);
        bundleEn.getString("GREETING");
        ResourceBundle bundleCn = ResourceBundle.getBundle(baseName, Locale.CHINA);
        bundleCn.getString("THANK_YOU");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseResourceBundle urb = new UseResourceBundle();
        urb.useResourceBundle();
    }
}
