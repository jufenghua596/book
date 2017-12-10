package com.java7book.chapter10;

class Parent {
    public Parent() {
        int average = 30 / getCount();
    }
    protected int getCount() {
        return 4;
    }
}

class Child extends Parent {
    private int count;
    public Child(int count) {
        this.count = count;
    }
    public int getCount() {
       return count;
    }
}

public class BadConstructor {
    public void test() {
        Child child = new Child(5);
    }
    
    public static void main(String[] args) {
        BadConstructor bc = new BadConstructor();
        bc.test();
    }
}
