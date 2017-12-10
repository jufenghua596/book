/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.locale;

import java.util.Locale;

/**
 *
 * @author chengfu
 */
public class UseLocaleBuilder {

    public void useLocaleBuilder() {
        Locale locale = new Locale.Builder().setLanguage("zh").setRegion("CN").setExtension('m', "myext").build();
        String tag = locale.toLanguageTag();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseLocaleBuilder ulb = new UseLocaleBuilder();
        ulb.useLocaleBuilder();
    }
}
