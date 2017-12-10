package com.java7book.chapter13.access;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class GetSystemProperty {
    public static String get(String property) {
        return System.getProperty(property);
    }
    
    public static String getWithPrivilege(final String property) {
        return AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty(property);
            }
        });
    }
    
    public static void main(String[] args) {
        System.out.println(GetSystemProperty.getWithPrivilege("user.dir"));
    }
}
