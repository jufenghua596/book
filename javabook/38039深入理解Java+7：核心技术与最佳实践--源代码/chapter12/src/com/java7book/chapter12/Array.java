package com.java7book.chapter12;

import java.util.ArrayList;
import java.util.List;

class StringArrayList extends ArrayList<String> {
    public void createArray() {
        ArrayList<String>[] array = new StringArrayList[10];
    }
}

public class Array {
    public void storeInArray() {
        Object[] array = new Integer[10];
        array[0] = "Hello"; //抛出异常
    }
    
    public void storeInGenericArray() {
        //Object[] array = new ArrayList<String>[10];
        //array[0] = new ArrayList<Integer>();
    }
    
    public static void main(String[] args) {
        Array array = new Array();
        array.storeInArray();
    }
}
