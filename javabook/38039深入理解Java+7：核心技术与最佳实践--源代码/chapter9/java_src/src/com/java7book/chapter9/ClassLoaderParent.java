package com.java7book.chapter9;

public class ClassLoaderParent {
    
    public void displayParents() {
        ClassLoader current = getClass().getClassLoader();
        while (current != null) {
            System.out.println(current.toString());
            current = current.getParent();
        }
    }

    public static void main(String[] args) {
        ClassLoaderParent clp = new ClassLoaderParent();
        clp.displayParents();
    }

}
