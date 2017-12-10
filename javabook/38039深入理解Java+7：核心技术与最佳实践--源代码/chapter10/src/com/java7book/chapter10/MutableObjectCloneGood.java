package com.java7book.chapter10;

class Counter implements Cloneable {
    private int value = 0;
    public void increase() {
        value++;
    }
    public int getValue() {
        return value;
    }
    
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}

class MutableObject implements Cloneable {
    private Counter counter = new Counter();
    public void increase() {
        counter.increase();
    }
    
    public int getValue() {
        return counter.getValue();
    }
    
    public Object clone() {
        MutableObject obj;
        try {
            obj = (MutableObject) super.clone();
            obj.counter = (Counter) counter.clone();
            return obj;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}

public class MutableObjectCloneGood {
    public void cloneObject() {
        MutableObject obj = new MutableObject();
        obj.increase();
        MutableObject clonedObj = (MutableObject) obj.clone();
        clonedObj.increase();
        obj.increase();
        System.out.println(clonedObj.getValue()); //值为2
    }
    
    public static void main(String[] args) {
        MutableObjectCloneGood moc = new MutableObjectCloneGood();
        moc.cloneObject();
    }
}
