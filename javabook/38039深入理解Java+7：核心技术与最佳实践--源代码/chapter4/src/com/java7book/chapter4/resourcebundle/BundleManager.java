/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author chengfu
 */
public class BundleManager {

    private Map<String, ResourceBundle> bundles = new HashMap<>();

    public String get(Class<?> clazz, String key, Object... args) {
        String baseName = clazz.getName();
        ResourceBundle bundle = bundles.get(key);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(baseName);
            bundles.put(key, bundle);
        }
        String message = bundle.getString(key);
        return MessageFormat.format(message, args);
    }
}
