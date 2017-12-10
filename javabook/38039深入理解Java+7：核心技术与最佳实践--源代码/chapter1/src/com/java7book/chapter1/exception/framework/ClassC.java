/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.exception.framework;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author chengfu
 */
public class ClassC {
    public void read(String filename) {
        FileInputStream input = null;
        BaseRuntimeException exception = new BaseRuntimeException();
        try {
            input = new FileInputStream(filename);
        } catch (IOException ex) {
               exception.addException(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                     exception.addException(ex);
                }
            }
            if (exception.isThrownRequired()) {
                throw exception;
            }
        }
    }
}
