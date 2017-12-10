package com.java7book.chapter12;

import java.util.List;


public class ObjectFactory {
    public static <T> T create(Class<T> interfaceType) throws Exception {
        String className = searchForClassName();
        Class<?> clazz = Class.forName(className);
        return interfaceType.cast(clazz.newInstance());
    }
    
    private static String searchForClassName() {
        return "";
    }
    
    public void test() throws Exception {
        List list = ObjectFactory.create(List.class);
        System.out.println(list);
    }
    
    public static void main(String[] args) throws Exception {
        new ObjectFactory().test();
    }
}
