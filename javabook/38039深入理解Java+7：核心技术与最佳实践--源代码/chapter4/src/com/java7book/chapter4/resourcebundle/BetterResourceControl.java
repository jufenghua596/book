/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author chengfu
 */
public class BetterResourceControl extends ResourceBundle.Control {
    private String encoding = "UTF-8";
    public BetterResourceControl(String encoding) {
        if (encoding != null) {
            this.encoding = encoding;
        }
    }

    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
        if ("java.properties".equals(format)) {
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, "properties");
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, encoding));
            return new PropertyResourceBundle(reader);
        }
        return super.newBundle(baseName, locale, format, loader, reload);
    }
}
