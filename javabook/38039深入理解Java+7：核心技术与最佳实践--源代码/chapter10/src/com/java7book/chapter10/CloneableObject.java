package com.java7book.chapter10;

public class CloneableObject implements Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e); // 不会发生该异常
        }
    }
    
    public static void main(String[] args) {
        CloneableObject obj = new CloneableObject();
        obj.clone();
    }
}
