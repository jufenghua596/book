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
public class ResourceBundleLoader {
    public static ResourceBundle load(String baseName, Locale locale) {
        BetterResourceControl control = new BetterResourceControl(null);
        return ResourceBundle.getBundle(baseName, locale, control);
    }
}
