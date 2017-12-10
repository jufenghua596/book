/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.format;

import java.text.Collator;
import java.util.Locale;

/**
 *
 * @author chengfu
 */
public class CollatorUsage {

    public void useCollator() {
        Collator collator = Collator.getInstance(Locale.US);
        collator.setStrength(Collator.PRIMARY);
        collator.compare("abc", "ABC"); //值为0
        collator.setStrength(Collator.IDENTICAL);
        collator.compare("abc", "ABC"); //值为-1
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CollatorUsage cu = new CollatorUsage();
        cu.useCollator();
    }
}
