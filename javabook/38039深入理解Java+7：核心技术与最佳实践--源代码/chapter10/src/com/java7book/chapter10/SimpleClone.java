package com.java7book.chapter10;

class ToBeCloned implements Cloneable {
    public ToBeCloned() {
        System.out.println("构造方法被调用。");
    }
    
    private int value = 0;
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}

public class SimpleClone {
    public void cloneObject() {
        ToBeCloned obj = new ToBeCloned();
        obj.setValue(1);
        ToBeCloned clonedObj = (ToBeCloned) obj.clone();
        System.out.println(clonedObj.getValue());
    }
    
    public static void main(String[] args) {
        SimpleClone sc = new SimpleClone();
        sc.cloneObject();
    }
}
