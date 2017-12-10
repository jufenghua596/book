package com.java7book.chapter10.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class NewUser3 implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient int age;
    public NewUser3(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
    
    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeInt(getAge());
    }
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        int age = input.readInt();
        this.age = age;
    } 
}
