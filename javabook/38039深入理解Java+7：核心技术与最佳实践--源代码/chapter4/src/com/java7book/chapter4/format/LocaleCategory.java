/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.format;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.ResourceBundle;
import java.util.Date;

/**
 *
 * @author chengfu
 */
public class LocaleCategory {
    
    public void useLocaleCategory() {
        ResourceBundle bundle = ResourceBundle.getBundle("com.java7book.chapter4.format.messages");
        String str = bundle.getString("GREETING");
        String msg = MessageFormat.format(str, new Object[] {"张三", new Date()});
        System.out.println(msg);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocaleCategory lc = new LocaleCategory();
        lc.useLocaleCategory();
    }
}
