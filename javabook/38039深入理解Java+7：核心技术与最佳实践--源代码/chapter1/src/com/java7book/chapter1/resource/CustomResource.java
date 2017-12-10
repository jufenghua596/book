/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.resource;

/**
 *
 * @author chengfu
 */
public class CustomResource implements AutoCloseable {

    public void close() throws Exception {
        System.out.println("进行资源释放。");
    }
    
    public void useCustomResource() throws Exception {
        try (CustomResource resource = new CustomResource())  {
            System.out.println("使用资源。");
        }
    }
    
    public static void main(String[] args) {
        try {
            new CustomResource().useCustomResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
