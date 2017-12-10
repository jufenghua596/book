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
public class DataAccessGateway {
    public void load() throws DataAccessException {
        try {
            FileInputStream input = new FileInputStream("data.txt");
        }
        catch (IOException e) {
            throw new DataAccessException(e);
        }
    }
}
