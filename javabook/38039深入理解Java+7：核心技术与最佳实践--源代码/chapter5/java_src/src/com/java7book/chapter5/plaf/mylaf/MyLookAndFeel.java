/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.plaf.mylaf;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *
 * @author chengfu
 */
public class MyLookAndFeel extends BasicLookAndFeel {

    @Override
    public String getName() {
        return "My Laf";
    }

    @Override
    public String getID() {
        return "com.java7book.chapter5.mylaf";
    }

    @Override
    public String getDescription() {
        return "My laf";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    public void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        table.putDefaults(new Object[] {"LabelUI", "com.java7book.chapter5.plaf.mylaf.MyLabelUI"});
    }
    
    
    
}
