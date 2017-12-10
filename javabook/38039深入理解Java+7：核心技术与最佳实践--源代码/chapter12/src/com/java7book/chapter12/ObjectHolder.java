package com.java7book.chapter12;

public class ObjectHolder<T> {
    private T obj;
    public T getObject() {
        return obj;
    }
    public void setObject(T obj) {
        this.obj = obj;
    }
}
