/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.resourcebundle;

import java.util.ListResourceBundle;

/**
 *
 * @author chengfu
 */
public class Messages_en_US extends ListResourceBundle {
    public Object[][] getContents() {
        return new Object[][]{
                    {"GREETING", "Hello!"},
                    {"THANK_YOU", "Thank you!"}
                };
    }
}
