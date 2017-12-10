/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter3.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 *
 * @author chengfu
 */
public class ExpressionParser {
    
    public void parse(InputStream input) throws IOException {
        PushbackInputStream pinput = new PushbackInputStream(input);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int data;
        while ((data = pinput.read()) != -1) {
            if (data == '+') {
                pinput.unread(data);
            }
            else {
                output.write(data);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
