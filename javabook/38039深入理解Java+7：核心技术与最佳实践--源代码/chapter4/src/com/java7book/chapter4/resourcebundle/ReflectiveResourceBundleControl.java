/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author chengfu
 */
public class ReflectiveResourceBundleControl extends ResourceBundle.Control {
    public List<String> getFormats(String baseName) {
        if (baseName == null) {
            throw new NullPointerException();
        }
        return Arrays.asList("reflection");
    }

    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
        if (baseName == null || locale == null
                || format == null || loader == null) {
            throw new NullPointerException();
        }
        ResourceBundle bundle = null;
        if (format.equals("reflection")) {
            String bundleName = toBundleName(baseName, locale);
            try {
                Class<?> clazz = loader.loadClass(bundleName);
                return new ReflectiveResourceBundle(clazz);
            } catch (ClassNotFoundException ex) {
                return bundle;
            }
        }
        return bundle;
    }
}
