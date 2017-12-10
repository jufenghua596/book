/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.reflect;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chengfu
 */
public class FieldUsage {
    
    public void useField() throws Exception {
        Field fieldCount = FieldContainer.class.getDeclaredField("count");
        fieldCount.set(null, 3);
        Field fieldName = FieldContainer.class.getDeclaredField("name");
        FieldContainer fieldContainer = new FieldContainer();
        fieldName.set(fieldContainer, "Bob");
        System.out.println(FieldContainer.count);
        System.out.println(fieldContainer.name);
    }
    
    public static void main(String[] args) {
        FieldUsage fu = new FieldUsage();
        try {
            fu.useField();
        } catch (Exception ex) {
            Logger.getLogger(FieldUsage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
