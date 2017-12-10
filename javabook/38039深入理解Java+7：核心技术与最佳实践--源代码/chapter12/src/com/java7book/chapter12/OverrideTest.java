package com.java7book.chapter12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class SuperClass <T> {
    public void method(T obj) {
    }
}

class SubClass extends SuperClass {
    public <S> void method() {
        
    }
}

public class OverrideTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(null);
    }
}
