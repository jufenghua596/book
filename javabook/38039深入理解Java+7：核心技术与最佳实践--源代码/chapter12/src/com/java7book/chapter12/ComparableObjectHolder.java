package com.java7book.chapter12;

public class ComparableObjectHolder<T extends Comparable<T>> {
    private T obj;
    public int compareTo(T anotherObj) {
        return obj.compareTo(anotherObj);
    }
    
    public void test() {
        ComparableObjectHolder<String> holder = new ComparableObjectHolder<>();
    }
}
