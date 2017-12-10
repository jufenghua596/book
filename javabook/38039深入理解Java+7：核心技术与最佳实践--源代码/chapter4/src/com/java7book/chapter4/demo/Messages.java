package com.java7book.chapter4.demo;

import java.text.MessageFormat;
import java.util.ListResourceBundle;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static ResourceBundle bundle;
    static {
        try {
            bundle = ResourceBundle.getBundle("com.java7book.chapter4.demo.Messages", LocaleHolder.get());
        } catch (MissingResourceException e) {
            bundle = new ListResourceBundle() {
                protected Object[][] getContents() {
                    return new Object[0][0];
                }
            };
        }
    }

    public static String get(String key, Object... args) {
        try {
            String value = bundle.getString(key);
            return MessageFormat.format(value, args);
        }
        catch (MissingResourceException e) {
            return "!!!" + key;
        }
    }
}
