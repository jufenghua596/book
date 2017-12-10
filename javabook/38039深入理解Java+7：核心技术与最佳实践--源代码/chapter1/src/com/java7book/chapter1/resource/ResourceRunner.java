/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.resource;

import java.io.IOException;

/**
 *
 * @author chengfu
 */
public class ResourceRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceBasicUsage rbu = new ResourceBasicUsage();
        try {
            String content = rbu.readFile("C:\\my.txt");
            System.out.println(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
